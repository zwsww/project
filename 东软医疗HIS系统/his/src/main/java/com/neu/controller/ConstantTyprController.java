package com.neu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.po.ConstantType;
import com.neu.po.ResponseResult;
import com.neu.service.ConstantTypeService;

@RestController
@RequestMapping("constantType")
public class ConstantTyprController {

	@Autowired
	private ConstantTypeService constantTypeService;
	
	
	@RequestMapping("getPaged")
	public ResponseResult getPaged(int pageNum , int pageSize,String keyword) {
		ResponseResult result = new ResponseResult();
		result.setData(constantTypeService.getPaged(pageNum, pageSize,keyword));
		return result;
	}
	
	
	@RequestMapping("update")
	public ResponseResult update(@RequestBody ConstantType constantType) {
		ResponseResult result = new ResponseResult();
		result.setData(constantTypeService.update(constantType));
		
		
		return result;
	}
	
	@RequestMapping("delete")
	public ResponseResult delete(int id) {
		ResponseResult result = new ResponseResult();
		result.setData(constantTypeService.delete(id));
		
		
		return result;
	}
	@RequestMapping("insert")
	public ResponseResult insert(@RequestBody ConstantType constantType) {
		ResponseResult result = new ResponseResult();
		constantType.setDelmark(1);
		result.setData(constantTypeService.insert(constantType));
		
		
		return result;
	}
	@RequestMapping("getAll")
	public ResponseResult getAll() {
		ResponseResult result = new ResponseResult();
		result.setData(constantTypeService.getAll());
		return result;
	}
}
