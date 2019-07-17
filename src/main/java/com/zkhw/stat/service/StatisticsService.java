package com.zkhw.stat.service;

import com.zkhw.stat.query.ResidentQuery;
import com.zkhw.stat.vo.ChildVo;
import com.zkhw.stat.vo.ElderlyVo;
import com.zkhw.stat.vo.FlupVo;
import com.zkhw.stat.vo.GravidaVo;
import com.zkhw.stat.vo.ResidentAgeVo;
import com.zkhw.stat.vo.StatResidentVo;
import com.zkhw.stat.vo.StatisticsVo;

public interface StatisticsService {

	StatisticsVo statForArea(ResidentQuery query);

	
	ResidentAgeVo statForAge(ResidentQuery query);


	StatResidentVo statForSpecialMan(ResidentQuery query);


	ElderlyVo statForElderly(ResidentQuery query);


	FlupVo statForFlup(ResidentQuery query);


	ChildVo statForChild(ResidentQuery query);


	GravidaVo statForGravida(ResidentQuery query);

	

}
