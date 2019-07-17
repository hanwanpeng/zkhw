package com.wuzhou.pub.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ElderSelfcareAbility {
    private String elderSelfcareAbilityId;

    private String personInfoId;

    private String elderHealthAssessCode;

    private Short dineScore;

    private Short cleanupScore;

    private Short dressedScore;

    private Short defecationScore;

    private Short activityScore;

    private Short totalScore;

    private Date fillDate;

    private String createOrgId;

    private String orgName;

    private String creatorId;

    private String creator;

    private Date createTime;

    private String modifiedOrgId;

    private String modifiedOrgName;

    private String modifierId;

    private String modifier;

    private Date modifiedTime;

    private Integer assessmentCount;

    private Integer missingCount;

    private BigDecimal intactRate;

    private Short isAppCreate;

    private String doctorName;

    private String doctorId;

    private Short errCode;

    private String errStr;

    public String getElderSelfcareAbilityId() {
        return elderSelfcareAbilityId;
    }

    public void setElderSelfcareAbilityId(String elderSelfcareAbilityId) {
        this.elderSelfcareAbilityId = elderSelfcareAbilityId == null ? null : elderSelfcareAbilityId.trim();
    }

    public String getPersonInfoId() {
        return personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId == null ? null : personInfoId.trim();
    }

    public String getElderHealthAssessCode() {
        return elderHealthAssessCode;
    }

    public void setElderHealthAssessCode(String elderHealthAssessCode) {
        this.elderHealthAssessCode = elderHealthAssessCode == null ? null : elderHealthAssessCode.trim();
    }

    public Short getDineScore() {
        return dineScore;
    }

    public void setDineScore(Short dineScore) {
        this.dineScore = dineScore;
    }

    public Short getCleanupScore() {
        return cleanupScore;
    }

    public void setCleanupScore(Short cleanupScore) {
        this.cleanupScore = cleanupScore;
    }

    public Short getDressedScore() {
        return dressedScore;
    }

    public void setDressedScore(Short dressedScore) {
        this.dressedScore = dressedScore;
    }

    public Short getDefecationScore() {
        return defecationScore;
    }

    public void setDefecationScore(Short defecationScore) {
        this.defecationScore = defecationScore;
    }

    public Short getActivityScore() {
        return activityScore;
    }

    public void setActivityScore(Short activityScore) {
        this.activityScore = activityScore;
    }

    public Short getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Short totalScore) {
        this.totalScore = totalScore;
    }

    public Date getFillDate() {
        return fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getAssessmentCount() {
        return assessmentCount;
    }

    public void setAssessmentCount(Integer assessmentCount) {
        this.assessmentCount = assessmentCount;
    }

    public Integer getMissingCount() {
        return missingCount;
    }

    public void setMissingCount(Integer missingCount) {
        this.missingCount = missingCount;
    }

    public BigDecimal getIntactRate() {
        return intactRate;
    }

    public void setIntactRate(BigDecimal intactRate) {
        this.intactRate = intactRate;
    }

    public Short getIsAppCreate() {
        return isAppCreate;
    }

    public void setIsAppCreate(Short isAppCreate) {
        this.isAppCreate = isAppCreate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
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