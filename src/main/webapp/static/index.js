(function () {
    /*获取当前登录用户信息*/
    /* var userInfoDeferred = $.ajax({
        type: "post",
        url: "/rest/common/getLoginUserInfo",
        data: JSON.stringify({}),
        success: function (data) {
            if (data.successful === true) {
                window.userInfo = data.resultValue;
            } else {
                simpleInfoDialog('type-warning', data.resultHint);
            }
        }
    }); */

    /* 获取返回的数据字典 */
    /* var commonDataDeferred = $.ajax({
        type: "post",
        url: "/rest/common/data",
        data: JSON.stringify({}),
        success: function (data) {
            if (data.code === 000) {
                window.commonData = $.extend(commonData,data.data);
            } else {
                simpleInfoDialog('type-warning', data.msg);
            }
        }
    }); */
    /**
     * 查看表格数据时,将数据字典值转化为前端页面展示的汉字
     * @param {Object} data 要查看的某一行表格数据
     */
    /* function checkTableInitDict(data) {
        var dictKeys = Object.keys(data);
        data = JSON.parse(JSON.stringify(data));
        dictKeys.forEach(function (dictKey) {
            var currentData = window.commonData[dictKey];
            if (!currentData) { return ""; };
            currentData.every(function (item) {
                if (item.code == data[dictKey]) {
                    data[dictKey] = item["name"];
                } else {
                    return true;
                }
            })
        });
        return data;
    } */

    /**
     * 填充表格列表时，将数据字典值转化为前端页面展示的汉字
     * @param {String} dictKey 要转化的字典字段名
     * @param {String} value 要转化的字典值
     */
    /* function fillTableInitDict(dictKey, value) {
        if (!window.commonData[dictKey]) { return ""; }
        window.commonData[dictKey].every(function (item) {
            if (item.code == value) {
                value = item["name"];
            } else {
                return true;
            }
        })
        return value;
    } */
    /*当屏幕很小的时候,通过点击打开收起按钮显示隐藏左侧导航条*/
    (function showLeftBtn() {
        $("#show-left-btn").on("click", function () {
            $("body").toggleClass("shrink-menu");
            $(this).toggleClass("fa-angle-left", !!$(this).hasClass("fa-angle-right"));
            $(this).toggleClass("fa-angle-right", !$(this).hasClass("fa-angle-right"));
            echartsResize();
            /*解决Google打开时，页面宽度无变化的问题*/
            setTimeout(function () {
                $(".main-right").width(20000 + Math.random())
            }, 0);
        });
    })();
    /*用户信息*/
    (function userInfo() {
        window.UserInfo = $.Deferred();
        var data = {
            id: localStorage.getItem("userInfo.id"),
            userAccount: localStorage.getItem("userInfo.userAccount"),
            userName: localStorage.getItem("userInfo.userName")
        };
        window.UserInfo.resolve(data);
    })();
    /*修改密码*/
    /*     (function modifyPassword() {
            $.validator.setDefaults({ ignore: ".removeBorder" });
            window.UserInfo.done(function (userInfo) {
                $("#loginName").attr("value", userInfo.loginName);
                $("#userName").attr("value", userInfo.userName);
                $("#currentUser").text(userInfo.loginName);
            });
            $("#modifyPassword").on("click", function () {
                validator.resetFormExtra();
            });
            $(".modal").on('hidden.bs.modal', function (event) {
                $(this).find("form").get().forEach(function (form) {
                    form.reset();
                });
            });
            var validator = $("#passwordManagement-form").validate({
                rules: {
                    oldPassword: {
                        required: true,
                        passwordCheck: true
                    },
                    newPassword: {
                        required: true,
                        passwordCheck: true
                    },
                    confirmNewPassword: {
                        required: true,
                        equalTo: "#newPassword"
                    }
                }
            });
            $("#passwordManagement-form").on("submit", function () {
                if (!validator.valid()) {
                    var errorField = validator.errorList[0].element;
                    errorField.focus();
                    errorField.scrollIntoView();
                    return false;
                } else {
                    $.post("/ldxk/user/modifyPassword", JSON.stringify(getFormData("#passwordManagement-form"))).done(function (data) {
                        if (data.code === "000") {
                            layer.msg(code_message['000'], { icon: 1 });
                            $(".modal").modal('hide');
                        } else {
                            layer.alert(data.msg, { icon: 0 });
                        }
                    });
                }
            });
        })(); */

    /*导航操作*/
    (function navigation() {
        var httpRequest, menuConfig,
            content = document.querySelector("#main-content");
        $.get(rootPath + '/static/menu_config.json').done(function (data) {
            if (typeof data === 'string') {
                menuConfig = JSON.parse(data);
            } else {
                menuConfig = data;
            }
            $.post( rootPath +  '/user/getLoginUserRights', "{}", null, 'json').done(function (data) {
                if (data.code !== "000") {
                    simpleInfoDialog('type-warning', data.msg);
                } else {
                    data.data.forEach(function (item) {
                        $.extend(item, menuConfig[item.code], {
                            text: item.name
                        });
                    });
                    var menus = data.data.filter(function (item) {
                        return /^menu-/.test(item.code);
                    });
                    var btnRight = data.data.filter(function (item) {
                        return !/^menu-/.test(item.code);
                    });
                    /*按钮权限*/
                    window.currentPermit = btnRight;
                    var navigationMenus = parentIdToCascade(menus, "id", "pId", 0, "children");
                    console.log(navigationMenus);
                    navigation(navigationMenus, btnRight);

                }
            });
        }).fail(function () {
            simpleInfoDialog('type-warning', '获取菜单配置失败，请检查menu_config.json');
        });

        function navigation(menus, btns) {
            var httpRequest,
                accordion = document.querySelector("#accordion"),
                accordionItem,
                content = document.querySelector("#main-content");
            var menus = parentIdToCascade(menus, "id", "pId", 0, "children");
            $(accordion).accordion({
                datas: menus,
                extraAttr: {
                    "data-page": function (data) {
                        return data.page;
                    }
                },
                onSelected: function (data, datas) {
                    var page;
                    if (data.page === "home") {
                        page = data.page;
                    } else if (data.children && data.children.length) {
                        $("[data-page=" + data.children[0].page + "]").click();
                        return;
                    } else {
                        page = data.page;
                    }
                    doNavigation(page, this, data, datas);
                    var query = window.URL.query().page;
                    var url = window.URL.stringify($.extend(window.URL.query(), {
                        page: page
                    }));
                    if (window.history.pushState) {
                        if (!query) {
                            window.history.replaceState({
                                page: page
                            }, "标题", url);
                        } else if (query !== page) {
                            window.history.pushState({
                                page: page
                            }, "标题", url);
                        }
                    } else {
                        if (query !== page) {
                            location.href = url;
                        }
                    }
                },
                headRenderFn: function (data) {
                    return [function () {
                            if (data.icon) {
                                return $("<i/>", {
                                    "class": "accordion-icon " + data.icon
                                })
                            }
                        }(),
                        $("<span/>", {
                            "class": "accordion-title",
                            "text": data.name
                        })
                    ];
                }
            });
            accordionItem = accordion.querySelector("[data-page]");
            if (window.history.pushState) {
                window.addEventListener("popstate", function () {
                    var query = window.URL.query().page;
                    if (!query) {
                        accordionItem.click();
                        return;
                    }
                    accordion.querySelector("[data-page=" + query + "]").click();
                });
            }
            if (typeof window.URL.query().page === "undefined") {
                accordionItem.click();
            } else {
                accordion.querySelector("[data-page=" + window.URL.query().page + "]").click();
            }

            function doNavigation(page, navBtn, data, datas) {
                var breadcrumbDatas = getBreadcrumbData(data, datas),
                    relativeUrl = breadcrumbDatas.reduce(function (url, data) {
                        return url + "module/" + data.page + "/";
                    }, rootPath + "/static/");
                document.title = data.text;
                if (httpRequest) {
                    httpRequest.abort();
                }
                Object.keys(window.ajaxArray).forEach(function (key) {
                    var request = window.ajaxArray[key];
                    request.abort();
                });
                window.ajaxArray = {};
                httpRequest = $.ajax({
                        url: relativeUrl + page + ".html",
                        type: "GET",
                        beforeSend: function () {
                            /*子页面加载以前删除掉所有的interval，这样页面切换的时候，拥有的interval
                             * 就清除掉了.
                             * */
                            /*(function(){
                                for(var i=0;i<window.timers.length;i++){
                                    window.clearInterval(timers[i]);
                                }
                                window.timers = [];
                            })();
                            $(document).off("ajaxSend");*/
                        }
                    })
                    /* ;
                                    $.when(httpRequest, commonDataDeferred,userInfoDeferred) */
                    .done(function (html) {
                        var page = document.createElement("div");
                        page.relativeUrl = relativeUrl;
                        $(content).html($(page).addClass("page").html(html));
                    }).done(function () {
                        /*子页面加载完毕以后重绘以下echarts*/
                        /*  echartsResize(); */
                        /* var selector = btns.map(function (item) {
                             return "[data-code="+item.code+"]"
                         }).join(",");
                         $(selector).removeClass("hidden");*/
                    });
            }
        }
    })();
    /*退出系统*/
    $("#signOut").on('click', function () {
        $.ajax({
            url: rootPath + "/user/logout"
        }).done(function (data) {
            if (data.code === "000") {
                localStorage.setItem("userKey", "");
                localStorage.setItem("userInfo.id", "");
                localStorage.setItem("userInfo.userAccount", "");
                localStorage.setItem("userInfo.userName", "");
                location.href = "/";
            } else if (data.code && data.code !== "000") {
                simpleInfoDialog('type-warning', data.msg);
            } else {
                if (data != null && (data.indexOf('<!-- #登录页面#  -->') == 0 || data.indexOf('S0000006') >= 0)) {
                    location.href = "/";
                }
            }
        });
    });
})();