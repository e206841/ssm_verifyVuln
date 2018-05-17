/**
 * Created by Wangqiong on 2017/2/23.
 */
/* 表单提交 */
(function(){
    /*设置全局ajax默认选项*/
    $.extend(window,{
        ENCRYPT_TYPE:{
            rsa : "rsa",
            aes : "aes"
        },
        simplePublicKey:localStorage.getItem("publicKey"),
        simpleUserKey:localStorage.getItem('userKey')
    });
    $.ajaxSetup({
        type: "POST",
        contentType: "application/json",
        dataFilter:function (data) {
            if(this.encrypt===window.ENCRYPT_TYPE.aes){
                try{
                    JSON.parse(data);
                }catch(error){
                    try{
                        data = simpleAesDecode(data);
                        JSON.parse(data);
                    }catch(error){
                        throw error;
                    }
                }
            }
            return data;
        },
        beforeSend:function(XMLHttpRequest,params){
            /*定义一个加密字符*/
            var encrypt;
            /*若是localStorage中拥有encryptOpen则赋值为aes*/
            if(localStorage.getItem('encryptOpen')){
                encrypt=window.ENCRYPT_TYPE.aes;
            }
            /*若传入的headers中拥有encrypt则赋值为传入的参数*/
            if(params.headers&&params.headers.encrypt){
                encrypt=params.headers.encrypt;
            }
            /*若是encrypt存在并且不等于aes或rsa那么就抛出异常*/
            if(encrypt&&encrypt!==window.ENCRYPT_TYPE.aes&&encrypt!==window.ENCRYPT_TYPE.rsa){
                throw new Error("the encrypt must be 'aes' or 'rsa'");
            }
            if(encrypt){
                XMLHttpRequest.setRequestHeader("encrypt",encrypt);
            }
            if(typeof params.data ==="object"){
                params.data=JSON.stringify(params.data);
            }
            if(encrypt===window.ENCRYPT_TYPE.aes){
                this.encrypt=window.ENCRYPT_TYPE.aes;
                this.dataType="text";
                params.data=simpleAesEncode(params.data);
            }
            if(encrypt===window.ENCRYPT_TYPE.rsa){
                params.data=simpleRsaEncode(params.data);
            }
            /*rsa的数据处理*/
            function simpleRsaEncode(data){
                var encrypt = new JSEncrypt();
                encrypt.setPublicKey(window.simplePublicKey);
                return encrypt.encrypt(data);
            }
            /*aes的数据处理*/
            function simpleAesEncode(data){
                //	var iv = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
                var iv = "95cd2cc9571580226df27a35262f3ad4";
                //  var salt = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
                var salt = "cbacf2ca42a3d265123a3d007eb56ee4";
                var aesUtil = new AesUtil(128, 1000);
                var ciphertext = aesUtil.encrypt(salt, iv, window.simpleUserKey, data);
                return ciphertext;
            }
            function simpleAesDecode(base64Str){
                //	var iv = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
                var iv = "95cd2cc9571580226df27a35262f3ad4";
                //  var salt = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
                var salt = "cbacf2ca42a3d265123a3d007eb56ee4";
                var aesUtil = new AesUtil(128, 1000);
                var ciphertext = aesUtil.decrypt(salt, iv, window.simpleUserKey, base64Str);
                return ciphertext;
            }
        }
    });
    /*表单提交验证*/
    var validator = $("#login-form").validate({
        rules: {
            userAccount:{
                required: true
            },
            password:{
                required: true
            },
            verificationCode:{
                required: true
            }
        },
        errorElement: "div",
        errorPlacement: function ( error, element ) {
            error.addClass( "field-warning" );
            error.insertAfter(element.parent());
        },
        highlight: function ( element, errorClass, validClass ) {
            $( element ).addClass( "has-error" ).removeClass( "has-success" );
        },
        unhighlight: function (element, errorClass, validClass) {
            $( element ).addClass( "has-success" ).removeClass( "has-error" );
        }
    });
    $("#login-form").on("submit", function (e) {
        e.preventDefault();
        if(!validator.valid()){
            var errorField=validator.errorList[0].element;
            errorField.focus();
            errorField.scrollIntoView();
            return false;
        }else {
            $('.submit').text('登录中....');
            var encryption = {userKey:guid()};
            var requestData = $.extend(encryption,getFormData("#login-form"));
            $.ajax({
                url : "/user/login",
                headers:{encrypt:window.ENCRYPT_TYPE.rsa},
                data:JSON.stringify(requestData)
            }).done(function (data) {
                $('.submit').text('登   录');
                if(data.code === "000"){
                    localStorage.setItem("userKey",encryption.userKey);
                    localStorage.setItem("userInfo.id",data.data.id);
                    localStorage.setItem("userInfo.userAccount",data.data.userAccount);
                    localStorage.setItem("userInfo.userName",data.data.userName);
                    simpleUserKey = encryption.userKey;
                     location.href = "../index.html";
                }else {
                    BootstrapDialog.alert({
                        title: '信息',
                        type: 'type-warning',
                        buttonLabel: '确定',
                        message: data.msg
                    });
                    $('.verification-img').click();
                    $('#login-verification-text').val('')
                }
            }).fail(function () {
                BootstrapDialog.alert({
                    title: '信息',
                    type: 'type-warning',
                    buttonLabel: '确定',
                    message: window.code_message["001"]
                });
            });
        }
    });
    /*验证码图片*/
    $('.verification-img').attr('src', '/verificationCode?_t=' + (new Date()).getTime());
    $('.verification-img').click(function () {
        $(this).attr('src', '/verificationCode?_t=' + (new Date()).getTime());
    });
   /* /!*忘记密码*!/
    $(".forget-password").on("click",function () {
        localStorage.setItem("retrieveUserEmail","");
        localStorage.setItem("retrieveUserMobile","");
        localStorage.setItem("retrieveLoginName","");
        location.href = "../retrieve/retrieve.html";
    });*/
    $.ajax({
        url:"/publicKey"
    }).done(function (data) {
        if(data.code === "000"){
            localStorage.setItem("publicKey",data.data);
            simplePublicKey = data.data;
        }else {
            BootstrapDialog.alert({
                title: '信息',
                type: 'type-warning',
                buttonLabel: '确定',
                message: data.msg
            });

        }
    }).fail(function () {
        BootstrapDialog.alert({
            title: '信息',
            type: 'type-warning',
            buttonLabel: '确定',
            message: code_message['001']
        });
    });
    
    var guuid = null;
    function guid() {
        if (guuid == null) {
            guuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
                var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
                return v.toString(16);
            });
        }
        return guuid;
    }
})();

