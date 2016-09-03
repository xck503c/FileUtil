package com.entity.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import com.entity.BaseEntity;
import com.entity.finder.FileFinder;
import com.service.FindFileTaskService;;

public class FindFileTask extends RecursiveTask<File> implements BaseTask<File>{
	
	public static List<BaseEntity> list;
	private static FileFinder fileFinder;
	private File file;
	
	public FindFileTask(File file){
		this.file = file;
	}
	
	static{
		list = new ArrayList<BaseEntity>();
	}

	@Override
	protected File compute() {
		return task();
	}
	
	public static void setFileFinder(FileFinder fileFinder) {
		FindFileTask.fileFinder = fileFinder;
	}

	public static FileFinder getFileFinder() {
		return fileFinder;
	}
	
	/*
	 * Ñ°ÕÒÆ¥ÅäÎÄ¼þÃû
	 * */
	public File task(){
		addFileInList(file);
		
		File [] children = file.listFiles();
		if(children != null){
			List<ForkJoinTask<File>> tasks = new ArrayList<>();
			for(File child : children){
				if(child.isFile()){
					addFileInList(child);
				}else{
					tasks.add(new FindFileTask(child));
				}
			}
				
			for(ForkJoinTask<File> task : invokeAll(tasks)){
				File temp;
				try {
					temp = task.get();
					addFileInList(temp);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		
		return file;
	}
	
	public void addFileInList(File file){
		if(file != null){
			BaseEntity baseEntity = FindFileTaskService.isFind(file);
			if(baseEntity != null){
				list.add(baseEntity);
			}
		}
	}

}
