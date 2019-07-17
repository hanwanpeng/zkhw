package com.zkhw.common.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.zkhw.common.vo.Menu1Vo;
import com.zkhw.common.vo.Menu2Vo;
import com.zkhw.framework.redis.RedisClient;
import com.zkhw.framework.utils.JsonConverter;
import com.zkhw.sys.dao.SysMenuDao;
import com.zkhw.sys.entity.SysMenu;

/**
 * 初始化数据类
 * 
 * @author houmeng
 *
 */

public class InitDataUtil {


	@Resource
	private RedisClient redisClient;


	@Resource
	private SysMenuDao sysMenuDao;
	
	

	public void process() {

		/**
		 * 模块
		 */

		// 模块json
		List<SysMenu> commonRights = sysMenuDao.findAllMenu(); // 系统公共模块菜单
		SysMenu sysRight = null;
		List<SysMenu> sysModuleList = new ArrayList<SysMenu>(); // 父级模块
		// 移除公共系统模块
		redisClient.del(ApiConstants.ZKHW_MODULE);
		redisClient.del(ApiConstants.ZKHW_MENU);
		List<SysMenu> commonModules = new ArrayList<SysMenu>();

		/**
		 * 系统公共模块
		 */
		String rightJson = null;
		if (commonRights != null && commonRights.size() > 0) {
			for (int i = 0; i < commonRights.size(); i++) {
				sysRight = commonRights.get(i);
				rightJson = JsonConverter.obj2Json(sysRight);
				if ("0".equals(sysRight.getMenuParentCode())) { // 缓存模块
					commonModules.add(sysRight);
					sysModuleList.add(sysRight);
					redisClient.setListRPush(ApiConstants.ZKHW_MODULE, rightJson);
				}
				redisClient.set(ApiConstants.ZKHW_RIGHT + sysRight.getMenuCode(), rightJson);
			}
		}

		/**
		 * 系统功能菜单（一级菜单及二级菜单)
		 */
		List<Menu1Vo> menuVoList = null;
		Menu1Vo menuVo = null;
		SysMenu module = null;
		SysMenu menu1 = null;
		SysMenu menu2 = null;
		List<Menu2Vo> menu2VoList = null;
		Menu2Vo menu2Vo = null;
		String menuJson = null;
		if (sysModuleList != null && sysModuleList.size() != 0) {
			for (int i = 0; i < sysModuleList.size(); i++) {
				module = sysModuleList.get(i);
				menuVoList = new ArrayList<Menu1Vo>();
				for (int j = 0; j < commonRights.size(); j++) {
					menu1 = commonRights.get(j);
					if (menu1.getMenuParentCode().equals(module.getMenuCode())) { // 一级菜单
						menuVo = new Menu1Vo();
						menuVo.setRightCode(menu1.getMenuCode());
						menuVo.setParentCode(menu1.getMenuParentCode());
						menuVo.setRightLevel(menu1.getMenuLevel());
						menuVo.setImageUrl(menu1.getMenuImgUrl());
						menuVo.setRightName(menu1.getMenuName());
						menuVo.setRightUrl(menu1.getMenuUrl());
						menu2VoList = new ArrayList<Menu2Vo>();
						for (int k = 0; k < commonRights.size(); k++) {
							menu2 = commonRights.get(k);
							if (menu2.getMenuParentCode().equals(menu1.getMenuCode())) { // 二级菜单
								menu2Vo = new Menu2Vo();
								menu2Vo.setRightCode(menu2.getMenuCode());
								menu2Vo.setParentCode(menu2.getMenuCode());
								menu2Vo.setRightLevel(menu2.getMenuLevel());
								menu2Vo.setImageUrl(menu2.getMenuImgUrl());
								menu2Vo.setRightName(menu2.getMenuName());
								menu2Vo.setRightUrl(menu2.getMenuUrl());
								menu2VoList.add(menu2Vo);
							}
						}
						menuVo.setMenu2(menu2VoList);
						menuVoList.add(menuVo);
					}
				}
				menuJson = JsonConverter.obj2Json(menuVoList);
				redisClient.setHash(ApiConstants.ZKHW_MENU, module.getMenuCode(), menuJson);
			}
		}	
		
	}	

}
