package com.wuzhou.pub.entity;

import java.util.Date;

public class HealthExamInhos {
	//个人健康体检住院治疗情况ID
    private String healthExamInhosId;

    //入院日期/建床日期
    private Date admissionDate;

    //原因
    private String admissionReason;

    //出院日期/撤床日期
    private Date dischargeDate;

    //个人健康体检ID
    private String healthExamId;

    //医疗机构名称
    private String hospitalName;

    //住院史类型代码(1住院史2病床史)
    private String inhosHistoryTypeCode;

    //病案号
    private String medicalRecordNo;

    //接口返回值，0成功1失败，由冠新填入。
    private Short errCode;

    //接口返回信息，由冠新填入。
    private String errStr;

    public String getHealthExamInhosId() {
        return healthExamInhosId;
    }

    public void setHealthExamInhosId(String healthExamInhosId) {
        this.healthExamInhosId = healthExamInhosId == null ? null : healthExamInhosId.trim();
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAdmissionReason() {
        return admissionReason;
    }

    public void setAdmissionReason(String admissionReason) {
        this.admissionReason = admissionReason == null ? null : admissionReason.trim();
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getHealthExamId() {
        return healthExamId;
    }

    public void setHealthExamId(String healthExamId) {
        this.healthExamId = healthExamId == null ? null : healthExamId.trim();
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName == null ? null : hospitalName.trim();
    }

    public String getInhosHistoryTypeCode() {
        return inhosHistoryTypeCode;
    }

    public void setInhosHistoryTypeCode(String inhosHistoryTypeCode) {
        this.inhosHistoryTypeCode = inhosHistoryTypeCode == null ? null : inhosHistoryTypeCode.trim();
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo == null ? null : medicalRecordNo.trim();
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