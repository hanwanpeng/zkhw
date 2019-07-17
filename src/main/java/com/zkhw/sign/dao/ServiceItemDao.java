package com.zkhw.sign.dao;

import java.util.List;

import com.zkhw.sign.entity.ServiceItem;

public interface ServiceItemDao {
    int deleteByPrimaryKey(String id);

    int insert(ServiceItem record);

    int insertSelective(ServiceItem record);

    ServiceItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceItem record);

    int updateByPrimaryKey(ServiceItem record);
    
    List<ServiceItem> findAll();
}