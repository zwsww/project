package com.neu.util;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.po.ResponseResult;

//@ControllerAdvice
public class GlobalExceptionHandle {
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseResult exceptionHandle(Exception e) {
		ResponseResult result = new ResponseResult();
		result.setResult("err");
		
		result.setData(e.getMessage());
		
		return result;
	}
}
