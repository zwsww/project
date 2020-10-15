package com.neu.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.po.Register;
import com.neu.po.ResponseResult;
import com.neu.service.ConstantItemService;
import com.neu.service.DepartmentService;
import com.neu.service.RegistLevelService;
import com.neu.service.RegisterService;
import com.neu.service.SchedulingService;
import com.neu.service.SettleCategoryService;
import com.neu.service.UserService;

@RestController
@RequestMapping("register")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private ConstantItemService constantitemService;
	
	@Autowired
	private SettleCategoryService settlecategoryService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private RegistLevelService registlevelService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SchedulingService schedulingService;
	
	@RequestMapping("getAll")
	public ResponseResult getAll() {
		ResponseResult result = new ResponseResult();
		
		result.setData(registerService.getAll());
		
		return result;
	}
	
	//查性别
	@RequestMapping("selectSex")
	public ResponseResult selectSex() {
		ResponseResult result = new ResponseResult();
		
		result.setData(constantitemService.getSex());
		
		return result;
	}
	
	//查结算类别
	@RequestMapping("settleid")
	public ResponseResult settleid() {
		ResponseResult result = new ResponseResult();
		
		result.setData(settlecategoryService.getAll());
		
		return result;
	}
	
	//查科室
	@RequestMapping("selDepartment")
	public ResponseResult selDepartment() {
		ResponseResult result = new ResponseResult();
		
		result.setData(departmentService.getAll());
		
		return result;
	}
	
	//查挂号级别
	@RequestMapping("selRegistLevel")
	public ResponseResult selRegisterLevel() {
		ResponseResult result = new ResponseResult();
		
		result.setData(registlevelService.getAll());
		
		return result;
	}
	
	//查医生
	@RequestMapping("selDoctor")
	public ResponseResult selDoctor() {
		ResponseResult result = new ResponseResult();
		
		result.setData(userService.getAll());
		
		return result;
	}
	
	//结算方式
	@RequestMapping("getCharge")
	public ResponseResult getCharge() {
		ResponseResult result = new ResponseResult();
		
		result.setData(constantitemService.getCharge());
		
		return result;
	}
	
	@RequestMapping("insert")
	public ResponseResult insert(@RequestBody Register register) {
		ResponseResult result = new ResponseResult();
		register.setRegisttime(new Date());
		
		result.setData(registerService.insert(register));
		
		return result;
	}
	
	@RequestMapping("getByA")
	public ResponseResult getByA(String noon, int deptId) {
		ResponseResult result = new ResponseResult();
		
		result.setData(schedulingService.getByA(noon, deptId));
		
		return result;
	}
	
	@RequestMapping("getByDate")
	public ResponseResult getByDate(Date date) {
		ResponseResult result = new ResponseResult();
		
		result.setData(schedulingService.getByDate(date));
		
		return result;
	}
	
	@RequestMapping("getByDateAndNoon")
	public ResponseResult getByDateAndNoon(Date date, String noon) {
		ResponseResult result = new ResponseResult();
		
		result.setData(schedulingService.getByDateAndNoon(date, noon));
		
		return result;
	}
	
	@RequestMapping("getByDateAndNoonAndDeptId")
	public ResponseResult getByDateAndNoonAndDeptId(Date date, String noon, int deptId) {
		ResponseResult result = new ResponseResult();
		
		result.setData(schedulingService.getByDateAndNoonAndDeptId(date, noon, deptId));
		
		return result;
	}
	
	@RequestMapping("getByDateAndNoonAndDeptIdAndRelId")
	public ResponseResult getByDateAndNoonAndDeptIdAndRelId(Date date, String noon, int deptId, int relId) {
		ResponseResult result = new ResponseResult();
		
		result.setData(schedulingService.getByDateAndNoonAndDeptIdAndRelId(date, noon, deptId, relId));
		
		return result;
	}
	
	@RequestMapping("getByCaseNumber")
	public ResponseResult getByCaseNumber(String num) {
		ResponseResult result = new ResponseResult();
		
		result.setData(registerService.getByCaseNumber(num));
		
		return result;
	}
	
	@RequestMapping("updataVisitState")
	public ResponseResult updataVisitState(int id,int visitstate) {
		ResponseResult result = new ResponseResult();
		
		result.setData(registerService.updataVisitState(id, visitstate));
		
		return result;
	}
}
