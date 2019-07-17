package com.zkhw.flup.entity;

import java.util.Date;

public class NeonatusInfo {
    private String id;

    private String name;

    private String archiveNo;

    private String idNumber;

    private String sex;

    private String birthday;

    private String homeAddress;

    private String fatherName;

    private String fatherProfession;

    private String fatherPhone;

    private String fatherBirthday;

    private String motherName;

    private String motherProfession;

    private String motherPhone;

    private String motherBirthday;

    private Integer gestationalWeeks;

    private String sickenStasus;

    private String sickenOther;

    private String midwifeOrg;

    private String birthSituation;

    private String birthOther;

    private String asphyxiaNeonatorum;

    private String asphyxiaTime;

    private String deformity;

    private String deformityOther;

    private String hearing;

    private String disease;

    private String diseaseOther;

    private String birthWeight;

    private String weight;

    private String birthHeight;

    private String feedingPatterns;

    private Integer milkNum;

    private Integer milkIntake;

    private String vomit;

    private String shit;

    private Integer defecationNum;

    private String temperature;

    private Integer heartRate;

    private Integer breathingRate;

    private String complexion;

    private String complexionOther;

    private String aurigo;

    private String aurigoOther;

    private String anteriorFontanelleWide;

    private String anteriorFontanelleHigh;

    private String anteriorFontanelle;

    private String anteriorFontanelleOther;

    private String eye;

    private String extremityMobility;

    private String ear;

    private String neckMass;

    private String nose;

    private String skin;

    private String skinOther;

    private String oralCavity;

    private String anus;

    private String heartLung;

    private String breast;

    private String abdominalTouch;

    private String spine;

    private String aedea;

    private String umbilicalCord;

    private String umbilicalCordOther;

    private String transferTreatment;

    private String transferTreatmentReason;

    private String transferTreatmentDepartment;

    private String guidance;

    private String guidanceOther;

    private String visitDate;

    private String nextVisitDate;

    private String nextVisitAddress;

    private String visitDoctor;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String countyCode;

    private String countyName;

    private String townsCode;

    private String townsName;

    private String villageCode;

