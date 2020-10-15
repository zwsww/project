package com.neu.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.neu.po.DepartMent;


public interface DepartmentService {
	PageInfo<DepartMent> getPaged(int pageNum,int pageSize,String keyword);
	
	int batchDelete(List<Integer> ids);
	
	int insert(DepartMent department);
	
	int update(DepartMent department);
	
	int delete(int id);
	
	List<DepartMent> getAll();
}
