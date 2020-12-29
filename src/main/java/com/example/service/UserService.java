package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repo.UserRepository;

@Service
public class UserService {

	@Autowired UserRepository userDao ;
	
	public User getUserDataById(int id) {
		return userDao.findById(id).get();
	}
	
}
