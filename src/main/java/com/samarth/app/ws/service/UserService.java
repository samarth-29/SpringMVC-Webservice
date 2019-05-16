package com.samarth.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.samarth.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	
	UserDto createUser(UserDto user);
	UserDto getUser(String email);
	UserDto getUserByUserId(String userId);
	UserDto updateUser(UserDto userDto, String userId);
	void deleteUser(String userId);
}
