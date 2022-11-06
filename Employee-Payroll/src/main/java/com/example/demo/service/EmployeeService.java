package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.exceptions.UserException;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.IEmpRepository;
import com.example.demo.utilities.JwtTokenUtil;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmpRepository repo;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	JwtTokenUtil tokenUtil;

	@Override
	public RegisterDTO register(RegisterDTO registerDTO) {
		Optional<EmployeeModel> empModel = repo.findByEmployeeName(registerDTO.getEmployeeName());
		if (empModel.isPresent()) {
			throw new UserException("Employee Name already exists!!");
		}
		EmployeeModel registeredemployee = modelMapper.map(registerDTO, EmployeeModel.class);
		registeredemployee.setVerified(true);
		repo.save(registeredemployee);

		System.out.println("Successfully registered");
		return registerDTO;
	}

	@Override
	public RegisterDTO searchByEmployeeName(String name) {
		Optional<EmployeeModel> empModel = repo.findByEmployeeName(name);
		if (empModel.isEmpty()) {
			throw new UserException("Employee doesn't exist!!!");
		}
		RegisterDTO registerDTO = modelMapper.map(empModel.get(), RegisterDTO.class);

		return registerDTO;
	}

	@Override
	public Optional<EmployeeModel> deleteEmployeeName(String employeeName) {
		Optional<EmployeeModel> empModel = repo.findByEmployeeName(employeeName);
		if (empModel.isEmpty()) {
			throw new UserException("Employee doesn't exist!!!");
		}
		repo.deleteByEmployeeName(employeeName);
		return empModel;

	}

	@Override
	public RegisterDTO updateEmployeeName(RegisterDTO employee, int employeeId) {
		employee.setEmployeeId(employeeId);
		return repo.save(employee);
	}

	@Override
	public String login(LoginDTO loginDTO) {
		Optional<EmployeeModel> empModel = repo.findByEmployeeIdAndEmployeeName(loginDTO.getEmployeeId(),
				loginDTO.getEmployeeName());
		if (empModel.isEmpty()) {
			Optional<EmployeeModel> empId = repo.findByEmployeeId(loginDTO.getEmployeeId());
			Optional<EmployeeModel> empName = repo.findByEmployeeName(loginDTO.getEmployeeName());
			if (empId.isEmpty()) {
				throw new UserException("Entered ID is incorrect");
			} else if (empName.isEmpty()) {
				throw new UserException("Entered Name is incorrect");
			}
		}
		String token = tokenUtil.generateToken(loginDTO);
		empModel.get().setStatus(1);
		repo.save(empModel.get());
		return token;
	}
	
	@Override
	public String logout(String token) {
		LoginDTO loginDTO = tokenUtil.deCode(token);
		Optional<EmployeeModel> checkUser = repo.findByEmployeeIdAndEmployeeName(loginDTO.getEmployeeId(), loginDTO.getEmployeeName());
		checkUser.get().setStatus(0);
		repo.save(checkUser.get());
		return "logout successful";
	}
	
	@Override
	public RegisterDTO update(RegisterDTO registerDTO, String token) {
		LoginDTO loginDTO = tokenUtil.deCode(token);
		EmployeeModel empModel = modelMapper.map(registerDTO, EmployeeModel.class);

		if (repo.findByEmployeeIdAndEmployeeName(loginDTO.getEmployeeId(), loginDTO.getEmployeeName()).isPresent() && repo
				.findByEmployeeIdAndEmployeeName(loginDTO.getEmployeeId(), loginDTO.getEmployeeName()).get().getStatus() == 1) {

			empModel.setEmployeeId(repo.findByEmployeeIdAndEmployeeName(loginDTO.getEmployeeId(), loginDTO.getEmployeeName()).get().getEmployeeId());
			empModel.setVerified(true);
			empModel.setStatus(1);
			repo.save(empModel);
			System.out.println("Updated Successfully");

			return registerDTO;
		} else {
			throw new UserException("Please Login!");
		}
	}
	
	public List<RegisterDTO> getAllEmployees(String role) {
		if (role.equals("Admin"))
			return repo.findAll().stream().map(user -> modelMapper.map(user, RegisterDTO.class))
					.collect(Collectors.toList());
		else {
			throw new UserException("You are not an Admin, Please check your Role");
		}
	}

}
