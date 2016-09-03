package test.com.entity.task;

import java.io.File;

import com.entity.task.FileSizeTask;
import com.service.FileSizeTaskService;

public class FileSizeTaskTest {
	public static void main(String[] args){
		final long start = System.nanoTime();
		long total = FileSizeTaskService.forJoinPool.invoke(new FileSizeTask(new File("D:/xck")));
		final long end = System.nanoTime();
		System.out.println("Time taken: " + (end - start)/1.0e9);
		System.out.println("Total Size: " + total);
	}
}
