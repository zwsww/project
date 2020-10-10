package com.neu.service;

import java.util.List;

import com.neu.po.Menu;

public interface MenuService {

	 List<Menu> getByRoleId(int roleId);
}
