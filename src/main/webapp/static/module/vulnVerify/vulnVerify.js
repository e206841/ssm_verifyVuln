/**
 * Created by fromtheblue on 2018/4/12.
 */
(function(){
    var local_json={
            "pageInfo":{
                "index":1,
                "size":20,
                "cont":10
            },
            "queryInfo":{}
        },
        validator,
        /*要下载文件id*/
        vulnId,
        vulnName,
        verifyId,
        verifyFileUrl;
    validator = $("#upPatch-form").validate({
        rules: {
            patchName: {
                required: true
            }
        }
    });
    /*模态框被隐藏时，重置模态框*/
    $(".modal").on('hidden.bs.modal', function (event) {
        $(this).find("form").get().forEach(function (form) {
            form.reset();
        });
    });
    /*表格配置*/
    $("#vulVerify-table").table({
        showRadio: false,
        showNo: false,
        columns: [{
            title: "CNNVD编号",
            field: "cnnvdNo"

        },{
            title: "漏洞名称",
            field: "vulnName"

        },{
            title: "CVE编号",
            field: "cveNo"

        },{
            title: "漏洞类型",
            field: "vulnTypeName"
        },{
            title: "漏洞级别",
            field: "vulnSeverityName"
        },{
            title: "验证代码",
            field: "verifycodestatus",
            cellTitle:false,
            formatter:function (value,rowData) {
                if(+value ==1){
                    return $("<a/>",{
                        "class": "col-md-100 col-xs-100 text-underline middle",
                        //"data-code":"button-decide-vulnArchive",
                        "click":function(){
                            console.log(rowData);
                            var vulnId = rowData.vulnId;
                            BootstrapDialog.confirm({
                                title: '信息',
                                type: 'type-warning',
                                size: 'size-small',
                                message: '是否要下载验证代码文件?',
                                btnCancelLabel: '取消',
                                btnOKLabel: '确定',
                                callback: function (result) {
                                    if(result){
                                        var url = rootPath+'/vulnVerify/download/'+vulnId;
                                        download(url);
                                        console.log(url);
                                    }
                                    return;
                                }
                            });
                        }
                    }).append(
                        document.createTextNode('验证代码')
                    );
                }else {
                    return $("<a/>",{
                        "class":"btn btn-primary btn-xs text-padding",
                        "data-code":"button-verify-vulnArchive",
                        "click":function(){
                            $("#validateDialog").modal("show");
                            $("#validateName").val(rowData.vulnName);
                            $("#validate-form").submit(function(){
                                var vulnId ={};
                                vulnId.vulnId =rowData. vulnId;
                                $('#validate-form').ajaxSubmit({
                                    url:rootPath+"/vulnVerify/addVerifyCode",
                                    enctype: "multipart/form-data",
                                    type: "post",
                                    data: vulnId,
                                    success: function (data) {
                                        if (data.code === "000") {
                                            simpleInfoDialog('type-success', code_message['000']);
                                            loadTable();
                                            $('#validateDialog').modal('hide');
                                        } else {
                                            simpleInfoDialog('type-warning', data.resultHint);
                                        }
                                    }
                                });
                            });

                        }
                    }).append(
                        $("<span/>",{
                            "class":"fa fa-arrow-circle-o-up"
                        }),
                        document.createTextNode('上传')
                    );
                }
            }

        },{
            title: "补丁",
            field: "patchstatus",
            cellTitle:false,
            formatter:function (value,rowData) {
                if(+value ===1){
                    return $("<a/>",{
                        "class": "col-md-100 col-xs-100 text-underline",
                        //"data-code":"button-decide-vulnArchive",
                        "click":function(){
                            $.post(rootPath+"/vulnVerify/queryPatchInfo",JSON.stringify({"vulnId":rowData.vulnId})).done(function (data) {
                                if(data.code ==="000"){
                                    $(".page-module-patch").removeClass("hidden");
                                    $(".page-module-main").addClass("hidden");
                                    var fillData = data.data[0];
                                    vulnId = rowData.vulnId;
                                    fillFormData("#patchDetail-form", rowData);
                                    fillFormData("#patchDetail-form", fillData);
                                    generateFileDownload(data.data);
                                }else {

                                }
                            })

                        }
                    }).append(
                        document.createTextNode('补丁信息')
                    );
                }else {
                    return $("<a/>",{
                        "class":"btn btn-primary btn-xs",
                        "data-code":"button-verify-vulnArchive",
                        "click":function(){
                            $("#upPatchDialog").modal("show");
                            $("#imageName").val(rowData.vulnName);
                            $("#upPatch-form").off("submit.submit").on("submit.submit",function () {
                                if(!validator.valid()){
                                    var errorField = validator.errorList[0].element;
                                    errorField.focus();
                                    errorField.scrollIntoView();
                                    return;
                                }else {
                                    var vulnId ={};
                                    vulnId.vulnId =rowData. vulnId;
                                    $('#upPatch-form').ajaxSubmit({
                                        url:rootPath+"/vulnVerify/addPatch",
                                        enctype: "multipart/form-data",
                                        type: "post",
                                        data: vulnId,
                                        success: function (data) {
                                            if (data.code === "000") {
                                                simpleInfoDialog('type-success', code_message['000']);
                                                $("#upPatchDialog").modal("hide");
                                                loadTable();
                                            } else {
                                                simpleInfoDialog('type-warning', data.resultHint);
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    }).append(
                        $("<span/>",{
                            "class":"fa fa-arrow-circle-o-up"
                        }),
                        document.createTextNode('上传')
                    );
                }
            }

        },{
            title: "镜像环境",
            field: "imageName"

        },{
            title: "操作",
            field: "operation",
            cellTitle:false,
            formatter: function (value,rowData) {
                return $("<a/>", {
                    "class": "btn btn-primary btn-xs middle",
                    "click": function () {
                        if(!rowData.imageId){
                            simpleInfoDialog('type-warning',"此漏洞下镜像还未开启!");
                            return;
                        }else {
                            vulnName = rowData.vulnName;
                            verifyId = rowData.vulnId;
                            $.post(rootPath+"/vulnVerify/verify/",JSON.stringify({"imageId":rowData.imageId})).done(function (data) {
                                if(data.code==="000"){
                                    $(".page-module-image").removeClass("hidden");
                                    $(".page-module-main").addClass("hidden");
                                    // 获取容器的信息（调用方法）
                                    getImageRequest(data.data)
                                }else {
                                    simpleInfoDialog('type-warning', data.resultHint);
                                }
                            })
                        }
                    }
                }).append(
                        $("<span/>",{
                            "class":"fa fa-check-square-o"
                        }),
                    document.createTextNode('验证')
                );
            }

        }]
    });
    /*调用虚拟机函数*/
    // 获取容器信息的（请求是否要，需要与后端协商）
    function getImageRequest(data) {
        if(data.status==="running"){
            var current_guac = {};
            current_guac.broker_host = data.ip;
            current_guac.broker_port = data.port;
            current_guac.graphics_passwd = data.pwd;
            window.UI.connect(current_guac);
        }else {
            simpleInfoDialog('type-warning',"虚拟机暂未开启,请稍后再链接!");
            return;
        }
    }


    /*虚拟机结束*/

    /*加载表格数据*/
    function loadTable(){
        $("#vulVerify-table").table("setDatas",[]);
        return $.post(rootPath+'/vulnVerify/list', JSON.stringify(local_json)).done(function (data) {
            if (data.code === "000") {
                $.extend(local_json.pageInfo, data.pageInfo);
            } else {
                simpleInfoDialog('type-warning', data.msg);
            }
        }).always(function (data) {
            console.log(data);
            $("#vulVerify-table").table("setDatas", data.data);
            loadPagination("#vulVerify-pagination", local_json.pageInfo, loadTable);
        });
    }
    loadTable();
    /*查询*/
   $("#searchBtn").on("click",function(){
       local_json.queryInfo = getFormData('#search-vulVerify');  //查询的数据
       local_json.pageInfo.index = 1;
       loadTable();
   });
   /*补丁信息界面打开新链接*/
    $(".openHref").off("click").on("click",function (e) {
        window.open ("http://"+e.target.value+"/");
    });

    /*补丁信息界面返回*/
    $("#dispatchReturn").on("click",function(){
        $(".page-module-patch").addClass("hidden");
        $(".page-module-main").removeClass("hidden");
    });

    /*动态添加下附件*/
    function generateFileDownload(data) {
        $(".downFile", "#patchDetail-form").append(
            data.map(function (item, idx) {
                return $("<div/>", {
                    "class": "row"
                }).append(
                    $("<label/>", {
                        "class": "col-md-12 col-xs-12 control-label"
                    }),
                    $("<div/>", {
                        "class": "form-group col-md-50 col-xs-50"
                    }).append(
                        $("<div/>", {
                            "class": "col-md-100 col-xs-100 text-underline",
                            "click": function () {
                                var url = rootPath+'/vulnVerify/downloadPatchFile/'+vulnId;
                                download(url);
                            }
                        }).append(
                            $("<input/>", {
                                "class": "form-control removeBorder download-file textColor  text-underline",
                                "name": "fileName",
                                "readonly": true,
                                "value": item.fileName
                            })
                        )
                    )
                )
            })
        );
    }



    /*上传附件*/
    (function importFile() {
        /*补丁文件上传*/
        $('#patchFile').filestyle({
            iconName: 'icon-file',
            buttonText: '选择文件',
            buttonName: 'btn-info'
        });
        /*上传验证代码文件*/
        $('#validateFile').filestyle({
            iconName: 'icon-file',
            buttonText: '选择文件',
            buttonName: 'btn-info'
        });
    })();

    /*验证代码操作  */
    (function(){
        $("#validateClose").on("click", function () {
            $("#validateDialog").modal("hide")
        });
        /*上传补丁界面*/
        $("#closePatch").on("click",function(){
            $("#upPatchDialog").modal("hide")
        });
    })();

/*截屏*/
    (function () {

            var canvas = document.getElementById("canvas");
            document.querySelector("#screenShot").addEventListener("click", function() {
                html2canvas(document.querySelector("#noVNC_canvas"), {canvas:canvas}).then(function(canvas) {
                    $("#canvas").css({"width":"370px","height":"200px"});
                    var imgData = canvas.toDataURL();
                    var img = document.createElement('img');
                    img.src = imgData;
                    verifyFileUrl = imgData;
                    document.getElementById("imgCont").appendChild(img);
                });
            }, false);


            /*提交*/
            $("#saveBtn").off("click").on("click",function () {
                var formData = getFormData('#image-form');
                formData.vulnId = verifyId;
                formData.vulnName = vulnName;
                formData.verifyFileUrl = verifyFileUrl;
                console.log(formData);
               $.post(rootPath+"/vulnVerify/save/",JSON.stringify(formData)).done(function (data) {
                   if(data.code ==="000"){
                       simpleInfoDialog('type-success', code_message['000']);
                       $(".page-module-image").addClass("hidden");
                       $(".page-module-main").removeClass("hidden");
                       loadTable();
                   }else {
                       simpleInfoDialog('type-warning', data.msg);
                   }
               })
            })

    })();

})();