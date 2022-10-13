package com.PracticeProgram;

public class Airtel {
	
	private Service service;

	public void setService(Service service) {
		this.service = service;
	}
	
	public void callService() {
		service.service();
	}
	

}
