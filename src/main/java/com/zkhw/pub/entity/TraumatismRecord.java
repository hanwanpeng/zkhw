package com.zkhw.pub.entity;

import java.util.Date;

public class TraumatismRecord {
    private String id;

    private String archiveNo;

    private String idNumber;

    private String traumatismName;

    private String traumatismTime;

    private String createName;

    private Date createTime;

    private String updateName;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getTraumatismName() {
        return traumatismName;
    }

    public void setTraumatismName(String traumatismName) {
        this.traumatismName = traumatismName == null ? null : traumatismName.trim();
    }

    public String getTraumatismTime() {
        return traumatismTime;
    }

    public void setTraumatismTime(String traumatismTime) {
        this.traumatismTime = traumatismTime == null ? null : traumatismTime.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
}