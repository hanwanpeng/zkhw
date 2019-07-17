package com.zkhw.ltd.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户角色
 * @author hm
 *
 */
@Setter
@Getter
public class UserRole implements Serializable {
    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 创建时间
     */
    private Date createTime;
    
    private static final long serialVersionUID = 1L;
    
}