package com.neu.service;

import java.util.List;

import com.neu.po.User;

public interface UserService {

	User login(String username ,String password);
	
	List<User> getAll();
}
