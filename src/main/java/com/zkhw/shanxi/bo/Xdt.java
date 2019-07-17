package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class Xdt extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "EHR_Arch_HealthCheck";

	@XmlAttribute(name = "id")
	private String id;
	
	//主键（引用检查记录表ID）
	@XmlElement(name = "Attribute")
	private BaseElement ExamID;

	// 心率(未检测录入0)
	@XmlElement(name = "Attribute")
	private BaseElement HeartRate;

	//心电数据（采样数据值逗号隔开）
	@XmlElement(name = "Attribute")
	private BaseElement ECGData;

	// 心电结果（多个结果用英文逗号隔开）
	@XmlElement(name = "Attribute")
	private BaseElement ECGResult;

	//心电图片（二进制数据字符串）
	@XmlElement(name = "Attribute")
	private BaseElement ECGImg;

	//心电图浏览地址（浏览地址Url）
	@XmlElement(name = "Attribute")
	private BaseElement ECGUrl;

	// 个人档案Id
	@XmlElement(name = "Attribute")
	private BaseElement archiveId;

	// 被检查者身份证号
	@XmlElement(name = "Attribute")
	private BaseElement CardNo;

	// 姓名
	@XmlElement(name = "Attribute")
	private BaseElement Name;

	// 联系方式
	@XmlElement(name = "Attribute")
	private BaseElement Phone;

	// 健康卡号
	@XmlElement(name = "Attribute")
	private BaseElement HealthNO;

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

	// 数据源类型（SX0374）
	@XmlElement(name = "Attribute")
	private BaseElement dataResType;

	// 设备供应商（参照一体机厂家代码）
	@XmlElement(name = "Attribute")
	private BaseElement sSupplierCode;

	// 设备编码
	@XmlElement(name = "Attribute")
	private BaseElement sMachineCode;

	// 是否上传成功（0带上传1上传成功2失败）
	@XmlElement(name = "Attribute")
	private BaseElement IsSuccess;

	// 上传时间
	@XmlElement(name = "Attribute")
	private BaseElement uploadTime;

	// 上传失败原因
	@XmlElement(name = "Attribute")
	private BaseElement errReason;

	

}
