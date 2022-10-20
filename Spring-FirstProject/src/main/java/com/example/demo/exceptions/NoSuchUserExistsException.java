package com.example.demo.exceptions;

public class NoSuchUserExistsException {
	
	private String message;

	public NoSuchUserExistsException(String message) {
		super();
		this.message = message;
	}
	
	public NoSuchUserExistsException() {
		
	}
	
}
