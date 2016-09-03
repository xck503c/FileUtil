package com.entity.finder;

import com.entity.BaseEntity;
import com.entity.BaseEntity.FileType;

public class FileFinder {
	private String str;  //需要匹配的字符串
	private String searchPlace; //寻找开始位置
	private String savePlace; //需要存放的位置
	
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
