package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.MenuMapper;
import com.neu.po.Menu;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> getByRoleId(int roleId) {
		
		return menuMapper.getByRoleId(roleId);
	}

}
