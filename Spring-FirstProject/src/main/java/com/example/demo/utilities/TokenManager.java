package com.example.demo.utilities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.model.UserModel;

@Component
public class TokenManager implements Serializable{
	private static final long serialVersionUID = -2550185165626007488L;

	public static final String JWT_TOKEN_VALIDITY = "secret";

	@Value("${jwt.secret}")
	private String secret;
	
	public String generateToken(UserModel userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return userDetails.getName();
	}

	
	

}
