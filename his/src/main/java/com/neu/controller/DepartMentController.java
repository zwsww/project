package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.po.DepartMent;
import com.neu.po.ResponseResult;
import com.neu.service.DepartMentService;

@RestController
@RequestMapping("DepartMent")
public class DepartMentController {

	@Autowired
	private DepartMentService departMentService;
	
	@RequestMapping("getPaged")
	public ResponseResult getPaged(int pageNum,int pageSize,String keyword) {
		ResponseResult result = new ResponseResult();
		result.setData(departMentService.getPaged(pageNum, pageSize, keyword));
		return result;
	}
	
	@RequestMapping("getAll")
	public ResponseResult getAll() {
		ResponseResult result = new ResponseResult();
		result.setData(departMentService.getAll());
		return result;
	}
	@RequestMapping("insert")
	public ResponseResult insert(@RequestBody DepartMent departMent) {
		ResponseResult result = new ResponseResult();
		departMent.setDelmark(1);
		result.setData(departMentService.insert(departMent));
		return result;
	}
	@RequestMapping("update")
	public ResponseResult update(@RequestBody DepartMent departMent) {
		ResponseResult result = new ResponseResult();
		result.setData(departMentService.update(departMent));
		return result;
	}
	@RequestMapping("delete")
	public ResponseResult delete(int id) {
		ResponseResult result = new ResponseResult();
		result.setData(departMentService.delete(id));
		return result;
	}
	@RequestMapping("batchDelete")
	public ResponseResult getPaged(@RequestBody List<Integer> ids) {
		ResponseResult result = new ResponseResult();
		result.setData(departMentService.batchDelete(ids));
		return result;
	}
}
