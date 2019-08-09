package com.wuzhou.pub.entity;

public class HealthExamDrug {
	//个人健康体检用药情况ID
    private String healthExamDrugId;

    //服药依从性代码
    private String drugComplianceCode;

    //服药依从性中文
    private String drugComplianceValue;

    //用量
    private String drugDose;

    //药物名称
    private String drugName;

    //用药时间
    private String drugTime;

    //用法代码
    private String drugUsageCode;

    //个人健康体检ID
    private String healthExamId;

    //接口返回值，0成功1失败，由冠新填入。
    private Short errCode;

    //接口返回信息，由冠新填入。
    private String errStr;

    public String getHealthExamDrugId() {
        return healthExamDrugId;
    }

    public void setHealthExamDrugId(String healthExamDrugId) {
        this.healthExamDrugId = healthExamDrugId == null ? null : healthExamDrugId.trim();
    }

    public String getDrugComplianceCode() {
        return drugComplianceCode;
    }

    public void setDrugComplianceCode(String drugComplianceCode) {
        this.drugComplianceCode = drugComplianceCode == null ? null : drugComplianceCode.trim();
    }

    public String getDrugComplianceValue() {
        return drugComplianceValue;
    }

    public void setDrugComplianceValue(String drugComplianceValue) {
        this.drugComplianceValue = drugComplianceValue == null ? null : drugComplianceValue.trim();
    }

    public String getDrugDose() {
        return drugDose;
    }

    public void setDrugDose(String drugDose) {
        this.drugDose = drugDose == null ? null : drugDose.trim();
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public String getDrugTime() {
        return drugTime;
    }

    public void setDrugTime(String drugTime) {
        this.drugTime = drugTime == null ? null : drugTime.trim();
    }

    public String getDrugUsageCode() {
        return drugUsageCode;
    }

    public void setDrugUsageCode(String drugUsageCode) {
        this.drugUsageCode = drugUsageCode == null ? null : drugUsageCode.trim();
    }

    public String getHealthExamId() {
        return healthExamId;
    }

    public void setHealthExamId(String healthExamId) {
        this.healthExamId = healthExamId == null ? null : healthExamId.trim();
    }

    public Short getErrCode() {
        return errCode;
    }

    public void setErrCode(Short errCode) {
        this.errCode = errCode;
    }

    public String getErrStr() {
        return errStr;
    }

    public void setErrStr(String errStr) {
        this.errStr = errStr == null ? null : errStr.trim();
    }
}