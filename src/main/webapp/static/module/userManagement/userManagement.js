/**
 * Created by wangqiong on 2017/3/7.
 */
(function () {
    var
        local_json = {
            "pageInfo": {
                "index": 1, //当前页
                "count": 0, //总条数
                "size": 15 //每页个数
            },
            "queryInfo": {}
        },
        /*表单验证配置*/
        validator,
        operateData;
    /*资产列表配置信息*/
    $("#userManagement-table").table({
        id:'userId',
        showRadio: false,
       /*  showNo: false, */
        columns: [{
            title: "用户",
            field: "userName"
        }, {
            title: "账号",
            field: "userAccount"
        }, {
            title: "用户类型",
            field: "userTypeName"
        }, {
            title: "电话",
            field: "telephone"
        }, {
            title: "邮箱",
            field: "mailbox"
        }, {
            title: "状态",
            field: "status",
            formatter:function (value) {
                switch (+value){
                    case 1:
                        return '启用';
                    case 2:
                        return '停用';
                }
            }
        }, {
            title: "更新者",
            field: "updateUser"
        }, {
            title: "更新时间",
            field: "updateTime"
        }, {
            title: "操作",
            field: "status",
            cls: 'operateBar',
            cellTitle: false,
            formatter: function (value, rowData) {
                return [$("<a/>", {
                        "class": "btn btn-info btn-xs table-btn",
                        "click": function () {
                            fillTableData("#details-table", rowData);
                            $('#checkDialog').modal('show');
                        }
                    }).append(
                        $("<span/>", {
                            "class": "fa fa-file-text-o"
                        }),
                        document.createTextNode('详情')
                    ), $("<a/>", {
                        "class": "btn edit-btn btn-xs table-btn",
                        "click": function () {
                            validator.resetFormExtra();
                            operateData = rowData;
                            fillFormData('#userInfo-form', rowData);
                            addOrEditSubmit("edit");
                            $('#editDialog').on('show.bs.modal', function (event) {
                                $(this).find('.modal-title').text('编辑');
                                /*修改操作的时候显示是否修改密码,同时密码框默认不可用*/
                                $("#isResetPwd").removeClass("hidden");
                                $("#resetPwd,.password").prop("disabled",true);
                            });
                            $('#editDialog').modal('show');
                        }
                    }).append(
                        $("<span/>", {
                            "class": "fa fa-pencil-square-o"
                        }),
                        document.createTextNode('编辑')
                    ),
                    function () {
                        switch (+value) {
                            case 2:
                                /* 停用 */
                                return (
                                    $("<a/>", {
                                        "class": "btn btn-success btn-xs table-btn enable-btn",
                                        "click": function () {
                                            BootstrapDialog.confirm({
                                                title: '信息',
                                                type: 'type-warning',
                                                size: 'size-small',
                                                message: code_message['005'],
                                                btnCancelLabel: '取消',
                                                btnOKLabel: '确定',
                                                callback: function (result) {
                                                    if (result) {
                                                        $(".enable-btn").prop("disabled", true);
                                                        $.post(rootPath+'/user/enable', JSON.stringify({
                                                            'id': rowData.userId
                                                        })).done(function (data) {
                                                            if (data.code === "000") {
                                                                simpleInfoDialog('type-success', code_message['000']);
                                                                loadTable();
                                                            } else {
                                                                simpleInfoDialog('type-warning', data.msg);
                                                            }
                                                        }).always(function () {
                                                            $(".enable-btn").prop("disabled", false);
                                                        });
                                                    }
                                                }
                                            })
                                        }
                                    }).append(
                                        $("<span/>", {
                                            "class": "glyphicon glyphicon-play"
                                        }),
                                        document.createTextNode('启用')
                                    )
                                );
                            case 1:
                                return (
                                    $("<a/>", {
                                        "class": "btn btn-danger btn-xs table-btn disable-btn",
                                        "click": function () {
                                            BootstrapDialog.confirm({
                                                title: '信息',
                                                type: 'type-warning',
                                                size: 'size-small',
                                                message: code_message['006'],
                                                btnCancelLabel: '取消',
                                                btnOKLabel: '确定',
                                                callback: function (result) {
                                                    if (result) {
                                                        $(".disable-btn").prop("disabled", true);
                                                        $.post(rootPath+'/user/disable', JSON.stringify({
                                                            'id': rowData.userId
                                                        })).done(function (data) {
                                                            if (data.code === "000") {
                                                                simpleInfoDialog('type-success', code_message['000']);
                                                                loadTable();
                                                            } else {
                                                                simpleInfoDialog('type-warning', data.msg);
                                                            }
                                                        }).always(function () {
                                                            $(".disable-btn").prop("disabled", false);
                                                        });
                                                    }
                                                }
                                            });
                                        }
                                    }).append(
                                        $("<span/>", {
                                            "class": "glyphicon glyphicon-stop"
                                        }),
                                        document.createTextNode('停用')
                                    )
                                )
                        }
                    }(), $("<a/>", {
                        "class": "btn delete-btn btn-xs",
                        "click": function () {
                            BootstrapDialog.confirm({
                                title: '信息',
                                type: 'type-warning',
                                size: 'size-small',
                                message: code_message['004'],
                                btnCancelLabel: '取消',
                                btnOKLabel: '确定',
                                callback: function (result) {
                                    if (result) {
                                        $.post(rootPath+'/user/remove', JSON.stringify({
                                            'id': rowData.userId
                                        })).done(function (data) {
                                            if (data.code === "000") {
                                                simpleInfoDialog('type-success', code_message['000']);
                                                loadTable();
                                            } else {
                                                simpleInfoDialog('type-warning', data.msg);
                                            }
                                        });
                                    }
                                }
                            });
                        }
                    }).append(
                        $("<span/>", {
                            "class": "fa fa-trash-o"
                        }),
                        document.createTextNode('删除')
                    )
                ];
            }
        }]
    });
    /*查询*/
    $(".search-bar").submit(function () {
        local_json.queryInfo = getFormData('.search-bar');
        local_json.pageInfo.index = 1;
        loadTable();
    });
    /* 添加和修改校验 */
    validator = $("#userInfo-form").validate({
        rules: {
            userName: {
                required: true
            },
            userAccount: {
                required: true,
                userAccount:true
            },
            password: {
                required: true,
                passwordCheck: true
            },
            confirmPassword: {
                required: true,
                equalTo: "#password"
            },
            userType: {
                required: true
            },
            mailbox: {
                emailCheck: true
            },
            telephone: {
                telephoneCheck: true
            }
        }
    });
    /*添加*/
    $(".add-btn").on("click", function () {
        validator.resetFormExtra();
        $('#editDialog').on('show.bs.modal', function (event) {
            $(this).find('.modal-title').text('添加');
            /*添加操作的时候隐藏是否修改密码,同时密码框可用*/
            $("#isResetPwd").addClass("hidden");
            $("#resetPwd,.password").prop("disabled",false);
        });
        $('#editDialog').modal('show');
        addOrEditSubmit("create");
    });
    /*重置密码*/
    $("#isResetPwd :checkbox").on("change",function(){
        if(this.checked){
            $("#resetPwd,.password").prop("disabled",false);
        }else{
            /*当不重置密码的时候将密码和确认密码的样式去掉*/
            $("#resetPwd")
                .find(".has-success,.has-error")
                .removeClass("has-success has-error")
                .end()
                .find(".error")
                .remove();
            $("#resetPwd,.password").prop("disabled",true);
        }
    });
    /**
     * 添加或修改提交表单的方法
     * @func
     * @param operate 进行的操作,add添加操作,edit修改操作
     */
    function addOrEditSubmit(operate) {
        $("#userInfo-form").off("submit.submit").on("submit.submit", function () {
            if (!validator.valid()) {
                var errorField = validator.errorList[0].element;
                errorField.focus();
                errorField.scrollIntoView();
                return;
            } else {
                var formData = getFormData('#userInfo-form');
                if (operate !== "edit") {
                    saveData("create", formData);
                } else {
                    var newData = $.extend({}, {
                        userId: operateData.userId
                    }, formData);
                    saveData("modify", newData);
                }
            }

        });
    }
    /**
     * 添加或修改保存数据的方法
     * @func
     * @param url
     * @param newData  提交的数据
     */
    function saveData(url, newData) {
        $.ajax({
            url: rootPath+"/user/" + url,
            /* headers: {
                encrypt: window.ENCRYPT_TYPE.aes
            }, */
            data: JSON.stringify(newData)
        }).done(function (data) {
            if (data.code === "000") {
                simpleInfoDialog('type-success', code_message['000']);
                $('#editDialog').modal('hide');
                if (url == 'create') {
                    local_json.pageInfo.index = 1;
                }
                loadTable();
            } else {
                simpleInfoDialog('type-warning', data.masg);
            }
        });
    }
    loadTable();
    /*请求表格数据*/
    function loadTable() {
        return $.post(rootPath+'/user/list', JSON.stringify(local_json)).done(function (data) {
            if (data.code === "000") {
                $.extend(local_json.pageInfo, data.pageInfo);
            } else {
                simpleInfoDialog('type-warning', data.msg);
            }
        }).always(function (data) {
            console.log(data.data);
            $("#userManagement-table").table("setDatas", data.data);
            loadPagination("#userManagement-pagination", local_json.pageInfo, loadTable);
        });
    }
})();