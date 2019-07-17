package com.zkhw.common.vo;

import java.util.List;
import java.util.Map;

import com.zkhw.ltd.entity.User;
import com.zkhw.sys.entity.SysMenu;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录后需要存储在session中的数据
 * @author houmeng
 *
 */

@Getter  
@Setter 
public class LoginVo implements java.io.Serializable {
	private static final long serialVersionUID = 6063939173855571984L;
	private User user; //登录用户
	private List<SysMenu> moduleList;           //登录用户拥有的模块
	private Map<String,List<Menu1Vo>> menuMap;  //当前登录用户权限菜单
	private long loginTime; //登录时间(毫秒数)
	private long lastOperateTime; //最后一次操作时间(毫秒数)
	private String logImg;//图片地址
	private String systemName;//系统名称
	private String provinceCode;
	private String cityCode;
	private String countyCode;
	private String townsCode;
	private String villageCode;
	
}
