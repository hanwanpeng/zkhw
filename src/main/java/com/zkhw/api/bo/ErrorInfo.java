package com.zkhw.api.bo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorInfo {

	@JSONField(name = "Archive")
	private List<Error> Archive;
	
	@JSONField(name = "OperationHistory")
	private List<Error> OperationHistory;
	
	@JSONField(name = "FamilyHistory")
	private List<Error> FamilyHistory;
	
	@JSONField(name = "HypertensionFollowUpLog")
	private List<FollowResult> HypertensionFollowUpLog;
	
	@JSONField(name = "TakeMedicineRecord")
	private List<Error> TakeMedicineRecord;
	
	@JSONField(name = "ChildrenBasicInfo")
	private List<Error> ChildrenBasicInfo;
	
	@JSONField(name = "ChildrenFamilyVisit")
	private List<Error> ChildrenFamilyVisit;
	
	@JSONField(name = "ChildrenHealthCheck")
	private List<Error> ChildrenHealthCheck;
	
	@JSONField(name = "ChanQian1")
	private List<Error> ChanQian1;
	
	@JSONField(name = "ChanQian2_5")
	private List<Error> ChanQian2_5;
	
	@JSONField(name = "ChanHouVisit")
	private List<Error> ChanHouVisit;
	
	@JSONField(name = "ChanHou42day")
	private List<Error> ChanHou42day;
	
	@JSONField(name = "ElderlyHealthManage")
	private List<FollowResult> ElderlyHealthManage;
	
	@JSONField(name = "TangNiaoBingVisit")
	private List<FollowResult> TangNiaoBingVisit;
	
	@JSONField(name = "JingShenBingInfo")
	private List<Error> JingShenBingInfo;
	
	@JSONField(name = "JingShenBingVisit")
	private List<FollowResult> JingShenBingVisit;
	
	@JSONField(name = "FamilyInfo")
	private List<Error> FamilyInfo;
	
	@JSONField(name = "FamilyMembers")
	private List<Error> FamilyMembers;
	
	@JSONField(name = "FeiJieHeVisit1")
	private List<Error> FeiJieHeVisit1;
	
	@JSONField(name = "FeiJieHeVisit")
	private List<Error> FeiJieHeVisit;
	
	@JSONField(name = "FeimianyiHis")
	private List<Error> FeimianyiHis;
}
