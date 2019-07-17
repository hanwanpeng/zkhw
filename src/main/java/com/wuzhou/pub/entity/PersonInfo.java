package com.wuzhou.pub.entity;

import java.util.Date;

public class PersonInfo {
    private String personInfoId;

    private String aboCode;

    private String address;

    private Date birthday;

    private String idNo;

    private String name;

    private String nationalityValue;

    private String rhCode;

    private String sexValue;

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