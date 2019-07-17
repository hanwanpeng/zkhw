package com.wuzhou.pub.dao;

import com.wuzhou.pub.entity.ElderSelfcareAbility;

public interface ElderSelfcareAbilityDao {
    int deleteByPrimaryKey(String elderSelfcareAbilityId);

    int insert(ElderSelfcareAbility record);

    int insertSelective(ElderSelfcareAbility record);

    ElderSelfcareAbility selectByPrimaryKey(String elderSelfcareAbilityId);

    int updateByPrimaryKeySelective(ElderSelfcareAbility record);

    int updateByPrimaryKey(ElderSelfcareAbility record);
}