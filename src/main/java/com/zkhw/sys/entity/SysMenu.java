package com.zkhw.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统菜单
 * @author hm
 *
 */
@Setter
@Getter
public class SysMenu implements Serializable {
    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 菜单父编码
     */
    private String menuParentCode;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单备注
     */
    private String menuNote;

    /**
     * 菜单级别
     */
    private String menuLevel;

    /**
     * 菜单ur
     */
    private String menuUrl;

    /**
     * 菜单img
     */
    private String menuImgUrl;

    /**
     * 排序号
     */
    private Double menuSort;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人编码
     */
    private String createUserCode;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人编码
     */
    private String updateUserCode;

    /**
     * 是否删除（1-已删除   0-未删除）
     */
    private Integer isDelete;
   
    private static final long serialVersionUID = 1L;
   
}