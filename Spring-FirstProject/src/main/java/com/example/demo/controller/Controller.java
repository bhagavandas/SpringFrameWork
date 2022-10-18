package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.IUserService;

@RestController
public class Controller {

	@Autowired
	IUserService userService;

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World!";
	}

	@PostMapping("/addUser")
	public UserModel addUser(@RequestBody UserModel user) {
		UserModel userModel = userService.add(user);
		return userModel;
	}

}
