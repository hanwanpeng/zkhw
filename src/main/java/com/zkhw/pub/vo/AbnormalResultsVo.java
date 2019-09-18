package com.zkhw.pub.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbnormalResultsVo {
	
	/**
	 * 血红蛋白
	 */
	private String hgb;
	
	/**
	 * 血小板数目
	 */
	private String plt;
	
	/**
	 * 白细胞数目
	 */
	private String wbc;
	
	/**
	 * 尿蛋白
	 */
	private String urineProtein;
	
	/**
	 * 尿糖
	 */
	private String glycosuria;
	
	/**
	 * 尿酮体
	 */
	private String urineAcetoneBodies;
	
	/**
	 * 尿潜血
	 */
	private String bld;
	
	/**
	 * 空腹血糖
	 */
	private String glu;
	
	/**
	 * 血清谷丙转氨酶
	 */
	private String alt;
	
	/**
	 * 血清谷草转氨酶
	 */
	private String ast;
	
	/**
	 * 白蛋白
	 */
	private String alb;
	
	/**
	 * 总胆红素
	 */
	private String tbil;
	
	/**
	 * 直接胆红素
	 */
	private String dbil;
	
	/**
	 * 血清肌酐
	 */
	private String crea;
	
	/**
	 * 尿素
	 */
	private String urea;
	
	/**
	 * 总胆固醇
	 */
	private String cho;
	
	/**
	 * 甘油三酯
	 */
	private String tg;
	
	/**
	 * 低密度脂蛋白
	 */
	private String ldlc;
	
	/**
	 * 高密度脂蛋白
	 */
	private String hdlc;
	
	/**
	 * 血压值
	 */
	private String dbp;
	
	/**
	 * 心电异常描述
	 */
	private String cardiogramMemo;
	
	/**
	 * 腹部B超异常描述
	 */
	private String ultrasoundMemo;
	
	  /**
     * 是否健康评价
     */
    private String healthEvaluation;
    
    /**
     * 异常1
     */
    private String abnormal1;
    
    /**
     * 异常2
     */
    private String abnormal2;
    
    /**
     * 异常3
     */
    private String abnormal3;
    
    /**
     * 异常4
     */
    private String abnormal4;
    
    /**
     * 高血压指导
     */
    private String sbpGuide;
    
    /**
     * 低血压指导
     */
    private String dbpGuide;
    
    /**
     * 高血脂健康指导
     */
    private String hyperlipidemiaGuide;
    
    /**
     * 糖尿病健康指导
     */
    private String diabetesGuide;
	
}
