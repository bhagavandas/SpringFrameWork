package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegistrationDTO;
import com.example.demo.model.FBUserModel;

public interface IUserRepository extends JpaRepository<FBUserModel, Integer>{


	Optional<FBUserModel> findByEmail(String email);

	void save(LoginDTO loginuser);

	//Optional<FBUserModel> find(String loginUser);

	void save(RegistrationDTO loginuser);

	Optional<FBUserModel> findByEmailAndPassword(String email, String Password);

	

	
	
	

}
