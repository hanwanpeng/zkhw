package com.zkhw.pub.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TjXcg {
    private String id;

    private String aichiveNo;

    private String idNumber;

    private String barCode;

    private String wbc;

    private String rbc;

    private String pct;

    private String plt;

    private String hgb;

    private String hct;

    private String mcv;

    private String mch;

    private String mchc;

    private String rdwcv;

    private String rdwsd;

    private String mono;

    private String monop;

    private String gran;

    private String granp;

    private String neut;

    private String neutp;

    private String eo;

    private String eop;

    private String baso;

    private String basop;

    private String lym;

    private String lymp;

    private String mpv;

    private String pdw;

    private String mxd;

    private String mxdp;

    private String plcr;

    private String others;
    @JSONField(format = "yyyy-MM-dd")
    private Date createtime;

    private Date updatetime;

    private String synchronizeType;

    private String zrysxcg;

    private String timecodeunique;

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

    public String getRbc() {
        return rbc;
    }

    public void setRbc(String rbc) {
        this.rbc = rbc == null ? null : rbc.trim();
    }

    public String getPct() {
        return pct;
    }

    public void setPct(String pct) {
        this.pct = pct == null ? null : pct.trim();
    }

    public String getPlt() {
        return plt;
    }

    public void setPlt(String plt) {
        this.plt = plt == null ? null : plt.trim();
    }

    public String getHgb() {
        return hgb;
    }

    public void setHgb(String hgb) {
        this.hgb = hgb == null ? null : hgb.trim();
    }

    public String getHct() {
        return hct;
    }

    public void setHct(String hct) {
        this.hct = hct == null ? null : hct.trim();
    }

    public String getMcv() {
        return mcv;
    }

    public void setMcv(String mcv) {
        this.mcv = mcv == null ? null : mcv.trim();
    }

    public String getMch() {
        return mch;
    }

    public void setMch(String mch) {
        this.mch = mch == null ? null : mch.trim();
    }

    public String getMchc() {
        return mchc;
    }

    public void setMchc(String mchc) {
        this.mchc = mchc == null ? null : mchc.trim();
    }

    public String getRdwcv() {
        return rdwcv;
    }

    public void setRdwcv(String rdwcv) {
        this.rdwcv = rdwcv == null ? null : rdwcv.trim();
    }

    public String getRdwsd() {
        return rdwsd;
    }

    public void setRdwsd(String rdwsd) {
        this.rdwsd = rdwsd == null ? null : rdwsd.trim();
    }

    public String getMono() {
        return mono;
    }

    public void setMono(String mono) {
        this.mono = mono == null ? null : mono.trim();
    }

    public String getMonop() {
        return monop;
    }

    public void setMonop(String monop) {
        this.monop = monop == null ? null : monop.trim();
    }

    public String getGran() {
        return gran;
    }

    public void setGran(String gran) {
        this.gran = gran == null ? null : gran.trim();
    }

    public String getGranp() {
        return granp;
    }

    public void setGranp(String granp) {
        this.granp = granp == null ? null : granp.trim();
    }

    public String getNeut() {
        return neut;
    }

    public void setNeut(String neut) {
        this.neut = neut == null ? null : neut.trim();
    }

    public String getNeutp() {
        return neutp;
    }

    public void setNeutp(String neutp) {
        this.neutp = neutp == null ? null : neutp.trim();
    }

    public String getEo() {
        return eo;
    }

    public void setEo(String eo) {
        this.eo = eo == null ? null : eo.trim();
    }

    public String getEop() {
        return eop;
    }

    public void setEop(String eop) {
        this.eop = eop == null ? null : eop.trim();
    }

    public String getBaso() {
        return baso;
    }

    public void setBaso(String baso) {
        this.baso = baso == null ? null : baso.trim();
    }

    public String getBasop() {
        return basop;
    }

    public void setBasop(String basop) {
        this.basop = basop == null ? null : basop.trim();
    }

    public String getLym() {
        return lym;
    }

    public void setLym(String lym) {
        this.lym = lym == null ? null : lym.trim();
    }

    public String getLymp() {
        return lymp;
    }

    public void setLymp(String lymp) {
        this.lymp = lymp == null ? null : lymp.trim();
    }

    public String getMpv() {
        return mpv;
    }

    public void setMpv(String mpv) {
        this.mpv = mpv == null ? null : mpv.trim();
    }

    public String getPdw() {
        return pdw;
    }

    public void setPdw(String pdw) {
        this.pdw = pdw == null ? null : pdw.trim();
    }

    public String getMxd() {
        return mxd;
    }

    public void setMxd(String mxd) {
        this.mxd = mxd == null ? null : mxd.trim();
    }

    public String getMxdp() {
        return mxdp;
    }

    public void setMxdp(String mxdp) {
        this.mxdp = mxdp == null ? null : mxdp.trim();
    }

    public String getPlcr() {
        return plcr;
    }

    public void setPlcr(String plcr) {
        this.plcr = plcr == null ? null : plcr.trim();
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
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

    public String getZrysxcg() {
        return zrysxcg;
    }

    public void setZrysxcg(String zrysxcg) {
        this.zrysxcg = zrysxcg == null ? null : zrysxcg.trim();
    }

    public String getTimecodeunique() {
        return timecodeunique;
    }

    public void setTimecodeunique(String timecodeunique) {
        this.timecodeunique = timecodeunique == null ? null : timecodeunique.trim();
    }

    public Integer getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Integer uploadStatus) {
        this.uploadStatus = uploadStatus;
    }
}