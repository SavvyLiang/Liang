package com.tourism.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tourism.dao.impl.UserDaoImpl;
import com.tourism.entity.User;

@Service
public class UserService extends BaseService<User> {
	@Resource
	private UserDaoImpl _userDaoImpl;
	@Resource
	public void setDao(UserDaoImpl dao){
		super.setBaseDao(dao);
	}
	public int getUserId() {
		return _userDaoImpl.getUserId();
	}
	
	public List findAllUser() {
		return _userDaoImpl.getAllUser();
	}
	
	public User saveToTable(User user) throws Exception {
		super.save(user);
		User userTwo = user;
		userTwo.setId(53);
		delete(userTwo);
		return user;
	}
	
}
