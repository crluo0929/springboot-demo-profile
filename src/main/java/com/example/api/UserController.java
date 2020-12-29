package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserController {

	@Autowired UserService userService ; 
	
	@GetMapping("/user/{id}")
	public User queryUser(@PathVariable int id) {
		return userService.getUserDataById(id);
	}
	
}
