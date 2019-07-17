package com.zkhw.pub.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationRecord {
    private String id;

    private String archiveNo;

    private String idNumber;

    private String operationName;

    private String operationTime;

    private String createName;

    private Date createTime;

    private String updateName;

    private Date updateTime;

    
}