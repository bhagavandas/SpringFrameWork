package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationsApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SpringAnnotationsApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);
		College college = context.getBean("college", College.class);
		System.out.println("College object created!!!");
		college.test();
		context.close();
	}

}
