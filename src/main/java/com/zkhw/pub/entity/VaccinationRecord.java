package com.zkhw.pub.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//疫苗接种附属表
public class VaccinationRecord implements Serializable {
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
     * 服务项目
     */
    private String serviceName;

    /**
     * 个案编码
     */
    private String cardId;

    /**
     * 接种类别 Ⅰ类 Ⅱ类 强化 应急
     */
    private String vaccinationType;

    /**
     * 疫苗编码
     */
    private String vaccinationId;

    /**
     * 接种名称
     */
    private String vaccinationName;

    /**
     * 疫苗编码
     */
    private String acuscount;

    /**
     * 剂量
     */
    private String dose;

    /**
     * 剂次描述
     */
    private String descnption;

    /**
     * 接种状态,未接种 已接种
     */
    private String inocuState;

    /**
     * 应接种日期
     */
    private String sinocuDate;

    /**
     * 接种日期
     */
    private String vaccinationTime;

    /**
     * 接种医生
     */
    private String inocuDoctor;

    /**
     * 登记人
     */
    private String registerPerson;

    /**
     * 电子监管码
     */
    private String dzjgm;

    /**
     * 疫苗批号
     */
    private String batchNumber;

    /**
     * 接种县国标
     */
    private String county;

    /**
     * 接种部位
     */
    private String inoculationSite;

    /**
     * 接种途径 
     */
    private String inoculationWay;

    /**
     * 接种机构
     */
    private String vaccinationOrgan;

    /**
     * 接种机构名称
     */
    private String vaccinationOrganName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 有效日期
     */
    private String validdate;

    /**
     * 生产企业名称
     */
    private String manufacturer;

    /**
     * 生产企业编码
     */
    private String manufactCode;

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
     * vaccination_record
     */
    private static final long serialVersionUID = 1L;

}