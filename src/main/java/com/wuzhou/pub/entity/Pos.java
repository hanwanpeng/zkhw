package com.wuzhou.pub.entity;

public class Pos {
	//id
    private String posId;

    //机构名称
    private String posName;

    //组织机构代码
    private String posCode;

    //上级机构id
    private String posPid;

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId == null ? null : posId.trim();
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName == null ? null : posName.trim();
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode == null ? null : posCode.trim();
    }

    public String getPosPid() {
        return posPid;
    }

    public void setPosPid(String posPid) {
        this.posPid = posPid == null ? null : posPid.trim();
    }
}