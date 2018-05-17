/**
 * Created by wangqiong on 2017/3/3.
 */
/**
 * 兼容所有浏览器的requestAnimationFrame的shim,能支持到ie6，尽管ie9及以下是使用setTimeout进行
 * 模拟的.
 * requestAnimationFrame是比setTimeout执行更快的异步算法
 * */
(function () {
    var lastTime = 0;
    var vendors = ['webkit', 'moz'];
    for (var x = 0; x < vendors.length && !window.requestAnimationFrame; ++x) {
        window.requestAnimationFrame = window[vendors[x] + 'RequestAnimationFrame'];
        window.cancelAnimationFrame = window[vendors[x] + 'CancelAnimationFrame'] || // name has changed in Webkit
            window[vendors[x] + 'CancelRequestAnimationFrame'];
    }

    if (!window.requestAnimationFrame) {
        window.requestAnimationFrame = function (callback, element) {
            var currTime = new Date().getTime();
            var timeToCall = Math.max(0, 16.7 - (currTime - lastTime));
            var id = window.setTimeout(function () {
                callback(currTime + timeToCall);
            }, timeToCall);
            lastTime = currTime + timeToCall;
            return id;
        };
    }
    if (!window.cancelAnimationFrame) {
        window.cancelAnimationFrame = function (id) {
            clearTimeout(id);
        };
    }
}());

/*设置window上面的全局属性*/
$.extend(window, {
    ENCRYPT_TYPE: {
        rsa: "rsa",
        aes: "aes"
    },
    simplePublicKey: localStorage.getItem("publicKey"),
    simpleUserKey: localStorage.getItem('userKey'),
    LOGOUT_AJAX_FLAG: 0
});

/*
 * 当发出ajax请求的时候让加载中出现,ajax完毕的时候让加载中消失
 * 当发出ajax请求的时候将ajax请求的url和request保存到一个json中去；当请求完毕或者又发出相同的url地址的请求的时候
 * 就将前面的请求abort掉
 * */
window.ajaxArray = {};
$(window).ajaxSend(function (evt, request, settings) {
    layer.load();
    (function () {
        /*
         * 若是ajax json中已经拥有了ajax的路径，那么就将对应的request abort掉，再将新的request放入
         * */
        var url = settings.url;
        var path = url.substring(0, url.indexOf("?") != -1 ? url.indexOf("?") : url.length);
        if (window.ajaxArray[path]) {
            window.ajaxArray[path].abort();
        }
        window.ajaxArray[path] = request;
    }())
}).ajaxComplete(function (evt, request, settings) {
    layer.closeAll('loading');
    (function () {
        /*
         * 将ajax json中的此次请求的ajax对应的数据清除掉
         * */
        var url = settings.url;
        var path = url.substring(0, url.indexOf("?") != -1 ? url.indexOf("?") : url.length);
        if (window.ajaxArray[path]) {
            delete window.ajaxArray[path];
        }
    }())
}).ajaxError(function (event, request, settings) {
    layer.closeAll('loading');
    /*
     * 如果是abort的；就不要进行错误处理(status==0是abort的)
     * */
    if (!request.status || request.status == 200) {
        return;
    }
    simpleInfoDialog('type-warning', code_message['001']);
});

