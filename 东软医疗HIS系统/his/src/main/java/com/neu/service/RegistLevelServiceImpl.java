package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.RegistLevelMapper;
import com.neu.po.RegistLevel;
@Service
public class RegistLevelServiceImpl implements RegistLevelService {

	@Autowired
	private RegistLevelMapper registlevelMapper;
	
	@Override
	public List<RegistLevel> getAll() {
		
		return registlevelMapper.getAll();
	}

}
