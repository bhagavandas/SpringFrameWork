package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.EmailDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.model.EmployeeModel;

public interface IEmployeeService {

	public RegisterDTO register(RegisterDTO registerDTO);

	

	String login(LoginDTO loginDTO);

	String logout(String token);

	RegisterDTO update(RegisterDTO registerDTO, String token);

	public List<RegisterDTO> getAllEmployees(String role);

	//public RegisterDTO updateByEmployeeId(RegisterDTO employee, int employeeId);

	RegisterDTO updateByEmail(RegisterDTO employee, String email);



	Optional<EmployeeModel> deleteEmail(String email);



	RegisterDTO searchByEmail(String email);



	String sendMail(EmailDTO mail);

}
