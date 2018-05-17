package com.vulnverify.web.security;

/**
 * 权限标识配置类, <br>
 * 与 permission 权限表 中的 permission_sign 字段 相对应 <br>
 * 使用:
 * 
 * <pre>
 * &#064;RequiresPermissions(value = PermissionConfig.USER_CREATE)
 * public String create() {
 *     return &quot;拥有user:create权限,能访问&quot;;
 * }
 * </pre>
 * 
 * @author linan
 * @date 2018年5月14日  
 **/
public class PermissionSign {
	
	/**
	 * 用户管理
	 */
	//查询用户列表
    public static final String GET_USER_LIST = "right-get-user-list";
    //创建用户
    public static final String USER_CREATE = "button-create-user";
    //修改用户
    public static final String USER_MODIFY = "button-modify-user";
    //删除用户
    public static final String USER_REMOVE = "button-remove-user";
    //停用用户
    public static final String USER_DISABLE = "button-disable-user";
    //启用用户
    public static final String USER_ENABLE = "button-enable-user";
    
}
