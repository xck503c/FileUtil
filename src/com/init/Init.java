package com.init;

import com.entity.finder.FileFinder;
import com.entity.task.FileSizeTask;
import com.service.FileSizeTaskService;
import com.service.FindFileTaskService;
import com.util.PropertiesUtil;

public class Init {

	public static void launch(){
		final long start = System.nanoTime();
		Object o = PropertiesUtil.setProperties();
		if(o != null){
			if(o instanceof FileFinder){
				FindFileTaskService.getInterface().launch(o);
			}else if(o instanceof FileSizeTask){
				FileSizeTaskService.getInterface().launch(o);
			}
		}
		final long end = System.nanoTime();
		System.out.println("Time taken: " + (end - start)/1.0e9);
	}
	
	public static void main(String[] args) {
		launch();
	}
}
