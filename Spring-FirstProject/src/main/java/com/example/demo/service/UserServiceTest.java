package com.example.demo.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.IUserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@Mock
	private IUserRepository repo;
	@Autowired
	private UserService userService;
	@Before
	void setup() {
		this.userService = new UserService();
		
	}
	@Test void getAllPerson() {
		userService.getAllUser("Admin");
		verify(repo).findAll();
	}
	
	
	
}


