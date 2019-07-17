package com.zkhw.common.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu1Vo {
    /**
     * 权限编码
     */
    private String rightCode;

    /**
     * 父权限码
     */
    private String parentCode;

    /**
     * 权限名称
     */
    private String rightName;

    /**
     * 权限地址
     */
    private String rightUrl;

    /**
     * 权限级别(0:模块 1:一级菜单 2:二级菜单)
     */
    private String rightLevel;

    /**
     * 图标地址
     */
    private String imageUrl;
    
    //二级菜单
    private List<Menu2Vo> menu2;

}
