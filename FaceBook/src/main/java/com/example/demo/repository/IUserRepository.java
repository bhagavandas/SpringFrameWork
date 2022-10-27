package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.model.FBUserModel;

public interface IUserRepository extends JpaRepository<FBUserModel, Integer>{


	Optional<FBUserModel> findByEmail(String email);

	void save(LoginDTO loginuser);

	//void get(FBUserModel loginuser);

	
	
	

}
