package com.zkhw.flup.entity;

import java.util.Date;

public class GravidaFollowRecord {
    private String id;

    private String gravidaId;

    private String name;

    private String archiveNo;

    private String idNumber;

    private String orderNum;

    private String visitDate;

    private Integer gestationalWeeks;

    private String symptom;

    private String weight;

    private String fundusHeight;

    private String abdomenCircumference;

    private String fetusPosition;

    private String fetalHeartRate;

    private Integer bloodPressureHigh;

    private Integer bloodPressureLow;

    private String hemoglobin;

    private String urineProtein;

    private String checkOther;

    private String conditions;

    private String errorInfo;

    private String guidance;

    private String guidanceOther;

    private String transferTreatment;

    private String transferTreatmentReason;

    private String transferTreatmentDepartment;

    private String nextVisitDate;

    private String visitDoctor;

    private String createUser;

    private String createName;

    private String createOrg;

    private String createOrgName;

    private Date createTime;

    private String updateUser;

    private String updateName;

    private Date updateTime;

    private Integer uploadStatus;

    private Date uploadTime;

    private String uploadResult;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGravidaId() {
        return gravidaId;
    }

    public void setGravidaId(String gravidaId) {
        this.gravidaId = gravidaId == null ? null : gravidaId.trim();
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

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate == null ? null : visitDate.trim();
    }

    public Integer getGestationalWeeks() {
        return gestationalWeeks;
    }

    public void setGestationalWeeks(Integer gestationalWeeks) {
        this.gestationalWeeks = gestationalWeeks;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getFundusHeight() {
        return fundusHeight;
    }

    public void setFundusHeight(String fundusHeight) {
        this.fundusHeight = fundusHeight == null ? null : fundusHeight.trim();
    }

    public String getAbdomenCircumference() {
        return abdomenCircumference;
    }

    public void setAbdomenCircumference(String abdomenCircumference) {
        this.abdomenCircumference = abdomenCircumference == null ? null : abdomenCircumference.trim();
    }

    public String getFetusPosition() {
        return fetusPosition;
    }

    public void setFetusPosition(String fetusPosition) {
        this.fetusPosition = fetusPosition == null ? null : fetusPosition.trim();
    }

    public String getFetalHeartRate() {
        return fetalHeartRate;
    }

    public void setFetalHeartRate(String fetalHeartRate) {
        this.fetalHeartRate = fetalHeartRate == null ? null : fetalHeartRate.trim();
    }

    public Integer getBloodPressureHigh() {
        return bloodPressureHigh;
    }

    public void setBloodPressureHigh(Integer bloodPressureHigh) {
        this.bloodPressureHigh = bloodPressureHigh;
    }

    public Integer getBloodPressureLow() {
        return bloodPressureLow;
    }

    public void setBloodPressureLow(Integer bloodPressureLow) {
        this.bloodPressureLow = bloodPressureLow;
    }

    public String getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(String hemoglobin) {
        this.hemoglobin = hemoglobin == null ? null : hemoglobin.trim();
    }

    public String getUrineProtein() {
        return urineProtein;
    }

    public void setUrineProtein(String urineProtein) {
        this.urineProtein = urineProtein == null ? null : urineProtein.trim();
    }

    public String getCheckOther() {
        return checkOther;
    }

    public void setCheckOther(String checkOther) {
        this.checkOther = checkOther == null ? null : checkOther.trim();
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo == null ? null : errorInfo.trim();
    }

    public String getGuidance() {
        return guidance;
    }

    public void setGuidance(String guidance) {
        this.guidance = guidance == null ? null : guidance.trim();
    }

    public String getGuidanceOther() {
        return guidanceOther;
    }

    public void setGuidanceOther(String guidanceOther) {
        this.guidanceOther = guidanceOther == null ? null : guidanceOther.trim();
    }

    public String getTransferTreatment() {
        return transferTreatment;
    }

    public void setTransferTreatment(String transferTreatment) {
        this.transferTreatment = transferTreatment == null ? null : transferTreatment.trim();
    }

    public String getTransferTreatmentReason() {
        return transferTreatmentReason;
    }

    public void setTransferTreatmentReason(String transferTreatmentReason) {
        this.transferTreatmentReason = transferTreatmentReason == null ? null : transferTreatmentReason.trim();
    }

    public String getTransferTreatmentDepartment() {
        return transferTreatmentDepartment;
    }

    public void setTransferTreatmentDepartment(String transferTreatmentDepartment) {
        this.transferTreatmentDepartment = transferTreatmentDepartment == null ? null : transferTreatmentDepartment.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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