package com.neu.util;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/*@Configuration
@EnableAspectJAutoProxy//开启切面的自动代理
@Component
@Aspect//切面
*/public class AOPUtil {
	//切点：加入相同代码的连接点
	@Pointcut("execution (* com.neu.service.*.*(..))")
	public void pointcut() {
		
	}
	//环绕通知：在连接点前后加入代码
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint p) throws Throwable {
		long startTime = System.nanoTime();
		
		Object obj = p.proceed();//调用要测试的方法
		
		long n = System.nanoTime() - startTime;
		System.out.println(n);
		
		return obj;
	}
	
	@Before("pointcut()")
	public void before(JoinPoint p) {
		//得到方法的签名（声明）
		Signature signature = p.getSignature();
		String declaringTypeName = signature.getDeclaringTypeName();
		String methodName = signature.getName();
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(declaringTypeName+"类型的"+methodName+"方法开始执行时间："+f.format(new Date()));
	}
	
	@AfterReturning("pointcut()")
	public void afterReturing() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("方法结束执行时间"+f.format(new Date()));
	}
	
	@AfterThrowing("pointcut()")
	public void afterThrowing() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("方法抛出异常时间"+f.format(new Date()));
	}
	
	@After("pointcut()")
	public void after() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("方法结束时间"+f.format(new Date()));
	}
}
