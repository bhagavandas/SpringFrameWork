package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.UserDTO;
import com.example.demo.model.UserModel;

public interface IUserService {
	
	
	public UserModel add(UserModel user);
	public Optional<UserModel> delete(int id);
	public UserDTO get(int id);
	public Optional<UserModel> getname(String name);
	//public UserDTO getById(int id);
	//public Optional<UserModel> save(UserModel user);
	public UserModel update(UserModel user, int id);
	
	
}
