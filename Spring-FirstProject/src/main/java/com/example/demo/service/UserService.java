package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.EmailDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.LogoutDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.DTO.UserDTO;

import com.example.demo.exceptions.UserException;
import com.example.demo.model.UserModel;
import com.example.demo.repository.IUserRepository;

import com.example.demo.utilities.JavaMailService;
import com.example.demo.utilities.JwtTokenUtil;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepo;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Autowired
	JavaMailService javaMailService;

	@Autowired
	RestTemplate restTemplate;

	String token;

	@Override
	public ResponseEntity add(UserDTO user) {

		String userMail = user.getEmail();
		if (userRepo.findByEmail(userMail).isPresent()) {
			throw new UserException("User already exist");

		} else {
			token = jwtTokenUtil.generateToken(user.getEmail(), user.getPassword());

			javaMailService.sendSimpleMail(user.getEmail(), token, "verification");
			UserModel userModel = modelMapper.map(user, UserModel.class);
			userModel.setIsVerified(true);
			//userModel.setRole("Admin");
			userRepo.save(userModel);
			return new ResponseEntity(user, "One user added");

		}

	}

	public List<UserDTO> getAllUser(String role) {
		if (role.equals("Admin"))
			return userRepo.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class))
					.collect(Collectors.toList());
		else {
			throw new UserException("not admin, check your Role");
		}
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

// Get user by Token or Login by using token
	@Override
	public UserDTO getUserByLogin(String token) {
		LoginDTO loginDTO = jwtTokenUtil.deCode(token);
		Optional<UserModel> userModel = userRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
		if (userModel.get().getStatus() == 1) {

			UserDTO userDTO = modelMapper.map(userModel.get(), UserDTO.class);
			userModel.get().setStatus(1);
			System.out.println("Successfully Fetched");
			return userDTO;
		} else {
			throw new UserException("Please login");
		}
	}

	@Override
	public String getToken(LoginDTO loginDTO) {
		Optional<UserModel> userModel = userRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());

		if (userModel.isEmpty()) {
			Optional<UserModel> useremail = userRepo.findByEmail(loginDTO.getEmail());
			Optional<UserModel> userPwd = userRepo.findByPassword(loginDTO.getPassword());
			if (useremail.isEmpty()) {
				throw new UserException("Entered email is incorrect");
			} else if (userPwd.isEmpty()) {
				throw new UserException("Entered password is incorrect");
			}
		}
		String token = jwtTokenUtil.generateToken(loginDTO);
		System.out.println(userModel.get().getStatus());
		userModel.get().setStatus(1);
		userRepo.save(userModel.get());
		System.out.println(userModel.get().getStatus());
		return token;

	}

	@Override
	public UserDTO updateByToken(UserDTO userDTO, String token) {
		LoginDTO loginDTO = jwtTokenUtil.deCode(token);
		UserModel userModel = modelMapper.map(userDTO, UserModel.class);

		if (userRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword()).isPresent() && userRepo
				.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword()).get().getStatus() == 1) {

			userModel.setId(userRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword()).get().getId());
			userModel.setIsVerified(true);
			userModel.setStatus(1);
			userRepo.save(userModel);
			System.out.println("Updated Successfully");

			return userDTO;
		} else {
			throw new UserException("Please Login!");
		}

	}

	@Override
	public String logoutByToken(String token) {
		LoginDTO loginDTO = jwtTokenUtil.deCode(token);
		Optional<UserModel> checkUser = userRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
		checkUser.get().setStatus(0);
		userRepo.save(checkUser.get());
		return "logout successful";
	}

	@Override
	public String sendMail(EmailDTO mail) {

		return javaMailService.sendSimpleMail(mail);
	}

}
