package com.zkhw.api.service;

import java.util.List;

import com.zkhw.api.bo.OrgInfo;

public interface OrgService {

	List<OrgInfo> getOrgList(String startIndex,String returnSize,String duns);
}
