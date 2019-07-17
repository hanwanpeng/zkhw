package com.zkhw.pub.vo;

import java.util.List;

import com.zkhw.pub.entity.TjBc;
import com.zkhw.pub.entity.TjNcg;
import com.zkhw.pub.entity.TjSgtz;
import com.zkhw.pub.entity.TjSh;
import com.zkhw.pub.entity.TjXcg;
import com.zkhw.pub.entity.TjXdt;
import com.zkhw.pub.entity.TjXy;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TjDataVo {

	private String name;
	
	private String archiveNo;
	
	 private String idNumber;
	 
	 List<TjNcg> ncgList;
	 
	 List<TjSgtz> sgtzList;
	 
	 List<TjSh> shList;
	 
	 List<TjXcg> xcgList;
	 
	 List<TjXy> xyList;
	 
	 List<TjBc> bcList;
	 
	 List<TjXdt> xdtList;
}
