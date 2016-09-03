package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mapper.ObjectMapper;

public class PropertiesUtil {
	public static Object setProperties(){
		try {
			InputStream is = ClassLoader.getSystemResourceAsStream("config.properties");
			Properties properties = new Properties();
			properties.load(is);
			String task = properties.getProperty("task.taskType");
			if(task.equals("FindFile")){
				return ObjectMapper.fileFinderMapper(properties);
			}else if(task.equals("FileSize")){
				return ObjectMapper.FileSizeTaskMapper(properties);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
