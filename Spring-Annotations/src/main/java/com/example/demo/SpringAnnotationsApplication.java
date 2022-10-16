package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringAnnotationsApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringAnnotationsApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);
		College college = context.getBean("collegeBean", College.class);
		System.out.println("College object created!!!");
		college.test();
	}

}
