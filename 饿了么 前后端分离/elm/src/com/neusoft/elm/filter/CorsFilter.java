package com.neusoft.elm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CorsFilter implements Filter{

	@Override 
	public void init(FilterConfig filterConfig) throws ServletException { } 
	
	@Override 
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException { 
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		//注意：如果想要允许发送Cookie，那么Access-Control-Allow-Origin的值不能为"*"
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081"); 
		response.setHeader("Access-Control-Allow-Credentials", "true"); 
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT"); 
		response.setHeader("Access-Control-Max-Age", "3628800"); 
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization"); 
		filterChain.doFilter(servletRequest, servletResponse); 
	} 
	
	@Override 
	public void destroy() { }

}
