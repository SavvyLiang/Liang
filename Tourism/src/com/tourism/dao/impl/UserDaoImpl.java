package com.tourism.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tourism.dao.BaseDao;
import com.tourism.entity.User;

@Repository
public class UserDaoImpl extends BaseDao<User> {
	@SuppressWarnings("unchecked")
	public List getAllUser() {
		String hql = "from User user order by user.id asc";
		List resultList = executeQuery(hql);
		if (resultList.isEmpty())
			return new ArrayList();
		else {
			return resultList;
		}
	}
	
	public int getUserId () {
		String hql = "select max(user.id) from User user ";
		List resultList = executeQuery(hql);
		if (resultList.isEmpty() || resultList.size() == 0 || (resultList.size() == 1 && resultList.get(0) == null))
			return 1000;
		else {
			return (Integer) resultList.get(resultList.size() - 1);
		}
	}
}
