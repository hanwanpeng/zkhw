package com.zkhw.ltd.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 角色
 * @author hm
 *
 */

@Setter
@Getter
public class Role implements Serializable {
    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleNote;

    /**
     * 组织机构编码
     */
    private String organCode;
    
    /**
     * 上级机构编码
     */
    private String parentOrgan;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人编码
     */
    private String createUserCode;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人编码
     */
    private String updateUserCode;
    
    private static final long serialVersionUID = 1L;

   
}