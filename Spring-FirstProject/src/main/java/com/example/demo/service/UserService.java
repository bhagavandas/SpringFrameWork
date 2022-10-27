package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.DTO.UserDTO;
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

	@Override
	public UserDTO get(int id) {
		Optional<UserModel> userModel = userRepo.findById(id);
		if (userModel.isEmpty()) {
			throw new UserException("User doesn't exist!!!");
		}
		UserDTO userDTO = modelMapper.map(userModel.get(), UserDTO.class);
		return userDTO;
	}

	@Override
	public RegisterDTO register(RegisterDTO user) {
		Optional<UserModel> userModel = userRepo.findByEmail(user.getEmail());
		if (userModel.isPresent()) {
			throw new UserException("Username already exists!!");
		}
		UserModel registeredUser = modelMapper.map(user, UserModel.class);
		userRepo.save(registeredUser);
		System.out.println("Successfully registered");
		return user;

	}

	@Override
	public UserDTO getUserByLogin(LoginDTO loginDTO) {
		Optional<UserModel> userModel = userRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
	if(userModel.isEmpty()) {
		Optional<UserModel> useremail = userRepo.findByEmail(loginDTO.getEmail());
		Optional<UserModel> userPwd = userRepo.findByPassword(loginDTO.getPassword());
		if(useremail.isEmpty()) {
			throw new UserException("Entered email is incorrect");
		}
		else if(userPwd.isEmpty()) {
			throw new UserException("Entered password is incorrect");
		}
		
		
		//throw new UserException("Check the email and password are correct");
	}
	UserDTO userDTO = modelMapper.map(userModel.get(), UserDTO.class);
	System.out.println("Successfully Fetched");
	return userDTO;
	
	}

	

		
	
	

}
