package com.neu.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.neu.po.ConstantType;

public interface ConstantTypeService {
	PageInfo<ConstantType> getPaged(int pageNum,int pageSize,String keyword);
	
	int update(ConstantType constantType);
	
	int delete(int id);
	
	int insert(ConstantType constantType);
	
	List<ConstantType> getAll();
}
