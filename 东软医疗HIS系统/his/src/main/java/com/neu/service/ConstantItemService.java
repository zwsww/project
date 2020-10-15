package com.neu.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.neu.po.ConstantItem;
import com.neu.vo.ConstantItemSearch;

public interface ConstantItemService {

	PageInfo<ConstantItem> getPaged(ConstantItemSearch item);
	
	int batchDelete(List<Integer> ids);
	
	List<ConstantItem> getAll(int id);
	
	List<ConstantItem> getSex();
	
	List<ConstantItem> getCharge();
}
