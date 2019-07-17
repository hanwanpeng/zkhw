package com.zkhw.sys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zkhw.common.enums.StatusCodeEnum;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.utils.CommonUtil;
import com.zkhw.common.utils.SystemParam;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.redis.RedisClient;
import com.zkhw.framework.utils.JsonWebPrintUtils;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.service.RoleMenuService;
import com.zkhw.ltd.service.UserRoleService;
import com.zkhw.ltd.service.UserService;
import com.zkhw.sys.entity.SysMenu;
import com.zkhw.sys.service.SysMenuService;
import com.zkhw.sys.vo.SysMenuVo;



@Controller
@RequestMapping("/sys/menu")
public class SysMenuController {
		
	@Resource
	private SysMenuService sysMenuService;
	
	@Resource
	private CodeUtil codeUtil;
	
	@Resource
	private RedisClient redisClient;
	
	@Resource
	private CommonUtil commonUtil;
	
	@Autowired
	private UserService userService;	
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleMenuService roleMenuService;
	
	/**
	 * 所有菜单分页查询
	 * @param request
	 * @param response
	 * @param pageData
	 * @param result
	 */
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void findAllRightByPage(HttpServletRequest request, HttpServletResponse response,PageInfos<SysMenu> pageData,ApiJsonResult result) {
		try {
			pageData = sysMenuService.findAllRightByPage(pageData);
			result.setCode(StatusCodeEnum.SUCCESS.getCode());
			result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JsonWebPrintUtils.printApiResult(request, response, pageData);
	}
	
	
	/*
	 *保存权限
	 */
	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
	public void saveMenu(HttpServletRequest request, HttpServletResponse response, SysMenu menu,ApiJsonResult result) throws Exception {
		menu.setIsDelete(0);
		sysMenuService.saveMenu(menu);
		result.setCode(StatusCodeEnum.SUCCESS.getCode());
		result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		JsonWebPrintUtils.printApiResult(request, response, result);
	}

	
	/**
	 * 根据权限编码获取权限
	 * @param request
	 * @param response
	 * @param sysRight
	 * @param result
	 */
	@RequestMapping(value = "/findMenuByCode", method = RequestMethod.POST)
	public void findRightByCode(HttpServletRequest request, HttpServletResponse response,String menuCode,ApiJsonResult result) {
		SysMenu sysMenu = sysMenuService.findMenuByCode(menuCode);
		result.setData(sysMenu);
		result.setCode(StatusCodeEnum.SUCCESS.getCode());
		result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	/**
	 * 更新权限
	 * @param request
	 * @param response
	 * @param sysRight
	 * @param result
	 */
	@RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
	public void updateRight(HttpServletRequest request, HttpServletResponse response,SysMenu menu,ApiJsonResult result) {
		sysMenuService.updateMenuByCode(menu);
		result.setCode(StatusCodeEnum.SUCCESS.getCode());
		result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	
	/**
	 * 获取所有权限
	 * @param request
	 * @param response
	 * @param sysRight
	 * @param result
	 */
	@RequestMapping(value = "/allMenu", method = RequestMethod.POST)
	public void allRight(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result) {
		
		List<SysMenu> rights = new ArrayList<SysMenu>();
		String loginName = SystemParam.getUserId();
		User  user = userService.findUserByLoginName(loginName);
		if(user != null){
			if (!"admin".equals(user.getLoginName())){
				List<String> roles = userRoleService.findRoleByUser(user.getUserCode());
				if(roles != null && roles.size() > 0){
					List<String> menus = roleMenuService.findMenuByRole(roles.get(0));				
					
					if( menus != null && menus.size() != 0 ) {
						for( int i = 0 ; i < menus.size() ; i++ ) {
							String rightCode = menus.get( i );
							SysMenu right = commonUtil.findMenuByCode(rightCode);
							if( right != null ) {
								rights.add(right);
							}
						}
					}
				}
			}else{
				rights = sysMenuService.findAllMenu();
			}
		}

		//List<SysMenu> rights = sysMenuService.findAllMenu();
		result.setData(rights);
		result.setCode(StatusCodeEnum.SUCCESS.getCode());
		result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @param result
	 */
	@RequestMapping(value = "/allMenuBySort", method = RequestMethod.POST)
	public void allRightByOrder(HttpServletRequest request, HttpServletResponse response,ApiJsonResult result) {
		 List<SysMenuVo> menuVoList = sysMenuService.findMenuVoList();
		result.setData(menuVoList);
		result.setCode(StatusCodeEnum.SUCCESS.getCode());
		result.setMsg(StatusCodeEnum.SUCCESS.getDesc());
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
	
    /**
     * 删除菜单
     * @param request
     * @param response
     * @param menuCode
     * @param result
     */
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	public void deleteMenu(HttpServletRequest request, HttpServletResponse response,String menuCode,ApiJsonResult result) {
		result = sysMenuService.deleteMenu(result,menuCode);
		JsonWebPrintUtils.printApiResult(request, response, result);
	}
	
}
