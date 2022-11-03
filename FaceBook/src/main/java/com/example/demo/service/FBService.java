package com.example.demo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegistrationDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exceptions.UserException;
import com.example.demo.model.FBUserModel;
import com.example.demo.repository.IUserRepository;

@Service
public class FBService implements IFBUserService {

	@Autowired
	IUserRepository userRepo;
	@Autowired
	ModelMapper mapper;

	@Override
	public RegistrationDTO register(RegistrationDTO userModel) {
		Optional<FBUserModel> registerUser = userRepo.findByEmail(userModel.getEmail());
		if (registerUser.isPresent()) {
			throw new UserException("Email already exists! ");
		}
		FBUserModel user = mapper.map(userModel, FBUserModel.class);
		userRepo.save(user);
		System.out.println("Succesfully added");
		return userModel;
	}

	
	@Override
	public LoginDTO login(LoginDTO user) {
		Optional<FBUserModel> fbUser = userRepo.findByEmail(user.getEmail());
		if (fbUser.isEmpty()) {
			throw new UserException("Email doesn't exists, try valid email! ");
		}
		FBUserModel loginuser = mapper.map(user.getEmail(), FBUserModel.class);
		userRepo.save(loginuser);
		System.out.println("Login Successfully");
		return user;
	}

	
	@Override
	public LoginDTO fetchUser(LoginDTO user) {
		
		System.out.println("Debugging");
		if (userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword()).isPresent()) {
			FBUserModel fbUser = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword()).get();
			UserDTO loginuser = mapper.map(fbUser, UserDTO.class);
			//userRepo.save(loginuser);
			System.out.println("Fetched User Data Successfully");
			return user;
			
		}
		throw new UserException("Email doesn't exists, try valid email! ");
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public LoginDTO get(RegistrationDTO registerUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistrationDTO login(RegistrationDTO registerUser) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public FBUserModel save(FBUserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}


	

//	@Override
//	public LoginDTO get(LoginDTO loginUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public LoginDTO get(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public LoginDTO get(LoginDTO loginUser) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public RegistrationDTO fetchUser(RegistrationDTO loginUser) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public LoginDTO getUserByLogin(LoginDTO logUser) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public LoginDTO fetchUser(LoginDTO loginUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}


//	@Override
//	public RegistrationDTO fetchUser(RegistrationDTO loginUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}


//	@Override
//	public LoginDTO fetchUser(LoginDTO loginUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}


//	@Override
//	public RegistrationDTO fetchUser(RegistrationDTO loginUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