/* 设置全局 ajax 默认选项 */
$.ajaxSetup({
    type: "POST",
    contentType: "application/json",
    // timeout: 30000, //超时时间：30秒
    dataFilter: function (data) {
        if (this.encrypt === window.ENCRYPT_TYPE.aes) {
            try {
                JSON.parse(data);
            } catch (error) {
                try {
                    data = simpleAesDecode(data);
                    JSON.parse(data);
                } catch (error) {
                    throw error;
                }
            }
        }
        try {
            var objData = JSON.parse(data);
            if (objData.code && objData.code !== "000") {
                BootstrapDialog.alert({
                    title: '信息',
                    type: 'type-warning',
                    /* size: 'size-small', */
                    buttonLabel: '确定',
                    message: function () {
                        if (objData.msg) {
                            return objData.msg;
                        } else {
                            return window.code_message["001"];
                        }
                    }()
                });
                return;
            }
        } catch (e) {}
        return data;
    },
    beforeSend: function (XMLHttpRequest, params) {
        /*首页实时扫描数据请求时，修改密码界面中的提交按钮不禁用*/
        if (!/list/.test(params.url) && !/scanData/.test(params.url)) {
            $("input[type=submit],.delete-btn").prop("disabled", true)
        }
        if (!(params.enctype && params.enctype === "multipart/form-data")) {
            /*定义一个加密字符*/
            var encrypt;
            /*若是localStorage中拥有encryptOpen则赋值为aes*/
            if (localStorage.getItem('encryptOpen')) {
                encrypt = window.ENCRYPT_TYPE.aes;
            }
            /*若传入的headers中拥有encrypt则赋值为传入的参数*/
            if (params.headers && params.headers.encrypt) {
                encrypt = params.headers.encrypt;
            }
            /*若是encrypt存在并且不等于aes或rsa那么就抛出异常*/
            if (encrypt && encrypt !== window.ENCRYPT_TYPE.aes && encrypt !== window.ENCRYPT_TYPE.rsa) {
                throw new Error("the encrypt must be 'aes' or 'rsa'");
            }
            if (encrypt) {
                XMLHttpRequest.setRequestHeader("encrypt", encrypt);
            }
            if (typeof params.data === "object") {
                doTrim(params.data);
                params.data = JSON.stringify(params.data);
            }
            if (simpleUserKey != null) {
                var signText = params.url;
                if (params.data != null) {
                    signText = signText + params.data;
                }
                XMLHttpRequest.setRequestHeader("simpleSign",
                    CryptoJS.HmacSHA1(signText, simpleUserKey));
            }
            if (encrypt === window.ENCRYPT_TYPE.aes) {
                this.encrypt = window.ENCRYPT_TYPE.aes;
                this.dataType = "text";
                params.data = simpleAesEncode(params.data);
            }
            if (encrypt === window.ENCRYPT_TYPE.rsa) {
                params.data = simpleRsaEncode(params.data);
            }
        }
        /*去掉请求参数中的值为字符串的前后空格*/
        function doTrim(data) {
            Object.keys(data).forEach(function (key) {
                var value = data[key];
                if (value instanceof Object && value !== null) {
                    doTrim(value);
                } else if (typeof value == "String" || typeof value == "string") {
                    data[key] = value.trim();
                }
            });
        }
    },
    complete: function (XMLHttpRequest, textStatus) {
        $("input[type=submit],.delete-btn").prop("disabled", false);
        if (XMLHttpRequest.responseText != null && (XMLHttpRequest.responseText.indexOf('<!-- #登录页面#  -->') == 0 || XMLHttpRequest.responseText.indexOf('S0000006') >= 0)) {
            if (!window.LOGOUT_AJAX_FLAG) {
                simpleInfoDialog('type-warning', '会话过期');
                $("#logout").click();
            }
            window.LOGOUT_AJAX_FLAG++;
            // logoutflag 仅仅是为了防止多次弹窗，同时如果logout后，没有跳转，则最多允许点击30次
            if (window.LOGOUT_AJAX_FLAG > 30) {
                window.LOGOUT_AJAX_FLAG = 0;
            }
        }
    }
});

/*rsa的数据处理*/
function simpleRsaEncode(data) {
    var encrypt = new JSEncrypt();
    encrypt.setPublicKey(window.simplePublicKey);
    return encrypt.encrypt(data);
}

