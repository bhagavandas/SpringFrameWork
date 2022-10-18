package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepo;

	@Override
	public UserModel add(UserModel user) {
		userRepo.save(user);
		return user;

	}

	@Override
	public Optional<UserModel> delete(int id) {
		Optional<UserModel> userModel = userRepo.findById(id);
		 userRepo.deleteById(id);
		return userModel;
		
	}

	@Override
	public Optional<UserModel> get(int id) {
		Optional<UserModel> userModel = userRepo.findById(id);
		userRepo.findById(id);
		return userModel;
	}

	@Override
	public Optional<UserModel> save(UserModel user, int id) {
		Optional<UserModel> userModel = userRepo.findById(id);
		//userRepo.getOne(id);
		return userModel;
	}

	
}
