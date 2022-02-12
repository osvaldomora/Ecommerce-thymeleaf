package com.spring.mvc.dao;

import com.spring.mvc.model.User;

public interface UserDao {

	void saveUser(User user);

	User authenticateUser(String name, String password);

}
