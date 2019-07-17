package com.zkhw.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkhw.common.utils.ApiConstants;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.redis.RedisClient;
import com.zkhw.framework.utils.JsonConverter;
import com.zkhw.framework.utils.StringUtils;
import com.zkhw.ltd.dao.RoleMenuDao;
import com.zkhw.sys.dao.SysMenuDao;
import com.zkhw.sys.entity.SysMenu;
import com.zkhw.sys.service.SysMenuService;
import com.zkhw.sys.vo.SysMenuVo;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Resource
	private SysMenuDao sysMenuDao;
	
	@Resource
	private RedisClient redisClient;
	
	@Resource
	private RoleMenuDao roleMenuDao;
	
	 /**
     * 分页查询所有权限
     */
	@Override
	public PageInfos<SysMenu> findAllRightByPage(PageInfos<SysMenu> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		SysMenu menu = new SysMenu();
		menu.setIsDelete(0);
		List<SysMenu> list = sysMenuDao.findMenuBySearch(menu);
		//用PageInfo对结果进行包装
		PageInfo<SysMenu> page = new PageInfo<SysMenu>(list);
		//返回分页数据
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal());       //总记录数
		pageData.setRows(list);
		return pageData;
	}
	
	/**
	 * 根据编码查询菜单
	 * @param menuCode
	 * @return
	 */
	@Override
	public SysMenu findMenuByCode(String menuCode) {
		return sysMenuDao.findMenuByCode(menuCode);
	}
	
	
	/**
	 * 保存权限
	 */
	@Override
	public void saveMenu(SysMenu menu) {
		String rightCode = CodeUtil.getRightCode();
		menu.setMenuCode(rightCode);
		String parentCode = menu.getMenuParentCode();
		Integer level = 0;
		if ( ! StringUtils.isEmpty(parentCode) ) {
			String parentRightJson = redisClient.get(ApiConstants.ZKHW_RIGHT + parentCode);
			SysMenu parentRight = JsonConverter.json2Obj(parentRightJson, SysMenu.class);
			if (parentRight != null) {
				if ("0".equals(parentRight.getMenuLevel())) {
					level = 1;
				} else if ("1".equals(parentRight.getMenuLevel())) {
					level = 2;
				} else {
					level = 0;
				}
			} else {
				level = 0;
			}
			menu.setMenuLevel(level+"");
		}else {
			menu.setMenuParentCode("0");
		}
		sysMenuDao.saveMenu(menu);
		// 存入缓存
		String rightJson = JsonConverter.obj2Json(menu);
		redisClient.set(ApiConstants.ZKHW_RIGHT + rightCode, rightJson);
	}
	
	/**
	 * 逻辑删除菜单
	 * @param menuCode
	 * @return
	 */
	@Override
	public void deleteMenuByLogic(String menuCode) {
		sysMenuDao.deleteMenuByLogic(menuCode);
	}
	
	/**
	  * 更新菜单
	  * @param menu
	  * @return
	  */
	public void updateMenuByCode(SysMenu menu) {
		String parentCode = menu.getMenuParentCode();
		Integer level = 0;
		if( ! StringUtils.isEmpty(parentCode)  ) {
			String parentRightJson = redisClient.get(ApiConstants.ZKHW_RIGHT+parentCode);
			SysMenu parentRight = JsonConverter.json2Obj(parentRightJson,SysMenu.class);
			if( parentRight != null ) {
				if( "0".equals(parentRight.getMenuLevel())) {
					level = 1;
				}else if( "1".equals(parentRight.getMenuLevel())) {
					level = 2;
				}else {
					level = 0;
				}
			}else {
				level = 0;
			}
			menu.setMenuLevel(level+"");
		}else {
			menu.setMenuParentCode("0");
		}
		sysMenuDao.updateMenuByCode(menu);
		//更新缓存
		String rightJson = JsonConverter.obj2Json(menu);
		redisClient.set(ApiConstants.ZKHW_RIGHT+menu.getMenuCode(), rightJson);
	}

	@Override
	public List<SysMenuVo> findMenuVoList() {
		SysMenu searchMenu = new SysMenu();
		searchMenu.setIsDelete(0);
		List<SysMenu> rights = sysMenuDao.findMenuBySearch(searchMenu);
		SysMenu right = null;
		
		List<SysMenu> modules = new ArrayList<SysMenu>();
		for(int i = 0 ; i < rights.size() ; i++  ) {
			right = rights.get( i );
			if( right.getMenuLevel() != null && "0".equals(right.getMenuLevel())) {
				modules.add(right);
			}
		}
		SysMenu module = null;
		SysMenu menu1 = null;
		SysMenuVo rightVo = null;
		List<SysMenuVo> list = new ArrayList<SysMenuVo>();
		SysMenuVo right1 = null;
		int nameSize = 0;
		String spackeStr = "";
		
		for( int i = 0 ; i < modules.size() ; i++) {  //模块
			spackeStr = ""; 
			module = modules.get( i );
			rightVo = new SysMenuVo();
			rightVo.setMenuCode(module.getMenuCode());
			rightVo.setMenuName(module.getMenuName());
			rightVo.setMenuLevel(module.getMenuLevel());
			list.add(rightVo);
			for(int j = 0 ; j < rights.size() ; j++  ) {  //菜单
				menu1 = rights.get( j );
				spackeStr = ""; 
				if( menu1.getMenuParentCode().equals(module.getMenuCode()) && "1".equals(menu1.getMenuLevel()) ) {  //一级菜单
					nameSize = module.getMenuName().length();
					while( nameSize > 0) {
						spackeStr +="&nbsp;";
						nameSize--;
					}
					right1 = new SysMenuVo();
					right1.setMenuCode(menu1.getMenuCode());
					right1.setMenuName(spackeStr+menu1.getMenuName());
					right1.setMenuLevel(menu1.getMenuLevel());
					list.add(right1);
				}
			}
		}
		return list;
	}
	
	/**
	 * 删除菜单
	 * @param menuCode
	 */
	public ApiJsonResult deleteMenu(ApiJsonResult result,String menuCode) {
		//校验是否存在子权限
		List<SysMenu> childRights = sysMenuDao.findChildMenuByCode(menuCode);
		//校验是否被用户占用
		List<String> roleCode = roleMenuDao.findRoleByMenu(menuCode);
		if( childRights != null && childRights.size() != 0 && roleCode !=null && roleCode.size() != 0 ) {
			result.setCode("r01");
			result.setMsg("当前权限下存在子权限或有用户占用");
		}else {
			sysMenuDao.deleteMenuByLogic(menuCode);
			result.setCode("0");
			result.setMsg("");
		}
		return result;
	}

	/**
	 * 查询所有权限
	 */
	public List<SysMenu> findAllMenu() {
		return sysMenuDao.findAllMenu();
	}
}
