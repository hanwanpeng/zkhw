package com.zkhw.ltd.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.utils.CommonUtil;
import com.zkhw.common.utils.SessionUtil;
import com.zkhw.common.vo.ApiJsonResult;
import com.zkhw.common.vo.LoginVo;
import com.zkhw.common.vo.Menu1Vo;
import com.zkhw.common.vo.Menu2Vo;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.DesEncrypt;
import com.zkhw.framework.utils.Md5Encrypt;
import com.zkhw.ltd.bo.UserBo;
import com.zkhw.ltd.dao.OrganizationDao;
import com.zkhw.ltd.dao.RoleDao;
import com.zkhw.ltd.dao.RoleMenuDao;
import com.zkhw.ltd.dao.UserDao;
import com.zkhw.ltd.dao.UserRoleDao;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.Role;
import com.zkhw.ltd.entity.User;
import com.zkhw.ltd.entity.UserRole;
import com.zkhw.ltd.service.UserService;
import com.zkhw.sign.dao.DoctorInfoDao;
import com.zkhw.sign.entity.DoctorInfo;
import com.zkhw.sys.comparator.SysMenuComparator;
import com.zkhw.sys.dao.SysMenuDao;
import com.zkhw.sys.entity.SysMenu;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Resource
	private SysMenuDao sysMenuDao;
	
	@Resource
	private UserRoleDao userRoleDao;
	
	@Resource
	private RoleMenuDao roleMenuDao;
	
	@Resource
	private CommonUtil commonUtil;
	
	@Autowired
	private OrganizationDao organizationDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private DoctorInfoDao doctorInfoDao;
	
	/**
	 * 用户登录查询
	 */
	public User findLoginUser(String loginName, String passWord) {
		return userDao.findLoginUser(loginName, passWord);
	}
	
	/**
	 * web登录
	 * @param loginName
	 * @param loginPass
	 * @throws Exception 
	 */
	public ApiJsonResult webLogin(HttpServletRequest request,HttpServletResponse response,ApiJsonResult result,String loginName, String loginPass) throws Exception {
		User user = userDao.findLoginUser(loginName,loginPass);
		   if ( user != null ) {
			   SessionUtil sessionUtil = new SessionUtil(request, response);
				// 当前登录用户信息,存入redis
				LoginVo loginVo = new LoginVo();
				long loginTime = System.currentTimeMillis();
				loginVo.setLoginTime(loginTime); // 登录时间
				loginVo.setLastOperateTime(loginTime); // 最后一次操作时间
				loginVo.setUser(user);
				if(!user.getLoginName().equals("admin")){
					Organization org = organizationDao.getOrganizationByCode(user.getOrganCode());
					if(org != null){
						loginVo.setProvinceCode(org.getProvinceCode());
						loginVo.setCityCode(org.getCityCode());
						loginVo.setCountyCode(org.getCountyCode());
						loginVo.setTownsCode(org.getTownsCode());
						loginVo.setVillageCode(org.getVillageCode());
					}
				}
				
				
				String  rightCode = null;
				List<Menu1Vo> menuVoList  = null;
				List<Menu2Vo> menu2VoList = null;
				Menu1Vo menuVo = null;
				Menu2Vo menu2Vo = null;
				SysMenu menu1 = null;
				SysMenu menu2 = null;
				List<SysMenu> menu1List = new ArrayList<SysMenu>();
				List<SysMenu> menu2List = new ArrayList<SysMenu>();
				 Map<String,List<Menu1Vo>> menuMap = new HashMap<String,List<Menu1Vo>>();
				//模块信息
				List<SysMenu> moduleList = new ArrayList<SysMenu>();
				SysMenu module = null;
				String admin ="admin";
				SysMenu right = null;
				//管理员,所有权限
				if( admin.equals(loginName)  ) {
					List<SysMenu> allRightList =  sysMenuDao.findAllMenu();
					if( allRightList != null ) {
						for( int i = 0 ; i < allRightList.size() ; i++ ) {
							right = allRightList.get( i );
							if( right != null ) {
								if( "0".equals(right.getMenuLevel()) ) {
									moduleList.add( right );
								}
								if( "1".equals(right.getMenuLevel()) ) {
									menu1List.add( right );
								}
								if( "2".equals(right.getMenuLevel()) ) {
									menu2List.add( right );
								}
							}
						}
					}
				}else { //其他，按角色权限走
					List<String> roleCodes = userRoleDao.findRoleByUser(user.getUserCode());
					//默认角色
					String defaultRoleCode = roleCodes.get(0);
					List<String> rightCodeList = roleMenuDao.findMenuByRole(defaultRoleCode) ;
					if( rightCodeList != null && rightCodeList.size() != 0 ) {
						for( int i = 0 ; i < rightCodeList.size() ; i++ ) {
							rightCode = rightCodeList.get( i );
							right = commonUtil.findMenuByCode(rightCode);
							if( right != null ) {
								if( "0".equals(right.getMenuLevel()) ) {
									moduleList.add( right );
								}
								if( "1".equals(right.getMenuLevel()) ) {
									menu1List.add( right );
								}
								if( "2".equals(right.getMenuLevel()) ) {
									menu2List.add( right );
								}
							}
						}
					}
				}
				Collections.sort(moduleList, new SysMenuComparator());
				Collections.sort(menu1List, new SysMenuComparator());
				Collections.sort(menu2List, new SysMenuComparator());
				
				for( int i = 0 ; i < moduleList.size() ; i++ ) {
					module = moduleList.get( i );
					menuVoList = new ArrayList<Menu1Vo>();
					for( int j = 0 ;j < menu1List.size() ; j++ ) {
						menu1 = menu1List.get( j );
						if( module.getMenuCode().equals(menu1.getMenuParentCode())) {
							menuVo = new Menu1Vo();
							menuVo.setRightCode(menu1.getMenuCode());
							menuVo.setParentCode(menu1.getMenuParentCode());
							menuVo.setRightLevel(menu1.getMenuLevel());
							menuVo.setImageUrl(menu1.getMenuImgUrl());
							menuVo.setRightName(menu1.getMenuName());
							menuVo.setRightUrl(menu1.getMenuUrl());
							menu2VoList  = new ArrayList<Menu2Vo>();
							for( int k = 0 ; k < menu2List.size(); k++ ) {
								menu2 = menu2List.get( k );
								if( menu1.getMenuCode().equals(menu2.getMenuParentCode())) {
									menu2Vo = new Menu2Vo();
									menu2Vo.setRightCode(menu2.getMenuCode());
									menu2Vo.setParentCode(menu2.getMenuParentCode());
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
					menuMap.put(module.getMenuCode(), menuVoList);
				}
				loginVo.setModuleList(moduleList);
				loginVo.setMenuMap(menuMap);
				// 保存用户登录信息
				sessionUtil.setLoginVo(loginVo);
				
				//写入登录日志
				/*Date date = new Date();
				SysLoginLog loginLog = new SysLoginLog();
				loginLog.setUserCode(user.getUserCode());
				loginLog.setSource(ApiConstants.WEB_SOURCE);
				loginLog.setUserName(user.getName());
				loginLog.setLoginDate(date);
				loginLog.setLoginTime(date.getTime()/1000);
				sysLoginLogService.saveLoginLog(loginLog);*/
				
				DesEncrypt des = new DesEncrypt();
		    	String cookie_value = des.encrypt( loginVo.getUser().getLoginName() );
		    	result.setData(cookie_value);
				result.setCode("0");
				result.setMsg("");
		   } else {
			   result.setCode("1");
			   result.setMsg("");
		   }
		   return result;
	}

	 /**
     * 根据条件分页查询用户
     * @param user
     * @param pageData
     * @return
     */
	public PageInfos<UserBo> findUserByPage(User user, PageInfos<UserBo> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<User> list = userDao.findUserBySearch(user);
		//用PageInfo对结果进行包装
		PageInfo<User> page = new PageInfo<User>(list);
		//返回分页数据
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal());       //总记录数
		
		List<UserBo> bolist = new ArrayList<UserBo>();
		for(int i = 0; i < page.getList().size(); i++){
			UserBo bo = new UserBo();
			BeanUtils.copyProperties(page.getList().get(i),bo);
			Organization org = organizationDao.selectByPrimaryKey(bo.getOrganCode());
			if(org != null){
				bo.setOrganName(org.getOrganName());
			}
			
			List<String> roles = userRoleDao.findRoleByUser(bo.getUserCode());
			if(roles != null && roles.size() > 0){
				Role role = roleDao.findRoleByCode(roles.get(0));
				
				if(role != null){
					bo.setRoleName(role.getRoleName());
				}
			}
			
			bolist.add(bo);
		}
		pageData.setRows(bolist);
		return pageData;
	}

	/**
	 * 保存用户
	 * @param user
	 */
	public ApiJsonResult saveUser(User user,String roleCodes) {
		   ApiJsonResult result = new ApiJsonResult();
			User existUser = userDao.findUserByLoginName(user.getLoginName());
			
			if( existUser == null ) {
				String userCode = CodeUtil.getUserCode();
				user.setUserCode(userCode);
				//默认密码6个1
				user.setLoginPass(Md5Encrypt.md5("111111"));
				//创建时间默认当前时间
				user.setCreateTime(new Date());
				user.setStatus(1);
				//保存用户
				userDao.saveUser(user);
				
				String roleCode = null;
				UserRole userRole = null;
				String [] roles = roleCodes.split(",");
				List<UserRole> userRoleList = new ArrayList<UserRole>();
				for( int i = 0 ; i < roles.length ;i++ ) {
					roleCode = roles[ i ];
					userRole = new UserRole();
					userRole.setRoleCode(roleCode);
					userRole.setUserCode(userCode);
					userRole.setCreateTime(new Date());
					userRoleList.add( userRole );
				}
				//保存用户-角色关系
				userRoleDao.saveRoleRightByBatch(userRoleList);
				
				if("1".equals(user.getUserTypeCode())){
					DoctorInfo dinfo = new DoctorInfo();
					String doctorNo = "d" + System.currentTimeMillis();
					dinfo.setId(CodeUtil.getUUID());
					dinfo.setUserCode(user.getUserCode());
					dinfo.setDoctorNo(doctorNo);
					dinfo.setDoctorName(user.getUserName());
					
					//dinfo.setAge(age);
					dinfo.setBirthday(user.getBirthday());
					dinfo.setSex(String.valueOf(user.getSex()));
					dinfo.setDoctorPhone(user.getTelePhone());
					dinfo.setDepartment(user.getDepartCode());
					
					Organization org = organizationDao.getOrganizationByCode(user.getOrganCode());
					if(org != null){
						dinfo.setProvinceCode(org.getProvinceCode());
						dinfo.setProvinceName(org.getProvinceName());		
						dinfo.setCityCode(org.getCityCode());
						dinfo.setCityName(org.getCityName());
						dinfo.setCountyCode(org.getCountyCode());
						dinfo.setCountyName(org.getCountyName());
						dinfo.setTownsCode(org.getTownsCode());
						dinfo.setTownsName(org.getTownsName());
						dinfo.setVillageCode(org.getVillageCode());
						dinfo.setVillageName(org.getVillageName());
						dinfo.setOrgName(org.getOrganName());
					}
	
	
					dinfo.setOrgCode(user.getOrganCode());
	
					//dinfo.setSpecialty(doctor.getSpecialty());
					//dinfo.setRemark(doctor.getRemark());
					
					//dinfo.setCreateName(user.getc);
					dinfo.setCreateUser(user.getCreateUserCode());
					dinfo.setCreateTime(user.getCreateTime());
									
					dinfo.setStatus("1");
	
					doctorInfoDao.insertSelective(dinfo);
				}
				result.setCode("0");
				result.setMsg("");
			}else {
				result.setData("登录名已经存在");
				result.setCode("1");
				result.setMsg("登录名已经存在");
			}
			return result;
	}
	
	
    /**
     * 更新用户
     * @param user
     */
    public ApiJsonResult updateUserByCode(User user,String roleCodes) {
    	ApiJsonResult result = new ApiJsonResult();
    	try {
			//移除旧用户角色关系
			userRoleDao.deleteUserRole(user.getUserCode());
			//更新用户信息
			userDao.updateUserByCode(user);
			//更新用户角色信息
			String roleCode = null;
			UserRole userRole = null;
			String [] roles = roleCodes.split(",");
			List<UserRole> userRoleList = new ArrayList<UserRole>();
			for( int i = 0 ; i < roles.length ;i++ ) {
				roleCode = roles[ i ];
				userRole = new UserRole();
				userRole.setRoleCode(roleCode);
				userRole.setUserCode(user.getUserCode());
				userRole.setCreateTime(new Date());
				userRoleList.add( userRole );
			}
			//保存用户-角色关系
			userRoleDao.saveRoleRightByBatch(userRoleList);
		} catch (Exception e) {
			result.setCode("1");
			result.setMsg("更新失败");
		}
		result.setCode("0");
		result.setMsg("");
    	return result;
    }

    /**
     * 根据用户编码查询用户
     */
	public User findUserByCode(String userCode) {
		return userDao.findUserByCode(userCode);
	}
	
	/**
	 * 登录名是否存在
	 * @param loginName
	 * @return
	 */
	public boolean existLoginName(String loginName) {
		User user = new User();
		user.setLoginName(loginName);
		List<User> users =  userDao.findUserBySearch(user);
		if( users != null && users.size() != 0 ) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * 根据登录获取用户信息
	 * @param loginName
	 * @return
	 */
	public User findUserByLoginName(String loginName) {
		return userDao.findUserByLoginName(loginName);
	}
	
	/**
	 * 删除用户
	 */
	public void deleteUser(String userCode) {
		User user = new User();
		user.setUserCode(userCode);
		user.setIsDelete(1);
		userDao.updateUserByCode(user);
		doctorInfoDao.deleteByUserCode(userCode);
	}
	
	
	   
   @Override
	public void updateUserByCode(User user) {
		this.userDao.updateUserByCode(user);		
	}

	@Override
	public List<User> findUserByOrgan(String organCode) {
		return userDao.findUserByOrgan(organCode);
	}
}
