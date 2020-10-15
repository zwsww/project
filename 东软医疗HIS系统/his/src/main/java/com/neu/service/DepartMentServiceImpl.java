package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.mapper.DepartMentMapper;
import com.neu.po.DepartMent;
import com.neu.po.DepartMentExample;
import com.neu.po.DepartMentExample.Criteria;


@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartMentMapper departmentMapper;

	@Override
	public PageInfo<DepartMent> getPaged(int pageNum,int pageSize,String keyword) {
		DepartMentExample example = new DepartMentExample();
		Criteria c1 = example.createCriteria();
		Criteria c2 = example.createCriteria();
		
		c1.andDelmarkEqualTo(1).andDeptcodeLike("%"+keyword+"%");
		c2.andDelmarkEqualTo(1).andDeptnameLike("%"+keyword+"%");
		
		example.or(c2);
		
		PageHelper.startPage(pageNum,pageSize);
		
		List<DepartMent> list = departmentMapper.selectByExample(example);
		
		PageInfo<DepartMent> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public int batchDelete(List<Integer> ids) {
		DepartMentExample example = new DepartMentExample();
		example.or().andIdIn(ids);

		return departmentMapper.deleteByExample(example);
	}

	@Override
	public int insert(DepartMent department) {
		return departmentMapper.insert(department);
	}

	@Override
	public int update(DepartMent department) {
		return departmentMapper.updateByPrimaryKey(department);
	}

	@Override
	public int delete(int id) {
		return departmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<DepartMent> getAll() {
		DepartMentExample example = new DepartMentExample();
		return departmentMapper.selectByExample(example);
	}

}
