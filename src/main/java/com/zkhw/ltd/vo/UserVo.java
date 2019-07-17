package com.zkhw.ltd.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.zkhw.common.vo.TreeVo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserVo {
	  /**
     * 用户编码
     */
    private String userCode;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 性别(1-男 0-女)
     */
    private Integer sex;

    /**
     * 工号
     */
    private String jobNum;

    /**
     * 电话
     */
    private String telePhone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 出生日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date birthday;

    /**
     * 组织机构编码
     */
    private String organCode;

    /**
     * 部门编码
     */
    private String departCode;

    /**
     * 用户类型
     */
    private String userTypeCode;

    /**
     * 数据级别
     */
    private Integer dataLevel;

    /**
     * 状态（1-启用  2-停用）
     */
    private Integer status;

    /**
     * 是否删除(0-未删  1-已删)
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 创建人编码
     */
    private String createUserCode;

    /**
     * 修改时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 修改人编码
     */
    private String updateUserCode;
    
    /**
     * 部门树
     */
    private List<TreeVo> departTree;
    
    /**
     * 当前角色编码
     */
    private String roleCode;

}
