package com.zkhw.flup.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GravidaAfterRecord {
    private String id;

    private String gravidaId;

    private String name;

    private String archiveNo;

    private String idNumber;

    private String visitDate;

    private String childbirth;

    private String dischargeDate;

    private String temperature;

    private String generalHealthStatus;

    private String generalPsychologyStatus;

    private Integer bloodPressureHigh;

    private Integer bloodPressureLow;

    private String breast;

    private String breastError;

    private String lyma;

    private String lymaError;

    private String womb;

    private String wombError;

    private String wound;

    private String woundError;

    private String other;

    private String conditions;

    private String conditionError;

    private String guidance;

    private String guidanceOther;

    private String transferTreatment;

    private String transferTreatmentReason;

    private String transferTreatmentDepartment;

    private String nextVisitDate;

    private String visitDoctor;

    private String createUser;

    private String createName;

    private String createOrg;

    private String createOrgName;

    private Date createTime;

    private String updateUser;

    private String updateName;

    private Date updateTime;

    private Integer uploadStatus;

    private Date uploadTime;

    private String uploadResult;

    private String recordType;
}