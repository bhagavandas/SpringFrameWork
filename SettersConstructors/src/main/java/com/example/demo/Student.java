package com.example.demo;

public class Student {
	
	private String studentName;
	private int id;
	
	
	//constructor is used to initializing non static values
public Student(String studentName, int id) {
		
		this.studentName = studentName;
		this.id = id;
	}



//	public void setStudentName(String studentName) {
//		this.studentName = studentName;
//	}
//	
//	public void setId(int id) {
//		this.id = id;
//	}
	
	public void displayStudentInfo() {
		System.out.println("Student name is : " + studentName + " and id is : " + id);
	}
	

}
