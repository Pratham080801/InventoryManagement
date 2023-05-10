package com.gl.inventorymanagement.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gl.inventorymanagement.entity.User;
import com.gl.inventorymanagement.repository.UserRepository;

@Component
	public class UserInfoUserDetailsService implements UserDetailsService {

	    @Autowired
	    private UserRepository repository;

	    @Override
	    public UserDetails loadUserByUsername(String username) {
	    	System.out.println(username);
	        Optional<User> userInfo = repository.findByUsername(username);
	        System.out.println(userInfo.get().getUsername());
	        System.out.println(userInfo.get().getPassword());
	        return userInfo.map(UserInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

	    }
	}