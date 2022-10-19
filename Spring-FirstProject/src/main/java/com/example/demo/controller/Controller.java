package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.model.UserModel;
import com.example.demo.service.IUserService;

@RestController
public class Controller {

	@Autowired
	IUserService userService;

//	@GetMapping("/hello")
//	public String helloWorld() {
//		return "Hello World!";
//	}

	@PostMapping("/addUser")
	public ResponseEntity addUser(@RequestBody UserModel user) {
		UserModel userModel = userService.add(user);

		System.out.println("User added Successfully");
		return new ResponseEntity(userModel, "User added successfully");
	}

//	@DeleteMapping("/deleteUser/{id}")
//	public Optional<UserModel> deleteUser(@PathVariable int id) {
//		Optional<UserModel> userModel = userService.delete(id);
//		System.out.println("User deleted Successfully");
//		return userModel;
//	}

	@DeleteMapping("/deleteUser")
	public Optional<UserModel> deleteUser(@RequestParam int id) {
		Optional<UserModel> userModel = userService.delete(id);
		System.out.println("User deleted Successfully");
		return userModel;
	}

	@GetMapping("/search/{id}")
	public Optional<UserModel> search(@PathVariable int id) {
		Optional<UserModel> userModel2 = userService.get(id);
		System.out.println("User got Successfully");
		return userModel2;
	}
	
	@GetMapping("/search")
	public Optional<UserModel> searchByName(@RequestParam String name) {
		System.out.println("User got Successfully By name" + name);
		Optional<UserModel> searchuserModel = userService.getname(name);
		
		return searchuserModel;
	}
	
	

	@PutMapping("/updateUser/{id}")
	public ResponseEntity updateUser(@RequestBody UserModel user, @PathVariable int id) {
		UserModel userModel3 = userService.update(user, id);
		return new ResponseEntity(userModel3, "User updated successfully");
	}

}
