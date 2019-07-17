package com.zkhw.sign.entity;

import java.util.Date;

public class SignServiceItem {
    private String id;

    private String signServiceId;

    private String serviceItemNo;

    private String serviceItemName;

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

    public String getSignServiceId() {
        return signServiceId;
    }

    public void setSignServiceId(String signServiceId) {
        this.signServiceId = signServiceId == null ? null : signServiceId.trim();
    }

    public String getServiceItemNo() {
        return serviceItemNo;
    }

    public void setServiceItemNo(String serviceItemNo) {
        this.serviceItemNo = serviceItemNo == null ? null : serviceItemNo.trim();
    }

    public String getServiceItemName() {
        return serviceItemName;
    }

    public void setServiceItemName(String serviceItemName) {
        this.serviceItemName = serviceItemName == null ? null : serviceItemName.trim();
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