package com.entity.finder;

import com.entity.BaseEntity;
import com.entity.BaseEntity.FileType;

public class FileFinder {
	private String str;  //��Ҫƥ����ַ���
	private String searchPlace; //Ѱ�ҿ�ʼλ��
	private String savePlace; //��Ҫ��ŵ�λ��
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getSearchPlace() {
		return searchPlace;
	}
	public void setSearchPlace(String searchPlace) {
		this.searchPlace = searchPlace;
	}
	public String getSavePlace() {
		return savePlace;
	}
	public void setSavePlace(String savePlace) {
		this.savePlace = savePlace;
	}
}
