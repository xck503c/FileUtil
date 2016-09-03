package com.entity;

import java.util.Date;

public abstract class BaseEntity {
	protected String fileName; //文件名字
	public final static FileType fileType = FileType.DEFAULT; //文件类型
	protected long fileSize; //文件大小
	protected String fileLastDate; //文件创建日期
	protected String filePathName; //文件路径
	
	public enum FileType{
		DEFAULT, DIR, FILE, PACKAGE, OTHER
	}
	
	@Override
	public String toString(){
		return "fileName: " + fileName
			+ " fileType: " + fileType
			+ " fileSize: " + fileSize
			+ " fileLastDate: " + fileLastDate
			+ " filePathName: " + filePathName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileLastDate() {
		return fileLastDate;
	}

	public void setFileLastDate(String fileLastDate) {
		this.fileLastDate = fileLastDate;
	}

	public String getFilePathName() {
		return filePathName;
	}

	public void setFilePathName(String filePathName) {
		this.filePathName = filePathName;
	}
}
