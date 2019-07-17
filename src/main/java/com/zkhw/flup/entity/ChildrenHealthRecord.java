package com.zkhw.flup.entity;

import java.util.Date;

public class ChildrenHealthRecord {
    private String id;

    private String name;

    private String archiveNo;

    private String idNumber;

    private Integer age;

    private String visitDate;

    private String weight;

    private String weightEvaluate;

    private String height;

    private String heightEvaluate;

    private String weightHeight;

    private String physicalAssessment;

    private String headCircumference;

    private String complexion;

    private String complexionOther;

    private String skin;

    private String skinOther;

    private String anteriorFontanelleWide;

    private String anteriorFontanelleHigh;

    private String anteriorFontanelle;

    private String neckMass;

    private String eye;

    private String eyeOther;

    private String vision;

    private String ear;

    private String earOther;

    private String hearing;

    private String oralCavity;

    private String cavityOther;

    private Integer teethingNum;

    private Integer cariesNum;

    private String breast;

    private String breastOther;

    private String abdominal;

    private String abdominalOther;

    private String umbilicalCord;

    private String umbilicalOther;

    private String extremity;

    private String extremityOther;

    private String gait;

    private String ricketsSymptom;

    private String ricketsSign;

    private String anus;

    private String anusOther;

    private String hemoglobin;

    private String other;

    private String outdoorTime;

    private String vitamindName;

    private String vitamindNum;

    private String growthResult;

    private String growth;

    private String sickenStasus;

    private Integer pneumoniaNum;

    private Integer diarrheaNum;

    private Integer traumaNum;

    private String sickenOther;

    private String transferTreatment;

    private String transferTreatmentReason;

    private String transferTreatmentDepartment;

    private String guidance;

    private String guidanceOther;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate == null ? null : visitDate.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getWeightEvaluate() {
        return weightEvaluate;
    }

