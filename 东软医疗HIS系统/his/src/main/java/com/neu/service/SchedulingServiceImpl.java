package com.neu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.SchedulingMapper;
import com.neu.po.Scheduling;
import com.neu.po.SchedulingExample;
@Service
public class SchedulingServiceImpl implements SchedulingService {

	@Autowired
	private SchedulingMapper schedulingMapper;
	
	@Override
	public List<Scheduling> getByA(String noon,int deptId) {
		SchedulingExample example = new SchedulingExample();
		
		example.or().andNoonEqualTo(noon).andDepartMentEqualTo(deptId);

		return schedulingMapper.selectByExample(example);
	}

	@Override
	public List<Scheduling> getByDate(Date date) {
//		SchedulingExample example = new SchedulingExample();
//		
//		example.or().andScheddateEqualTo(date);
		
		return schedulingMapper.getByDate(date);
	}

	@Override
	public List<Scheduling> getByDateAndNoon(Date date, String noon) {
//		SchedulingExample example = new SchedulingExample();
//		
//		example.or().andScheddateEqualTo(date).andNoonEqualTo(noon);
		
		return schedulingMapper.getByDateAndNoon(date, noon);
	}

	@Override
	public List<Scheduling> getByDateAndNoonAndDeptId(Date date, String noon, int deptId) {
//		SchedulingExample example = new SchedulingExample();
//		
//		example.or().andScheddateEqualTo(date).andNoonEqualTo(noon).andDepartmentEqualTo(deptId);
		
		return schedulingMapper.getByDateAndNoonAndDeptId(date, noon, deptId);
	}

	@Override
	public List<Scheduling> getByDateAndNoonAndDeptIdAndRelId(Date date, String noon, int deptId, int relId) {
		
		return schedulingMapper.getByDateAndNoonAndDeptIdAndRelId(date, noon, deptId, relId);
	}


}
