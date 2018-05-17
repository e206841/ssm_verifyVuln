/**
 * Created by li812 on 2018/4/23.
 */
/*表格数据*/
(function () {
    $.mockjax({
        url:"/ldxk/vulnVerify/list",
        responseText:{
            code:"000",
            msg:"查询异常，请重试（后端返回信息）",
            data:[{
                id:12093,
                CNNVDCode:"CNNVD编号",
                vulName:"漏洞名称",
                CVECode:"CVE编号",
                vulType:"漏洞类型",
                vulnLevel:"漏洞级别",
                vulnVerify:2,
                patch:2,
                environment:"镜像环境"
            },{
                id:12093,
                CNNVDCode:"CNNVD编号",
                vulName:"漏洞名称",
                CVECode:"CVE编号",
                vulType:"漏洞类型",
                vulnLevel:"漏洞级别",
                vulnVerify:1,
                patch:1,
                environment:"镜像环境"
            }],
            pageInfo: {
                index: 1,  //当前页
                count: 80, //总条数
                size: 15  //每页个数
            }
        }
    });

    /*补丁提交*/
    $.mockjax({
        url:"/ldxk/vulnVerify/fileUp",
        responseText: {
            "successful": true,
            'resultHint': "查询异常，请重试（后端返回信息）"
        }
    })

})();