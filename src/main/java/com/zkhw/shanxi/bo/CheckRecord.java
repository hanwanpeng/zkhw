package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class CheckRecord extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "EHR_Arch_HealthCheck";

	@XmlAttribute(name = "id")
	private String id;

	// 个人档案Id
	@XmlElement(name = "Attribute")
	private BaseElement archiveId;

	// 被检查者身份证号
	@XmlElement(name = "Attribute")
	private BaseElement CardNo;

	// 检查时间
	@XmlElement(name = "Attribute")
	private BaseElement checkDate;

	// 姓名
	@XmlElement(name = "Attribute")
	private BaseElement Name;

	// 联系方式
	@XmlElement(name = "Attribute")
	private BaseElement Phone;

	// 健康卡号
	@XmlElement(name = "Attribute")
	private BaseElement HealthNO;

	// 检查人员
	@XmlElement(name = "Attribute")
	private BaseElement checkdoctor;

	// 机构
	@XmlElement(name = "Attribute")
	private BaseElement duns;

	// 创建者
	@XmlElement(name = "Attribute")
	private BaseElement created_By;

	// 创建时间
	@XmlElement(name = "Attribute")
	private BaseElement created_Date;

	// 修改者
	@XmlElement(name = "Attribute")
	private BaseElement updated_By;

	// 修改时间
	@XmlElement(name = "Attribute")
	private BaseElement updated_Date;

	// 数据源类型(SX0374)
	@XmlElement(name = "Attribute")
	private BaseElement dataResType;

	// 设备供应商(参见一体机厂家代码)
	@XmlElement(name = "Attribute")
	private BaseElement sSupplierCode;

	// 设备编码(供应商编码+“^”+机器码如：01^1233322122)
	@XmlElement(name = "Attribute")
	private BaseElement sMachineCode;

	// 是否上传成功(由基层软件填写，0待上传1成功上传2失败)
	@XmlElement(name = "Attribute")
	private BaseElement IsSuccess;

	// 上传时间
	@XmlElement(name = "Attribute")
	private BaseElement uploadTime;

	// 上传失败原因
	@XmlElement(name = "Attribute")
	private BaseElement errReason;

}
