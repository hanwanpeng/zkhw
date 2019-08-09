package com.wuzhou.pub.entity;

import java.util.Date;

public class ElderInfo {
	
	//老年人专档ID
    private String elderInfoId;

    //个人档案ID
    private String personInfoId;

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

    //本人姓名
    private String name;

    //赡养方式
    private String maintenanceModeCode;

    //监护人姓名
    private String guardianName;

    //监护人与本人关系代码
    private String guardianRelationCode;

    //监护人地址
    private String guardianAddr;

    //监护人电话号码
    private String guardianTelNo;

    //监护人手机号码
    private String guardianMobile;

    //被调查者
    private String informant;

    //签名日期
    private Date informantDate;

    //调查者
    private String investigator;

    //调查日期
    private Date investigatorDate;

    //纳入老年人管理日期
    private Date manageDate;

    //备注
    private String remarks;

    //传入“5”
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