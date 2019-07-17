package com.zkhw.sign.dao;

import java.util.List;

import com.zkhw.sign.entity.DoctorInfo;

public interface DoctorInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(DoctorInfo record);

    int insertSelective(DoctorInfo record);

    DoctorInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DoctorInfo record);

    int updateByPrimaryKey(DoctorInfo record);
    
    int deleteByUserCode(String userCode);
    
    List<DoctorInfo> findDoctorListByOrg(String orgCode);
    
    int updateByDoctorNo(DoctorInfo record);
    
    DoctorInfo getDoctorByUser(String userCode);
}