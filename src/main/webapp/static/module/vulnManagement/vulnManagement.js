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
        validator_search, // 主页面查询的
        validator_search, // 选择弹框的
        operateData;
    var
        local_json_select = {
            "pageInfo": {
                "index": 1, //当前页
                "count": 0, //总条数
                "size": 15 //每页个数
            },
            "queryInfo": {}
        };
    // -----------------------------------------------------$(function)开始-------------------------------------------------------------------------------
    $(function(){
      var validator_search = $(".search-bar").validate({
            rules: {
//              vbCode: {
//                  maxlength: 100
//              },
//              vbName: {
//                  maxlength: 30
//              }
            }
        });
      // 查询
      $(".search-bar").submit(function () {
          if (!validator_search.valid()) {
              // 表单中有输入错误的时候
              var errorField = validator_search.errorList[0].element;
              errorField.focus();
              errorField.scrollIntoView();
              return;
          } else {
              // formData.js中封装了getFormData()
              var formData = getFormData(".search-bar");
              console.log(formData)
              local_json.queryInfo = formData;
              local_json.pageInfo.index = 1;
              loadTable();
          }
      });
      var validator_select = $(".select-search-bar").validate({
            rules: {
//              vbCode: {
//                  maxlength: 100
//              },
//              vbName: {
//                  maxlength: 30
//              }
            }
        });
      // 选择弹框中的查询
      $(".select-search-bar").submit(function () {
          if (!validator_select.valid()) {
              // 表单中有输入错误的时候
              var errorField = validator_select.errorList[0].element;
              errorField.focus();
              errorField.scrollIntoView();
              return;
          } else {
              // formData.js中封装了getFormData()
              var formData = getFormData(".select-search-bar");
              console.log(formData)
              local_json_select.queryInfo = formData;
              local_json_select.pageInfo.index = 1;
              loadSelectTable();
          }
      });
      // 点击详情,增加页面的导航(漏洞管理)
      $(".detail-title").on("click", function(){
        $(".page-module-main").removeClass("hidden");
        $(".page-module-detail").addClass("hidden");
        $(".page-module-addOrEdit").addClass("hidden");
        // 加载下表格
        loadTable();
      })
      // 点击选择（增加或编辑的页面）
      $(".select-btn").on("click", function(){
        loadSelectTable()
        $("#selectDialog").modal("show")
      })
      // 点击选择弹框中的确定
      $("#select-ok-btn").on("click", function(){
//      console.log("queding")
        var checkedData = $("#select-table").table("getChecked");
//      console.log(checkedData)
        if (checkedData.length !== 0) {
          // 后续这个字段需要修改
          // 向镜像的表格里面添值
          myData[0].userName = checkedData[0].userName
          myData[0].id = checkedData[0].id
          $("#addOrEdit-table").table("setDatas", myData);
          $("#selectDialog").modal("hide")
        } else {
          simpleInfoDialog('type-warning', code_message['002'], "size-small");
        }
      })
    })
    // -----------------------------------------------------$(function)结束-------------------------------------------------------------------------------
    
    // 增加或编辑中表格的配置信息
    $("#addOrEdit-table").table({
        showRadio: false,
//      showNo: false,
        columns: [{
            title: "环境镜像名",
            field: "userName"
        }]
    })
    var myData = [
      {
        userName: "",
        id: ""
      }
    ]
    $("#addOrEdit-table").table("setDatas", myData);
    // 选择镜像弹框中的表格
    $("#select-table").table({
        showRadio: true,
        showNo: false,
        columns: [{
            title: "镜像名",
            field: "userName"
        }, {
            title: "OS系统",
            field: "account"
        }, {
            title: "支持环境",
            field: "account"
        }, {
            title: "应用软件",
            field: "account"
        }, {
            title: "创建时间",
            field: "account"
        }]
    })
    /*资产列表配置信息*/
    $("#userManagement-table").table({
        showRadio: false,
        showNo: false,
//      showCheckbox:true,
        columns: [{
            title: "CNNVD编号",
            field: "userName"
        }, {
            title: "漏洞名称",
            field: "account"
        }, {
            title: "CVE编号",
            field: "userType"
//          formatter: function (value) {
//              switch (+value) {
//                  case 0:
//                      return '环境管理人员';
//                  case 1:
//                      return '漏洞验证人员';
//              }
//          }
        }, {
            title: "漏洞类型",
            field: "phone"
        }, {
            title: "漏洞级别",
            field: "email"
        }, {
            title: "厂商",
            field: "status"
        }, {
            title: "镜像环境",
            field: "update"
        }, {
            title: "创建时间",
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
                            // 一条表格的数据
                            console.log(rowData)
                            // 调用请求
                            getDetailRequest(rowData.id)
//                          fillTableData("#details-table", rowData);
                            $(".page-module-main").addClass("hidden");
                            $(".page-module-addOrEdit").addClass("hidden");
                            $(".page-module-detail").removeClass("hidden");
                        }
                    }).append(
                        $("<span/>", {
                            "class": "fa fa-file-text-o"
                        }),
                        document.createTextNode('详情')
                    ), $("<a/>", {
                        "class": "btn edit-btn btn-xs table-btn",
                        "click": function () {
                            // 表格内容重置
                            validator.resetFormExtra();
                            myData = [
                                  {
                                    userName: "",
                                    id: ""
                                  }
                                ]
                            $("#addOrEdit-table").table("setDatas", myData);
                            // 页面出现
                            $(".vuln-title-name").html("编辑漏洞")
                            $(".page-module-addOrEdit").removeClass("hidden")
                            $(".page-module-main").addClass("hidden");
                            $(".page-module-detail").addClass("hidden");
                            // 请求接口
                            getEditRequest(rowData.id)
                            // 主要为了记录id
                            operateData = rowData;
//                          fillFormData('#userInfo-form', rowData);
                            addOrEditSubmit("edit");
                        }
                    }).append(
                        $("<span/>", {
                            "class": "fa fa-pencil-square-o"
                        }),
                        document.createTextNode('编辑')
                    ), $("<a/>", {
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
                                    // 点击确定为true，取消为false
                                    if (result) {
                                        $.post('/user/remove', JSON.stringify({
                                            'id': rowData.id
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
    /* 添加和修改校验 */
    validator = $("#userInfo-form").validate({
        rules: {
            vbName: {
                required: true
            },
            account: {
                required: true
            },
//          or: {
//              required: true
//          },
            vulnDescribe: {
                required: true
            }
//          password: {
//              required: true,
//              passwordCheck: true
//          },
//          confirmPassword: {
//              required: true,
//              equalTo: "#password"
//          },
//          email: {
//              required: true,
//              emailCheck: true
//          },
//          mobile: {
//              required: true,
//              mobilePhone: true
//          }
        }
    });
    /*添加*/
    $(".add-btn").on("click", function () {
       // 重置表单内容
        validator.resetFormExtra();
        myData = [
              {
                userName: "",
                id: ""
              }
            ]
        $("#addOrEdit-table").table("setDatas", myData);
        // 页面显示
        $(".vuln-title-name").html("添加漏洞")
        $(".page-module-addOrEdit").removeClass("hidden")
        $(".page-module-main").addClass("hidden");
        $(".page-module-detail").addClass("hidden");
        addOrEditSubmit("create");
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
               // 判断表格要选择一个
                if (myData[0].userName == ""){
                  $(".table-error").removeClass("hidden");
                } else {
                  $(".table-error").addClass("hidden");
                  var formData = getFormData('#userInfo-form');
                  // 环境镜像的id
                  formData.environmentalMirrorId = myData[0].id
//                console.log(formData)
                  // 判断是增加还是编辑
                  if (operate !== "edit") {
                    // 新增
                      saveData("create", formData);
                  } else {
                     // 编辑（比新增多传一个id）
                      var newData = $.extend({}, {
                          id: operateData.id
                      }, formData);
                      saveData("modify", newData);
                  }
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
        console.log(newData)
        $.ajax({
            url: "/user/" + url,
            /* headers: {
                encrypt: window.ENCRYPT_TYPE.aes
            }, */
            data: JSON.stringify(newData)
        }).done(function (data) {
            if (data.code === "000") {
                simpleInfoDialog('type-success', code_message['000']);
                $(".page-module-main").removeClass("hidden");
                $(".page-module-detail").addClass("hidden");
                $(".page-module-addOrEdit").addClass("hidden");
                // 新增的放在最前面
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
//      $("#userManagement-table").table("setDatas", []);
        return $.post('/user/list', JSON.stringify(local_json)).done(function (data) {
            if (data.code === "000") {
                $.extend(local_json.pageInfo, data.pageInfo);
            } else {
                simpleInfoDialog('type-warning', data.msg);
            }
        }).always(function (data) {
//          console.log(data.data);
            $("#userManagement-table").table("setDatas", data.data);
            loadPagination("#userManagement-pagination", local_json.pageInfo, loadTable);
        });
    }
    // 请求选择镜像弹框中的表格数据
    function loadSelectTable() {
//      $("#select-table").table("setDatas", []);
        return $.post('/user/list', JSON.stringify(local_json_select)).done(function (data) {
            if (data.code === "000") {
                $.extend(local_json_select.pageInfo, data.pageInfo);
            } else {
                simpleInfoDialog('type-warning', data.msg);
            }
        }).always(function (data) {
            console.log(data.data);
            $("#select-table").table("setDatas", data.data);
            loadPagination("#select-pagination", local_json_select.pageInfo, loadSelectTable);
        });
    }
    // 获得详情数据的请求
    function getDetailRequest(id) {
      console.log(id)
      // 后续url要变
      $.post('/user/list', JSON.stringify({'id': id}))
      .done(function (data) {
//        console.log(data)
          if (data.code === "000") {
              // 在formData.js中封装的方法fillFormData()
              // 在index.js封装的checkTableInitDict(),,将数据字典值转化为前端页面展示的汉字
//            fillFormData("#check-form", checkTableInitDict(data.resultValue));
//            generateFileDownloadInput(data.resultValue.files);
          } else {
              simpleInfoDialog('type-warning', data.msg);
          }
      });
    }
    // 获得编辑数据的请求
    function getEditRequest(id) {
      console.log(id)
      // 后续url要变
      $.post('/user/list', JSON.stringify({'id': id}))
      .done(function (data) {
//        console.log(data)
          if (data.code === "000") {
              // 在formData.js中封装的方法fillFormData()
              // 在index.js封装的checkTableInitDict(),,将数据字典值转化为前端页面展示的汉字
//            fillFormData("#check-form", checkTableInitDict(data.resultValue));
//            generateFileDownloadInput(data.resultValue.files);
          } else {
              simpleInfoDialog('type-warning', data.msg);
          }
      });
    }
})();