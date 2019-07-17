package com.zkhw.pub.entity;

import java.util.Date;

public class HospitalizedRecord {
    private String id;

    private String examId;

    private String archiveNo;

    private String idNumber;

    private String serviceName;

    private Integer hospitalizedType;

    private String inHospitalTime;

    private String leaveHospitalTime;

    private String reason;

    private String hospitalOrgan;

    private String caseCode;

    private String remark;

    private String createOrg;

    private String createName;

    private Date createTime;

    private String updateName;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId == null ? null : examId.trim();
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Integer getHospitalizedType() {
        return hospitalizedType;
    }

    public void setHospitalizedType(Integer hospitalizedType) {
        this.hospitalizedType = hospitalizedType;
    }

    public String getInHospitalTime() {
        return inHospitalTime;
    }

    public void setInHospitalTime(String inHospitalTime) {
        this.inHospitalTime = inHospitalTime == null ? null : inHospitalTime.trim();
    }

    public String getLeaveHospitalTime() {
        return leaveHospitalTime;
    }

    public void setLeaveHospitalTime(String leaveHospitalTime) {
        this.leaveHospitalTime = leaveHospitalTime == null ? null : leaveHospitalTime.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getHospitalOrgan() {
        return hospitalOrgan;
    }

    public void setHospitalOrgan(String hospitalOrgan) {
        this.hospitalOrgan = hospitalOrgan == null ? null : hospitalOrgan.trim();
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode == null ? null : caseCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg == null ? null : createOrg.trim();
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
}