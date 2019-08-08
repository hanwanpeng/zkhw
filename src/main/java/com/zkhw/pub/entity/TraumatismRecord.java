package com.zkhw.pub.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//外伤附属表
public class TraumatismRecord implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 电子档案编码
     */
    private String archiveNo;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 外伤名称
     */
    private String traumatismName;

    /**
     * 外伤时间
     */
    private String traumatismTime;

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
     * 修改人时间
     */
    private Date updateTime;

    /**
     * traumatism_record
     */
    private static final long serialVersionUID = 1L;

}