package com.spring.mvc.service;

import com.spring.mvc.model.User;

public interface UserService {

	void saveUser(User user);

	User authenticateUser(String name, String password);

}
