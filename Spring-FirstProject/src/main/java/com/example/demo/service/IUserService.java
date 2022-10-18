package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;

public interface IUserService {
	
	
	public UserModel add(UserModel user);
	public Optional<UserModel> delete(int id);
	public Optional<UserModel> get(int id);
	
	public Optional<UserModel> save(UserModel user, int id);
	
	
}
