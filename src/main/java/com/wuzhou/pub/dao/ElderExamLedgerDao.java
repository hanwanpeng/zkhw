package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.ElderExamLedger;

public interface ElderExamLedgerDao {
    int deleteByPrimaryKey(String elderExamLedgerId);

    int insert(ElderExamLedger record);

    int insertSelective(ElderExamLedger record);

    ElderExamLedger selectByPrimaryKey(String elderExamLedgerId);

    int updateByPrimaryKeySelective(ElderExamLedger record);

    int updateByPrimaryKey(ElderExamLedger record);
}