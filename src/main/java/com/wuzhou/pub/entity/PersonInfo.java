package com.wuzhou.pub.entity;

import java.util.Date;

public class PersonInfo {
	//个人档案ID
    private String personInfoId;

    //姓名
    private String aboCode;

    //性别
    private String address;

    //民族
    private Date birthday;

    //身份证证号
    private String idNo;

    //出生日期
    private String name;

    //家庭地址
    private String nationalityValue;

    //ABO血型代码
    private String rhCode;

    //Rh血型代码
    private String sexValue;

    //药物过敏史
    private String drugAllergyValue;

    public String getPersonInfoId() {
        return personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId == null ? null : personInfoId.trim();
    }

    public String getAboCode() {
        return aboCode;
    }

    public void setAboCode(String aboCode) {
        this.aboCode = aboCode == null ? null : aboCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNationalityValue() {
        return nationalityValue;
    }

    public void setNationalityValue(String nationalityValue) {
        this.nationalityValue = nationalityValue == null ? null : nationalityValue.trim();
    }

    public String getRhCode() {
        return rhCode;
    }

    public void setRhCode(String rhCode) {
        this.rhCode = rhCode == null ? null : rhCode.trim();
    }

    public String getSexValue() {
        return sexValue;
    }

    public void setSexValue(String sexValue) {
        this.sexValue = sexValue == null ? null : sexValue.trim();
    }

    public String getDrugAllergyValue() {
        return drugAllergyValue;
    }

    public void setDrugAllergyValue(String drugAllergyValue) {
        this.drugAllergyValue = drugAllergyValue == null ? null : drugAllergyValue.trim();
    }
}