package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegistrationDTO;
import com.example.demo.model.FBUserModel;
import com.example.demo.service.IFBUserService;

@RestController
public class Controller {
	
	@Autowired
	IFBUserService userService;
	
	@PostMapping("/registerUser")
	public ResponseEntity register(@RequestBody RegistrationDTO userModel) {
		RegistrationDTO fBUserModel = userService.register(userModel);
		System.out.println("Added");
		return new ResponseEntity(fBUserModel, "Registered SuccessFully!!!");
		
	}
	
	@GetMapping("/loginUser")
	public ResponseEntity login(@RequestBody LoginDTO loginUser) {
		LoginDTO fBLoginUser = userService.login(loginUser);
		System.out.println("Logged in");
		return new ResponseEntity(fBLoginUser, "Login SuccessFully!!!");
		
	}
	
	@GetMapping("/getUserData")
	public ResponseEntity fetchData(@RequestBody LoginDTO loginDto) {
		LoginDTO fBLoginUser = userService.getUserByLogin(loginDto);
		System.out.println("Fetched");
		return new ResponseEntity(loginDto, "Fetched User SuccessFully!!!");
		
	}

}
