package com.tourism.service;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import com.tourism.dao.BaseDao;

public class BaseService<T extends Serializable> {
	private BaseDao<T> _baseDao;
	public T save(T entity) throws Exception{
		return _baseDao.save(entity);
	}
	
	public void update(Object entity) {
		_baseDao.update(entity);
	}
	
	public void saveOrUpdate(Object entity) {
		_baseDao.saveOrUpdate(entity);
	}
	
	public void delete(Object entity) {
		_baseDao.delete(entity);
	}
	
	public void deleteById(Serializable id) {
		_baseDao.delete(load(id));
	}

	public T get(Serializable id) {
		T entity = (T)_baseDao.get(id);
		return entity;
	}
	
	public T load(Serializable id) {
		T entity = (T)_baseDao.load(id);
		return entity;
	}
	
	public BaseDao getBaseDao() {
		return _baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		_baseDao = baseDao;
	}
	
}
