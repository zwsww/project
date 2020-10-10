package com.neu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.UserMapper;
import com.neu.po.User;
import com.neu.po.UserExample;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(String username, String password) {
		UserExample example = new UserExample();
		example.or().andUsernameEqualTo(username)
			.andPasswordEqualTo(password).andDelmarkEqualTo(1);
		if(userMapper.selectByExample(example).size()>0) {
			return userMapper.selectByExample(example).get(0);
		}
		return null;
	}

}
