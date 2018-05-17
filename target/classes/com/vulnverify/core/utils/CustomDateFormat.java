package com.vulnverify.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期格式类，在objectmapper反序列化时使用
 * @author LiWenbin
 */
public class CustomDateFormat extends SimpleDateFormat {
	
	private static final long serialVersionUID = -2558609660869037379L;

	@Override
	public Date parse(String dateStr) throws ParseException{
		String[] patterns = new String[]{"yyyy-MM-dd HH:mm:ss",
				"yyyy/MM/dd HH:mm:ss","yyyy-MM-dd","yyyy/MM/dd",
				"HH:mm:ss","HH:mm"};
		Date date = null;
		for(String pattern : patterns){
			try{
				super.applyPattern(pattern);
				date = super.parse(dateStr);
			}catch(ParseException e){
			}
			if(date != null){
				break;
			}
		}
		if(date == null){
			throw new ParseException("only support "+patterns.toString(),-1);
		}
		return date;
	}
}
