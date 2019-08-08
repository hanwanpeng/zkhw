package com.zkhw.pub.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//手术表
public class OperationRecord implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 电子档案唯一编码
     */
    private String archiveNo;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 手术名称
     */
    private String operationName;

    /**
     * 手术时间
     */
    private String operationTime;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateName;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * operation_record
     */
    private static final long serialVersionUID = 1L;

}