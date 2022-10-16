package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary  // In teacher, there are two teachers. If we want to get one teacher from them.
public class MathTeacher implements Teacher{

	@Override
	public void teach() {
		System.out.println("I am your Math Teacher");
		System.out.println("My name is Saurav");
		
	}

}
