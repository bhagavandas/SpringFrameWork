package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.EmailDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.LogoutDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.UserModel;
import com.example.demo.utilities.JwtTokenUtil;

public interface IUserService {

	public ResponseEntity add(UserDTO userDTO);

	public Optional<UserModel> delete(int id);

	public UserDTO get(int id);

	public Optional<UserModel> getname(String name);

	public UserModel update(UserModel user, int id);

	public RegisterDTO register(RegisterDTO user);

	public String getToken(LoginDTO loginDTO);

	UserDTO getUserByLogin(String token);

	UserDTO updateByToken(UserDTO userDTO, String token);

	public String logoutByToken(String token);

	 public String sendMail(EmailDTO mail);

	public List<UserDTO> getAllUser(String role);

}
