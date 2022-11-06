package com.example.demo.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.model.EmployeeModel;

@Repository
public interface IEmpRepository extends JpaRepository<EmployeeModel, Integer> {

	Optional<EmployeeModel> findByEmployeeName(String employeeName);

	RegisterDTO save(RegisterDTO registeredemployee);

	void deleteByEmployeeName(String employeeName);

	Optional<EmployeeModel> findByEmployeeIdAndEmployeeName(int employeeId, String employeeName);

	void save(LoginDTO loginEmp);

	Optional<EmployeeModel> findByEmployeeId(int employeeId);

}
