package com.zkhw.sys.entity;

import java.util.Date;

public class ThresholdValue {
    private String id;

    private String classType;

    private String type;

    private Float warningMin;

    private Float warningMax;

    private Float thresholdMin;

    private Float thresholdMax;

    private String createUser;

    private String createName;

    private Date createTime;

    private String updateUser;

    private String updateName;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType == null ? null : classType.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Float getWarningMin() {
        return warningMin;
    }

    public void setWarningMin(Float warningMin) {
        this.warningMin = warningMin;
    }

    public Float getWarningMax() {
        return warningMax;
    }

    public void setWarningMax(Float warningMax) {
        this.warningMax = warningMax;
    }

    public Float getThresholdMin() {
        return thresholdMin;
    }

    public void setThresholdMin(Float thresholdMin) {
        this.thresholdMin = thresholdMin;
    }

    public Float getThresholdMax() {
        return thresholdMax;
    }

    public void setThresholdMax(Float thresholdMax) {
        this.thresholdMax = thresholdMax;
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
}