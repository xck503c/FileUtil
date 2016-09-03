package com.service;

import java.util.concurrent.ForkJoinPool;

import com.entity.task.FileSizeTask;

public class FileSizeTaskService extends BaseService{
	
	public static ForkJoinPool forJoinPool;
	private static FileSizeTaskService service = null;
	
	static{
		forJoinPool = new ForkJoinPool();
		service = new FileSizeTaskService();
	}
	
	public static FileSizeTaskService getInterface(){
		return service;
	}

	@Override
	public void launch(Object o) {
		FileSizeTask fileSizeTask = (FileSizeTask)o;
		long total = FileSizeTaskService.forJoinPool.invoke(fileSizeTask);
		System.out.println("Total Size: " + total);
	}
}
