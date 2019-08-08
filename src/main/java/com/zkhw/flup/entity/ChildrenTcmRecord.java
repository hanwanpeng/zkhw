package com.zkhw.flup.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//儿童中医健康服务
public class ChildrenTcmRecord implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电子档案编号
     */
    private String archiveNo;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 月龄
     */
    private String age;

    /**
     * 随访日期
     */
    private String visitDate;

    /**
     * 中医药健康管理服务
     */
    private String tcmInfo;

    /**
     * 其他服务
     */
    private String tcmOther;

    /**
     * 下次随访日期
     */
    private String nextVisitDate;

    /**
     * 随方医生签名
     */
    private String visitDoctor;

    /**
     * 
     */
    private String createUser;

    /**
     * 
     */
    private String createName;

    /**
     * 
     */
    private String createOrg;

    /**
     * 
     */
    private String createOrgName;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String updateUser;

    /**
     * 
     */
    private String updateName;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer uploadStatus;

    /**
     * 
     */
    private Date uploadTime;

    /**
     * 
     */
    private String uploadResult;

    /**
     * children_tcm_record
     */
    private static final long serialVersionUID = 1L;

}