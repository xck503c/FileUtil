package com.entity;

import java.util.Date;

public abstract class BaseEntity {
	protected String fileName; //�ļ�����
	public final static FileType fileType = FileType.DEFAULT; //�ļ�����
	protected long fileSize; //�ļ���С
	protected String fileLastDate; //�ļ���������
	protected String filePathName; //�ļ�·��
	
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
