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
        /*j镜像上传成功返回的id*/
        uuid,
        flag = false;

    /*模态框被隐藏时，重置模态框*/
    $(".modal").on('hidden.bs.modal', function (event) {
        $(this).find("form").get().forEach(function (form) {
            form.reset();
        });
    });

    /*上传文件*/
    (function(){
        $('#patchFile').filestyle({
            iconName:'icon-file',
            buttonText: '添加',
            buttonName: 'btn-warning'
        });
    })();


    /*表格配置*/
    $("#imageManagement-table").table({
        showRadio: false,
        showNo: false,
        columns: [{
            title: "镜像名",
            field: "imageName"
        },{
            title: "OS系统版本",
            field: "os"
        },{
            title: "支撑环境",
            field: "enviroment"
        },{
            title: "软件版本",
            field: "software"
        },{
            title: "文件大小",
            field: "fileSize"
        },{
            title: "镜像描述",
            field: "description"
        },{
            title: "创建时间",
            field: "createTime"
        }]
    });
    /*请求表格数据*/
    function loadTable(){
        return $.post(rootPath+'/image/imageList', JSON.stringify(local_json)).done(function (data) {
            if (data.code === "000") {
                $.extend(local_json.pageInfo, data.pageInfo);
            } else {
                simpleInfoDialog('type-warning', data.msg);
            }
        }).always(function (data) {
            $("#imageManagement-table").table("setDatas", data.data||[]);
            loadPagination("#imageManagement-pagination", local_json.pageInfo, loadTable);
        });
    }
    loadTable();

    /*查询*/
    $(".search-bar").submit(function () {
        local_json.queryInfo = getFormData(".search-bar");
        local_json.pageInfo.index = 1;
        loadTable();
    });
    /**
     * 添加
     */
    $(".add-btn").on("click",function(){
        $('#addDialog').modal('show');
        $('#addDialog').on('shown.bs.modal', function (event) {
            $(this).find('.modal-title').text('添加镜像');
        });

    });
    $("#closeBtn").on("click",function(){
        $('#addDialog').modal('hide');
    });
    /*支撑环境添加*/
    (function(){
        var   imageAddData = [];
        $("#environmentAddBtn").on("click",function(){
            $('#environment_add_Dialog').modal('show');
            $('#environment_add_Dialog').on('shown.bs.modal', function (event) {

            });

            /*添加支撑环境*/
            $("#environmentAddForm").off("submit.submit").on("submit.submit",function(){
                var data = $("#addEnvironment-table").data("table").datas;
                var formData =  getFormData('#environmentAddForm');
                $('#environment_add_Dialog').modal('hide');
               // if(data.length===0){
               //     imageAddData.push(formData);
               //     $("#addEnvironment-table").table("setDatas",imageAddData);
               // }else {
               //
               // }
                $("#addEnvironment-table").table("setDatas",[]);
                imageAddData.push(formData);
                $("#addEnvironment-table").table("setDatas",imageAddData);
            });

        });
        /*add支撑环境表格*/
        $("#addEnvironment-table").table({
            showRadio: false,
            columns: [{
                title: "环境名称",
                field: "imageName"
            },{
                title: "环境版本",
                field: "imageVersion"
            },
             {
                title: "操作",
                field: "operation",
                formatter: function (value,rowData) {
                    if(!value){
                        return $("<a/>",{
                            "class":"btn  btn-success btn-xs middle",
                            "data-code":"button-archive-vulnArchive",
                            "click":function(){
                                BootstrapDialog.confirm({
                                    title: '信息',
                                    type: 'type-warning',
                                    size: 'size-small',
                                    message: '是否要删除?',
                                    btnCancelLabel: '取消',
                                    btnOKLabel: '确定',
                                    callback: function (result) {
                                        if (result) {
                                            var data = $("#addEnvironment-table").data("table").datas;
                                            data.map(function (item) {
                                                if(item.imageName===rowData.imageName||item.imageVersion ===rowData.imageVersion){
                                                    data.splice(data.indexOf(item), 1);
                                                    $("#addEnvironment-table").table("setDatas",[]);
                                                }
                                            });
                                            $("#addEnvironment-table").table("setDatas", data);
                                        }
                                    }
                                });

                            }
                        }).append(
                            $("<span/>",{
                                "class":"icon-vulnerability-collection"
                            }),
                            document.createTextNode('删除')
                        )
                    }
                }
            }
            ]
        });
        $("#addEnvironment-table").table("setDatas", []);
    })();





    /*应用软件操作--添加*/
    (function () {
        var   versionAddData = [];
        $("#versionAddBtn").on("click",function(){
            $('#version_add_Dialog').modal('show');
            $('#version_add_Dialog').on('shown.bs.modal', function (event) {
            });
        });
        /**/
        $("#addVersion-table").table({
            showRadio: false,
            cellTitle: false,
            columns: [{
                title: "软件名称",
                field: "versionName"
            },{
                title: "软件版本",
                field: "versionNo"
            },{
                title: "操作",
                field: "imageName",
                formatter: function (value,rowData) {
                    if(!value){
                        return $("<a/>",{
                            "class":"btn  btn-success btn-xs middle",
                            "data-code":"button-archive-vulnArchive",
                            "click":function(){
                                BootstrapDialog.confirm({
                                    title: '信息',
                                    type: 'type-warning',
                                    size: 'size-small',
                                    message: '是否要删除?',
                                    btnCancelLabel: '取消',
                                    btnOKLabel: '确定',
                                    callback: function (result) {
                                        if (result) {
                                            var data = $("#addVersion-table").data("table").datas;
                                            data.map(function (item) {
                                                if(item.versionName===rowData.versionName||item.versionNo ===rowData.versionNo){
                                                    data.splice(data.indexOf(item), 1);
                                                    $("#addVersion-table").table("setDatas",[]);
                                                }
                                            });
                                            $("#addVersion-table").table("setDatas", data);
                                        }
                                    }
                                });

                            }
                        }).append(
                            $("<span/>",{
                                "class":"icon-vulnerability-collection"
                            }),
                            document.createTextNode('删除')
                        )
                    }
                }
            }]
        });
        $("#addVersion-table").table("setDatas", []);
        /*添加支撑环境*/
        $("#version_add-form").off("submit.submit").on("submit.submit",function(){
            var data = $("#addVersion-table").data("table").datas;
            var formData =  getFormData('#version_add-form');
            $('#version_add_Dialog').modal('hide');
            for(var i = 0;i<data.length;i++){
                if(i.versionName===formData.versionName||i.versionNo ===formData.versionNo){
                    simpleInfoDialog('type-warning','已添加过不能重复添加!','size-small');
                    return;
                }
            }
            $("#addVersion-table").table("setDatas",[]);
            versionAddData.push(formData);
            $("#addVersion-table").table("setDatas",versionAddData||[]);

        });
    })();
    /*镜像文件操作*/
    (function () {
        $("#imageFile_table").table({
            showRadio: false,
            showNo: false,
            columns: [{
                title: "文件名称",
                field: "imageName"
            },{
                title: "文件大小",
                field: "fillSize"
            },{
                title: "上传进度",
                field: ""
            },{
                title: "操作",
                field: "",
                cellTitle: false,
                formatter:function(value,rowData) {
                    var btns=[];
                    var scanTaskBtn=$("<a/>",{
                        "class":"btn btn-success btn-xs  subBtn",
                        "click":function(){
                            BootstrapDialog.confirm({
                                title: '信息',
                                type: 'type-warning',
                                size: 'size-small',
                                message: '请确认上传文档,一经上传不可修改!',
                                btnCancelLabel: '取消',
                                btnOKLabel: '确定',
                                callback: function (result) {
                                    if(result){
                                        $('#subImage-form').ajaxSubmit({
                                            url: rootPath+"/image/uploadFile",
                                            enctype: "multipart/form-data",
                                            type: "post",
                                            success: function (data) {
                                                if (data.code === "000") {
                                                    uuid = data.data;
                                                    flag = true;
                                                    $("#subBtn").attr("disabled", false);
                                                    $(".subBtn").attr("disabled", true);
                                                    simpleInfoDialog('type-success', code_message['000']);
                                                } else {
                                                    flag = false;
                                                    simpleInfoDialog('type-warning', data.msg);
                                                }
                                            }
                                        });
                                    }
                                    return;
                                }
                            });
                        }
                    }).append(
                        $("<span/>",{
                            "class":"fa fa-arrow-circle-o-up"
                        }),
                        document.createTextNode('上传')
                    );
                    btns.push(scanTaskBtn);
                    // var taskInstanceBtn=$("<a/>",{
                    //     "class": "btn btn-info btn-xs",
                    //     "data-code":"button-decide-vulnArchive",
                    //     "click":function(){
                    //
                    //     }
                    // }).append(
                    //     //$("<span/>",{
                    //     //    "class": "glyphicon glyphicon-upload"
                    //     //}),
                    //     document.createTextNode("暂停")
                    // );
                    // var taskCancelBtn=$("<a/>",{
                    //     "class": "btn btn-info btn-xs",
                    //     "data-code":"button-decide-vulnArchive",
                    //     "click":function(){
                    //         flag = 3;
                    //     }
                    // }).append(
                    //     //$("<span/>",{
                    //     //    "class": "glyphicon glyphicon-upload"
                    //     //}),
                    //     document.createTextNode("取消")
                    // );
                    // if(flag===1){
                    //     btns.push(scanTaskBtn);
                    //
                    // }else if(flag ===2) {
                    //     btns.splice(0,btns.length);
                    //     btns.push(taskInstanceBtn,taskCancelBtn);
                    // }else {
                    //     btns.splice(0,btns.length);
                    //     btns.push(scanTaskBtn);
                    // }
                    return btns;
                }
            }]
        });
        $("#imageFile_table").table("setDatas", []);
    })();






    (function(){
        /*镜像文件表格*/
        validator = $(".addDialog-form").validate({
            rules: {
                imageName: {
                    required: true
                },
                osName: {
                    required: true
                },
                osVersions: {
                    required: true
                }
            }
        });

        $("#patchFile").change(function () {
            var files = this.files[0],imageObj={},imageData=[];
            var   size = files.size > 1024
                ? files.size / 1024  > 1024
                ? files.size / (1024 * 1024) > 1024
                ? (files.size / (1024 * 1024 * 1024)).toFixed(2) + 'GB'
                : (files.size / (1024 * 1024)).toFixed(2) + 'MB'
                : (files.size / 1024).toFixed(2) + 'KB'
                : (files.size).toFixed(2) + 'B';
            imageObj.imageName=files.name;
            imageObj.fillSize=size;
            imageData.push(imageObj);
            $("#imageFile_table").table("setDatas",imageData);
        });


        /*镜像文件提交*/
        $(".addDialog-form").off("submit.submit").on("submit.submit",function () {
            if(!flag){
                simpleInfoDialog('type-success',"请确定镜像文件是否已上传!");
                return;
            }else {
                if(!validator.valid()){
                    var errorField = validator.errorList[0].element;
                    errorField.focus();
                    errorField.scrollIntoView();
                    return;
                }else{
                    var formData = getFormData(".addDialog-form"),os,versionDatas=[],environmentDatas=[],
                        versionData = $("#addVersion-table").data("table").datas, environmentData = $("#addEnvironment-table").data("table").datas;
                    os =formData.osName.concat(formData.osVersions);
                    formData.os = os;
                    delete  formData.osName;
                    delete  formData.osVersions;
                    versionData.map(function (item) {
                        versionDatas.push(item.versionName.concat(item.versionNo));
                    });
                    environmentData.map(function (item) {
                        environmentDatas.push(item.imageName.concat(item.imageVersion));
                    });
                    formData.enviroment = environmentDatas.join(",");
                    formData.software = versionDatas.join(",");
                    formData.uuid = uuid;
                    $.post(rootPath+'/image/add', JSON.stringify(formData)).done(function (data) {
                        if (data.code === "000") {
                            simpleInfoDialog('type-success', code_message['000']);
                            $('#addDialog').modal('hide');
                            loadTable();
                        } else {
                            simpleInfoDialog('type-warning', data.msg);
                        }
                    })
                }
            }

        });
    })();
})();


