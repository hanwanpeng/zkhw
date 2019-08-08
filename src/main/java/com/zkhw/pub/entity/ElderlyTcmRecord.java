package com.zkhw.pub.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//老年人体质辨识表
public class ElderlyTcmRecord implements Serializable {
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
     * 气虚质得分
     */
    private Integer qixuzhiScore;

    /**
     * 气虚质结果
     */
    private Integer qixuzhiResult;

    /**
     * 阳虚质得分
     */
    private Integer yangxuzhiScore;

    /**
     * 阳虚质结果
     */
    private Integer yangxuzhiResult;

    /**
     * 阴虚质得分
     */
    private Integer yinxuzhiScore;

    /**
     * 阴虚质结果
     */
    private Integer yinxuzhiResult;

    /**
     * 痰湿质得分
     */
    private Integer tanshizhiScore;

    /**
     * 痰湿质结果
     */
    private Integer tanshizhiResult;

    /**
     * 湿热质得分
     */
    private Integer shirezhiScore;

    /**
     * 湿热质结果
     */
    private Integer shirezhiResult;

    /**
     * 血瘀质得分
     */
    private Integer xueyuzhiScore;

    /**
     * 血瘀质结果
     */
    private Integer xueyuzhiResult;

    /**
     * 气郁质得分
     */
    private Integer qiyuzhiScore;

    /**
     * 气郁质结果
     */
    private Integer qiyuzhiResult;

    /**
     * 特禀质得分
     */
    private Integer tebingzhiSorce;

    /**
     * 特禀质结果
     */
    private Integer tebingzhiResult;

    /**
     * 平和质得分
     */
    private Integer pinghezhiSorce;

    /**
     * 平和质结果
     */
    private Integer pinghezhiResult;

    /**
     * 
     */
    private String testDoctor;

    /**
     * 
     */
    private String tcmGuidance;

    /**
     * 
     */
    private String guidanceOther;

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
     * elderly_tcm_record
     */
    private static final long serialVersionUID = 1L;

}