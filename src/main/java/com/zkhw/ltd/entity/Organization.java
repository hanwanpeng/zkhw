package com.zkhw.ltd.entity;

import java.util.Date;

public class Organization {
    private String id;

    private String pubOrgcode;

    private String organCode;

    private String organName;

    private String organShortName;

    private String organLevel;

    private String organParentCode;

    private String createUserCode;

    private Date createTime;

    private String updateUserCode;

    private Date updateTime;

    private Integer isDelete;

    private String remark;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String countyCode;

    private String countyName;

    private String townsCode;

    private String townsName;

    private String villageCode;

    private String villageName;

    private String address;

    private String lng;

    private String lat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPubOrgcode() {
        return pubOrgcode;
    }

    public void setPubOrgcode(String pubOrgcode) {
        this.pubOrgcode = pubOrgcode == null ? null : pubOrgcode.trim();
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode == null ? null : organCode.trim();
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName == null ? null : organName.trim();
    }

    public String getOrganShortName() {
        return organShortName;
    }

    public void setOrganShortName(String organShortName) {
        this.organShortName = organShortName == null ? null : organShortName.trim();
    }

    public String getOrganLevel() {
        return organLevel;
    }

    public void setOrganLevel(String organLevel) {
        this.organLevel = organLevel == null ? null : organLevel.trim();
    }

    public String getOrganParentCode() {
        return organParentCode;
    }

    public void setOrganParentCode(String organParentCode) {
        this.organParentCode = organParentCode == null ? null : organParentCode.trim();
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode == null ? null : createUserCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode == null ? null : updateUserCode.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }

    public String getTownsCode() {
        return townsCode;
    }

    public void setTownsCode(String townsCode) {
        this.townsCode = townsCode == null ? null : townsCode.trim();
    }

    public String getTownsName() {
        return townsName;
    }

    public void setTownsName(String townsName) {
        this.townsName = townsName == null ? null : townsName.trim();
    }

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode == null ? null : villageCode.trim();
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName == null ? null : villageName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }
}