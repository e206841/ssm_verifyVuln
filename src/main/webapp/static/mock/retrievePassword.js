/**
 * Created by fromtheblue on 2017/6/29.
 */
(function () {
    /*找回密码*/
    $.mockjax({
        url: "/ldxk/forget/retrive",
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）",
            "data": {
                mobile: "187****1888",
                email: "a****@sina.com",
                forgetId:"01"
            }
        }
    });
    /*通过邮箱验证*/
    $.mockjax({
        url: "/ldxk/forget/sendEmail",
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）"
        }
    });
    /*获取验证码*/
    $.mockjax({
        url: "/ldxk/forget/sendVerificationCode",
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）"
        }
    });
    /*通过短信验证提交验证码*/
    $.mockjax({
        url: "/ldxk/forget/message",
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）"
        }
    });
    /*重置密码*/
    $.mockjax({
        url: "/ldxk/forget/resetPassword",
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）"
        }
    })
})();
