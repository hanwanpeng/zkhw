package com.zkhw.shanxi.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HospitalizedVo {

    private String id;

    private String examId;

    private String archiveNo;

    private String idNumber;

    private String serviceName;

    private Integer hospitalizedType;

    private String inHospitalTime;

    private String leaveHospitalTime;

    private String reason;

    private String hospitalOrgan;

    private String caseCode;

    private String remark;

    private String createOrg;
}
