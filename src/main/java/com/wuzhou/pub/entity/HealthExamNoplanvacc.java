package com.wuzhou.pub.entity;

import java.util.Date;

public class HealthExamNoplanvacc {
    private String healthExamNoplanVaccId;

    private String healthExamId;

    private Short ssn;

    private Date vaccinationDate;

    private String vaccinationOrgName;

    private String vaccineCode;

    private Short errCode;

    private String errStr;

    public String getHealthExamNoplanVaccId() {
        return healthExamNoplanVaccId;
    }

    public void setHealthExamNoplanVaccId(String healthExamNoplanVaccId) {
        this.healthExamNoplanVaccId = healthExamNoplanVaccId == null ? null : healthExamNoplanVaccId.trim();
    }

    public String getHealthExamId() {
        return healthExamId;
    }

    public void setHealthExamId(String healthExamId) {
        this.healthExamId = healthExamId == null ? null : healthExamId.trim();
    }

    public Short getSsn() {
        return ssn;
    }

    public void setSsn(Short ssn) {
        this.ssn = ssn;
    }

    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getVaccinationOrgName() {
        return vaccinationOrgName;
    }

    public void setVaccinationOrgName(String vaccinationOrgName) {
        this.vaccinationOrgName = vaccinationOrgName == null ? null : vaccinationOrgName.trim();
    }

    public String getVaccineCode() {
        return vaccineCode;
    }

    public void setVaccineCode(String vaccineCode) {
        this.vaccineCode = vaccineCode == null ? null : vaccineCode.trim();
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