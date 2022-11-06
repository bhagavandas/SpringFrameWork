package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.model.EmployeeModel;

public interface IEmployeeService {

	public RegisterDTO register(RegisterDTO registerDTO);

	public RegisterDTO searchByEmployeeName(String name);

	public Optional<EmployeeModel> deleteEmployeeName(String employeeName);

	// public Optional<EmployeeModel> updateEmployeeName(RegisterDTO
	// registerEmployee, String employeeName);

	public RegisterDTO updateEmployeeName(RegisterDTO employee, int employeeId);

	//public LoginDTO login(int employeeId, String employeeName);

	String login(LoginDTO loginDTO);

	String logout(String token);

	RegisterDTO update(RegisterDTO registerDTO, String token);

	public List<RegisterDTO> getAllEmployees(String role);

}
