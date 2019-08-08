package com.zkhw.pub.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//居民疾病表
public class ResidentDiseases  {
    /**
     * 
     */
    private String id;

    /**
     * 电子档案唯一编码
     */
    private String archiveNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 疾病类型
     */
    private String diseaseType;

    /**
     * 疾病名字
     */
    private String diseaseName;

    /**
     * 确认日期
     */
    private String diseaseDate;

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
    private Date createTime;

    /**
     * resident_diseases
     */
   
}