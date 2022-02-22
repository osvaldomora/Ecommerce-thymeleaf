package com.spring.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.UserDao;
import com.spring.mvc.model.User;
import com.spring.mvc.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	static int count=0;
	
	@Autowired
	private UserDao userDao;
	@Override
	public void saveUser(User user) {
		
		userDao.saveUser(user);
		
	}
	@Override
	public User authenticateUser(String name, String password) {

		return userDao.authenticateUser(name,password);
	}

}
