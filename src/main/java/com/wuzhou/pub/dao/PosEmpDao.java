package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.PosEmp;

public interface PosEmpDao {
    int deleteByPrimaryKey(String empId);

    int insert(PosEmp record);

    int insertSelective(PosEmp record);

    PosEmp selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(PosEmp record);

    int updateByPrimaryKey(PosEmp record);
}