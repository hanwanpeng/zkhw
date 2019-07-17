package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class Resident extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "EHR_Arch_Basicinfo";

	@XmlAttribute(name = "id")
	private String id;

	/**
	 * 纸质档案号
	 */
	@XmlElement(name = "Attribute")
	private BaseElement archiveNo;

	/**
	 * 姓名
	 */
	@XmlElement(name = "Attribute")
	private BaseElement fullname;

	/**
	 * 性别
	 */
	@XmlElement(name = "Attribute")
	private BaseElement gender;

	/**
	 * 出生日期
	 */
	@XmlElement(name = "Attribute")
	private BaseElement birthday;

	/**
	 * 身份证号
	 */
	@XmlElement(name = "Attribute")
	private BaseElement identityno;

	/**
	 * 户籍地址
	 */
	@XmlElement(name = "Attribute")
	private BaseElement resaddr_committee;

	/**
	 * 户籍地址门牌号
	 */
	@XmlElement(name = "Attribute")
	private BaseElement resaddr_doorno;

	/**
	 * 现住址
	 */
	@XmlElement(name = "Attribute")
	private BaseElement curaddr_committee;

	/**
	 * 现住址门牌号
	 */
	@XmlElement(name = "Attribute")
	private BaseElement curaddr_doorno;

	/**
	 * 工作单位(无)
	 */
	@XmlElement(name = "Attribute")
	private BaseElement company;

	/**
	 * 本人电话
	 */
	@XmlElement(name = "Attribute")
	private BaseElement tel;

	/**
	 * 联系人姓名
	 */
	@XmlElement(name = "Attribute")
	private BaseElement linkman;

	/**
	 * 联系人电话
	 */
	@XmlElement(name = "Attribute")
	private BaseElement linkman_tel;

	/**
	 * 常住类型
	 */
	@XmlElement(name = "Attribute")
	private BaseElement residenttype;

	/**
	 * 民族
	 */
	@XmlElement(name = "Attribute")
	private BaseElement nation;

	/**
	 * 社保/农合卡号
	 */
	@XmlElement(name = "Attribute")
	private BaseElement medicareid;

	/**
	 * 责任医生
	 */
	@XmlElement(name = "Attribute")
	private BaseElement dutydoctor;

	/**
	 * 所在家庭是否贫困
	 */
	@XmlElement(name = "Attribute")
	private BaseElement isPoor;

	/**
	 * 建档日期
	 */
	@XmlElement(name = "Attribute")
	private BaseElement build_date;

	/**
	 * 建档医生
	 */
	@XmlElement(name = "Attribute")
	private BaseElement builddoctor;

	/**
	 * 备注
	 */
	@XmlElement(name = "Attribute")
	private BaseElement remark;

	/**
	 * 档案管理机构
	 */
	@XmlElement(name = "Attribute")
	private BaseElement duns;
	
	/**
	 * 档案编号
	 */
	@XmlElement(name = "Attribute")
	private BaseElement archiveid;
	
	/**
	 * 档案状态
	 */
	@XmlElement(name = "Attribute")
	private BaseElement archstatus;

}
