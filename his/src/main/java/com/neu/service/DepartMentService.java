package com.neu.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.neu.po.DepartMent;


public interface DepartMentService {

	PageInfo<DepartMent> getPaged(int pageNum,int pageSize,String keyword);
	
	List<DepartMent> getAll();
	
	int insert(DepartMent departMent);
	
	int update(DepartMent departMent);
	
	int delete(int id);
	
	int batchDelete(List<Integer> ids);
}
