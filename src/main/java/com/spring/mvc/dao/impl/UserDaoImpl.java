package com.spring.mvc.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.UserDao;
import com.spring.mvc.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	
	Map<String,User> userDatabase = new HashMap<>();
	@Override
	public void saveUser(User user) {

		userDatabase.put(user.getName(), user);
		System.out.println(user.getName()+ "detail saved");
	}
	@Override
	public User authenticateUser(String name, String password) {
		User user=userDatabase.get(name);
        if(user.getPassword().equals(password)) {
        	return user;
        }
        
        
		return null;
	}

}