/*aes的数据处理*/
function simpleAesEncode(data) {
    //	var iv = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
    var iv = "95cd2cc9571580226df27a35262f3ad4";
    //  var salt = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
    var salt = "cbacf2ca42a3d265123a3d007eb56ee4";
    var aesUtil = new AesUtil(128, 1000);
    var ciphertext = aesUtil.encrypt(salt, iv, window.simpleUserKey, data);
    return ciphertext;
}

/*aes的解码*/
function simpleAesDecode(base64Str) {
    //	var iv = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
    var iv = "95cd2cc9571580226df27a35262f3ad4";
    //  var salt = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
    var salt = "cbacf2ca42a3d265123a3d007eb56ee4";
    var aesUtil = new AesUtil(128, 1000);
    var ciphertext = aesUtil.decrypt(salt, iv, window.simpleUserKey, base64Str);
    return ciphertext;
}

/* 阻止form的自动提交;主要是防止表单内元素回车自动提交*/
$(document).on("submit", "form", function (event) {
    event.preventDefault();
});

/*表单验证的默认配置*/
$.validator.setDefaults({
    ignore: ":disabled",
    ignoreTitle: true,
    errorElement: "span",
    normalizer: function (value) {
        return $.trim(value);
    },
    errorPlacement: function (error, element) {
        // Add the `help-block` class to the error element
        error.addClass("validation-error text-danger");

        if (element.prop("type") === "checkbox" || element.prop("type") === "radio") {
            error.addClass("center-block").insertAfter(element.parent("label"));
        } else {
            error.insertAfter(element);
        }
    },
    highlight: function (element, errorClass, validClass) {
        $(element).closest(".form-group").addClass("has-error").removeClass("has-success");
    },
    unhighlight: function (element, errorClass, validClass) {
        $(element).closest(".form-group").addClass("has-success").removeClass("has-error");
    }
});
/*修正表单验证插件校验文件格式的方法 Accept a value from a file input based on a required mimetype*/
$.validator.addMethod("accept", function (value, element, param) {

    // Split mime on commas in case we have multiple types we can accept
    var typeParam = typeof param === "string" ? param.replace(/\s/g, "") : "image/*",
        optionalValue = this.optional(element),
        i, file, regex;

    // Element is optional
    if (optionalValue) {
        return optionalValue;
    }

    if ($(element).attr("type") === "file") {

        // Escape string to be used in the regex
        // see: http://stackoverflow.com/questions/3446170/escape-string-for-use-in-javascript-regex
        // Escape also "/*" as "/.*" as a wildcard
        typeParam = typeParam
            .replace(/[\-\[\]\/\{\}\(\)\+\?\.\\\^\$\|]/g, "\\$&")
            .replace(/,/g, "|")
            .replace(/\/\*/g, "/.*");

        // Check if the element has a FileList before checking each file
        if (element.files && element.files.length) {
            regex = new RegExp(".?(" + typeParam + ")$", "i");
            for (i = 0; i < element.files.length; i++) {
                file = element.files[i];

                // Grab the mimetype from the loaded file, verify it matches
                if (!file.type.match(regex) && !file.name.match(regex)) {
                    return false;
                }
            }
        }
    }

    // Either return true because we've validated each file, or because the
    // browser does not support element.files and the FileList feature
    return true;
}, $.validator.format("Please enter a value with a valid mimetype."));
/*校验ip格式——正确的IPv4格式的IP*/
$.validator.addMethod("ip", function (value, element) {
    return this.optional(element) || /^(25[0-5]|2[0-4]\d|[01]?\d\d?)\.(25[0-5]|2[0-4]\d|[01]?\d\d?)\.(25[0-5]|2[0-4]\d|[01]?\d\d?)\.(25[0-5]|2[0-4]\d|[01]?\d\d?)$/i.test(value)
}, "请输入正确的IP地址");

