package com.rupesh.app.password.encription;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncriptor {

	public String encriptPassword(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
	
}
