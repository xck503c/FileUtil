package com.service;

import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import com.entity.BaseEntity;

public abstract class BaseService{
	
	protected BaseEntity entity;
	
	public BaseService(){}
	
	public abstract void launch(Object o);
}
