package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // we need to add package name here
@ComponentScan(basePackages = "com.example.demo")
@PropertySource("classpath:college-info.properties") // we need to use this annotation whenever we get value from properties file
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
