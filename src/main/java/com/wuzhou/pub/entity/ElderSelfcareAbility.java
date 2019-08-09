package com.wuzhou.pub.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ElderSelfcareAbility {
	//老年人自理能力评估表ID
    private String elderSelfcareAbilityId;

    //个人档案ID
    private String personInfoId;

    //老年人健康状态自我评估代码
    private String elderHealthAssessCode;

    //进餐评分
    private Short dineScore;

    //梳洗评分
    private Short cleanupScore;

    //穿衣评分
    private Short dressedScore;

    //如厕评分
    private Short defecationScore;

    //活动评分
    private Short activityScore;

    //总评分
    private Short totalScore;

    //填表时间
    private Date fillDate;

    //录入机构ID
    private String createOrgId;

    //录入机构名称
    private String orgName;

    //录入人ID
    private String creatorId;

    //录入人姓名
    private String creator;

    //录入时间
    private Date createTime;

    //最后更新机构ID
    private String modifiedOrgId;

    //最后更新机构名称
    private String modifiedOrgName;

    //最后更新人ID
    private String modifierId;

    //最后更新人姓名
    private String modifier;

    //最后更新时间
    private Date modifiedTime;

    //考核项总数
    private Integer assessmentCount;

    //未考核项
    private Integer missingCount;

    //完整率
    private BigDecimal intactRate;

    //传入“5”
    private Short isAppCreate;

    //评价医生姓名
    private String doctorName;

    //评价医生ID
    private String doctorId;

    //接口返回值，0成功1失败，由冠新填入。
    private Short errCode;

    //接口返回信息，由冠新填入。
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