    public void setWeightEvaluate(String weightEvaluate) {
        this.weightEvaluate = weightEvaluate == null ? null : weightEvaluate.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getHeightEvaluate() {
        return heightEvaluate;
    }

    public void setHeightEvaluate(String heightEvaluate) {
        this.heightEvaluate = heightEvaluate == null ? null : heightEvaluate.trim();
    }

    public String getWeightHeight() {
        return weightHeight;
    }

    public void setWeightHeight(String weightHeight) {
        this.weightHeight = weightHeight == null ? null : weightHeight.trim();
    }

    public String getPhysicalAssessment() {
        return physicalAssessment;
    }

    public void setPhysicalAssessment(String physicalAssessment) {
        this.physicalAssessment = physicalAssessment == null ? null : physicalAssessment.trim();
    }

    public String getHeadCircumference() {
        return headCircumference;
    }

    public void setHeadCircumference(String headCircumference) {
        this.headCircumference = headCircumference == null ? null : headCircumference.trim();
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion == null ? null : complexion.trim();
    }

    public String getComplexionOther() {
        return complexionOther;
    }

    public void setComplexionOther(String complexionOther) {
        this.complexionOther = complexionOther == null ? null : complexionOther.trim();
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin == null ? null : skin.trim();
    }

    public String getSkinOther() {
        return skinOther;
    }

    public void setSkinOther(String skinOther) {
        this.skinOther = skinOther == null ? null : skinOther.trim();
    }

    public String getAnteriorFontanelleWide() {
        return anteriorFontanelleWide;
    }

    public void setAnteriorFontanelleWide(String anteriorFontanelleWide) {
        this.anteriorFontanelleWide = anteriorFontanelleWide == null ? null : anteriorFontanelleWide.trim();
    }

    public String getAnteriorFontanelleHigh() {
        return anteriorFontanelleHigh;
    }

    public void setAnteriorFontanelleHigh(String anteriorFontanelleHigh) {
        this.anteriorFontanelleHigh = anteriorFontanelleHigh == null ? null : anteriorFontanelleHigh.trim();
    }

    public String getAnteriorFontanelle() {
        return anteriorFontanelle;
    }

    public void setAnteriorFontanelle(String anteriorFontanelle) {
        this.anteriorFontanelle = anteriorFontanelle == null ? null : anteriorFontanelle.trim();
    }

    public String getNeckMass() {
        return neckMass;
    }

    public void setNeckMass(String neckMass) {
        this.neckMass = neckMass == null ? null : neckMass.trim();
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye == null ? null : eye.trim();
    }

    public String getEyeOther() {
        return eyeOther;
    }

    public void setEyeOther(String eyeOther) {
        this.eyeOther = eyeOther == null ? null : eyeOther.trim();
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision == null ? null : vision.trim();
    }

    public String getEar() {
        return ear;
    }

    public void setEar(String ear) {
        this.ear = ear == null ? null : ear.trim();
    }

    public String getEarOther() {
        return earOther;
    }

    public void setEarOther(String earOther) {
        this.earOther = earOther == null ? null : earOther.trim();
    }

    public String getHearing() {
        return hearing;
    }

    public void setHearing(String hearing) {
        this.hearing = hearing == null ? null : hearing.trim();
    }

    public String getOralCavity() {
        return oralCavity;
    }

    public void setOralCavity(String oralCavity) {
        this.oralCavity = oralCavity == null ? null : oralCavity.trim();
    }

    public String getCavityOther() {
        return cavityOther;
    }

    public void setCavityOther(String cavityOther) {
        this.cavityOther = cavityOther == null ? null : cavityOther.trim();
    }

    public Integer getTeethingNum() {
        return teethingNum;
    }

    public void setTeethingNum(Integer teethingNum) {
        this.teethingNum = teethingNum;
    }

    public Integer getCariesNum() {
        return cariesNum;
    }

    public void setCariesNum(Integer cariesNum) {
        this.cariesNum = cariesNum;
    }

    public String getBreast() {
        return breast;
    }

    public void setBreast(String breast) {
        this.breast = breast == null ? null : breast.trim();
    }

    public String getBreastOther() {
        return breastOther;
    }

    public void setBreastOther(String breastOther) {
        this.breastOther = breastOther == null ? null : breastOther.trim();
    }

    public String getAbdominal() {
        return abdominal;
    }

    public void setAbdominal(String abdominal) {
        this.abdominal = abdominal == null ? null : abdominal.trim();
    }

    public String getAbdominalOther() {
        return abdominalOther;
    }

    public void setAbdominalOther(String abdominalOther) {
        this.abdominalOther = abdominalOther == null ? null : abdominalOther.trim();
    }

    public String getUmbilicalCord() {
        return umbilicalCord;
    }

    public void setUmbilicalCord(String umbilicalCord) {
        this.umbilicalCord = umbilicalCord == null ? null : umbilicalCord.trim();
    }

    public String getUmbilicalOther() {
        return umbilicalOther;
    }

    public void setUmbilicalOther(String umbilicalOther) {
        this.umbilicalOther = umbilicalOther == null ? null : umbilicalOther.trim();
    }

    public String getExtremity() {
        return extremity;
    }

    public void setExtremity(String extremity) {
        this.extremity = extremity == null ? null : extremity.trim();
    }

    public String getExtremityOther() {
        return extremityOther;
    }

    public void setExtremityOther(String extremityOther) {
        this.extremityOther = extremityOther == null ? null : extremityOther.trim();
    }

    public String getGait() {
        return gait;
    }

    public void setGait(String gait) {
        this.gait = gait == null ? null : gait.trim();
    }

    public String getRicketsSymptom() {
        return ricketsSymptom;
    }

    public void setRicketsSymptom(String ricketsSymptom) {
        this.ricketsSymptom = ricketsSymptom == null ? null : ricketsSymptom.trim();
    }

    public String getRicketsSign() {
        return ricketsSign;
    }

    public void setRicketsSign(String ricketsSign) {
        this.ricketsSign = ricketsSign == null ? null : ricketsSign.trim();
    }

    public String getAnus() {
        return anus;
    }

    public void setAnus(String anus) {
        this.anus = anus == null ? null : anus.trim();
    }

    public String getAnusOther() {
        return anusOther;
    }

    public void setAnusOther(String anusOther) {
        this.anusOther = anusOther == null ? null : anusOther.trim();
    }

    public String getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(String hemoglobin) {
        this.hemoglobin = hemoglobin == null ? null : hemoglobin.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getOutdoorTime() {
        return outdoorTime;
    }

    public void setOutdoorTime(String outdoorTime) {
        this.outdoorTime = outdoorTime == null ? null : outdoorTime.trim();
    }

    public String getVitamindName() {
        return vitamindName;
    }

    public void setVitamindName(String vitamindName) {
        this.vitamindName = vitamindName == null ? null : vitamindName.trim();
    }

    public String getVitamindNum() {
        return vitamindNum;
    }

    public void setVitamindNum(String vitamindNum) {
        this.vitamindNum = vitamindNum == null ? null : vitamindNum.trim();
    }

    public String getGrowthResult() {
        return growthResult;
    }

    public void setGrowthResult(String growthResult) {
        this.growthResult = growthResult == null ? null : growthResult.trim();
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth == null ? null : growth.trim();
    }

    public String getSickenStasus() {
        return sickenStasus;
    }

    public void setSickenStasus(String sickenStasus) {
        this.sickenStasus = sickenStasus == null ? null : sickenStasus.trim();
    }

    public Integer getPneumoniaNum() {
        return pneumoniaNum;
    }

    public void setPneumoniaNum(Integer pneumoniaNum) {
        this.pneumoniaNum = pneumoniaNum;
    }

    public Integer getDiarrheaNum() {
        return diarrheaNum;
    }

    public void setDiarrheaNum(Integer diarrheaNum) {
        this.diarrheaNum = diarrheaNum;
    }

    public Integer getTraumaNum() {
        return traumaNum;
    }

    public void setTraumaNum(Integer traumaNum) {
        this.traumaNum = traumaNum;
    }

    public String getSickenOther() {
        return sickenOther;
    }

    public void setSickenOther(String sickenOther) {
        this.sickenOther = sickenOther == null ? null : sickenOther.trim();
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