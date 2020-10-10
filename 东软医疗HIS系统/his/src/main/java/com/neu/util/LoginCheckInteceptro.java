package com.neu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.po.ResponseResult;

public class LoginCheckInteceptro implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("username");
		if(user != null) {
			return true;
		}
		response.setContentType("application/json;charset=utf-8");
		ResponseResult result = new ResponseResult();
		result.setResult("err");
		result.setData("您还没有登录");
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(result);
		response.getWriter().print(json);
		return false;
	}
}
