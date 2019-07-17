package com.zkhw.code.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TreeVo {
	
	  private String id;//节点id
	  private String pId;//父节点pId I必须大写
	  private String name;//节点名称
	  private String open = "false";//是否展开树节点，默认不展开
	  private String leval = ""; //级别
	  private String checked = ""; //级别
}
