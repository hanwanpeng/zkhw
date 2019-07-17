package com.zkhw.flup.entity;

import java.util.Date;

public class Hypertension {
    private String id;

    private String name;

    private String archiveNo;

    private String idNumber;

    private String visitDate;

    private String visitType;

    private String symptom;

    private String otherSymptom;

    private Integer sbp;

    private Integer dbp;

    private String weight;

    private String targetWeight;

    private String height;

    private String bmi;

    private String targetBmi;

    private Integer heartRate;

    private String otherSign;

    private Integer smoken;

    private Integer targetSomken;

    private Integer wine;

    private Integer targetWine;

    private Integer sportWeek;

    private Integer sportOnce;

    private Integer targetSportWeek;

    private Integer targetSportOnce;

    private String saltIntake;

    private String targetSaltIntake;

    private String mindAdjust;

    private String doctorObey;

    private String assistExamine;

    private String drugObey;

    private String untowardEffect;

    private String untowardEffectDrug;

    private String visitClass;

    private String referralCode;

    private String nextVisitDate;

    private String visitDoctor;

    private String advice;

    private String createUser;

    private String createName;

    private Date createTime;

    private String createOrg;

    private String createOrgName;

    private String updateName;

    private Date updateTime;

    private String transferOrgan;

    private String transferReason;

    private Integer uploadStatus;

    private Date uploadTime;

    private String uploadResult;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getArchiveNo() {
        return archiveNo;
    }

    public void setArchiveNo(String archiveNo) {
        this.archiveNo = archiveNo == null ? null : archiveNo.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate == null ? null : visitDate.trim();
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType == null ? null : visitType.trim();
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    public String getOtherSymptom() {
        return otherSymptom;
    }

    public void setOtherSymptom(String otherSymptom) {
        this.otherSymptom = otherSymptom == null ? null : otherSymptom.trim();
    }

    public Integer getSbp() {
        return sbp;
    }

    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }

    public Integer getDbp() {
        return dbp;
    }

    public void setDbp(Integer dbp) {
        this.dbp = dbp;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(String targetWeight) {
        this.targetWeight = targetWeight == null ? null : targetWeight.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi == null ? null : bmi.trim();
    }

    public String getTargetBmi() {
        return targetBmi;
    }

    public void setTargetBmi(String targetBmi) {
        this.targetBmi = targetBmi == null ? null : targetBmi.trim();
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public String getOtherSign() {
        return otherSign;
    }

    public void setOtherSign(String otherSign) {
        this.otherSign = otherSign == null ? null : otherSign.trim();
    }

    public Integer getSmoken() {
        return smoken;
    }

    public void setSmoken(Integer smoken) {
        this.smoken = smoken;
    }

    public Integer getTargetSomken() {
        return targetSomken;
    }

    public void setTargetSomken(Integer targetSomken) {
        this.targetSomken = targetSomken;
    }

    public Integer getWine() {
        return wine;
    }

    public void setWine(Integer wine) {
        this.wine = wine;
    }

    public Integer getTargetWine() {
        return targetWine;
    }

    public void setTargetWine(Integer targetWine) {
        this.targetWine = targetWine;
    }

    public Integer getSportWeek() {
        return sportWeek;
    }

    public void setSportWeek(Integer sportWeek) {
        this.sportWeek = sportWeek;
    }

    public Integer getSportOnce() {
        return sportOnce;
    }

    public void setSportOnce(Integer sportOnce) {
        this.sportOnce = sportOnce;
    }

    public Integer getTargetSportWeek() {
        return targetSportWeek;
    }

    public void setTargetSportWeek(Integer targetSportWeek) {
        this.targetSportWeek = targetSportWeek;
    }

    public Integer getTargetSportOnce() {
        return targetSportOnce;
    }

    public void setTargetSportOnce(Integer targetSportOnce) {
        this.targetSportOnce = targetSportOnce;
    }

    public String getSaltIntake() {
        return saltIntake;
    }

    public void setSaltIntake(String saltIntake) {
        this.saltIntake = saltIntake == null ? null : saltIntake.trim();
    }

    public String getTargetSaltIntake() {
        return targetSaltIntake;
    }

    public void setTargetSaltIntake(String targetSaltIntake) {
        this.targetSaltIntake = targetSaltIntake == null ? null : targetSaltIntake.trim();
    }

    public String getMindAdjust() {
        return mindAdjust;
    }

    public void setMindAdjust(String mindAdjust) {
        this.mindAdjust = mindAdjust == null ? null : mindAdjust.trim();
    }

    public String getDoctorObey() {
        return doctorObey;
    }

    public void setDoctorObey(String doctorObey) {
        this.doctorObey = doctorObey == null ? null : doctorObey.trim();
    }

    public String getAssistExamine() {
        return assistExamine;
    }

    public void setAssistExamine(String assistExamine) {
        this.assistExamine = assistExamine == null ? null : assistExamine.trim();
    }

    public String getDrugObey() {
        return drugObey;
    }

    public void setDrugObey(String drugObey) {
        this.drugObey = drugObey == null ? null : drugObey.trim();
    }

    public String getUntowardEffect() {
        return untowardEffect;
    }

    public void setUntowardEffect(String untowardEffect) {
        this.untowardEffect = untowardEffect == null ? null : untowardEffect.trim();
    }

    public String getUntowardEffectDrug() {
        return untowardEffectDrug;
    }

    public void setUntowardEffectDrug(String untowardEffectDrug) {
        this.untowardEffectDrug = untowardEffectDrug == null ? null : untowardEffectDrug.trim();
    }

    public String getVisitClass() {
        return visitClass;
    }

    public void setVisitClass(String visitClass) {
        this.visitClass = visitClass == null ? null : visitClass.trim();
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode == null ? null : referralCode.trim();
    }

    public String getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(String nextVisitDate) {
        this.nextVisitDate = nextVisitDate == null ? null : nextVisitDate.trim();
    }

    public String getVisitDoctor() {
        return visitDoctor;
    }

    public void setVisitDoctor(String visitDoctor) {
        this.visitDoctor = visitDoctor == null ? null : visitDoctor.trim();
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg == null ? null : createOrg.trim();
    }

    public String getCreateOrgName() {
        return createOrgName;
    }

    public void setCreateOrgName(String createOrgName) {
        this.createOrgName = createOrgName == null ? null : createOrgName.trim();
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTransferOrgan() {
        return transferOrgan;
    }

    public void setTransferOrgan(String transferOrgan) {
        this.transferOrgan = transferOrgan == null ? null : transferOrgan.trim();
    }

    public String getTransferReason() {
        return transferReason;
    }

    public void setTransferReason(String transferReason) {
        this.transferReason = transferReason == null ? null : transferReason.trim();
    }

    public Integer getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Integer uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadResult() {
        return uploadResult;
    }

    public void setUploadResult(String uploadResult) {
        this.uploadResult = uploadResult == null ? null : uploadResult.trim();
    }
}