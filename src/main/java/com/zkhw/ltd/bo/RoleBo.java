package com.zkhw.ltd.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleBo {
	
    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 组织机构编码
     */
    private String organCode;
    
    private String parentOrgan;

    /**
     * 备注
     */
    private String remark;
    
    //角色权限
    private String rights;
 
}
