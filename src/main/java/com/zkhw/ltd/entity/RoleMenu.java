package com.zkhw.ltd.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 角色菜单
 * @author hm
 *
 */

@Setter
@Getter
public class RoleMenu implements Serializable {
    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
   
}