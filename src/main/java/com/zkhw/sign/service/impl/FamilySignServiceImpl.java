package com.zkhw.sign.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zkhw.common.utils.CodeUtil;
import com.zkhw.common.vo.PageInfos;
import com.zkhw.framework.utils.DateUtil;
import com.zkhw.ltd.dao.OrganizationDao;
import com.zkhw.ltd.entity.Organization;
import com.zkhw.ltd.entity.User;
import com.zkhw.pub.dao.ResidentBaseInfoDao;
import com.zkhw.pub.entity.ResidentBaseInfo;
import com.zkhw.sign.dao.DoctorInfoDao;
import com.zkhw.sign.dao.ServiceItemDao;
import com.zkhw.sign.dao.SignServiceInfoDao;
import com.zkhw.sign.dao.SignServiceItemDao;
import com.zkhw.sign.dao.TeamDoctorDao;
import com.zkhw.sign.entity.DoctorInfo;
import com.zkhw.sign.entity.ServiceItem;
import com.zkhw.sign.entity.SignServiceInfo;
import com.zkhw.sign.entity.SignServiceItem;
import com.zkhw.sign.entity.TeamDoctor;
import com.zkhw.sign.service.FamilySignService;

@Service
public class FamilySignServiceImpl implements FamilySignService {

	@Autowired
	private ServiceItemDao serviceItemDao;
	
	@Autowired
	private ResidentBaseInfoDao residentBaseInfoDao;
	
	@Autowired
	private OrganizationDao organizationDao;
	
	@Autowired
	private DoctorInfoDao doctorInfoDao;
	
	@Autowired
	private TeamDoctorDao teamDoctorDao;
	
	@Autowired
	private SignServiceInfoDao signServiceInfoDao;
	
	@Autowired
	private SignServiceItemDao signServiceItemDao;
	
	@Override
	public List<ServiceItem> findServiceItems() {
		return serviceItemDao.findAll();
	}

	@Override
	public int checkArchiveNo(String archiveNo) {
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(archiveNo);
		if(list != null){
			return list.size();
		}else{
			return 0;
		}		
	}

	@Override
	public int saveSignService(SignServiceInfo info, User user, String items) {
		int result = 0;
		String serviceId = CodeUtil.getUUID();
		info.setId(serviceId);			
		String archiveNo = info.getArchiveNo();
		Organization org = organizationDao.getOrganizationByCode(user.getOrganCode());
		String no = org.getTownsCode().substring(0, org.getTownsCode().length() - 3) + archiveNo;
		List<ResidentBaseInfo> list = residentBaseInfoDao.findResidentByArchiveNo(no);
		if(list != null && list.size() > 0){
			info.setArchiveNo(no);
			ResidentBaseInfo redisent = list.get(0);
			info.setName(redisent.getName());
			info.setIdNumber(redisent.getIdNumber());
			info.setPhone(redisent.getPhone());			
			//info.setFamilyArchiveNo(redisent.get);
		}else{
			result = 1;
			return result;
		}
		
		DoctorInfo doctor = doctorInfoDao.getDoctorByUser(user.getUserCode());
		if(doctor != null){
			info.setDoctorName(doctor.getDoctorName());
			info.setDoctorPhone(doctor.getDoctorPhone());
			List<TeamDoctor> teams = teamDoctorDao.findTeamByDoctorNo(doctor.getDoctorNo());
			if(teams != null && teams.size() > 0){
				info.setTeamNo(teams.get(0).getTeamNo());
				info.setTeamName(teams.get(0).getTeamName());
			}else{
				result = 3;
				return result;
			}
		}else{
			result = 2;
			return result;
		}
		
		Date now = new Date();
		info.setSignDate(DateUtil.fmtDate(now, "yyyy-MM-dd"));
		info.setIsfinish("0");
		info.setStatus("1");
		info.setCreateUser(user.getUserCode());
		info.setCreateName(user.getUserName());
		info.setCreateTime(now);
		
		info.setUpdateUser(user.getUserCode());
		info.setUpdateName(user.getUserName());
		info.setUpdateTime(now);
		
		signServiceInfoDao.insertSelective(info);
		
		String[] item = items.split(",");
		for(int i = 0; i < item.length; i++){
			if(StringUtil.isNotEmpty(item[i])){
				SignServiceItem si = new SignServiceItem();
				si.setId(CodeUtil.getUUID());
				si.setSignServiceId(serviceId);
				si.setServiceItemNo(item[i]);
				
				si.setCreateUser(user.getUserCode());
				si.setCreateName(user.getUserName());
				si.setCreateTime(now);
				
				si.setUpdateUser(user.getUserCode());
				si.setUpdateName(user.getUserName());
				si.setUpdateTime(now);
				
				signServiceItemDao.insertSelective(si);
			}
		}
		
		return result;
	}

	@Override
	public PageInfos<SignServiceInfo> findSignServiceByPage(SignServiceInfo sign, PageInfos<SignServiceInfo> pageData) {
		PageHelper.startPage( (int)pageData.getPage(), (int)pageData.getPageSize());//pageNum, pageSize
		List<SignServiceInfo> list = signServiceInfoDao.findSignServiceList(sign);
		PageInfo<SignServiceInfo> page = new PageInfo<SignServiceInfo>(list);
		pageData.setPage(page.getPageNum());      //当前页码
		pageData.setPageCount(page.getPages());   //总页数
		pageData.setPageSize(page.getPageSize()); //每页记录数
		pageData.setTotal(page.getTotal()); 
		pageData.setRows(page.getList());
		return pageData;
	}

}
