package com.neu.service;

import java.util.Date;
import java.util.List;

import com.neu.po.Scheduling;

public interface SchedulingService {
	List<Scheduling> getByA(String noon,int deptId);
	
	List<Scheduling> getByDate(Date date);
	
	List<Scheduling> getByDateAndNoon(Date date,String noon);
	
	List<Scheduling> getByDateAndNoonAndDeptId(Date date,String noon,int deptId);
	
	List<Scheduling> getByDateAndNoonAndDeptIdAndRelId(Date date, String noon, int deptId, int relId);
	
	
}
