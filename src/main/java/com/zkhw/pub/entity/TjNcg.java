package com.zkhw.pub.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TjNcg {
    private String id;

    private String aichiveNo;

    private String idNumber;

    private String barCode;

    private String wbc;

    private String leu;

    private String nit;

    private String uro;

    private String pro;

    private String ph;

    private String bld;

    private String sg;

    private String ket;

    private String bil;

    private String glu;

    private String vc;

    private String ma;

    private String acr;

    private String ca;

    private String cr;

    private String type;

    @JSONField(format = "yyyy-MM-dd")
    private Date createtime;

    private Date updatetime;

    private String synchronizeType;

    private String zrysncg;

    private Integer uploadStatus;

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

    public String getWbc() {
        return wbc;
    }

    public void setWbc(String wbc) {
        this.wbc = wbc == null ? null : wbc.trim();
    }

    public String getLeu() {
        return leu;
    }

    public void setLeu(String leu) {
        this.leu = leu == null ? null : leu.trim();
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit == null ? null : nit.trim();
    }

    public String getUro() {
        return uro;
    }

    public void setUro(String uro) {
        this.uro = uro == null ? null : uro.trim();
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro == null ? null : pro.trim();
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph == null ? null : ph.trim();
    }

    public String getBld() {
        return bld;
    }

    public void setBld(String bld) {
        this.bld = bld == null ? null : bld.trim();
    }

    public String getSg() {
        return sg;
    }

    public void setSg(String sg) {
        this.sg = sg == null ? null : sg.trim();
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket == null ? null : ket.trim();
    }

    public String getBil() {
        return bil;
    }

    public void setBil(String bil) {
        this.bil = bil == null ? null : bil.trim();
    }

    public String getGlu() {
        return glu;
    }

    public void setGlu(String glu) {
        this.glu = glu == null ? null : glu.trim();
    }

    public String getVc() {
        return vc;
    }

    public void setVc(String vc) {
        this.vc = vc == null ? null : vc.trim();
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma == null ? null : ma.trim();
    }

    public String getAcr() {
        return acr;
    }

    public void setAcr(String acr) {
        this.acr = acr == null ? null : acr.trim();
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca == null ? null : ca.trim();
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr == null ? null : cr.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getZrysncg() {
        return zrysncg;
    }

    public void setZrysncg(String zrysncg) {
        this.zrysncg = zrysncg == null ? null : zrysncg.trim();
    }

    public Integer getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Integer uploadStatus) {
        this.uploadStatus = uploadStatus;
    }
}