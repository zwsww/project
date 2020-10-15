package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.po.ResponseResult;
import com.neu.service.ConstantItemService;
import com.neu.vo.ConstantItemSearch;

@RestController
@RequestMapping("constantItem")
public class ConstantItemController {
	@Autowired
	private ConstantItemService constantItemService;
	
	@RequestMapping("getPaged")
	public ResponseResult getPaged(@RequestBody ConstantItemSearch item) {
		ResponseResult result = new ResponseResult();
		result.setData(constantItemService.getPaged(item));
		return result;
	}
	@RequestMapping("batchDelete")
	public ResponseResult getPaged(@RequestBody List<Integer> ids) {
		ResponseResult result = new ResponseResult();
		result.setData(constantItemService.batchDelete(ids));
		return result;
	}
	@RequestMapping("getAll")
	public ResponseResult getAll(int id) {
		ResponseResult result = new ResponseResult();
		result.setData(constantItemService.getAll(id));
		return result;
		
	}
}

