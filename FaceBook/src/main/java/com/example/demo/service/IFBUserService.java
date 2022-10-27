package com.example.demo.service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegistrationDTO;
import com.example.demo.model.FBUserModel;

public interface IFBUserService {
	
	
	public FBUserModel save(FBUserModel userModel);
	
	RegistrationDTO register(RegistrationDTO userModel);
	//public LoginDTO login(String email);

	LoginDTO login(LoginDTO loginUser);

	public LoginDTO get(LoginDTO loginUser);

	public LoginDTO get(String email);
	
	

}
