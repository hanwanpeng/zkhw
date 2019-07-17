package com.zkhw.stat.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsVo {

	/**
	 * 体检总人数
	 */
	private Integer examTotalNum;

	List<PhysicalVo> physicalList;

}
