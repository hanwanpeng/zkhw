package com.zkhw.stat.vo;

import java.util.List;

import com.zkhw.flup.entity.DiabetesFollowRecord;
import com.zkhw.flup.entity.Hypertension;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonVo {
	
	private List<Hypertension> hypertensionList;
	
	private List<DiabetesFollowRecord> diabetesFollowRecordList;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 年龄
	 */
	private String age;
	
	/**
	 * 身份证号
	 */
	private String IdNumber;
	
	/**
	 * 住址
	 */
	private String registerAddress;
	
	/**
	 * 是否高血压
	 */
	private Integer isHypertension;
	
	/**
	 * 是否糖尿病
	 */
	private Integer isDiabetes;
	
	/**
	 * 问询次数
	 */
	private Integer physicalExaminationRecord;
	
	/**
	 * 老年人生活自理能力评估数
	 */
	private Integer elderlySelfcareEstimateNum;
	
	/**
	 * 老年人中医体质辨识
	 */
	private Integer elderlyTcmRecordNum;
	
	/**
	 * 高血压数
	 */
	private Integer fuvHypertensionNum;
	
	/**
	 * 糖尿病数
	 */
	private Integer diabetesFollowRecordNum;
	
	/**
	 * 肺结核数
	 */
	private Integer tuberculosisFollowRecord;
	
	/**
	 * 精神病数
	 */
	private Integer psychosisFollowRecord;
	
	/**
	 * 儿童随访次数
	 */
	private Integer childrenHealthRecordNum;
	
	/**
	 * 孕产妇产前随访
	 */
	private Integer gravidaFollowRecordNum;
	
	/**
	 * 孕产妇产后随访
	 */
	private Integer gravidaAfterRecordNum;
	
	

	
	
}