    private String villageName;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName == null ? null : fatherName.trim();
    }

    public String getFatherProfession() {
        return fatherProfession;
    }

    public void setFatherProfession(String fatherProfession) {
        this.fatherProfession = fatherProfession == null ? null : fatherProfession.trim();
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone == null ? null : fatherPhone.trim();
    }

    public String getFatherBirthday() {
        return fatherBirthday;
    }

    public void setFatherBirthday(String fatherBirthday) {
        this.fatherBirthday = fatherBirthday == null ? null : fatherBirthday.trim();
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName == null ? null : motherName.trim();
    }

    public String getMotherProfession() {
        return motherProfession;
    }

    public void setMotherProfession(String motherProfession) {
        this.motherProfession = motherProfession == null ? null : motherProfession.trim();
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone == null ? null : motherPhone.trim();
    }

    public String getMotherBirthday() {
        return motherBirthday;
    }

    public void setMotherBirthday(String motherBirthday) {
        this.motherBirthday = motherBirthday == null ? null : motherBirthday.trim();
    }

    public Integer getGestationalWeeks() {
        return gestationalWeeks;
    }

    public void setGestationalWeeks(Integer gestationalWeeks) {
        this.gestationalWeeks = gestationalWeeks;
    }

    public String getSickenStasus() {
        return sickenStasus;
    }

    public void setSickenStasus(String sickenStasus) {
        this.sickenStasus = sickenStasus == null ? null : sickenStasus.trim();
    }

    public String getSickenOther() {
        return sickenOther;
    }

    public void setSickenOther(String sickenOther) {
        this.sickenOther = sickenOther == null ? null : sickenOther.trim();
    }

    public String getMidwifeOrg() {
        return midwifeOrg;
    }

    public void setMidwifeOrg(String midwifeOrg) {
        this.midwifeOrg = midwifeOrg == null ? null : midwifeOrg.trim();
    }

    public String getBirthSituation() {
        return birthSituation;
    }

    public void setBirthSituation(String birthSituation) {
        this.birthSituation = birthSituation == null ? null : birthSituation.trim();
    }

    public String getBirthOther() {
        return birthOther;
    }

    public void setBirthOther(String birthOther) {
        this.birthOther = birthOther == null ? null : birthOther.trim();
    }

    public String getAsphyxiaNeonatorum() {
        return asphyxiaNeonatorum;
    }

    public void setAsphyxiaNeonatorum(String asphyxiaNeonatorum) {
        this.asphyxiaNeonatorum = asphyxiaNeonatorum == null ? null : asphyxiaNeonatorum.trim();
    }

    public String getAsphyxiaTime() {
        return asphyxiaTime;
    }

    public void setAsphyxiaTime(String asphyxiaTime) {
        this.asphyxiaTime = asphyxiaTime == null ? null : asphyxiaTime.trim();
    }

    public String getDeformity() {
        return deformity;
    }

    public void setDeformity(String deformity) {
        this.deformity = deformity == null ? null : deformity.trim();
    }

    public String getDeformityOther() {
        return deformityOther;
    }

    public void setDeformityOther(String deformityOther) {
        this.deformityOther = deformityOther == null ? null : deformityOther.trim();
    }

    public String getHearing() {
        return hearing;
    }

    public void setHearing(String hearing) {
        this.hearing = hearing == null ? null : hearing.trim();
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease == null ? null : disease.trim();
    }

    public String getDiseaseOther() {
        return diseaseOther;
    }

    public void setDiseaseOther(String diseaseOther) {
        this.diseaseOther = diseaseOther == null ? null : diseaseOther.trim();
    }

    public String getBirthWeight() {
        return birthWeight;
    }

    public void setBirthWeight(String birthWeight) {
        this.birthWeight = birthWeight == null ? null : birthWeight.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getBirthHeight() {
        return birthHeight;
    }

    public void setBirthHeight(String birthHeight) {
        this.birthHeight = birthHeight == null ? null : birthHeight.trim();
    }

    public String getFeedingPatterns() {
        return feedingPatterns;
    }

    public void setFeedingPatterns(String feedingPatterns) {
        this.feedingPatterns = feedingPatterns == null ? null : feedingPatterns.trim();
    }

    public Integer getMilkNum() {
        return milkNum;
    }

    public void setMilkNum(Integer milkNum) {
        this.milkNum = milkNum;
    }

    public Integer getMilkIntake() {
        return milkIntake;
    }

    public void setMilkIntake(Integer milkIntake) {
        this.milkIntake = milkIntake;
    }

    public String getVomit() {
        return vomit;
    }

    public void setVomit(String vomit) {
        this.vomit = vomit == null ? null : vomit.trim();
    }

    public String getShit() {
        return shit;
    }

    public void setShit(String shit) {
        this.shit = shit == null ? null : shit.trim();
    }

    public Integer getDefecationNum() {
        return defecationNum;
    }

    public void setDefecationNum(Integer defecationNum) {
        this.defecationNum = defecationNum;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getBreathingRate() {
        return breathingRate;
    }

    public void setBreathingRate(Integer breathingRate) {
        this.breathingRate = breathingRate;
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

    public String getAurigo() {
        return aurigo;
    }

    public void setAurigo(String aurigo) {
        this.aurigo = aurigo == null ? null : aurigo.trim();
    }

    public String getAurigoOther() {
        return aurigoOther;
    }

    public void setAurigoOther(String aurigoOther) {
        this.aurigoOther = aurigoOther == null ? null : aurigoOther.trim();
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

    public String getAnteriorFontanelleOther() {
        return anteriorFontanelleOther;
    }

    public void setAnteriorFontanelleOther(String anteriorFontanelleOther) {
        this.anteriorFontanelleOther = anteriorFontanelleOther == null ? null : anteriorFontanelleOther.trim();
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye == null ? null : eye.trim();
    }

    public String getExtremityMobility() {
        return extremityMobility;
    }

    public void setExtremityMobility(String extremityMobility) {
        this.extremityMobility = extremityMobility == null ? null : extremityMobility.trim();
    }

    public String getEar() {
        return ear;
    }

    public void setEar(String ear) {
        this.ear = ear == null ? null : ear.trim();
    }

    public String getNeckMass() {
        return neckMass;
    }

    public void setNeckMass(String neckMass) {
        this.neckMass = neckMass == null ? null : neckMass.trim();
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose == null ? null : nose.trim();
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

    public String getOralCavity() {
        return oralCavity;
    }

    public void setOralCavity(String oralCavity) {
        this.oralCavity = oralCavity == null ? null : oralCavity.trim();
    }

    public String getAnus() {
        return anus;
    }

    public void setAnus(String anus) {
        this.anus = anus == null ? null : anus.trim();
    }

    public String getHeartLung() {
        return heartLung;
    }

    public void setHeartLung(String heartLung) {
        this.heartLung = heartLung == null ? null : heartLung.trim();
    }

    public String getBreast() {
        return breast;
    }

    public void setBreast(String breast) {
        this.breast = breast == null ? null : breast.trim();
    }

    public String getAbdominalTouch() {
        return abdominalTouch;
    }

    public void setAbdominalTouch(String abdominalTouch) {
        this.abdominalTouch = abdominalTouch == null ? null : abdominalTouch.trim();
    }

    public String getSpine() {
        return spine;
    }

    public void setSpine(String spine) {
        this.spine = spine == null ? null : spine.trim();
    }

    public String getAedea() {
        return aedea;
    }

    public void setAedea(String aedea) {
        this.aedea = aedea == null ? null : aedea.trim();
    }

    public String getUmbilicalCord() {
        return umbilicalCord;
    }

    public void setUmbilicalCord(String umbilicalCord) {
        this.umbilicalCord = umbilicalCord == null ? null : umbilicalCord.trim();
    }

    public String getUmbilicalCordOther() {
        return umbilicalCordOther;
    }

    public void setUmbilicalCordOther(String umbilicalCordOther) {
        this.umbilicalCordOther = umbilicalCordOther == null ? null : umbilicalCordOther.trim();
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

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate == null ? null : visitDate.trim();
    }

    public String getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(String nextVisitDate) {
        this.nextVisitDate = nextVisitDate == null ? null : nextVisitDate.trim();
    }

    public String getNextVisitAddress() {
        return nextVisitAddress;
    }

    public void setNextVisitAddress(String nextVisitAddress) {
        this.nextVisitAddress = nextVisitAddress == null ? null : nextVisitAddress.trim();
    }

    public String getVisitDoctor() {
        return visitDoctor;
    }

    public void setVisitDoctor(String visitDoctor) {
        this.visitDoctor = visitDoctor == null ? null : visitDoctor.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }

    public String getTownsCode() {
        return townsCode;
    }

    public void setTownsCode(String townsCode) {
        this.townsCode = townsCode == null ? null : townsCode.trim();
    }

    public String getTownsName() {
        return townsName;
    }

    public void setTownsName(String townsName) {
        this.townsName = townsName == null ? null : townsName.trim();
    }

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode == null ? null : villageCode.trim();
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName == null ? null : villageName.trim();
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