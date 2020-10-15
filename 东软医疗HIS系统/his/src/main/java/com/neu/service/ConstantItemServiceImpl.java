package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.mapper.ConstantItemMapper;
import com.neu.po.ConstantItem;
import com.neu.po.ConstantItemExample;
import com.neu.po.ConstantItemExample.Criteria;
import com.neu.vo.ConstantItemSearch;

@Service
public class ConstantItemServiceImpl implements ConstantItemService {
	@Autowired
	private ConstantItemMapper constantItemMapper;

	@Override
	public PageInfo<ConstantItem> getPaged(ConstantItemSearch item) {
		PageHelper.startPage(item.getPageNum(),item.getPageSize());
		
		ConstantItemExample example = new ConstantItemExample();
		Criteria c1 = example.createCriteria();
		Criteria c2 = example.createCriteria();
		example.or(c2);
		
		if(item.getCodeOrName() != null) {
			c1.andCodeLike("%"+item.getCodeOrName()+"%").andDelmarkEqualTo(1);
		}else {
			c1.andDelmarkEqualTo(1);
		}
		
		if(item.getTypeId() != null) {
			c1.andTypeEqualTo(item.getTypeId());
		}
		
		if(item.getCodeOrName() != null) {
			c2.andNameLike("%"+item.getCodeOrName()+"%").andDelmarkEqualTo(1);
		}else {
			c2.andDelmarkEqualTo(1);
		}
		
		if(item.getTypeId() != null) {
			c2.andTypeEqualTo(item.getTypeId());
		}
		List<ConstantItem> list = constantItemMapper.selectByExample(example);
		
		PageInfo<ConstantItem> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public int batchDelete(List<Integer> ids) {
		ConstantItemExample example = new ConstantItemExample();
		example.or().andIdIn(ids);
	
		return constantItemMapper.deleteByExample(example);
	}

	@Override
	public List<ConstantItem> getAll(int id) {
		ConstantItemExample example = new ConstantItemExample();
		example.or().andTypeEqualTo(id);
		
		return constantItemMapper.selectByExample(example);
	}

	@Override
	public List<ConstantItem> getSex() {
		// TODO Auto-generated method stub
		return constantItemMapper.getSex();
	}

	@Override
	public List<ConstantItem> getCharge() {
		// TODO Auto-generated method stub
		return constantItemMapper.getCharge();
	}

}
