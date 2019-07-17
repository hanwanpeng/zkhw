package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class Vaccination extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "EHR_Immu_InocNote";

	@XmlAttribute(name = "id")
	private String id;

	//服务类型"SX0030"
	@XmlElement(name = "Attribute")
	private BaseElement serviceName;

	// 服务记录id
	@XmlElement(name = "Attribute")
	private BaseElement serviceId;

	//档案id
	@XmlElement(name = "Attribute")
	private BaseElement archiveid;

	// 个案编码
	@XmlElement(name = "Attribute")
	private BaseElement cardID;

	// 接种类别 Ⅰ类 Ⅱ类 强化 应急
	@XmlElement(name = "Attribute")
	private BaseElement bacterinType;

	// 疫苗编码 
	@XmlElement(name = "Attribute")
	private BaseElement bacterinid;

	// 疫苗名称
	@XmlElement(name = "Attribute")
	private BaseElement bacterinname;

	// 剂次
	@XmlElement(name = "Attribute")
	private BaseElement acuscount;

	// 剂量
	@XmlElement(name = "Attribute")
	private BaseElement dose;

	// 剂次描述
	@XmlElement(name = "Attribute")
	private BaseElement description;

	// 接种状态,未接种 已接种
	@XmlElement(name = "Attribute")
	private BaseElement inocustate;

	// 应接种日期
	@XmlElement(name = "Attribute")
	private BaseElement sinocudate;

	// 接种医生
	@XmlElement(name = "Attribute")
	private BaseElement inocudoctor;

	// 登记人
	@XmlElement(name = "Attribute")
	private BaseElement registerperson;

	// 接种日期
	@XmlElement(name = "Attribute")
	private BaseElement inocudate;

	// 电子监管码
	@XmlElement(name = "Attribute")
	private BaseElement dzjgm;

	// 疫苗批号
	@XmlElement(name = "Attribute")
	private BaseElement batchnumber;

	// 接种县国标
	@XmlElement(name = "Attribute")
	private BaseElement county;

	// 接种部位 SX0504
	@XmlElement(name = "Attribute")
	private BaseElement inoculationsite;

	// 接种途径 SX0507
	@XmlElement(name = "Attribute")
	private BaseElement inoculationway;

	// 接种机构代码
	@XmlElement(name = "Attribute")
	private BaseElement inoculateDuns;

	// 接种结构名称
	@XmlElement(name = "Attribute")
	private BaseElement inoculateDunsName;

	// 备注
	@XmlElement(name = "Attribute")
	private BaseElement remark;

	// 有效日期
	@XmlElement(name = "Attribute")
	private BaseElement validdate;

	// 生产企业名称
	@XmlElement(name = "Attribute")
	private BaseElement manufacturer;

	// 生产企业编码
	@XmlElement(name = "Attribute")
	private BaseElement manufactCode;

	// 录入日期
	@XmlElement(name = "Attribute")
	private BaseElement inputDate;

	// 录入机构
	@XmlElement(name = "Attribute")
	private BaseElement duns;

}
