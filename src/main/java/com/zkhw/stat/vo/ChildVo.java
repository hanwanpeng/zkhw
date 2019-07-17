package com.zkhw.stat.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildVo {
	
	/**
	 * 新生儿人数
	 */
	private Integer neonatusNum;
	
	/**
	 * 0-6岁儿童健康体检人数
	 */
	private Integer childrenHealthNum;
	
	/**
	 * 儿童中医健康管理人数
	 */
	private Integer childrenTcmNum;

}
