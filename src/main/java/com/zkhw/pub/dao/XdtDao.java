package com.zkhw.pub.dao;

import com.zkhw.pub.entity.Xdt;

public interface XdtDao {
    int deleteByPrimaryKey(String id);

    int insert(Xdt record);

    int insertSelective(Xdt record);

    Xdt selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Xdt record);

    int updateByPrimaryKeyWithBLOBs(Xdt record);

    int updateByPrimaryKey(Xdt record);
}