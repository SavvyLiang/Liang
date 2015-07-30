package com.tourism.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BaseDao<T extends Serializable> {
	@Resource
	private SessionFactory _sessionFactory;
	
	public Session getSession() {
		Session session = _sessionFactory.getCurrentSession();
		return session;
	}
	
	private Class<T> _className;
	
	@SuppressWarnings("unchecked")
	public BaseDao() {
		_className = (Class<T>)((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T save(T entity) {
		getSession().save(entity);
		return entity;
	}
	
	public void update(Object entity){
		getSession().update(entity);
	}
	
	public void saveOrUpdate(Object entity) {
		getSession().saveOrUpdate(entity);
	}
	public void delete(Object entity) {
		getSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		T entity = (T)getSession().get(_className, id);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public T load(Serializable id) {
		T entity = (T)getSession().load(_className, id);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	protected List executeQuery(String hql, Object... values) { 
		Query query = getSession().createQuery(hql);  
        for (int i = 0; values != null && i < values.length; i++) {    
            query.setParameter(i, values[i]);  
        } 
        return query.list();
	}

}
