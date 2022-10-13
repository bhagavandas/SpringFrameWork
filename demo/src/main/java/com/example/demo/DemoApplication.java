package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springIoc.xml");
		System.out.println("Created!!!");
		context.getBean("sim", Airtel.class).calling();
	}

}
