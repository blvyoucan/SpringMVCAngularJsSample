package com.sucsoft.sample.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sucsoft.sample.dao.BaseDao;

public abstract class BaseService<T extends Serializable> {

	@Autowired
	private BaseDao<T> dao;
	
	@Transactional(readOnly=true)
	public List<T> queryAll(){
		return dao.queryAll();
	}
	
	@Transactional
	public String add(T entity){
		return  dao.add(entity);
	}
	
	@Transactional
	public void del(String id){
		dao.del(id);
	}
	
	@Transactional(readOnly=true)
	public T query(String id){
		return dao.query(id);
	}
}
