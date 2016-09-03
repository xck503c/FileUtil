package com.entity.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FileSizeTask extends RecursiveTask<Long> implements BaseTask<Long>{

	private File file;
	
	public FileSizeTask(File file){
		this.file = file;
	}
	
	@Override
	protected Long compute() {
		return task();
	}
	
	@Override
	public Long task() {
		long size = 0;
		if(file.isFile()){
			size = file.length();
		}else{
			File [] children = file.listFiles();
			if(children != null){
				List<ForkJoinTask<Long>> tasks = new ArrayList<>();
				for(File child : children){
					if(child.isFile()){
						size += child.length();
					}else{
						tasks.add(new FileSizeTask(child));
					}
				}
				
				for(ForkJoinTask<Long> t : invokeAll(tasks)){
					size += t.join();
				}
			}
		}
		return size;
	}
}
