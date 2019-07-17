package com.zkhw.framework.utils;

import java.text.DecimalFormat;


/**
 * 数学工具�?
 *
 */
public class MathUtils {
	private MathUtils() {}
	
	public static void main(String[] args) {
		for(int i=1; i<=10; i++){
			double n = MathUtils.random(1.5, 2.5);
			System.out.println( n );
			//System.out.println( MathUtils.round2(n) );
			System.out.println( Math.floor(n*100)/100.0 );
		}
	}
	
	/**
	 * 产生n1到n2之间的随机数
	 * @param args
	 */
	public static double random(int n1,int n2){
		double n3 = n1+Math.random()*(n2-n1);
		return n3;
	}
	
	/**
	 * 产生n1到n2之间的随机数
	 * @param args
	 */
	public static double random(double n1,double n2){
		double n3 = n1+Math.random()*(n2-n1);
		return n3;
	}
	
	/**
	 * 四舍五入到整�?
	 */
	public static String formatDouble0(double d) {
        DecimalFormat df = new DecimalFormat("#");
        return df.format(d);
    }
	
	/**
	 * 四舍五入�?1位小�?
	 */
	public static String formatDouble1(double d) {
        DecimalFormat df = new DecimalFormat("#.0");
        return df.format(d);
    }
	
	/**
	 * 四舍五入�?2位小�?
	 */
	public static String formatDouble2(double d) {
        //DecimalFormat df = new DecimalFormat("#.00");
		DecimalFormat df = new DecimalFormat("0.00");
        return df.format(d);
    }
	
	/**
	 * 四舍五入�?2位小�?
	 */
	public static double round2(double d) {
        return Math.round(d*100)/100.0;
    }	
}
