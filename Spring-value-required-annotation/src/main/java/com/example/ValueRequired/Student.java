package com.example.ValueRequired;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public class Student {
	
	private String name;
	private String interestedCourse;
	private String hobby;
	
	// without using setter method, we can get data using the values
	//without giving the values here, we can get the values from properties file using ${}
	@Value("${student.name}")
	public void setName(String name) {
		this.name = name;
	}
	
	@Required
	//@Value("Bhagavan")
	@Value("${student.interestedCourse}")
	public void setinterestedCourse(String interestedCourse) {
		this.interestedCourse = interestedCourse;
	}
	
	@Value("${student.hobby}")
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public void displayStudentInfo() {
		System.out.println("Student name : " + name + ", Interested Course : " +interestedCourse+ ",  And hobby is : " + hobby);
	}
	
	
	
}
