package com.wuzhou.pub.entity;

import java.util.Date;

public class ElderInfo {
    private String elderInfoId;

    private String personInfoId;

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

    private String name;

    private String maintenanceModeCode;

    private String guardianName;

    private String guardianRelationCode;

    private String guardianAddr;

    private String guardianTelNo;

    private String guardianMobile;

    private String informant;

    private Date informantDate;

    private String investigator;

    private Date investigatorDate;

    private Date manageDate;

    private String remarks;

    private Short isAppCreate;

    public String getElderInfoId() {
        return elderInfoId;
    }

    public void setElderInfoId(String elderInfoId) {
        this.elderInfoId = elderInfoId == null ? null : elderInfoId.trim();
    }

    public String getPersonInfoId() {
        return personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId == null ? null : personInfoId.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMaintenanceModeCode() {
        return maintenanceModeCode;
    }

    public void setMaintenanceModeCode(String maintenanceModeCode) {
        this.maintenanceModeCode = maintenanceModeCode == null ? null : maintenanceModeCode.trim();
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName == null ? null : guardianName.trim();
    }

    public String getGuardianRelationCode() {
        return guardianRelationCode;
    }

    public void setGuardianRelationCode(String guardianRelationCode) {
        this.guardianRelationCode = guardianRelationCode == null ? null : guardianRelationCode.trim();
    }

    public String getGuardianAddr() {
        return guardianAddr;
    }

    public void setGuardianAddr(String guardianAddr) {
        this.guardianAddr = guardianAddr == null ? null : guardianAddr.trim();
    }

    public String getGuardianTelNo() {
        return guardianTelNo;
    }

    public void setGuardianTelNo(String guardianTelNo) {
        this.guardianTelNo = guardianTelNo == null ? null : guardianTelNo.trim();
    }

    public String getGuardianMobile() {
        return guardianMobile;
    }

    public void setGuardianMobile(String guardianMobile) {
        this.guardianMobile = guardianMobile == null ? null : guardianMobile.trim();
    }

    public String getInformant() {
        return informant;
    }

    public void setInformant(String informant) {
        this.informant = informant == null ? null : informant.trim();
    }

    public Date getInformantDate() {
        return informantDate;
    }

    public void setInformantDate(Date informantDate) {
        this.informantDate = informantDate;
    }

    public String getInvestigator() {
        return investigator;
    }

    public void setInvestigator(String investigator) {
        this.investigator = investigator == null ? null : investigator.trim();
    }

    public Date getInvestigatorDate() {
        return investigatorDate;
    }

    public void setInvestigatorDate(Date investigatorDate) {
        this.investigatorDate = investigatorDate;
    }

    public Date getManageDate() {
        return manageDate;
    }

    public void setManageDate(Date manageDate) {
        this.manageDate = manageDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Short getIsAppCreate() {
        return isAppCreate;
    }

    public void setIsAppCreate(Short isAppCreate) {
        this.isAppCreate = isAppCreate;
    }
}