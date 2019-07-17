package com.wuzhou.pub.entity;

public class Pos {
    private String posId;

    private String posName;

    private String posCode;

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