package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class College {

	
	private Principal principal;
	private Teacher teacher;
	
	@Autowired
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
		
	}

	@Autowired
	public void setPrincipal(Principal principal) {
		this.principal = principal;
		System.out.println("using setPrincipal method");
	}
	
	public void test() {
		principal.principalInfo();
		teacher.teach();
		System.out.println("testing this methods");
	}

	

	
}
