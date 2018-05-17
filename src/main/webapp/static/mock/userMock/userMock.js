/**
 * Created by suwt on 2017/3/14.
 */
(function () {
    $.mockjax({
        url: '/user/list',
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）",
            "data": [{
                id: "000001",
                userName: "李四",
                email: "12345@qq.com",
                mobile: "12345678901",
                orgId: "12",
                orgName: "山东电力公司",
                position: "yyyy",
                status: "0",
                userType:"0",
                userTypeName:"环境管理人员",
                roleId: "0",
                roleName: "总部操作员"
            }, {
                id: "000002",
                userName: "张三",
                email: "12345@qq.com",
                mobile: "12345678901",
                orgId: "0",
                orgName: "山东电力公司",
                position: "xxxx",
                status: "0",
                userType:"0",
                userTypeName:"环境管理人员",
                roleId: "0",
                roleName: "总部操作员"
            }, {
                id: "000003",
                userName: "李四",
                email: "12345@qq.com",
                mobile: "12345678901",
                orgId: "0",
                orgName: "山东电力公司",
                position: "xxxx",
                status: "1",
                userType:"1",
                userTypeName:"漏洞验证人员",
                roleId: "0",
                roleName: "总部操作员"
            }, {
                id: "000004",
                userName: "李四",
                email: "12345@qq.com",
                mobile: "12345678901",
                orgId: "0",
                orgName: "山东电力公司",
                position: "xxxx",
                status: "0",
                userType:"0",
                userTypeName:"环境管理人员",
                roleId: "0",
                roleName: "总部操作员"
            }],
            pageInfo: {
                index: 1,  //当前页
                count: 80, //总条数
                size: 15  //每页个数
            }
        }
    });
    //添加
    $.mockjax({
        url: '/user/create',
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）"
        }
    });
    //修改
    $.mockjax({
        url: '/user/modify',
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）"
        }
    });
    // 删除
    $.mockjax({
        url: '/user/remove',
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）"
        }
    });
    //启用
    $.mockjax({
        url: '/user/enable',
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）"
        }
    });
    //停用
    $.mockjax({
        url: '/user/disable',
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）"
        }
    });
    //获取单位、角色类型、用户类型接口
    $.mockjax({
        url: '/rest/common/data',
        responseText: {
            "code": "000",
            "msg": "查询异常，请重试（后端返回信息）",
            "data": {
                orgs:[
                    { id:1, pId:0, name:"国家电网",grade:"0"},
                    { id:11, pId:1, name:"北京电力公司",grade:"1"},
                    { id:111, pId:11, name:"昌平电力",grade:"2"},
                    { id:112, pId:11, name:"海淀电力",grade:"2"},
                    { id:12, pId:1, name:"山东电力公司",grade:"1"},
                    { id:121, pId:12, name:"石家庄电力",grade:"2"},
                    { id:13, pId:1, name:"湖南电力",grade:"1"}
                ],
                roleName:[
                    {id:0,name:"总部操作员"},
                    {id:1,name:'小黑'},
                    {id:2,name:'小白'}
                ],
                userType:[
                    {id:0,name:'小黑'},
                    {id:1,name:'小白'}
                ]
            }
        }
    });
})();