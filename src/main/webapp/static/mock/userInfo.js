/**
 * Created by fromtheblue on 2017/3/21.
 */
//登录后返回的用户信息   参数为用户名/密码/验证码
(function () {
    $.mockjax({
        url:"/rest/common/getLoginUserInfo",
        responseText:{
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）",
            "data":{
                id:"01",
                loginName:"xyz",/*用户名*/
                userName:"abc" /*姓名*/
            }
        }
    })
})();