package com.zkhw.pub.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TjSgtz {
    private String id;

    private String aichiveNo;

    private String idNumber;

    private String barCode;

    private String bmi;

    private String height;

    private String weight;
    @JSONField(format = "yyyy-MM-dd")
    private Date createtime;

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

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi == null ? null : bmi.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Integer uploadStatus) {
        this.uploadStatus = uploadStatus;
    }
}