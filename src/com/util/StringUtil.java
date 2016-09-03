package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.entity.task.FindFileTask;

public class StringUtil{
	
	/*
	 * �����ַ���ƥ��
	 * @param str Ҫƥ����ַ���
	 * @param fileName ���������ļ���
	 * @return boolean
	 * */
	public static boolean matchFileNameOfPart(String str, String fileName){
		String line = ".*"+ str +".*";
		Pattern p = Pattern.compile(line);
		Matcher mathcher = p.matcher(fileName);
		if(mathcher.find()){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*
	 * ȫ��ƥ��
	 * @param str
	 * @param fileName
	 * @return boolean
	 * */
	public static boolean matchFileNameOfAll(String str, String fileName){
		if(fileName.equals(str)){
			return true;
		}
		return false;
	}
	
	public static String getFilePath(String absolutePath){
		if(absolutePath != null && !absolutePath.equals("")){
			int index = FindFileTask.getFileFinder().getSearchPlace().length();
			absolutePath = absolutePath.substring(index + 1);
			return absolutePath;
		}
		
		return "";
	}
}
