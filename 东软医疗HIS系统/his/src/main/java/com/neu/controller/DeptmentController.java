package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.po.DepartMent;
import com.neu.po.ResponseResult;
import com.neu.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DeptmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("getPaged")
	public ResponseResult getPaged(int pageNum,int pageSize,String keyword) {
		ResponseResult result = new ResponseResult();
		result.setData(departmentService.getPaged(pageNum, pageSize,keyword));
		return result;
	}
	
	@RequestMapping("update")
	public ResponseResult update(@RequestBody DepartMent department) {
		ResponseResult result = new ResponseResult();
		result.setData(departmentService.update(department));
		return result;
	}
	@RequestMapping("delete")
	public ResponseResult update(int id) {
		ResponseResult result = new ResponseResult();
		result.setData(departmentService.delete(id));
		return result;
	}
	@RequestMapping("insert")
	public ResponseResult insert(@RequestBody DepartMent department) {
		ResponseResult result = new ResponseResult();
		result.setData(departmentService.insert(department));
		return result;
	}
	@RequestMapping("getAll")
	public ResponseResult getAll() {
		ResponseResult result = new ResponseResult();
		result.setData(departmentService.getAll());
		return result;
	}
	@RequestMapping("batchDelete")
	public ResponseResult batchDelete(@RequestBody List<Integer> ids) {
		ResponseResult result = new ResponseResult();
		result.setData(departmentService.batchDelete(ids));
		return result;
	}
	
}
