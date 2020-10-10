package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.po.Menu;
import com.neu.po.ResponseResult;
import com.neu.service.MenuService;

@RestController
@RequestMapping("role")
public class RoleController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("getMenuByRoleId")
	public ResponseResult getMenuByRoleId(int roleId) {
		ResponseResult result = new ResponseResult();
		List<Menu> list = menuService.getByRoleId(roleId);
		
		result.setData(list);
		
		return result;
	}
}
