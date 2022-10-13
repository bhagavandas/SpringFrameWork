package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SettersConstructorsApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//Student bhagavan = context.getBean("student", Student.class);
		//bhagavan.displayStudentInfo();
		
		Student das = context.getBean("das", Student.class);
		das.displayStudentInfo();
		
//		Student das = new Student("das", 1);
//		das.displayStudentInfo();
		
		
	}

}