/*校验ip范围格式——正确的IPv4格式的IP范围*/
$.validator.addMethod("ipRange", function (value, element) {
    var ip4RegExp = /^(25[0-5]|2[0-4]\d|[01]?\d\d?)\.(25[0-5]|2[0-4]\d|[01]?\d\d?)\.(25[0-5]|2[0-4]\d|[01]?\d\d?)\.(25[0-5]|2[0-4]\d|[01]?\d\d?)$/i;
    var isTrue = value.split(",").every(function (value) {
        var values = value.split("-");
        var isTrue = false;
        if (values.length == 2 || values.length == 1) {
            var value1 = values[0].trim();
            if (values.length == 2) {
                var value2 = values[1].trim();
            } else if (values.length == 1) {
                var value2 = values[0].trim();
            }
            var value1Start = value1.substring(0, value1.lastIndexOf("."));
            var value1End = +value1.substring(value1.lastIndexOf(".") + 1);
            var value2Start = value2.substring(0, value2.lastIndexOf("."));
            var value2End = +value2.substring(value2.lastIndexOf(".") + 1);
            if (value1Start == value2Start && value1End <= value2End && ((ip4RegExp.test(value1) && ip4RegExp.test(value2)))) {
                isTrue = true;
            }
        }
        return isTrue;
    });
    return this.optional(element) || isTrue;
}, "请输入正确的IP地址范围");

/*校验是否在ip范围内*/
$.validator.addMethod("ipInnerRange", function (value, element, param) {
    var params = param.split(",").map(function (param) {
        var ranges = param.split("-");
        var range1 = ranges[0].trim();
        if (ranges.length == 2) {
            var range2 = ranges[1].trim();
        } else if (ranges.length == 1) {
            var range2 = ranges[0].trim();
        }
        var ipStart = range1.substring(0, range1.lastIndexOf("."));
        var range1End = +range1.substring(range1.lastIndexOf(".") + 1);
        var range2End = /^\d*$/.test(range2) ? +range2 : +range2.substring(range2.lastIndexOf(".") + 1);
        return {
            "ipStart": ipStart,
            "range1End": range1End,
            "range2End": range2End
        };
    });
    var isTrue = value.split(",").every(function (value) {
        var values = value.split("-");
        var value1 = values[0].trim();
        if (values.length == 2) {
            var value2 = values[1].trim();
        } else if (values.length == 1) {
            var value2 = values[0].trim();
        }
        var value1Start = value1.substring(0, value1.lastIndexOf("."));
        var value1End = +value1.substring(value1.lastIndexOf(".") + 1);
        if (/^\d*$/.test(value2)) {
            var value2End = +value2;
            return params.some(function (param) {
                return param.ipStart == value1Start && value1End >= param.range1End && value2End <= param.range2End;
            })
        } else {
            var value2Start = value2.substring(0, value2.lastIndexOf("."));
            var value2End = +value2.substring(value2.lastIndexOf(".") + 1);
            return params.some(function (param) {
                return param.ipStart == value1Start && param.ipStart == value2Start && value1End >= param.range1End && value2End <= param.range2End;
            });
        }
    });
    return this.optional(element) || isTrue;
}, "您输入的IP地址范围超出了可用范围");

/*校验手机号——只验证必须是数字,第一位是1,共11位*/
$.validator.addMethod("mobilePhone", function (value, element) {
    return this.optional(element) || /^1\d{10}$/i.test(value);
}, "请输入手机号码");

/*校验联系电话——输入正确的手机号（必须是数字,第一位是1,共11位）或固定电话（区号、主机号、分机号用短横线分隔，区号和分机号可省略）*/
$.validator.addMethod("telephoneCheck", function (value, element) {
    return this.optional(element) || /^1\d{10}$|^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/i.test(value);
}, "请输入正确的手机号码或固定电话");

/*校验用户名——长度3-16，只允许字母、数字、下划线、横线，区分大小写*/
$.validator.addMethod("userAccount", function (value, element) {
    return this.optional(element) || /^[A-Za-z0-9_-]{3,16}$/.test(value);
}, "您输入的用户名格式不正确");

