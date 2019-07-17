package com.zkhw.pub.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TjBc {
    private String id;

    private String aichiveNo;

    private String idNumber;

    private String barCode;

    private String fububc;

    private String fuburesult;

    private String fubudesc;

    private String qitabc;

    private String qitaresult;

    private String qitadesc;

    private String bupic01;

    private String bupic02;

    private String bupic03;

    private String bupic04;

    @JSONField(format = "yyyy-MM-dd")
    private Date createtime;

    private Date updatetime;

    private String synchronizeType;

    private String zrysbc;

    private Integer uploadStatus;

    private String imageurlA;

    private String imageurlB;

    private String imageurlC;

    private String imageurlD;

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

    public String getFububc() {
        return fububc;
    }

    public void setFububc(String fububc) {
        this.fububc = fububc == null ? null : fububc.trim();
    }

    public String getFuburesult() {
        return fuburesult;
    }

    public void setFuburesult(String fuburesult) {
        this.fuburesult = fuburesult == null ? null : fuburesult.trim();
    }

    public String getFubudesc() {
        return fubudesc;
    }

    public void setFubudesc(String fubudesc) {
        this.fubudesc = fubudesc == null ? null : fubudesc.trim();
    }

    public String getQitabc() {
        return qitabc;
    }

    public void setQitabc(String qitabc) {
        this.qitabc = qitabc == null ? null : qitabc.trim();
    }

    public String getQitaresult() {
        return qitaresult;
    }

    public void setQitaresult(String qitaresult) {
        this.qitaresult = qitaresult == null ? null : qitaresult.trim();
    }

    public String getQitadesc() {
        return qitadesc;
    }

    public void setQitadesc(String qitadesc) {
        this.qitadesc = qitadesc == null ? null : qitadesc.trim();
    }

    public String getBupic01() {
        return bupic01;
    }

    public void setBupic01(String bupic01) {
        this.bupic01 = bupic01 == null ? null : bupic01.trim();
    }

    public String getBupic02() {
        return bupic02;
    }

    public void setBupic02(String bupic02) {
        this.bupic02 = bupic02 == null ? null : bupic02.trim();
    }

    public String getBupic03() {
        return bupic03;
    }

    public void setBupic03(String bupic03) {
        this.bupic03 = bupic03 == null ? null : bupic03.trim();
    }

    public String getBupic04() {
        return bupic04;
    }

    public void setBupic04(String bupic04) {
        this.bupic04 = bupic04 == null ? null : bupic04.trim();
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

    public String getZrysbc() {
        return zrysbc;
    }

    public void setZrysbc(String zrysbc) {
        this.zrysbc = zrysbc == null ? null : zrysbc.trim();
    }

    public Integer getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Integer uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public String getImageurlA() {
        return imageurlA;
    }

    public void setImageurlA(String imageurlA) {
        this.imageurlA = imageurlA == null ? null : imageurlA.trim();
    }

    public String getImageurlB() {
        return imageurlB;
    }

    public void setImageurlB(String imageurlB) {
        this.imageurlB = imageurlB == null ? null : imageurlB.trim();
    }

    public String getImageurlC() {
        return imageurlC;
    }

    public void setImageurlC(String imageurlC) {
        this.imageurlC = imageurlC == null ? null : imageurlC.trim();
    }

    public String getImageurlD() {
        return imageurlD;
    }

    public void setImageurlD(String imageurlD) {
        this.imageurlD = imageurlD == null ? null : imageurlD.trim();
    }
}