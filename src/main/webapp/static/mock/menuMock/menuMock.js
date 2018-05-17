(function () {
  /* 菜单权限 */
  $.mockjax({
    url: '/user/getLoginUserRights',
    responseText: {
      "code": "000",
      "msg": "查询异常，请重试（后端返回信息）",
      "data": [
        {
          "name": "用户管理",
          "page": "userManagement",
          'code': "menu-user-manage"
        },
        {
          "name": "设备管理",
          "page": "systemManagement",
          'code': "menu-device-manage"
        },
        {
          "name": "镜像管理",
          "page": "orgManagement",
          'code': "menu-image-manage"
        },
        {
          "name": "容器管理",
          "page": "configManagement",
          'code': "menu-container-manage"
        },
        {
          "name": "漏洞管理",
          "page": "vulnManagement",
          'code': "menu-vuln-manage"
        },
        {
          "name": "漏洞验证",
          "page": "vulnVerify",
          'code': "menu-vuln-verify"
        }
      ]
    }
  });
  /* 获取commonData */
  $.mockjax({
    url: '/rest/common/data',
    responseText: {
      "code": "000",
      "msg": "查询异常，请重试（后端返回信息）",
      "data": [
        
      ]
    }
  });

})();
