package com.service;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

import com.entity.BaseEntity;
import com.entity.BaseEntity.FileType;
import com.entity.finder.FileFinder;
import com.entity.task.FindFileTask;
import com.mapper.ObjectMapper;
import com.util.IOUtil;
import com.util.PropertiesUtil;
import com.util.StringUtil;

public class FindFileTaskService extends BaseService {
	
	public static ForkJoinPool forJoinPool;
	private static FindFileTaskService service = null;
	
	static{
		forJoinPool = new ForkJoinPool();
		service = new FindFileTaskService();
	}
	
	public static FindFileTaskService getInterface(){
		return service;
	}
	
	public static BaseEntity isFind(File file){
		String fileName = file.getName();
//		int indexOfPoint = name.lastIndexOf(".");
//		if(indexOfPoint != -1){
//			String fileName = name.substring(0, indexOfPoint);
//			String suffix = name.substring(fileName.lastIndexOf(".") + 1);
//			if(fileName.equals(Task.getFileFinder().getStr())){
//				return FileMapper.fileMapper(file);
//			}
//		}else{
//			if(name.equals(Task.getFileFinder().getStr())){
//				return FileMapper.fileMapper(file);
//			}
//		}
		if(StringUtil.matchFileNameOfPart(FindFileTask.getFileFinder().getStr(), fileName)){
			System.out.println(StringUtil.getFilePath(file.getAbsolutePath()));
			return ObjectMapper.fileMapper(file);
		}
		return null;
	}
	
	@Override
	public void launch(Object o) {
		FileFinder fileFinder = (FileFinder)o;
		forJoinPool.invoke(new FindFileTask(new File(fileFinder.getSearchPlace())));
		System.out.println("保存是否成功: " + IOUtil.saveFileFinderPath(fileFinder));
	}
}
