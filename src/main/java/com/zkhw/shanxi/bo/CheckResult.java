package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@Setter
public class CheckResult extends ExaminationObject {

	@XmlAttribute(name = "name")
	private String name = "YTJ1012";

	@XmlAttribute(name = "id")
	private String id;

	// 个人档案Id
	@XmlElement(name = "Attribute")
	private BaseElement ID;

	//
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

	// 一体机检查报告地址
	@XmlElement(name = "Attribute")
	private BaseElement checkURL;

	// 检查报告结果
	@XmlElement(name = "Attribute")
	private BaseElement checkResult;

	// 心率
	@XmlElement(name = "Attribute")
	private BaseElement HeartRate;

	// 心电数据（采样数据值逗号隔开）
	@XmlElement(name = "Attribute")
	private BaseElement ECGData;

	// 心电结果
	@XmlElement(name = "Attribute")
	private BaseElement ECGResult;

	// 心电图片
	@XmlElement(name = "Attribute")
	private BaseElement ECGImg;

	// 图片地址url
	@XmlElement(name = "Attribute")
	private BaseElement ECGUrl;

	// 血糖
	@XmlElement(name = "Attribute")
	private BaseElement Glucose;

	// 收缩压
	@XmlElement(name = "Attribute")
	private BaseElement Systolic;

	// 舒张压
	@XmlElement(name = "Attribute")
	private BaseElement Diastolic;

	// 血氧
	@XmlElement(name = "Attribute")
	private BaseElement Oxygen;

	// 脉率
	@XmlElement(name = "Attribute")
	private BaseElement Pulse;

	// 体温
	@XmlElement(name = "Attribute")
	private BaseElement Temperature;

	// 尿白细胞酯酶
	@XmlElement(name = "Attribute")
	private BaseElement Leu;

	// 尿亚硝酸盐
	@XmlElement(name = "Attribute")
	private BaseElement Nit;

	// 尿胆原
	@XmlElement(name = "Attribute")
	private BaseElement Ubg;

	// 尿蛋白
	@XmlElement(name = "Attribute")
	private BaseElement Pro;

	// 尿酸碱度
	@XmlElement(name = "Attribute")
	private BaseElement Ph;

	// 尿潜血
	@XmlElement(name = "Attribute")
	private BaseElement Bld;

	// 尿比重
	@XmlElement(name = "Attribute")
	private BaseElement Sg;

	// 尿酮体
	@XmlElement(name = "Attribute")
	private BaseElement Ket;

	// 尿胆红素
	@XmlElement(name = "Attribute")
	private BaseElement Bil;

	// 尿葡萄糖
	@XmlElement(name = "Attribute")
	private BaseElement Glu;

	// 维生素C
	@XmlElement(name = "Attribute")
	private BaseElement Vc;

	// 报告图片（二进制数据字符串）
	@XmlElement(name = "Attribute")
	private BaseElement RutImg;

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

	// 数据源类型
	@XmlElement(name = "Attribute")
	private BaseElement dataResType;

	// 设备供应商
	@XmlElement(name = "Attribute")
	private BaseElement sSupplierCode;

	// 设备编码
	@XmlElement(name = "Attribute")
	private BaseElement sMachineCode;

	// 是否上传成功
	@XmlElement(name = "Attribute")
	private BaseElement IsSuccess;

	// 上传时间
	@XmlElement(name = "Attribute")
	private BaseElement uploadTime;

	// 上传失败原因
	@XmlElement(name = "Attribute")
	private BaseElement errReason;

}
