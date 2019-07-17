package com.zkhw.pub.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TjXy {
    private String id;

    private String aichiveNo;

    private String idNumber;

    private String barCode;

    private String dbp;

    private String sbp;

    private String pulse;
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

    public String getDbp() {
        return dbp;
    }

    public void setDbp(String dbp) {
        this.dbp = dbp == null ? null : dbp.trim();
    }

    public String getSbp() {
        return sbp;
    }

    public void setSbp(String sbp) {
        this.sbp = sbp == null ? null : sbp.trim();
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse == null ? null : pulse.trim();
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