package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.UserModel;

public interface IUserService {

	public UserModel add(UserModel user);

	public Optional<UserModel> delete(int id);

	public UserDTO get(int id);

	public Optional<UserModel> getname(String name);

	public UserModel update(UserModel user, int id);

	public RegisterDTO register(RegisterDTO user);
	
	//public LoginDTO getUserByLogin(String email, String Password);

	UserDTO getUserByLogin(LoginDTO loginDTO);

	

}
