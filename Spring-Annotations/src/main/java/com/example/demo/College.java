package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class College {

	// @Value("Bridgelabz") // value is used to inject value
	@Value("${college.Name}") // instead of giving value here, we get the value from properties file
	private String collegeName;

	@Required
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	

	@Autowired
	private Principal principal;

	@Autowired
	@Qualifier("mathTeacher") // here we will change which one we want
	private Teacher teacher;

	public void test() {
		principal.principalInfo();
		teacher.teach();
		System.out.println("My college name is : " + collegeName);
		System.out.println("testing this methods");
	}

}
