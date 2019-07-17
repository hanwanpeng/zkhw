package com.zkhw.common.utils;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wuzhou.pub.service.WuzhouSynService;
import com.zkhw.framework.redis.RedisClient;
import com.zkhw.shanxi.service.ShanxiSyncService;


@Component
@Lazy(false)
public class TokenScheduler {

	@Resource
	private RedisClient redisClient;
	
	@Autowired
	private WuzhouSynService wuzhouSynService; 
	
	@Autowired
	private ShanxiSyncService shanxiSyncService;
		
	@Scheduled(cron="0 5 0 * * *") 
	public void wuzhouSync(){
		//wuzhouSynService.sync();
	}
	
	@Scheduled(cron="0 0/1 * * * *") 
	public void shanxiSync(){
		//shanxiSyncService.examSync();
	}		

	@Scheduled(cron="0 0/10 * * * *") 
	public void shanxiResidentSync(){
		//shanxiSyncService.redidentSync();
	}
	
	@Scheduled(cron="0 0/1 * * * *") 
	public void shanxiTcmSync(){
		//shanxiSyncService.tcmSync();
	}
	
	@Scheduled(cron="0 0/1 * * * *") 
	public void shanxiDiabetesSync(){
		//shanxiSyncService.diabetesSync();
	}
	
	@Scheduled(cron="0 0/1 * * * *") 
	public void shanxiHypertensionSync(){
		//shanxiSyncService.hypertensionSync();
	}	
}
