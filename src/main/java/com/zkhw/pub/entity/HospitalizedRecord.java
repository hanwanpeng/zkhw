package com.zkhw.pub.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//住院表
public class HospitalizedRecord implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 
     */
    private String examId;

    /**
     * 电子档案唯一编码
     */
    private String archiveNo;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 
     */
    private String serviceName;

    /**
     * 住院治疗类型（1住院/2家庭病床）
     */
    private Integer hospitalizedType;

    /**
     * 入院日期（建床日期）
     */
    private String inHospitalTime;

    /**
     * 出院日期（撤床日期）
     */
    private String leaveHospitalTime;

    /**
     * 原因
     */
    private String reason;

    /**
     * 医疗结构名称
     */
    private String hospitalOrgan;

    /**
     * 病案号
     */
    private String caseCode;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private String createOrg;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateName;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * hospitalized_record
     */
    private static final long serialVersionUID = 1L;

}