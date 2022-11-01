package com.example.demo.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.UserModel;


@Repository
public interface IUserRepository extends JpaRepository<UserModel, Integer> {

	Optional<UserModel> findByName(String name);

	Optional<UserModel> findByEmail(String email);

	void save(String name);

	Optional<UserModel> findByEmailAndPassword(String email, String password);

	Optional<UserModel> findByPassword(String email);

	Optional<UserModel> findByToken(String email);

	void save(Map<String, Object> claims);

	void save(UserDTO userDTO);

	UserModel save(LoginDTO loginDTO);

	//Optional<UserModel> findByEmailAndPassword(String email, String password);

}
