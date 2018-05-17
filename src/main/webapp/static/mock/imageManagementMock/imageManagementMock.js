/**
 * Created by li812 on 2018/4/18.
 */
(function () {
    $.mockjax({
        url:"/ldxk/imageManagement/list",
        responseText:{
            code:"000",
            msg:"查询异常，请重试（后端返回信息）",
            data:[{
                imageName:"linux-centos-tomcat",
                OSVersion:"centos6.5",
                environment:"JDK1.8",
                version:"tomcat8",
                fileSize:"4GB",
                describe:"linux centos",
                createTime:"2018-01-05"
            }],
            pageInfo: {
                index: 1,  //当前页
                count: 80, //总条数
                size: 15  //每页个数
            }
        }
    });

})();