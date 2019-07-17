package com.zkhw.pub.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResidentVo {
	
	
	/**
	 * 家族史
	 */
	private String familyRecord;
	
	/**
	 * 既往史疾病
	 */
	private String historyIllness;
	
	/**
	 * 手术
	 */
	private String operation; 
	
	/**
	 * 外伤
	 */
	private String trauma;
	
	/**
	 * 输血
	 */
	private String transfusion;
	
	

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
     * 身份证照片
     */
    private String cardPic;

    /**
     * 工作单位
     */
    private String company;

    /**
     * 电话
     */
    private String phone;

    /**
     * 联系人
     */
    private String linkName;

    /**
     * 联系人电话
     */
    private String linkPhone;

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
     * 民族
     */
    private String nation;

    /**
     * 血型
     */
    private String bloodGroup;

    /**
     * RH血型
     */
    private String bloodRh;

    /**
     * 文化程度
     */
    private String education;

    /**
     * 职业
     */
    private String profession;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 医疗费用支付方式
     */
    private String payType;

    /**
     * 其他支付方式
     */
    private String payOther;

    /**
     * 药物过敏史
     */
    private String drugAllergy;

    /**
     * 其他过敏
     */
    private String allergyOther;

    /**
     * 暴露史
     */
    private String exposure;

    /**
     * 其他疾病
     */
    private String diseaseOther;

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
     * 是否遗传病
     */
    private Integer isHeredity;

    /**
     * 遗传病名称
     */
    private String heredityName;

    /**
     * 是否残疾
     */
    private String isDeformity;

    /**
     * 残疾名字
     */
    private String deformityName;

    /**
     * 是否贫困
     */
    private Integer isPoor;

    /**
     * 厨房排风设施
     */
    private String kitchen;

    /**
     * 燃料类型
     */
    private String fuel;

    /**
     * 燃料类型(其它)
     */
    private String otherFuel;

    /**
     * 饮水
     */
    private String drink;

    /**
     * 饮水(其它)
     */
    private String otherDrink;

    /**
     * 厕所
     */
    private String toilet;

    /**
     * 禽畜栏
     */
    private String poultry;

    /**
     * 健康卡号
     */
    private String medicalCode;

    /**
     * 摄像头照片地址
     */
    private String photoCode;

    /**
     * 建档机构
     */
    private String aichiveOrg;

    /**
     * 责任医生
     */
    private String doctorName;

    /**
     * 是否签约
     */
    private Integer isSigning;

    /**
     * 是否同步
     */
    private Integer isSynchro;

    /**
     * 同步结果（成功/失败）
     */
    private String synchroResult;

    /**
     * 同步时间
     */
    private Date synchroTime;

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
     * 1正常2死亡2失访
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 
     */
    private String createUser;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建机构
     */
    private String createOrg;

    /**
     * 创建机构名称
     */
    private String createOrgName;

    /**
     * 
     */
    private String updateUser;

    /**
     * 修改人
     */
    private String updateName;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 恶性肿瘤
     */	
    private String cancer;
    /**
     * 职业病
     */
    private String occupationDisease;
}
