package com.mapper;

import java.io.File;
import java.util.Properties;

import com.entity.BaseEntity;
import com.entity.DirEntity;
import com.entity.FileEntity;
import com.entity.finder.FileFinder;
import com.entity.task.FileSizeTask;
import com.entity.task.FindFileTask;
import com.util.DateUtil;
import com.util.StringUtil;

public class ObjectMapper {
	public static BaseEntity fileMapper(File file){
		BaseEntity baseEntity = null;
		if(file.isDirectory()){
			baseEntity = new DirEntity();
			//��ȡ����޸�ʱ��
			baseEntity.setFileLastDate(DateUtil.tranDate(file));
			//�ļ�����
			baseEntity.setFileName(file.getName());
			//�ļ�·��
			baseEntity.setFilePathName(StringUtil.getFilePath(file.getAbsolutePath()));
			//�ļ���С
			baseEntity.setFileSize(file.length());
			
			return baseEntity;
		}else{
			baseEntity = new FileEntity();
			//��ȡ����޸�ʱ��
			baseEntity.setFileLastDate(DateUtil.tranDate(file));
			//�ļ�����
			baseEntity.setFileName(file.getName());
			//�ļ�·��
			baseEntity.setFilePathName(StringUtil.getFilePath(file.getAbsolutePath()));
			//�ļ���С
			baseEntity.setFileSize(file.length());
			
			return baseEntity;
		}
	}
	
	public static FileFinder fileFinderMapper(Properties properties){
		FileFinder fileFinder = new FileFinder();
		fileFinder.setStr(properties.getProperty("task.searchName"));
		fileFinder.setSearchPlace(properties.getProperty("task.begainPlace"));
		fileFinder.setSavePlace(properties.getProperty("task.savePlace"));
		FindFileTask.setFileFinder(fileFinder);
		return fileFinder;
	}
	
	public static FileSizeTask FileSizeTaskMapper(Properties properties){
		String filePath = properties.getProperty("task.filePath");
		File file = new File(filePath);
		FileSizeTask fileSizeTask = new FileSizeTask(file);
		return fileSizeTask;
	}
}
