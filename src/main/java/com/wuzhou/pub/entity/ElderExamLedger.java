package com.wuzhou.pub.entity;

import java.util.Date;

public class ElderExamLedger {
	//65岁老年人体检管理台账ID
    private String elderExamLedgerId;

    //体检ID
    private String healthExamId;

    //录入机构ID
    private String createOrgId;

    //录入机构名称
    private String orgName;

    //录入时间
    private Date createTime;

    //录入人ID
    private String creatorId;

    //录入人姓名
    private String creator;

    //最后更新机构ID
    private String modifiedOrgId;

    //最后更新机构名称
    private String modifiedOrgName;

    //最后更新时间
    private Date modifiedTime;

    //最后更新人ID
    private String modifierId;

    //最后更新人姓名
    private String modifier;

    //体检日期
    private Date examDate;

    //个人档案ID
    private String personInfoId;

    //本人姓名
    private String name;

    //身份证证号
    private String idNo;

    //ABO血型
    private String aboCode;

    //地址
    private String address;

    //糖尿病药物
    private String diabetesDrugs;

    //酒
    private String drink;

    //过敏史
    private String drugAllergy;

    //文化程度
    private String educationCode;

    //锻炼
    private String exercise;

    //心脏病药物
    private String heartDrugs;

    //高血压药物
    private String hyperDrugs;

    //婚姻状况
    private String marriageCode;

    //医保
    private String medical;

    //烟
    private String smoking;

    //牙齿
    private String teeth;

    //电话号码
    private String telNo;

    //工作单位
    private String workUnit;

    //年份
    private Long year;

    //老年人认知功能筛查
    private String elderCognition;

    //老年人抑郁情况筛查
    private String elderDepression;

    //自理能力评估结果
    private String elderSelfCareAssess;

    //性别中文
    private String sexValue;

    //出生日期
    private Date birthday;

    //健康评价异常
    private String healthAbnormDesc;

    public String getElderExamLedgerId() {
        return elderExamLedgerId;
    }

    public void setElderExamLedgerId(String elderExamLedgerId) {
        this.elderExamLedgerId = elderExamLedgerId == null ? null : elderExamLedgerId.trim();
    }

    public String getHealthExamId() {
        return healthExamId;
    }

    public void setHealthExamId(String healthExamId) {
        this.healthExamId = healthExamId == null ? null : healthExamId.trim();
    }

    public String getCreateOrgId() {
        return createOrgId;
    }

    public void setCreateOrgId(String createOrgId) {
        this.createOrgId = createOrgId == null ? null : createOrgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getModifiedOrgId() {
        return modifiedOrgId;
    }

    public void setModifiedOrgId(String modifiedOrgId) {
        this.modifiedOrgId = modifiedOrgId == null ? null : modifiedOrgId.trim();
    }

    public String getModifiedOrgName() {
        return modifiedOrgName;
    }

    public void setModifiedOrgName(String modifiedOrgName) {
        this.modifiedOrgName = modifiedOrgName == null ? null : modifiedOrgName.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId == null ? null : modifierId.trim();
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getPersonInfoId() {
        return personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId == null ? null : personInfoId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
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

    public String getDiabetesDrugs() {
        return diabetesDrugs;
    }

    public void setDiabetesDrugs(String diabetesDrugs) {
        this.diabetesDrugs = diabetesDrugs == null ? null : diabetesDrugs.trim();
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink == null ? null : drink.trim();
    }

    public String getDrugAllergy() {
        return drugAllergy;
    }

    public void setDrugAllergy(String drugAllergy) {
        this.drugAllergy = drugAllergy == null ? null : drugAllergy.trim();
    }

    public String getEducationCode() {
        return educationCode;
    }

    public void setEducationCode(String educationCode) {
        this.educationCode = educationCode == null ? null : educationCode.trim();
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise == null ? null : exercise.trim();
    }

    public String getHeartDrugs() {
        return heartDrugs;
    }

    public void setHeartDrugs(String heartDrugs) {
        this.heartDrugs = heartDrugs == null ? null : heartDrugs.trim();
    }

    public String getHyperDrugs() {
        return hyperDrugs;
    }

    public void setHyperDrugs(String hyperDrugs) {
        this.hyperDrugs = hyperDrugs == null ? null : hyperDrugs.trim();
    }

    public String getMarriageCode() {
        return marriageCode;
    }

    public void setMarriageCode(String marriageCode) {
        this.marriageCode = marriageCode == null ? null : marriageCode.trim();
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical == null ? null : medical.trim();
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking == null ? null : smoking.trim();
    }

    public String getTeeth() {
        return teeth;
    }

    public void setTeeth(String teeth) {
        this.teeth = teeth == null ? null : teeth.trim();
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo == null ? null : telNo.trim();
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getElderCognition() {
        return elderCognition;
    }

    public void setElderCognition(String elderCognition) {
        this.elderCognition = elderCognition == null ? null : elderCognition.trim();
    }

    public String getElderDepression() {
        return elderDepression;
    }

    public void setElderDepression(String elderDepression) {
        this.elderDepression = elderDepression == null ? null : elderDepression.trim();
    }

    public String getElderSelfCareAssess() {
        return elderSelfCareAssess;
    }

    public void setElderSelfCareAssess(String elderSelfCareAssess) {
        this.elderSelfCareAssess = elderSelfCareAssess == null ? null : elderSelfCareAssess.trim();
    }

    public String getSexValue() {
        return sexValue;
    }

    public void setSexValue(String sexValue) {
        this.sexValue = sexValue == null ? null : sexValue.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHealthAbnormDesc() {
        return healthAbnormDesc;
    }

    public void setHealthAbnormDesc(String healthAbnormDesc) {
        this.healthAbnormDesc = healthAbnormDesc == null ? null : healthAbnormDesc.trim();
    }
}