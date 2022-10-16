package com.example.demo;

import org.springframework.stereotype.Component;

//@Component("college")
public class College {

	private Principal principal;

	public void setPrincipal(Principal principal) {
		this.principal = principal;
		System.out.println("using setPrincipal method");
	}
	
	public void test() {
		principal.principalInfo();
		System.out.println("testing this methods");
	}

	

	
}
