package com.zkhw.pub.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//输血表
public class MetachysisRecord implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 电子档案唯一编码
     */
    private String archiveNo;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 输血原因
     */
    private String metachysisReasonn;

    /**
     * 输血时间
     */
    private String metachysisTime;

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
     * metachysis_record
     */
    private static final long serialVersionUID = 1L;

}