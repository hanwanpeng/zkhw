package com.zkhw.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 * <pre>
 * The Class DateUtils.
 * 
 * Description:
 * 日期工具类，默认格式yyyy-MM-dd
 * 
 * </pre>
 */
public final class DateUtil {
    /**
     * 当月�?后一�?
     * @param yearMonth 2017-01
     * @return
     */
	@SuppressWarnings("deprecation")
	public static int getLastDay(String yearMonth) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
			Date theDate = df.parse(yearMonth);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(theDate);
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			Date lastDayOfMonth = calendar.getTime();
			return lastDayOfMonth.getDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
    }
    
	/**
	 * <pre>
	 * 获取当前时间的yyyy-MM-dd格式的字符串.
	 * </pre>
	 * 
	 * @return the string
	 * @author chenhaobin 2013-4-3
	 */
	public static String getTodayString() {
		return new DateTime().toString("yyyy-MM-dd");
	}

	/**
	 * <pre>
	 * 获取当前时间的yyyy-MM-dd hh:mm:ss格式的字符串.
	 * </pre>
	 * 
	 * @return the string
	 * @author chenhaobin 2013-4-3
	 */
	public static String getTodaySecondString() {
		return new DateTime().toString("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * <pre>
	 * 将指定日期输出为yyyy-MM-dd格式字符�?.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @author chenhaobin 2013-4-3
	 */
	public static String getDateString(Date date) {
		return new DateTime(date).toString("yyyy-MM-dd");
	}

	/**
	 * <pre>
	 * 将指定日期输出为yyyy-MM-dd hh:mm:ss格式字符�?.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @author chenhaobin 2013-4-3
	 */
	public static String getDateTimeString(Date date) {
		return new DateTime(date).toString("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * <pre>
	 * 将yyyy-MM-dd格式的字符串转换为java.util.Date类型.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 * @author chenhaobin 2013-4-3
	 */
	public static Date getDate(String date) {
		if (null == date || "".equals(date.trim())) {
			return null;
		}
		return new DateTime(date).toDate();
	}

	/**
	 * <pre>
	 * 将format指定格式的字符串转换为java.util.Date类型.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 * @author chenhaobin 2013-4-3
	 */
	public static Date getDate(String datestr,String format) {
		if (null == datestr || "".equals(datestr.trim())) {
			return null;
		}
		Date date = null;
		try {
			date = new SimpleDateFormat(format).parse(datestr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	public static Long getLongDate(String datestr,String format) {
		if (null == datestr || "".equals(datestr.trim())) {
			return null;
		}
		Long date1 = null;
		Date date = null;
		try {
			date = new SimpleDateFormat(format).parse(datestr);
			date1 = date.getTime()/1000;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date1;
	}
	
	/**
	 * <pre>
	 * 将时间戳转换为java.util.Date类型.
	 * </pre>
	 * 
	 * @param timestamp
	 *            the timestamp
	 * @return the date
	 * @author chenhaobin 2013-4-3
	 */
	public static Date getDate(long timestamp) {
		return new DateTime(timestamp).toDate();
	}

	/**
	 * <pre>
	 * 获取当前时间是本月的几号.
	 * </pre>
	 * 
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getTodayDayOfMonth() {
		return new DateTime().getDayOfMonth();
	}

	/**
	 * <pre>
	 * 获取指定日期字符串�?�yyyy-MM-dd”是本月的几�?.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getDayOfMonth(String date) {
		return new DateTime(date).getDayOfMonth();
	}

	/**
	 * <pre>
	 * 获取指定日期是本月的几号.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getDayOfMonth(Date date) {
		return new DateTime(date).getDayOfMonth();
	}

	/**
	 * <pre>
	 * 获取今天是本周的周几.
	 * </pre>
	 * 
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getTodayDayOfWeek() {
		return new DateTime().getDayOfWeek();
	}

	/**
	 * <pre>
	 * 获取指定日期字符串�?�yyyy-MM-dd”是本周的周�?.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getDayOfWeek(String date) {
		return new DateTime(date).getDayOfWeek();
	}

	/**
	 * <pre>
	 * 获取指定日期是本周的周几.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getDayOfWeek(Date date) {
		return new DateTime(date).getDayOfWeek();
	}

	/**
	 * <pre>
	 * 获取今天是当年的第几�?.
	 * </pre>
	 * 
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getTodayDayOfYear() {
		return new DateTime().getDayOfYear();
	}

	/**
	 * <pre>
	 * 获取指定日期“yyyy-MM-dd”是该年第几�?.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getDayOfYear(String date) {
		return new DateTime(date).getDayOfYear();
	}

	/**
	 * <pre>
	 * 获取指定日期是该年第几天.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getDayOfYear(Date date) {
		return new DateTime(date).getDayOfYear();
	}

	/**
	 * <pre>
	 * 获取今天是当年的第几�?.
	 * </pre>
	 * 
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getTodayOfWeekyear() {
		return new DateTime().getWeekOfWeekyear();
	}

	/**
	 * <pre>
	 * 获取指定日期“yyyy-MM-dd”是该年第几�?.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getWeekOfWeekyear(String date) {
		return new DateTime(date).getWeekOfWeekyear();
	}

	/**
	 * <pre>
	 * 获取指定日期是该年第几周.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getWeekOfWeekyear(Date date) {
		return new DateTime(date).getWeekOfWeekyear();
	}

	/**
	 * <pre>
	 * 是否晚于当前时间，比较到�?.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return true, if is after now
	 * @author chenhaobin 2013-4-3
	 */
	public static boolean isAfterNow(String date) {
		return new DateTime(date).isAfterNow();
	}

	/**
	 * <pre>
	 * 是否晚于当前时间，比较到�?.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return true, if is after now
	 * @author chenhaobin 2013-4-3
	 */
	public static boolean isAfterNow(Date date) {
		return new DateTime(date).isAfterNow();
	}

	/**
	 * <pre>
	 * 是否早于当前时间，比较到�?.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return true, if is before now
	 * @author chenhaobin 2013-4-3
	 */
	public static boolean isBeforeNow(String date) {
		return new DateTime(date).isBeforeNow();
	}

	/**
	 * <pre>
	 * 是否早于当前时间，比较到�?.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return true, if is before now
	 * @author chenhaobin 2013-4-3
	 */
	public static boolean isBeforeNow(Date date) {
		return new DateTime(date).isBeforeNow();
	}

	/**
	 * <pre>
	 * 比较两个日期大小.
	 * </pre>
	 * 
	 * @param begin
	 *            the begin
	 * @param end
	 *            the end
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int compareTo(Date begin, Date end) {
		return new DateTime(begin).compareTo(new DateTime(end));
	}

	/**
	 * <pre>
	 * 计算下一个工作日.
	 * </pre>
	 * 
	 * @param start
	 *            �?始日�?
	 * @param workdays
	 *            间隔工作日，单位：天
	 * @return the date
	 * @author chenhaobin 2013-4-3
	 */
	public static Date ToWorkDate(Date start, int workdays) {
		DateTime startDate = new DateTime(start);
		if (0 < workdays) {
			while (workdays-- > 1) {
				// not include weekend
				startDate = startDate.plusDays(1);
				if (startDate.dayOfWeek().get() == 6
						|| startDate.dayOfWeek().get() == 7) {
					workdays++;
					continue;
				}
			}
		} else {
			while (workdays++ < 0) {
				// not include weekend
				startDate = startDate.plusDays(-1);
				if (startDate.dayOfWeek().get() == 6
						|| startDate.dayOfWeek().get() == 7) {
					workdays++;
					continue;
				}
			}
		}
		return startDate.toDate();
	}

	/**
	 * <pre>
	 * 获取两个日期之间间隔多少工作�?.
	 * </pre>
	 * 
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getWorkDays(Date start, Date end) {
		int works = 1;
		DateTime startDate = new DateTime(start);
		DateTime endDate = new DateTime(end);
		if (startDate.isBefore(endDate)) {
			while (endDate.compareTo(startDate) > 0) {
				startDate = startDate.plusDays(1);
				if (startDate.dayOfWeek().get() != 6
						&& startDate.dayOfWeek().get() != 7) {
					works++;
				}
			}
		} else if (startDate.isEqual(endDate)) {
			works = 1;
		} else {
			works = -1;
			while (startDate.compareTo(endDate) > 0) {
				startDate = startDate.plusDays(-1);
				if (startDate.dayOfWeek().get() != 6
						&& startDate.dayOfWeek().get() != 7) {
					works--;
				}
			}
		}
		return works;
	}

	/**
	 * <pre>
	 * 获取指定日期增加天数后的日期.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @param plusDays
	 *            the plus days
	 * @return the date
	 * @author chenhaobin 2013-4-3
	 */
	public static Date getPlusDay(Date date, int plusDay) {
		return new DateTime(date).plusDays(plusDay).toDate();
	}

	/**
	 * 获取指定日期增加月数后的日期. DateUtil.getPlusMonth()<BR>
	 * <P>
	 * Author : LiuJianHua
	 * </P>
	 * <P>
	 * Date : 2013-6-18
	 * </P>
	 * 
	 * @param date
	 * @param plusMonth
	 * @return
	 */
	public static Date getPlusMonth(Date date, int plusMonth) {
		return new DateTime(date).plusMonths(plusMonth).toDate();
	}

	/**
	 * <pre>
	 * 获取指定日期减去天数后的日期.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @param minusDay
	 *            the minus day
	 * @return the Day
	 * @author chenhaobin 2013-4-3
	 */
	public static Date getMinusDay(Date date, int minusDay) {
		return new DateTime(date).minusDays(minusDay).toDate();
	}

	/**
	 * <pre>
	 * 计算两个日期相隔多少�?.
	 * </pre>
	 * 
	 * @param from
	 *            the from
	 * @param to
	 *            the to
	 * @return the int
	 * @author chenhaobin 2013-4-3
	 */
	public static int getDays(Date from, Date to) {
		LocalDate fromDate = new LocalDate(from);
		LocalDate toDate = new LocalDate(to);
		return Days.daysBetween(fromDate, toDate).getDays();
	}

	/**
	 * add by zhuqingjie 取当前时�?,精确到秒，并返回形如"20030401240000"的字符串
	 * 
	 * @return 当前时间字符�?
	 */
	public static String getCurrentDateTimeString() {
		Date dt = new Date();
		return convertTimeToString(dt);
	}

	/**
	 * add by zhuqingjie 将指定日期对象，转换为形�?"20030401240000"的字符串
	 * 
	 * @param time
	 *            将要转换的Date对象
	 * @return 转换后的字符�?
	 */
	public static String convertTimeToString(Date time) {
		SimpleDateFormat formatter3 = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter3.format(time).trim();
	}

	/**
	 * 获取当前时间到第2�?0点的时间�?(毫秒)
	 */
	public static long getIntervalFromNow2TomorrowZeroHour(){
		Date date = new Date();
        Date date2 = DateUtil.getAfterDate(date, 1);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date3 = null;
        try {
        	date3 = format2.parse( format.format(date2) + "000000" );
		} catch (Exception e) {
			e.printStackTrace();
		}
        return date3.getTime() - date.getTime();
	}
	
	/**
	 * 获取当天0点的毫秒
	 */
	public static long getTodayZeroHourTimeMillis(){
		Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date3 = null;
        try {
        	date3 = format2.parse( format.format(date) + "000000" );
		} catch (Exception e) {
			e.printStackTrace();
		}
        return date3.getTime();
	}
	
	/**
	 * 从指定的日期加上指定的天数的日期
	 * 
	 * @param sDate
	 *            �?始日�?
	 * @param days
	 *            相隔天数
	 * @return 加上指定的天数后的日�?
	 */
	public static Date getAfterDate(Date date,int days){
        Calendar c = Calendar.getInstance();  
        c.setTime(date);
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day + days);  
        Date date2 = c.getTime();
        return date2;
	}
	
	/**
	 * 从指定的日期加上指定的月数的日期
	 * 
	 * @param sDate
	 *            �?始日�?
	 * @param n
	 *            相隔月数
	 * @return 加上指定的月数后的日�?
	 */
	public static Date getAfterMonth(Date date,int n){
        Calendar c = Calendar.getInstance();  
        c.setTime(date);
        int month = c.get(Calendar.MONTH);  
        c.set(Calendar.MONTH, month + n);  
        Date date2 = c.getTime();
        return date2;
	}
	
	/**
	 * <pre>
	 * 将指定日期输出为yyyy-MM-dd HH格式字符�?.
	 * </pre>
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @author chenhaobin 2013-4-3
	 */
	public static String getSpeDateString(Date date) {
		return new DateTime(date).toString("yyyy-MM-dd HH");
	}
	/**
	 * 给定日期对象格式化为指定日期模式�?
	 * @param beginDate 日期实例
	 * @param pattern 日期模式�?
	 * @return rtnStr/null
	 */
	public static String fmtDate(Date beginDate, String pattern) {
		try {
			return null == beginDate ? null : new SimpleDateFormat(pattern).format(beginDate);
		} catch (Exception e) {
		}
		return null;
	}
	
	
	 /**
	    * 将时间转换成unix类型
	    * @param timeString
	    * @param format
	    * @return
	    */
	   public static Long Date2TimeStamp(String dateStr) {
	       try {
	           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	           return Long.valueOf(sdf.parse(dateStr).getTime() / 1000);
	       }
	       catch (Exception e) {
	    	   e.printStackTrace();
	       }
	       return 0L;
	   }
	   
	   /**
	     * Java将Unix时间戳转换成指定格式日期字符�?
	     * @param timestampString 时间�? 如："1473048265";
	     * @param formats 要格式化的格�? 默认�?"yyyy-MM-dd HH:mm:ss";
	     *
	     * @return 返回结果 如："2016-09-05 16:06:42";
	     */
	    public static String TimeStamp2Date(Long times) {
	    	 Long timestamp = times * 1000;
	         String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timestamp));
	         return date;
	    }
	    
		/**
		 * 获取不大于指定日期的、最近的偶数分钟，整数分�?
		 * 示例:
		 * "2017/01/01 10:03:59"  -- "2017/01/01 10:02:00"
		 * "2017/01/01 10:02:01"  -- "2017/01/01 10:02:00"
		 */
		public static Date getFloorEvenMinuteDate(Date dt){
			Calendar c= Calendar.getInstance();
			c.setTime(dt);
			//偶数分直接返回，奇数分则�?1返回
			c.set(Calendar.SECOND, 0);
			if( c.get(Calendar.MINUTE)%2!=0 ){
				c.set(Calendar.MINUTE, c.get(Calendar.MINUTE)-1);
			}
			return c.getTime();
		}
		
		//把分钟转换成时分的格式显�?
		public static  String remainTimeStr(int minutes){
	        int hour = minutes/60;
	        int minute= minutes%60;
	       return String.valueOf(hour)+"小时"+String.valueOf(minute)+"分钟";
	    }
		
		/**
		 * 获取分钟为偶数日�?  若当前为奇数，获取后面的偶数,若为偶数返回当前
		 * @param dt
		 * @author hm
		 * @return
		 */
		@SuppressWarnings("deprecation")
		public static Date getAfterEvenMinuteDate(Date dt){
			int minute = dt.getMinutes();
			if( minute % 2 != 0  ){
				dt.setMinutes( minute + 1 );
			}
			return dt;
		}
		
		public static Integer getAge(String birthday) throws Exception{
			if(birthday != null && !"".equals(birthday)){

		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        
		       Date birthDay = sdf.parse(birthday);
			    Calendar cal = Calendar.getInstance();
			    
		        if (cal.before(birthDay)) {
		            throw new IllegalArgumentException(
		                    "The birthDay is before Now.It's unbelievable!");
		        }
		        int yearNow = cal.get(Calendar.YEAR);
		        int monthNow = cal.get(Calendar.MONTH);
		        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		        cal.setTime(birthDay);
		 
		        int yearBirth = cal.get(Calendar.YEAR);
		        int monthBirth = cal.get(Calendar.MONTH);
		        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		 
		        int age = yearNow - yearBirth;
		 
		        if (monthNow <= monthBirth) {
		            if (monthNow == monthBirth) {
		                if (dayOfMonthNow < dayOfMonthBirth) age--;
		            }else{
		                age--;
		            }
		        }
		        return age;
				
			}else{
				return null;
			}
			
		}
		
		public static Integer getNominalAge(String birthday) throws Exception{
			if(birthday != null && !"".equals(birthday)){

		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        
		       Date birthDay = sdf.parse(birthday);
			    Calendar cal = Calendar.getInstance();
			    
		        if (cal.before(birthDay)) {
		            throw new IllegalArgumentException(
		                    "The birthDay is before Now.It's unbelievable!");
		        }
		        int yearNow = cal.get(Calendar.YEAR);
		        cal.setTime(birthDay);		 
		        int yearBirth = cal.get(Calendar.YEAR);		 
		        int age = yearNow - yearBirth;
		 
		        return age;
				
			}else{
				return null;
			}			
		}		
}
