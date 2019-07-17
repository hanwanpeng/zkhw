package com.zkhw.shanxi.vo;

import javax.xml.bind.annotation.XmlElement;

import com.zkhw.shanxi.bo.BaseElement;

import lombok.Setter;

@Setter
public class ResidentBody {
	
	/**
	 * 档案ID
	 */
	private BaseElement archiveid;

	/**
	 * 姓名
	 */
	private BaseElement fullname;

	/**
	 * 性别
	 */	
	private BaseElement gender;

	/**
	 * 出生日期
	 */
	private BaseElement birthday;

	/**
	 * 身份证号
	 */
	private BaseElement identityno;

	/**
	 * 户籍地址
	 */
	private BaseElement resaddr_committee;

	/**
	 * 户籍地址门牌号
	 */
	private BaseElement resaddr_doorno;

	/**
	 * 现住址
	 */
	private BaseElement curaddr_committee;

	/**
	 * 现住址门牌号
	 */
	private BaseElement curaddr_doorno;

	/**
	 * 本人电话
	 */
	private BaseElement tel;

	/**
	 * 是否患高血压
	 */
	private BaseElement dishyperflag;

	/**
	 * 是否患糖尿病
	 */
	private BaseElement disdmflag;

	/**
	 * 是否换冠心病
	 */
	private BaseElement disheartflag;

	/**
	 * 档案状态
	 */
	private BaseElement archstatus;

	/**
	 * 责任医生
	 */
	private BaseElement dutydoctor;

	/**
	 * 建档日期
	 */
	private BaseElement build_date;

	/**
	 * 建档医生
	 */
	private BaseElement builddoctor;

	/**
	 * 档案管理机构
	 */
	private BaseElement duns;
	
	/**
	 * 是否贫困
	 */
	private BaseElement isPoor;	
	
	/**
	 * 是否签约
	 */
	private BaseElement isSign;	
	
	/**
	 * 签约服务包名称
	 */
	private BaseElement signPag;

	@XmlElement(name = "Attribute")
	public BaseElement getArchiveid() {
		return archiveid;
	}
	
	@XmlElement(name = "Attribute")
	public BaseElement getFullname() {
		return fullname;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getGender() {
		return gender;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getBirthday() {
		return birthday;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getIdentityno() {
		return identityno;
	}
	
	@XmlElement(name = "Attribute")
	public BaseElement getResaddr_committee() {
		return resaddr_committee;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getResaddr_doorno() {
		return resaddr_doorno;
	}
	
	@XmlElement(name = "Attribute")
	public BaseElement getCuraddr_committee() {
		return curaddr_committee;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getCuraddr_doorno() {
		return curaddr_doorno;
	}
	
	@XmlElement(name = "Attribute")
	public BaseElement getTel() {
		return tel;
	}
	
	@XmlElement(name = "Attribute")
	public BaseElement getDishyperflag() {
		return dishyperflag;
	}
	
	@XmlElement(name = "Attribute")
	public BaseElement getDisdmflag() {
		return disdmflag;
	}
	
	@XmlElement(name = "Attribute")
	public BaseElement getDisheartflag() {
		return disheartflag;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getArchstatus() {
		return archstatus;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getDutydoctor() {
		return dutydoctor;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getBuild_date() {
		return build_date;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getBuilddoctor() {
		return builddoctor;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getDuns() {
		return duns;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getIsPoor() {
		return isPoor;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getIsSign() {
		return isSign;
	}

	@XmlElement(name = "Attribute")
	public BaseElement getSignPag() {
		return signPag;
	}	
}
