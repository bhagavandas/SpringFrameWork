package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World!";
	}
	
//	@PostMapping("/post")
//	public String post() {
//		return " SpringBoot";
//	}

}
