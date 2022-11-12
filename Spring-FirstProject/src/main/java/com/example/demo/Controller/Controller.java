package com.example.demo.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.ResponseEntity;
import com.example.demo.SpringFirstProjectApplication;
import com.example.demo.DTO.EmailDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.LogoutDTO;
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
	@Autowired
	EmailDTO emailDTO;
	Logger logger = LoggerFactory.getLogger(Controller.class);

	@GetMapping("/hello")
	public String helloWorld() {

		logger.info("Inside Info");
		logger.error("Inside Error");
		logger.debug("Inside Debug");
		logger.warn("Inside Warn");
		logger.trace("Inside Trace");
		return "Hello World!";
	}

	@PostMapping("/addUser")
	public ResponseEntity addUser(@RequestBody UserDTO userDTO) {
		ResponseEntity userModel = userService.add(userDTO);
		return new ResponseEntity(userModel, "User added successfully");
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity getAllUser(@RequestParam String role) {
		List<UserDTO> userModel1 = userService.getAllUser(role);
		return new ResponseEntity(userModel1, "Fetched users successfully");
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
		return new ResponseEntity(userDTO, "Got user successfully");
	}

	@GetMapping("/login") // when we login, token will generate
	public ResponseEntity getToken(@RequestBody LoginDTO loginDTO) {
		String token = userService.getToken(loginDTO);
		return new ResponseEntity(token, "Login successfully");
	}

	@PutMapping("/updateUserByToken")
	public ResponseEntity updateUserByToken(@RequestBody UserDTO userDTO, @RequestHeader String token) {
		UserDTO userModel3 = userService.updateByToken(userDTO, token);
		return new ResponseEntity(userModel3, "User updated successfully");
	}

	@GetMapping("/logoutUserByToken")
	public ResponseEntity logoutUserByToken(@RequestHeader String token) {

		return new ResponseEntity(userService.logoutByToken(token), "User logged out successfully");
	}

	@PostMapping("/sendMail")
	public ResponseEntity sendMail(@RequestBody EmailDTO details) {

		String status = userService.sendMail(details);

		return new ResponseEntity(status, "Sent Mail successfully");
	}

	@GetMapping("/token")
	public String UserToken(@RequestParam String token) {
		return "Registered successfully";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<String> getProducts() {
		List<String> productsList = new ArrayList<>();
		productsList.add("Honey");
		productsList.add("Almond");
		return productsList;
	}

	// http://localhost:8080/swagger-ui/index.html#/
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String createProduct() {
		return "Product is saved successfully";
	}
}
