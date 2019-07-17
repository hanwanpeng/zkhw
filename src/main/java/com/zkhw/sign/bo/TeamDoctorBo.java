package com.zkhw.sign.bo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeamDoctorBo {

    private String id;

    private String teamNo;

    private String teamName;

    private String doctorNo;

    private String doctorName;

    private String position;

    private String createUser;

    private String createName;

    private Date createTime;

    private String updateUser;

    private String updateName;

    private Date updateTime;
    
    private String remark;
    
    private String specialty;
}
