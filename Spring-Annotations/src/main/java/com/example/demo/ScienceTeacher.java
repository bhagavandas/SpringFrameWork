package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class ScienceTeacher implements Teacher{

	@Override
	public void teach() {
		System.out.println("I am your Science Teacher");
		System.out.println("My name is Dhoni");
		
	}

}
