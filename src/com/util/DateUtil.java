package com.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	
	/*
	 * �����ļ��޸����ʱ�䣺ʱ����ʽ  ��-��  ��-ʱ:��:��
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
