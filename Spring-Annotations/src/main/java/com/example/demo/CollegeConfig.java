package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // we need to add package name here
@ComponentScan(basePackages = "com.example.demo")
public class CollegeConfig {
	
	@Bean
	public Principal principalBean() {
		return new Principal();
	}
	// instead of using component we can use like this
	@Bean  //("college")
	public College collegeBean() {
		College college = new College();
		college.setPrincipal(principalBean());
		return college;
	}

}
