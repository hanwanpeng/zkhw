package com.zkhw.flup.entity;

import java.util.Date;

public class PsychosisInfo {
    private String id;

    private String name;

    private String archiveNo;

    private String idNumber;

    private String guardianName;

    private String guardianRelation;

    private String guardianAddress;

    private String guardianPhone;

    private String neighborhoodCommitteeLinkman;

    private String neighborhoodCommitteeLinktel;

    private String residentType;

    private String employmentStatus;

    private String agreeManage;

    private String agreeName;

    private String agreeDate;

    private String firstMorbidityDate;

    private String symptom;

    private String symptomOther;

    private String isolation;

    private String outpatient;

    private String firstMedicineDate;

    private Integer hospitalizedNum;

    private String diagnosis;

    private String diagnosisHospital;

    private String diagnosisDate;

    private String recentlyTreatmentEffect;

    private String dangerousAct;

    private Integer slightTroubleNum;

    private Integer causeTroubleNum;

    private Integer causeAccidentNum;

    private Integer harmOtherNum;

    private Integer autolesionNum;

    private Integer attemptedSuicideNum;

    private String economics;

    private String specialistSuggestion;

    private String recordDate;

    private String recordDoctor;

    private String remark;

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

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName == null ? null : guardianName.trim();
    }

    public String getGuardianRelation() {
        return guardianRelation;
    }

    public void setGuardianRelation(String guardianRelation) {
        this.guardianRelation = guardianRelation == null ? null : guardianRelation.trim();
    }

    public String getGuardianAddress() {
        return guardianAddress;
    }

    public void setGuardianAddress(String guardianAddress) {
        this.guardianAddress = guardianAddress == null ? null : guardianAddress.trim();
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone == null ? null : guardianPhone.trim();
    }

    public String getNeighborhoodCommitteeLinkman() {
        return neighborhoodCommitteeLinkman;
    }

    public void setNeighborhoodCommitteeLinkman(String neighborhoodCommitteeLinkman) {
        this.neighborhoodCommitteeLinkman = neighborhoodCommitteeLinkman == null ? null : neighborhoodCommitteeLinkman.trim();
    }

    public String getNeighborhoodCommitteeLinktel() {
        return neighborhoodCommitteeLinktel;
    }

    public void setNeighborhoodCommitteeLinktel(String neighborhoodCommitteeLinktel) {
        this.neighborhoodCommitteeLinktel = neighborhoodCommitteeLinktel == null ? null : neighborhoodCommitteeLinktel.trim();
    }

    public String getResidentType() {
        return residentType;
    }

    public void setResidentType(String residentType) {
        this.residentType = residentType == null ? null : residentType.trim();
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus == null ? null : employmentStatus.trim();
    }

    public String getAgreeManage() {
        return agreeManage;
    }

    public void setAgreeManage(String agreeManage) {
        this.agreeManage = agreeManage == null ? null : agreeManage.trim();
    }

    public String getAgreeName() {
        return agreeName;
    }

    public void setAgreeName(String agreeName) {
        this.agreeName = agreeName == null ? null : agreeName.trim();
    }

    public String getAgreeDate() {
        return agreeDate;
    }

    public void setAgreeDate(String agreeDate) {
        this.agreeDate = agreeDate == null ? null : agreeDate.trim();
    }

    public String getFirstMorbidityDate() {
        return firstMorbidityDate;
    }

    public void setFirstMorbidityDate(String firstMorbidityDate) {
        this.firstMorbidityDate = firstMorbidityDate == null ? null : firstMorbidityDate.trim();
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    public String getSymptomOther() {
        return symptomOther;
    }

    public void setSymptomOther(String symptomOther) {
        this.symptomOther = symptomOther == null ? null : symptomOther.trim();
    }

    public String getIsolation() {
        return isolation;
    }

    public void setIsolation(String isolation) {
        this.isolation = isolation == null ? null : isolation.trim();
    }

    public String getOutpatient() {
        return outpatient;
    }

    public void setOutpatient(String outpatient) {
        this.outpatient = outpatient == null ? null : outpatient.trim();
    }

    public String getFirstMedicineDate() {
        return firstMedicineDate;
    }

    public void setFirstMedicineDate(String firstMedicineDate) {
        this.firstMedicineDate = firstMedicineDate == null ? null : firstMedicineDate.trim();
    }

    public Integer getHospitalizedNum() {
        return hospitalizedNum;
    }

    public void setHospitalizedNum(Integer hospitalizedNum) {
        this.hospitalizedNum = hospitalizedNum;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    public String getDiagnosisHospital() {
        return diagnosisHospital;
    }

    public void setDiagnosisHospital(String diagnosisHospital) {
        this.diagnosisHospital = diagnosisHospital == null ? null : diagnosisHospital.trim();
    }

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate == null ? null : diagnosisDate.trim();
    }

    public String getRecentlyTreatmentEffect() {
        return recentlyTreatmentEffect;
    }

    public void setRecentlyTreatmentEffect(String recentlyTreatmentEffect) {
        this.recentlyTreatmentEffect = recentlyTreatmentEffect == null ? null : recentlyTreatmentEffect.trim();
    }

    public String getDangerousAct() {
        return dangerousAct;
    }

    public void setDangerousAct(String dangerousAct) {
        this.dangerousAct = dangerousAct == null ? null : dangerousAct.trim();
    }

    public Integer getSlightTroubleNum() {
        return slightTroubleNum;
    }

    public void setSlightTroubleNum(Integer slightTroubleNum) {
        this.slightTroubleNum = slightTroubleNum;
    }

    public Integer getCauseTroubleNum() {
        return causeTroubleNum;
    }

    public void setCauseTroubleNum(Integer causeTroubleNum) {
        this.causeTroubleNum = causeTroubleNum;
    }

    public Integer getCauseAccidentNum() {
        return causeAccidentNum;
    }

    public void setCauseAccidentNum(Integer causeAccidentNum) {
        this.causeAccidentNum = causeAccidentNum;
    }

    public Integer getHarmOtherNum() {
        return harmOtherNum;
    }

    public void setHarmOtherNum(Integer harmOtherNum) {
        this.harmOtherNum = harmOtherNum;
    }

    public Integer getAutolesionNum() {
        return autolesionNum;
    }

    public void setAutolesionNum(Integer autolesionNum) {
        this.autolesionNum = autolesionNum;
    }

    public Integer getAttemptedSuicideNum() {
        return attemptedSuicideNum;
    }

    public void setAttemptedSuicideNum(Integer attemptedSuicideNum) {
        this.attemptedSuicideNum = attemptedSuicideNum;
    }

    public String getEconomics() {
        return economics;
    }

    public void setEconomics(String economics) {
        this.economics = economics == null ? null : economics.trim();
    }

    public String getSpecialistSuggestion() {
        return specialistSuggestion;
    }

    public void setSpecialistSuggestion(String specialistSuggestion) {
        this.specialistSuggestion = specialistSuggestion == null ? null : specialistSuggestion.trim();
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate == null ? null : recordDate.trim();
    }

    public String getRecordDoctor() {
        return recordDoctor;
    }

    public void setRecordDoctor(String recordDoctor) {
        this.recordDoctor = recordDoctor == null ? null : recordDoctor.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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