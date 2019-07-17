package com.zkhw.stat.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResidentAgeVo {
	
	/**
	 * 0-6岁总人数
	 */
	private Integer totalSixAgeNum;

	/**
	 * 0-6岁人数 --男
	 */
	private Integer manSixAgeNum;
	
	/**
	 * 0-6岁人数--女
	 */
	private Integer womanSixAgeNum;
	
	/**
	 * 7-25岁总人数
	 */
	private Integer totalTwentyFiveAgeNum;

	/**
	 * 7-25岁人数--男
	 */
	private Integer manTwentyFiveAgeNum;
	
	/**
	 * 7-25岁人数--女
	 */
	private Integer womanTwentyFiveAgeNum;
	
	/**
	 * 26-64岁总人数
	 */
	private Integer totalSixtyFourAgeNum;

	/**
	 * 26-64岁人数--男
	 */
	private Integer manSixtyFourAgeNum;
	
	/**
	 * 26-64岁人数--女
	 */
	private Integer womanSixtyFourAgeNum;
	
	/**
	 * 65岁及以上总人数
	 */
	private Integer totalSixtyFiveAgeNum;

	/**
	 * 65岁及以上人数--男
	 */
	private Integer manSixtyFiveAgeNum;
	
	/**
	 * 65岁及以上人数--女
	 */
	private Integer womanSixtyFiveAgeNum;

}
