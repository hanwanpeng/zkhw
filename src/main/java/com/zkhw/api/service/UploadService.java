package com.zkhw.api.service;

import com.zkhw.api.bo.ChildenFollowBo;
import com.zkhw.api.bo.DiabetesBo;
import com.zkhw.api.bo.ErrorInfo;
import com.zkhw.api.bo.Gravida42AfterBo;
import com.zkhw.api.bo.GravidaAfterBo;
import com.zkhw.api.bo.GravidaFirstBo;
import com.zkhw.api.bo.GravidaFollowBo;
import com.zkhw.api.bo.HypertensionBo;
import com.zkhw.api.bo.NeonatusBaseInfoBo;
import com.zkhw.api.bo.NeonatusFirstBo;
import com.zkhw.api.bo.PsychosisBo;
import com.zkhw.api.bo.PsychosisInfoBo;
import com.zkhw.api.bo.ResidentUpBo;
import com.zkhw.api.bo.TuberculosisBo;
import com.zkhw.api.bo.TuberculosisFollowBo;

public interface UploadService {

	ErrorInfo diabetesUpload(DiabetesBo bo);
	
	ErrorInfo psychosisFollow(PsychosisBo bo);
	
	ErrorInfo hypertensionUpload(HypertensionBo bo);
	
	ErrorInfo psychosisFirst(PsychosisInfoBo bo);
	
	ErrorInfo tuberculosisFirst(TuberculosisBo bo);
	
	ErrorInfo tuberculosisFollow(TuberculosisFollowBo bo);
	
	ErrorInfo gravidaFollow(GravidaFollowBo bo);
	
	ErrorInfo gravidaAfter(GravidaAfterBo bo);
	
	ErrorInfo gravida42After(Gravida42AfterBo bo);
	
	ErrorInfo gravidaFirst(GravidaFirstBo bo);
	
	ErrorInfo residentUp(ResidentUpBo bo);
	
	ErrorInfo neonatusBaseInfo(NeonatusBaseInfoBo bo);
	
	ErrorInfo neonatusFirst(NeonatusFirstBo bo);
	
	ErrorInfo childrenFollow(ChildenFollowBo bo);
}
