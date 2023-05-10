package com.gl.inventorymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.inventorymanagement.entity.User;
import com.gl.inventorymanagement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	public User authenticate(String name, String password) {
		return userRepository.findUserByUsernameAndPassword(name, password);
	}

	public User registerUser(User user) {
		String password=  passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		return userRepository.save(user);
	}
	
}
