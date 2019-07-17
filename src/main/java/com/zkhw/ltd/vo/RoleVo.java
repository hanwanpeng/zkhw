package com.zkhw.ltd.vo;

import java.util.List;

import com.zkhw.ltd.entity.Role;
import com.zkhw.sys.entity.SysMenu;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleVo {
	
	//角色
    private Role role;
    
    //角色对应的权限 
    private List<String> roleRight;
    
    //所有权限-检测机构下权限
    private List<SysMenu> allRight;
    
}
