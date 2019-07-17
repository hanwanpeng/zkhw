package com.zkhw.pub.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TjXdt {
    private String id;

    private String aichiveNo;

    private String idNumber;

    private String barCode;

    private String xdtresult;

    private String xdtdesc;

    private String xdtdoctor;

    private String xdtname;

    private String ventrate;

    private String pr;

    private String qrs;

    private String qt;

    private String qtc;

    private String pRT;

    private String dob;

    private String age;

    private String gen;

    private String dep;

    @JSONField(format = "yyyy-MM-dd")
    private Date createtime;

    private Date updatetime;

    private String synchronizeType;

    private String zrysxdt;

    private String imageurl;

    private Integer uploadStatus;

    private String hr;

    private String p;

    private String pqrs;

    private String t;

    private String rv5;

    private String sv1;

    private String baselineDrift;

    private String myoelectricity;

    private String frequency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAichiveNo() {
        return aichiveNo;
    }

    public void setAichiveNo(String aichiveNo) {
        this.aichiveNo = aichiveNo == null ? null : aichiveNo.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public String getXdtresult() {
        return xdtresult;
    }

    public void setXdtresult(String xdtresult) {
        this.xdtresult = xdtresult == null ? null : xdtresult.trim();
    }

    public String getXdtdesc() {
        return xdtdesc;
    }

    public void setXdtdesc(String xdtdesc) {
        this.xdtdesc = xdtdesc == null ? null : xdtdesc.trim();
    }

    public String getXdtdoctor() {
        return xdtdoctor;
    }

    public void setXdtdoctor(String xdtdoctor) {
        this.xdtdoctor = xdtdoctor == null ? null : xdtdoctor.trim();
    }

    public String getXdtname() {
        return xdtname;
    }

    public void setXdtname(String xdtname) {
        this.xdtname = xdtname == null ? null : xdtname.trim();
    }

    public String getVentrate() {
        return ventrate;
    }

    public void setVentrate(String ventrate) {
        this.ventrate = ventrate == null ? null : ventrate.trim();
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr == null ? null : pr.trim();
    }

    public String getQrs() {
        return qrs;
    }

    public void setQrs(String qrs) {
        this.qrs = qrs == null ? null : qrs.trim();
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt == null ? null : qt.trim();
    }

    public String getQtc() {
        return qtc;
    }

    public void setQtc(String qtc) {
        this.qtc = qtc == null ? null : qtc.trim();
    }

    public String getpRT() {
        return pRT;
    }

    public void setpRT(String pRT) {
        this.pRT = pRT == null ? null : pRT.trim();
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob == null ? null : dob.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen == null ? null : gen.trim();
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep == null ? null : dep.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getSynchronizeType() {
        return synchronizeType;
    }

    public void setSynchronizeType(String synchronizeType) {
        this.synchronizeType = synchronizeType == null ? null : synchronizeType.trim();
    }

    public String getZrysxdt() {
        return zrysxdt;
    }

    public void setZrysxdt(String zrysxdt) {
        this.zrysxdt = zrysxdt == null ? null : zrysxdt.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public Integer getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Integer uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr == null ? null : hr.trim();
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p == null ? null : p.trim();
    }

    public String getPqrs() {
        return pqrs;
    }

    public void setPqrs(String pqrs) {
        this.pqrs = pqrs == null ? null : pqrs.trim();
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t == null ? null : t.trim();
    }

    public String getRv5() {
        return rv5;
    }

    public void setRv5(String rv5) {
        this.rv5 = rv5 == null ? null : rv5.trim();
    }

    public String getSv1() {
        return sv1;
    }

    public void setSv1(String sv1) {
        this.sv1 = sv1 == null ? null : sv1.trim();
    }

    public String getBaselineDrift() {
        return baselineDrift;
    }

    public void setBaselineDrift(String baselineDrift) {
        this.baselineDrift = baselineDrift == null ? null : baselineDrift.trim();
    }

    public String getMyoelectricity() {
        return myoelectricity;
    }

    public void setMyoelectricity(String myoelectricity) {
        this.myoelectricity = myoelectricity == null ? null : myoelectricity.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }
}