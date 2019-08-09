package com.wuzhou.pub.entity;

import java.util.Date;

public class ElderTcmHealth {
	//老年人中医药健康表ID
    private String elderTcmHealthId;

    //个人档案ID
    private String personInfoId;

    //编号
    private String elderTcmHealthNo;

    //姓名
    private String name;

    //(1)您精力充沛吗？（指精神头足，乐于做事）
    private String energy;

    //2)您容易疲乏吗？（指体力如何，是否稍微活动一下或做一点家务劳动就感到累）
    private String fatigue;

    //(3)您容易气短，呼吸短促，接不上气吗？
    private String breathe;

    //(4)您说话声音低弱无力吗?（指说话没有力气）
    private String speak;

    //(5)您感到闷闷不乐、情绪低沉吗?（指心情不愉快，情绪低落）
    private String unpleasant;
    
    //(6)您容易精神紧张、焦虑不安吗?（指遇事是否心情紧张）
    private String nervous;

    //(7)您因为生活状态改变而感到孤独、失落吗？
    private String solitary;

    //(8)您容易感到害怕或受到惊吓吗?
    private String scare;

    //(9)您感到身体超重不轻松吗?(感觉身体沉重) [BMI指数=体重（kg）/身高2（m）]
    private String weight;

    //(10)您眼睛干涩吗?
    private String eye;

    //(11)您手脚发凉吗?（不包含因周围温度低或穿的少导致的手脚发冷）
    private String hand;

    //(12)您胃脘部、背部或腰膝部怕冷吗？（指上腹部、背部、腰部或膝关节等，有一处或多处怕冷）
    private String craw;

    //(13)您比一般人耐受不了寒冷吗？（指比别人容易害怕冬天或是夏天的冷空调、电扇等
    private String cold;

    //(14)您容易患感冒吗?（指每年感冒的次数）
    private String catchacold;

    //(15)您没有感冒时也会鼻塞、流鼻涕吗?
    private String runathenose;

    //(16)您有口粘口腻，或睡眠打鼾吗？
    private String mouth;

    //(17)您容易过敏(对药物、食物、气味、花粉或在季节交替、气候变化时)吗?
    private String food;

    //(18)您的皮肤容易起荨麻疹吗? (包括风团、风疹块、风疙瘩)
    private String derma;

    //(19)您的皮肤在不知不觉中会出现青紫瘀斑、皮下出血吗?（指皮肤在没有外伤的情况下出现青一块紫一块的情况）
    private String bleeding;

    //(20)您的皮肤一抓就红，并出现抓痕吗?（指被指甲或钝物划过后皮肤的反应）
    private String fingermail;

    //(21)您皮肤或口唇干吗?
    private String oraldry;

    //(22)您有肢体麻木或固定部位疼痛的感觉吗？
    private String ache;

    //(23)您面部或鼻部有油腻感或者油亮发光吗?（指脸上或鼻子）
    private String face;

    //(24)您面色或目眶晦黯，或出现褐色斑块/斑点吗?
    private String spot;

    //(25)您有皮肤湿疹、疮疖吗？
    private String sore;

    //(26)您感到口干咽燥、总想喝水吗？
    private String drinking;

    //(27)您感到口苦或嘴里有异味吗?（指口苦或口臭）
    private String bittertaste;

    //(28)您腹部肥大吗?（指腹部脂肪肥厚）
    private String abdomen;

    //(29)您吃(喝)凉的东西会感到不舒服或者怕吃(喝)凉的东西吗？（指不喜欢吃凉的食物，或吃了凉的食物后会不舒服）
    private String uncomfortable;

    //(30)您有大便黏滞不爽、解不尽的感觉吗?(大便容易粘在马桶或便坑壁上)
    private String unwell;

    //(31)您容易大便干燥吗?
    private String malaise;

    //(32)您舌苔厚腻或有舌苔厚厚的感觉吗?（如果自我感觉不清楚可由调查员观察后填写）
    private String tongue;

    //(33)您舌下静脉瘀紫或增粗吗？（可由调查员辅助观察后填写
    private String vein;

    //气虚质得分
    private Short qiDeficiencyScore;

    //气虚质代码
    private String qiDeficiencyCode;

    //阳虚质得分
    private Short yangDeficiencyScore;

    //阳虚质代码
    private String yangDeficiencyCode;

    //阴虚质得分
    private Short yinDeficiencyScore;

    //阴虚质代码
    private String yinDeficiencyCode;

    //痰湿质得分
    private Short phlegmWetScore;

    //痰湿质代码
    private String phlegmWetCode;

    //湿热质得分
    private Short dampHeatScore;

    //湿热质代码
    private String dampHeatCode;

    //血瘀质得分
    private Short bloodStasisScore;

    //血瘀质代码
    private String bloodStasisCode;

    //气郁质得分
    private Short qiDepressionScore;

