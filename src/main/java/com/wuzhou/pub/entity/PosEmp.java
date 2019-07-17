package com.wuzhou.pub.entity;

public class PosEmp {
    private String empId;

    private String posId;

    private String empName;

    private String empRin;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId == null ? null : posId.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpRin() {
        return empRin;
    }

    public void setEmpRin(String empRin) {
        this.empRin = empRin == null ? null : empRin.trim();
    }
}