package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DependencyInjectionObjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Student student = context.getBean("stu", Student.class);
		student.cheating();
		
		AnotherStudent another = context.getBean("anotherStudent", AnotherStudent.class);
		another.startCheating();
	}

}
