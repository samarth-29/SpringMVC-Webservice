package com.samarth.app.ws.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") // http://localhost:8080/users/
public class UserController {
	
	@GetMapping
	public String getUser()
	{
		return "get user";
	}
	
	@PostMapping
	public String createUser()
	{
		return "created user";
	}
	
	@PutMapping
	public String updateUser()
	{
		return "updated user";
	}
	
	@DeleteMapping
	public String deleteUser()
	{
		return "deleted user";
	}
}
