package com.zkhw.pub.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExaminationListVo {

	 /**
     * 主键
     */
    private String id;

    /**
     * 电子档案唯一编码
     */
    private String archiveNo;

    /**
     * 公卫平台电子档案编码
     */
    private String pbArchive;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 身份证号
     */
    private String idNumber;


    /**
     * 电话
     */
    private String phone;

    /**
     * 常住类型
     */
    private String residentType;

    /**
     * 户籍所在地
     */
    private String registerAddress;

    /**
     * 现住址
     */
    private String residenceAddress;

    /**
     * 是否高血压
     */
    private Integer isHypertension;

    /**
     * 是否糖尿病
     */
    private Integer isDiabetes;

    /**
     * 是否精神病
     */
    private Integer isPsychosis;

    /**
     * 是否结核病
     */
    private Integer isTuberculosis;

    /**
     * 建档机构
     */
    private String aichiveOrg;
    
    /**
     * 责任医生ID
     */
    private String doctorId;
    
    /**
     * 责任医生
     */
    private String doctorName;

    /**
     * 是否签约
     */
    private Integer isSigning;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 市编码
     */
    private String cityCode;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 县编码
     */
    private String countyCode;

    /**
     * 县名称
     */
    private String countyName;

    /**
     * 镇编码
     */
    private String townsCode;

    /**
     * 镇名称
     */
    private String townsName;

    /**
     * 村编码
     */
    private String villageCode;

    /**
     * 村名称
     */
    private String villageName;

    /**
     * 备注
     */
    private String remark;
    
    private String examId;
    
    private String checkDate;

}
