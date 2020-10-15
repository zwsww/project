package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.SettleCategoryMapper;
import com.neu.po.SettleCategory;
@Service
public class SettleCategoryServiceImpl implements SettleCategoryService {

	@Autowired
	private SettleCategoryMapper settlecategoryMapper;
	
	@Override
	public List<SettleCategory> getAll() {
		
		return settlecategoryMapper.getAll();
	}

}
