package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.mapper.ConstantTypeMapper;
import com.neu.po.ConstantType;
import com.neu.po.ConstantTypeExample;
import com.neu.po.ConstantTypeExample.Criteria;

@Service
public class ConstantTypeServiceImpl implements ConstantTypeService {
	
	@Autowired
	private ConstantTypeMapper constantTypeMapper;

	@Override
	public PageInfo<ConstantType> getPaged(int pageNum, int pageSize,String keyword) {
		ConstantTypeExample example = new ConstantTypeExample();
		Criteria c1 = example.createCriteria();
		Criteria c2 = example.createCriteria();
		
		c1.andDelmarkEqualTo(1).andConstanttypecodeLike("%"+keyword+"%");
		c2.andDelmarkEqualTo(1).andConstanttypenameLike("%"+keyword+"%");
		
		example.or(c2);
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<ConstantType> list = constantTypeMapper.selectByExample(example);
		
		PageInfo<ConstantType> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public int update(ConstantType constantType) {
		
		return constantTypeMapper.updateByPrimaryKey(constantType);
	}

	@Override
	public int delete(int id) {
		return constantTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ConstantType constantType) {
		return constantTypeMapper.insert(constantType);
	}

	@Override
	public List<ConstantType> getAll() {
		ConstantTypeExample example = new ConstantTypeExample();
		
		return constantTypeMapper.selectByExample(example);
	}

}
