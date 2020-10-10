package com.neu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.neu.util.DateConverter;
import com.neu.util.LoginCheckInteceptro;

@SpringBootConfiguration
@MapperScan("com.neu.mapper")
public class AppConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("*")
			.allowCredentials(true);
	}
	@Override
	public void addFormatters(FormatterRegistry registry) {
		DateConverter d = new DateConverter();
		registry.addConverter(d);
	}
	/*
	 * @Override public void addInterceptors(InterceptorRegistry registry) {
	 * registry.addInterceptor(new LoginCheckInteceptro()) .addPathPatterns("/**")
	 * .excludePathPatterns("/user/login"); }
	 */
}