/*校验密码——长度6-18，只允许字母、数字、下划线、横线，区分大小写*/
$.validator.addMethod("passwordCheck", function (value, element) {
    return this.optional(element) || /^[A-Za-z0-9_-]{6,18}$/.test(value);
}, "您输入的密码格式不正确");

/*校验邮箱*/
$.validator.addMethod("emailCheck", function (value, element) {
    return this.optional(element) || /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/.test(value);
}, "您输入的邮箱格式不正确");

/*校验职务——只允许长度小于80个字符的汉字和字母*/
$.validator.addMethod("positionCheck", function (value, element) {
    return this.optional(element) || /^[a-zA-Z\u3400-\u4DB5\u4E00-\u9FA5\u9FA6-\u9FBB\uF900-\uFA2D\uFA30-\uFA6A\uFA70-\uFAD9\uFF00-\uFFEF\u2E80-\u2EFF\u3000-\u303F\u31C0-\u31EF\u2F00-\u2FDF\u2FF0-\u2FFF\u3100-\u312F\u31A0-\u31BF\u3040-\u309F\u30A0-\u30FF\u31F0-\u31FF\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F\u4DC0-\u4DFF\uA000-\uA48F\uA490-\uA4CF\u2800-\u28FF\u3200-\u32FF\u3300-\u33FF\u2700-\u27BF\u2600-\u26FF\uFE10-\uFE1F\uFE30-\uFE4F]{0,80}$/.test(value);
}, "您输入的职务格式不正确");

/*校验MAC地址——6个字节（十六进制）组成，数字、大小写字母（a-fA-F）,冒号、短横线连接*/
$.validator.addMethod("macAddressCheck", function (value, element) {
    return this.optional(element) || /^(([0-9A-Fa-f]{2}:){5}|([0-9A-Fa-f]{2}-){5})[0-9A-Fa-f]{2}$/.test(value);
}, "您输入的MAC地址格式不正确");

/*扩展一个方法使得resetForm的时候将bootstrap高亮去掉*/
$.validator.prototype.resetFormExtra = function () {
    this.resetForm();
    $(this.currentForm).find(".has-success").removeClass("has-success");
    $(this.currentForm).find(".has-error").removeClass("has-error");
    this.currentForm.reset();
};

/**
 * @func
 * @desc  加载分页
 * @param element 节点
 * @param pageInfo 标准分页信息
 * @param callback 翻页的回调函数
 */
function loadPagination(element, pageInfo, callback) {
    $(element).pagination({
        showPageCount: 5,
        total: pageInfo.count, //总条数
        currentPage: pageInfo.index - 1, //当前页
        preCount: pageInfo.size, //每页条数
        showMsg: true,
        showCustomPage: true,
        click: function (page) {
            $.extend(pageInfo, {
                index: page + 1
            });
            this.pagination("render", {
                currentPage: page
            });
            callback();
        }
    });
}

/**
 * @func
 * @desc  下载文件
 * @param fileURL 下载地址
 */
function download(fileURL) {
    var a = document.createElement("a");
    a.target = "_self";
    a.href = fileURL;
    /*ie需要text,否则点击不执行*/
    a.innerText = "ieNeed";
    a.download = true;
    /*firefox需要将a放入文档,否则不执行*/
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
}

/*重绘echarts*/
function echartsResize() {
    [].forEach.call(document.querySelectorAll("[_echarts_instance_]"), function (instanceDom) {
        $(instanceDom).children().hide();
        window.requestAnimationFrame(function () {
            echarts.getInstanceByDom(instanceDom) && echarts.getInstanceByDom(instanceDom).resize({
                width: instanceDom.clientWidth - 2
            });
        });
    });
}
/**
 * 向表格中填充数据(文件类型的不支持填充)
 * @param ele  填充的表格
 * @param data  填充的数据
 */
