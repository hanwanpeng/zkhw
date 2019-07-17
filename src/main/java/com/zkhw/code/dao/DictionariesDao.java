package com.zkhw.code.dao;

import java.util.List;

import com.zkhw.code.entity.Dictionaries;

public interface DictionariesDao {
    int deleteByPrimaryKey(Integer mtId);

    int insert(Dictionaries record);

    int insertSelective(Dictionaries record);

    Dictionaries selectByPrimaryKey(Integer mtId);

    int updateByPrimaryKeySelective(Dictionaries record);

    int updateByPrimaryKey(Dictionaries record);
    
    List<Dictionaries> findAll();
}