    //气郁质代码
    private String qiDepressionCode;

    //特禀质得分
    private Short specialDiathsisScore;

    //特禀质代码
    private String specialDiathsisCode;

    //平和质得分
    private Short gentleQualityScore;

    //平和质代码
    private String gentleQualityCode;

    //签名医师ID
    private String doctorId;

    //签名医生姓名
    private String doctorName;

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

    //传入“5”
    private Short isAppCreate;

    private Short errCode;

    private String errStr;

    public String getElderTcmHealthId() {
        return elderTcmHealthId;
    }

    public void setElderTcmHealthId(String elderTcmHealthId) {
        this.elderTcmHealthId = elderTcmHealthId == null ? null : elderTcmHealthId.trim();
    }

    public String getPersonInfoId() {
        return personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId == null ? null : personInfoId.trim();
    }

    public String getElderTcmHealthNo() {
        return elderTcmHealthNo;
    }

    public void setElderTcmHealthNo(String elderTcmHealthNo) {
        this.elderTcmHealthNo = elderTcmHealthNo == null ? null : elderTcmHealthNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy == null ? null : energy.trim();
    }

    public String getFatigue() {
        return fatigue;
    }

    public void setFatigue(String fatigue) {
        this.fatigue = fatigue == null ? null : fatigue.trim();
    }

    public String getBreathe() {
        return breathe;
    }

    public void setBreathe(String breathe) {
        this.breathe = breathe == null ? null : breathe.trim();
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak == null ? null : speak.trim();
    }

    public String getUnpleasant() {
        return unpleasant;
    }

    public void setUnpleasant(String unpleasant) {
        this.unpleasant = unpleasant == null ? null : unpleasant.trim();
    }

    public String getNervous() {
        return nervous;
    }

    public void setNervous(String nervous) {
        this.nervous = nervous == null ? null : nervous.trim();
    }

    public String getSolitary() {
        return solitary;
    }

    public void setSolitary(String solitary) {
        this.solitary = solitary == null ? null : solitary.trim();
    }

    public String getScare() {
        return scare;
    }

    public void setScare(String scare) {
        this.scare = scare == null ? null : scare.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye == null ? null : eye.trim();
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand == null ? null : hand.trim();
    }

    public String getCraw() {
        return craw;
    }

    public void setCraw(String craw) {
        this.craw = craw == null ? null : craw.trim();
    }

    public String getCold() {
        return cold;
    }

    public void setCold(String cold) {
        this.cold = cold == null ? null : cold.trim();
    }

    public String getCatchacold() {
        return catchacold;
    }

    public void setCatchacold(String catchacold) {
        this.catchacold = catchacold == null ? null : catchacold.trim();
    }

    public String getRunathenose() {
        return runathenose;
    }

    public void setRunathenose(String runathenose) {
        this.runathenose = runathenose == null ? null : runathenose.trim();
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth == null ? null : mouth.trim();
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food == null ? null : food.trim();
    }

    public String getDerma() {
        return derma;
    }

    public void setDerma(String derma) {
        this.derma = derma == null ? null : derma.trim();
    }

    public String getBleeding() {
        return bleeding;
    }

    public void setBleeding(String bleeding) {
        this.bleeding = bleeding == null ? null : bleeding.trim();
    }

    public String getFingermail() {
        return fingermail;
    }

    public void setFingermail(String fingermail) {
        this.fingermail = fingermail == null ? null : fingermail.trim();
    }

    public String getOraldry() {
        return oraldry;
    }

    public void setOraldry(String oraldry) {
        this.oraldry = oraldry == null ? null : oraldry.trim();
    }

    public String getAche() {
        return ache;
    }

    public void setAche(String ache) {
        this.ache = ache == null ? null : ache.trim();
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face == null ? null : face.trim();
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot == null ? null : spot.trim();
    }

    public String getSore() {
        return sore;
    }

    public void setSore(String sore) {
        this.sore = sore == null ? null : sore.trim();
    }

    public String getDrinking() {
        return drinking;
    }

    public void setDrinking(String drinking) {
        this.drinking = drinking == null ? null : drinking.trim();
    }

    public String getBittertaste() {
        return bittertaste;
    }

    public void setBittertaste(String bittertaste) {
        this.bittertaste = bittertaste == null ? null : bittertaste.trim();
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen == null ? null : abdomen.trim();
    }

    public String getUncomfortable() {
        return uncomfortable;
    }

    public void setUncomfortable(String uncomfortable) {
        this.uncomfortable = uncomfortable == null ? null : uncomfortable.trim();
    }

    public String getUnwell() {
        return unwell;
    }

    public void setUnwell(String unwell) {
        this.unwell = unwell == null ? null : unwell.trim();
    }

    public String getMalaise() {
        return malaise;
    }

