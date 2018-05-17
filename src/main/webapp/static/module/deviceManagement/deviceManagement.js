/**
 * Created by fromtheblue on 2018/4/12.
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
        };
    /*资产列表配置信息*/
    $("#deviceManagement-table").table({
        id: 'hostMachineId',
        showRadio: false,
       /*  showNo: false, */
        columns: [{
            title: "设备IP",
            field: "hostMachineIp"
        }, {
            title: "状态",
            field: "status",
            formatter: function (value) {
                switch (+value) {
                    case 1:
                        return '运行';
                    case 2:
                        return '未运行';
                }
            }
        }, {
            title: "CPU",
            field: "cpuCoreNum"
        }, {
            title: "RAM",
            field: "ramSize"
        }, {
            title: "DISK",
            field: "diskSize"
        }, {
            title: "操作",
            field: "status",
            cls: 'operateBar',
            cellTitle: false,
            formatter: function (value, rowData) {
                switch (+value) {
                    case 2:
                        return $("<a/>", {
                            "class": "btn btn-success btn-xs table-btn enable-btn",
                            "click": function () {
                                BootstrapDialog.confirm({
                                    title: '信息',
                                    type: 'type-warning',
                                    size: 'size-small',
                                    message: '确定重启？',
                                    btnCancelLabel: '取消',
                                    btnOKLabel: '确定',
                                    callback: function (result) {
                                        if (result) {
                                            $(".enable-btn").prop("disabled", true);
                                            $.post(rootPath + '/host/restart', JSON.stringify({
                                                'id': rowData.hostMachineId
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
                                "class": "glyphicon glyphicon-repeat"
                            }),
                            document.createTextNode('重启')
                        );
                    case 1:
                        return $("<a/>", {
                            "class": "btn btn-danger btn-xs table-btn disable-btn",
                            "click": function () {
                                BootstrapDialog.confirm({
                                    title: '信息',
                                    type: 'type-warning',
                                    size: 'size-small',
                                    message: '确定关机？',
                                    btnCancelLabel: '取消',
                                    btnOKLabel: '确定',
                                    callback: function (result) {
                                        if (result) {
                                            $(".disable-btn").prop("disabled", true);
                                            $.post(rootPath + '/host/stop', JSON.stringify({
                                                'id': rowData.hostMachineId
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
                                "class": "glyphicon glyphicon-off"
                            }),
                            document.createTextNode('关机')
                        )
                }

            }
        }]
    });
    loadTable();
    /*查询*/
    $(".search-bar").submit(function () {
        local_json.queryInfo = getFormData('.search-bar');
        local_json.pageInfo.index = 1;
        loadTable();
    });
    /*请求表格数据*/
    function loadTable() {
        /* $.extend(local_json.queryInfo,getFormData('.search-bar'));*/
        return $.post(rootPath + '/host/list', JSON.stringify(local_json)).done(function (data) {
            if (data.code === "000") {
                $.extend(local_json.pageInfo, data.pageInfo);
            } else {
                simpleInfoDialog('type-warning', data.msg);
            }
        }).always(function (data) {
            console.log(data.data);
            $("#deviceManagement-table").table("setDatas", data.data);
            loadPagination("#deviceManagement-pagination", local_json.pageInfo, loadTable);
        });
    }
})();