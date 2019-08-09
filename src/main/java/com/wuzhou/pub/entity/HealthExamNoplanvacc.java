package com.wuzhou.pub.entity;

import java.util.Date;

public class HealthExamNoplanvacc {
	//个人健康体检疫苗情况ID
    private String healthExamNoplanVaccId;

    //个人健康体检ID
    private String healthExamId;

    //表内顺序
    private Short ssn;

    //疫苗接种日期
    private Date vaccinationDate;

    //疫苗接种单位名称
    private String vaccinationOrgName;

    //疫苗名称代码
    private String vaccineCode;

    //接口返回值，0成功1失败，由冠新填入。
    private Short errCode;

    //接口返回信息，由冠新填入。
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