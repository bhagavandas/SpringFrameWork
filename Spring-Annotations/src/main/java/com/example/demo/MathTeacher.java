package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class MathTeacher implements Teacher{

	@Override
	public void teach() {
		System.out.println("I am your Math Teacher");
		System.out.println("My name is Saurav");
		
	}

}
