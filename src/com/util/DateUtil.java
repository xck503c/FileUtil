package com.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	
	/*
	 * 返回文件修改最后时间：时间形式  年-月  日-时:分:秒
	 * */
	public static String tranDate(File file){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		long time = file.lastModified();
		cal.setTimeInMillis(time);
		String date = dateFormat.format(cal.getTime());
		return date;
	}
}
