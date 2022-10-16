package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // we need to add package name here
@ComponentScan(basePackages = "com.example.demo")
public class CollegeConfig {
//
//	@Bean
//	public Teacher mathTeacherBean() {
//		return new MathTeacher();
//
//	}
//
//	@Bean
//	public Principal principalBean() {
//		return new Principal();
//	}
//
//	@Bean // ("college")
//	public College collegeBean() { // collegeBean - bean
//		College college = new College();
//		college.setPrincipal(principalBean()); // setting our dependencies
//		college.setTeacher(mathTeacherBean());
//		return college;
//	}

}