function fillTableData(ele, data) {
    Object.keys(data).forEach(function (key) {
        $("[data-name=" + key + "]", $(ele)).html('');
    });
    Object.keys(data).forEach(function (key) {
        var value = data[key];
        if (value === 0) {
            value += "";
        } else if (!value) {
            value = "";
        } else {
            value += "";
        }
        $("[data-name=" + key + "]", $(ele)).text(value);
    });
}

/*当浏览器尺寸发生变化的时候重绘所有的echarts*/
$(window).resize(function () {
    echartsResize();
});
/**
 * @func simpleInfoDialog
 * @desc  信息提示对话框
 * @param type 类型（不同类型，对应不同颜色的对话框）
 *              'type-default'  'type-info' 'type-primary' 'type-success' 'type-warning' 'type-danger'
 * @param message 信息
 * @param size 大小 'size-normal'  'size-wide'  'size-large' 
 * @param callback 回调函数
 */
function simpleInfoDialog(type, message, size, callback) {
    switch (type) {
        case 'type-info':
            return BootstrapDialog.alert({
                title: '信息',
                type: 'type-info',
                size: size || 'size-small',
                buttonLabel: '确定',
                message: message,
                callback: callback
            });
        case 'type-warning':
            return BootstrapDialog.alert({
                title: '信息',
                type: 'type-warning',
                size: size || 'size-normal',
                buttonLabel: '确定',
                message: message,
                callback: callback
            });
        case 'type-success':
            BootstrapDialog.show({
                title: '信息',
                type: 'type-success',
                size: size || 'size-small',
                closable: false,
                message: message,
                onshown: function (dialog) {
                    setTimeout(function () {
                        dialog.close()
                    }, 1000);
                }
            });
    }
}
/**
 *比较两个数组中的不同,并返回第一个数组中与第二个数组中不同的数据组成的新数组
 * @param currentData 第一个数组
 * @param originData 第二个数组
 * @param id 默认使用id 用于数组中每一项进行比较的索引键
 */
function getDiffData(currentData, originalData, id) {
    if (!(currentData instanceof Array)) {
        throw new Error("the first params must be a Array");
    }
    if (!(originalData instanceof Array)) {
        throw new Error("the second params must be a Array");
    }
    //id的默认值赋为"id"
    id = id || "id";
    //复制一份originData,防止对原originData造成破坏
    originalData = JSON.parse(JSON.stringify(originalData));
    return currentData.filter(function (currentItem) {
        //与currentItem匹配的originData中的数据
        var originItem;
        //与currentItem匹配的originData中的数据在数组中的位置
        var originId;
        originalData.some(function (item, idx) {
            if (item[id] === currentItem[id]) {
                originItem = item;
                originId = idx;
                return true;
            }
        });
        if (originItem) {
            originalData.splice(originId, 1);
            return JSON.stringify(currentItem) !== JSON.stringify(originItem);
        }
    })
}
/**
 * 简单数组去重，一维数组，比如[1,2,3,4]
 * @param arr
 * @param key
 * @returns {Array}
 */
function uniqueArr(arr, key) {
    var tem = [];
    for (var i = 0; i < arr.length; i++) {
        if (tem.indexOf(arr[i]) <= -1) {
            tem.push(arr[i]);
        }
    }
    return tem;
}

/**
 * 比较两个数组，并且合并两个数组，去重
 * [{id:1},{id:2}],[{id:1}],key按照哪个key去重
 * @param arr1
 * @param arr2
 * @param key
 * @returns {Array.<*>}
 */
function compareArr(arr1, arr2, key) {
    var tem = [].concat(arr1);
    var flag = false;
    for (var i = 0; i < arr2.length; i++) {
        flag = false;
        for (var j = 0; j < arr1.length; j++) {
            if (arr2[i][key] == arr1[j][key]) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            tem.push(arr2[i]);
        }
    }
    return tem;
}