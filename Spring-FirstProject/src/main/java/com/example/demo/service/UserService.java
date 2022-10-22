package com.example.demo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.UserDTO;
import com.example.demo.exceptions.UserException;
import com.example.demo.model.UserModel;
import com.example.demo.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserModel add(UserModel user) {
		UserModel userModel = userRepo.findById(user.getId()).orElse(null);
		if (userModel == null) {
			userRepo.save(user);
			System.out.println("User added Successfully");
			return userModel;
		} else
			throw new UserException("User already exists!!");
	}

	@Override
	public Optional<UserModel> delete(int id) {
		Optional<UserModel> userModel = userRepo.findById(id);
		userRepo.deleteById(id);
		return userModel;

	}

	@Override
	public UserDTO get(int id) {
		Optional<UserModel> userModel = userRepo.findById(id);
		//System.out.println("Found by ID: " + userModel.get());
		if (userModel.isEmpty()) {
			throw new UserException("User doesn't exist!!!");
		}
		UserDTO userDTO = modelMapper.map(userModel.get(), UserDTO.class);

		return userDTO; //registered DTO
	}

	@Override
	public UserModel update(UserModel user, int id) {
		user.setId(id);
		return userRepo.save(user);
	}

	@Override
	public Optional<UserModel> getname(String name) {
		Optional<UserModel> getuserModel = userRepo.findByName(name);
		if (getuserModel.isEmpty()) {
			throw new UserException("User doesn't exist!!!");
		} else
			return getuserModel;
	}

	

}
