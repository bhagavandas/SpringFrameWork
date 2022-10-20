package com.example.demo.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

	private String message;

	public UserAlreadyExistsException(String message) {

		this.message = message;
	}

	public UserAlreadyExistsException() {

	}

}