    public void setMalaise(String malaise) {
        this.malaise = malaise == null ? null : malaise.trim();
    }

    public String getTongue() {
        return tongue;
    }

    public void setTongue(String tongue) {
        this.tongue = tongue == null ? null : tongue.trim();
    }

    public String getVein() {
        return vein;
    }

    public void setVein(String vein) {
        this.vein = vein == null ? null : vein.trim();
    }

    public Short getQiDeficiencyScore() {
        return qiDeficiencyScore;
    }

    public void setQiDeficiencyScore(Short qiDeficiencyScore) {
        this.qiDeficiencyScore = qiDeficiencyScore;
    }

    public String getQiDeficiencyCode() {
        return qiDeficiencyCode;
    }

    public void setQiDeficiencyCode(String qiDeficiencyCode) {
        this.qiDeficiencyCode = qiDeficiencyCode == null ? null : qiDeficiencyCode.trim();
    }

    public Short getYangDeficiencyScore() {
        return yangDeficiencyScore;
    }

    public void setYangDeficiencyScore(Short yangDeficiencyScore) {
        this.yangDeficiencyScore = yangDeficiencyScore;
    }

    public String getYangDeficiencyCode() {
        return yangDeficiencyCode;
    }

    public void setYangDeficiencyCode(String yangDeficiencyCode) {
        this.yangDeficiencyCode = yangDeficiencyCode == null ? null : yangDeficiencyCode.trim();
    }

    public Short getYinDeficiencyScore() {
        return yinDeficiencyScore;
    }

    public void setYinDeficiencyScore(Short yinDeficiencyScore) {
        this.yinDeficiencyScore = yinDeficiencyScore;
    }

    public String getYinDeficiencyCode() {
        return yinDeficiencyCode;
    }

    public void setYinDeficiencyCode(String yinDeficiencyCode) {
        this.yinDeficiencyCode = yinDeficiencyCode == null ? null : yinDeficiencyCode.trim();
    }

    public Short getPhlegmWetScore() {
        return phlegmWetScore;
    }

    public void setPhlegmWetScore(Short phlegmWetScore) {
        this.phlegmWetScore = phlegmWetScore;
    }

    public String getPhlegmWetCode() {
        return phlegmWetCode;
    }

    public void setPhlegmWetCode(String phlegmWetCode) {
        this.phlegmWetCode = phlegmWetCode == null ? null : phlegmWetCode.trim();
    }

    public Short getDampHeatScore() {
        return dampHeatScore;
    }

    public void setDampHeatScore(Short dampHeatScore) {
        this.dampHeatScore = dampHeatScore;
    }

    public String getDampHeatCode() {
        return dampHeatCode;
    }

    public void setDampHeatCode(String dampHeatCode) {
        this.dampHeatCode = dampHeatCode == null ? null : dampHeatCode.trim();
    }

    public Short getBloodStasisScore() {
        return bloodStasisScore;
    }

    public void setBloodStasisScore(Short bloodStasisScore) {
        this.bloodStasisScore = bloodStasisScore;
    }

    public String getBloodStasisCode() {
        return bloodStasisCode;
    }

    public void setBloodStasisCode(String bloodStasisCode) {
        this.bloodStasisCode = bloodStasisCode == null ? null : bloodStasisCode.trim();
    }

    public Short getQiDepressionScore() {
        return qiDepressionScore;
    }

    public void setQiDepressionScore(Short qiDepressionScore) {
        this.qiDepressionScore = qiDepressionScore;
    }

    public String getQiDepressionCode() {
        return qiDepressionCode;
    }

    public void setQiDepressionCode(String qiDepressionCode) {
        this.qiDepressionCode = qiDepressionCode == null ? null : qiDepressionCode.trim();
    }

    public Short getSpecialDiathsisScore() {
        return specialDiathsisScore;
    }

    public void setSpecialDiathsisScore(Short specialDiathsisScore) {
        this.specialDiathsisScore = specialDiathsisScore;
    }

    public String getSpecialDiathsisCode() {
        return specialDiathsisCode;
    }

    public void setSpecialDiathsisCode(String specialDiathsisCode) {
        this.specialDiathsisCode = specialDiathsisCode == null ? null : specialDiathsisCode.trim();
    }

    public Short getGentleQualityScore() {
        return gentleQualityScore;
    }

    public void setGentleQualityScore(Short gentleQualityScore) {
        this.gentleQualityScore = gentleQualityScore;
    }

    public String getGentleQualityCode() {
        return gentleQualityCode;
    }

    public void setGentleQualityCode(String gentleQualityCode) {
        this.gentleQualityCode = gentleQualityCode == null ? null : gentleQualityCode.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
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

    public Short getIsAppCreate() {
        return isAppCreate;
    }

    public void setIsAppCreate(Short isAppCreate) {
        this.isAppCreate = isAppCreate;
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