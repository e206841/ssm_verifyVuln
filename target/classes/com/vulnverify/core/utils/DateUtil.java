package com.vulnverify.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 日期转换工具类
 * 
 * @author LiWenbin
 */
public class DateUtil {
	
	public static SimpleDateFormat getSdfDatetime1(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	public static SimpleDateFormat getSdfDatetime2(){
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	}
	public static Date parseDatetime(String dateStr) throws ParseException {
		Date datetime = null;
		try {
			datetime = getSdfDatetime1().parse(dateStr);
		} catch (ParseException e) {
			try {
				datetime = getSdfDatetime2().parse(dateStr);
			} catch (ParseException ee) {
				throw ee;
			}
		}
		return datetime;
	}
	public static SimpleDateFormat getSdfDate1(){
		return new SimpleDateFormat("yyyy-MM-dd");
	}
	public static SimpleDateFormat getSdfDate2(){
		return new SimpleDateFormat("yyyy/MM/dd");
	}
	public static Date parseDate(String dateStr) throws ParseException {
		Date date = null;
		try {
			date = getSdfDate1().parse(dateStr);
		} catch (ParseException e) {
			try {
				date = getSdfDate2().parse(dateStr);
			} catch (ParseException ee) {
				throw ee;
			}
		}
		return date;
	}
	public static SimpleDateFormat getSdfTime(){
		return new SimpleDateFormat("HH:mm:ss");
	}
	public static Date parseTime(String dateStr) throws ParseException {
		return getSdfTime().parse(dateStr);
	}

	public static String formatDatetime(Date date) {
		return getSdfDatetime1().format(date);
	}

	public static String formatDate(Date date) {
		return getSdfDate1().format(date);
	}
	public static String formatTime(Date date) {
		return getSdfTime().format(date);
	}

	/**
	 * 获取日期是星期几
	 * @param date
	 * @return week
	 * @author linan
	 */
	public static Integer getWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return week;
	}
	/**
	 * 获取日期是几号
	 * @param date
	 * @return day
	 * @author linan
	 */
	public static Integer getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	/**
	 * 获取日期的字符串类型开始时间
	 * @param date
	 * @return String
	 * @author linan
	 */
	public static String getStartTime(Date date) {
		String startTime = getSdfDate1().format(date)+ " 00:00:00";
		return startTime;
	}
	/**
	 * 获取日期的字符串类型结束时间
	 * @param date
	 * @return String
	 * @author linan
	 */
	public static String getEndsTime(Date date) {
		String startTime = getSdfDate1().format(date)+ " 23:59:59";
		return startTime;
	}
	/**
	 * 获取日期的日期类型开始时间
	 * @param date
	 * @return Date
	 * @throws ParseException 
	 * @author linan
	 */
	public static Date getStartTimeStr(Date date) throws ParseException {
		String startTime = getSdfDate1().format(date)+ " 00:00:00";
		Date parse = getSdfDatetime1().parse(startTime);
		return parse;
	}
	/**
	 * 获取日期的日期类型结束时间
	 * @param date
	 * @return Date
	 * @throws ParseException 
	 * @author linan
	 */
	public static Date getEndsTimeStr(Date date) throws ParseException {
		String startTime = getSdfDate1().format(date)+ " 23:59:59";
		Date parse = getSdfDatetime1().parse(startTime);
		return parse;
	}

	/**
	 * 获取日期是几分钟
	 * @param date
	 * @return int
	 */
	public static int getMinuteByDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int minute = calendar.get(Calendar.MINUTE);
		return minute;
	}

	/**
	 * 获取日期是几小时
	 * @param date
	 * @return int
	 */
	public static int getHourByDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		return hour;
	}

	/**
	 * 获取日期是几秒
	 * @param date
	 * @return int
	 */
	public static int getSecondByDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int second = calendar.get(Calendar.SECOND);
		return second;
	}
	/**
	 * 获取本月开始时间
	 * @return
	 */
	public static String getMonthStartDate(){
       String firstday=null;  
       Calendar cale = Calendar.getInstance();  
       cale.add(Calendar.MONTH, 0);  
       cale.set(Calendar.DAY_OF_MONTH, 1);  
       firstday = getSdfDate1().format(cale.getTime())+" 00:00:00";  
       return firstday;
	}
	/**
	 * 获取本月结束时间
	 * @return
	 */
	public static String getMonthEndDate(){
		String lastday=null;
		Calendar cale = Calendar.getInstance();  
        cale.add(Calendar.MONTH, 1);  
        cale.set(Calendar.DAY_OF_MONTH, 0);  
        lastday = getSdfDate1().format(cale.getTime())+" 23:59:59";  
        return lastday;
	}
	/**
	 * 获取近12个月份
	 */
	public static List<Integer> getMonthBefer12(){
		List<Integer> monthList=new ArrayList<Integer>();
		Calendar calendar=Calendar.getInstance();
		int nowMonth=calendar.get(Calendar.MONDAY)+1;
		monthList.add(nowMonth);
		for(int i=0;i<11;i++){
			if(nowMonth==1){
				nowMonth=12;
				monthList.add(12);
			}else{
				nowMonth=nowMonth-1;
				monthList.add(nowMonth);
			}
		}
		Collections.reverse(monthList);
		return monthList;
	}
	/**
	 * 获取当前年份
	 * @return
	 */
	public static int getYear(){
		Calendar calendar=Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		return year;
	}
	
	/**
	 * 获取当前月
	 * @return
	 */
	public static int getMonth(){
		Calendar calendar=Calendar.getInstance();
		int month=calendar.get(Calendar.MONTH)+1;
		return month;
	}
	
	/**
	 * @return	最近的12个月（附带年份,返回集合）
	 */
	public static  List<String> getLast12MonthsList(){  
        
        List<String> last12Months=new ArrayList<String>();
        Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1); //要先+1,才能把本月的算进去</span>  
        for(int i=0; i<12; i++){  
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1); //逐次往前推1个月  
            String month = String.format("%2d",cal.get(Calendar.MONTH)+1);
            last12Months.add(cal.get(Calendar.YEAR)+ "-" + month.trim());  
            
        }  
        Collections.reverse(last12Months);
        return last12Months;  
    }
	/*
	 * @return	最近的12个月（附带年份,返回数组）
	 */
	public static  String[] getLast12Months(){  
       
		String[] last12Months = new String[12];  
       Calendar cal = Calendar.getInstance();  
       for(int i=0; i<12; i++){  
           last12Months[11-i] =cal.get(Calendar.YEAR)+ "-" + String.format("%02d",cal.get(Calendar.MONTH)+1);  
           cal.add(Calendar.MONTH, -1); //逐次往前推1个月  
       }  
       return last12Months;  
   }
	public static void main(String[] args) {
		Integer integer=2017;
		Integer bInteger=2017;
		System.out.println(integer==bInteger);
	}
}
