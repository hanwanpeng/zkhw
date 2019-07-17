package com.wuzhou.pub.entity;

import java.util.Date;

public class HealthExamInhos {
    private String healthExamInhosId;

    private Date admissionDate;

    private String admissionReason;

    private Date dischargeDate;

    private String healthExamId;

    private String hospitalName;

    private String inhosHistoryTypeCode;

    private String medicalRecordNo;

    private Short errCode;

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