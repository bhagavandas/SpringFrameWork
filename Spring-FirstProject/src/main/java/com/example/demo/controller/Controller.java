package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.UserModel;
import com.example.demo.service.IUserService;
import com.example.demo.utilities.JwtTokenUtil;

@RestController
public class Controller {

	@Autowired
	IUserService userService;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;

//	@GetMapping("/hello")
//	public String helloWorld() {
//		return "Hello World!";
//	}

	@PostMapping("/addUser")
	public ResponseEntity addUser(@RequestBody UserModel user) {
		UserModel userModel = userService.add(user);
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

	@GetMapping("/search/{id}")
	public UserDTO search(@PathVariable int id) {
		UserDTO userModel2 = userService.get(id);
		System.out.println("User got Successfully");
		return userModel2;
	}

	@PostMapping("/registerUser")
	public ResponseEntity registerUser(@RequestBody RegisterDTO user) {
		RegisterDTO registerDTO = userService.register(user);
		return new ResponseEntity(registerDTO, "Registered successfully");
	}
	
	@GetMapping("/getUserByLogin")
	public ResponseEntity getUserByLogin(@RequestHeader String token) {
		UserDTO userDTO = userService.getUserByLogin(token);
		//System.out.println(jwtTokenUtil.generateToken(userDTO));
		return new ResponseEntity(userDTO, "Fetched successfully");
	}
	
	@GetMapping("/getToken")
	public String getToken(@RequestBody LoginDTO loginDTO) {
		String token = userService.getToken(loginDTO);
		//System.out.println(jwtTokenUtil.generateToken(userDTO));
		return token;
	}

}
