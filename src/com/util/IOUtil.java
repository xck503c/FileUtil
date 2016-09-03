package com.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.entity.BaseEntity;
import com.entity.finder.FileFinder;
import com.entity.task.FindFileTask;

public class IOUtil {
	
	public static boolean saveFileFinderPath(FileFinder fileFinder){
		File file = new File(fileFinder.getSavePlace());
		try (FileWriter fw = new FileWriter(file)){
			
			for(BaseEntity entity : FindFileTask.list){
				fw.write(entity.getFilePathName() + "\r\n");
				fw.flush();
			}
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}
