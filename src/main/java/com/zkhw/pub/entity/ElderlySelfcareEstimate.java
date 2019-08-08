package com.zkhw.pub.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//老年人生活自理能力评估表
public class ElderlySelfcareEstimate implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String examId;

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
     * 测试日期
     */
    private String testDate;

    /**
     * 回答结果
     */
    private String answerResult;

    /**
     * 总分
     */
    private Integer totalScore;

    /**
     * 评判结果
     */
    private String judgementResult;

    /**
     * 测试医生
     */
    private String testDoctor;

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
     * elderly_selfcare_estimate
     */
    private static final long serialVersionUID = 1L;

}