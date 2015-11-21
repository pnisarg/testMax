package com.projects.testMax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.testMax.entity.Users;
import com.projects.testMax.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public Users getUser(String username) {
		return userRepo.findOne(username);
	}

	@Override
	public Users authenticate(String username, String password) {
		Users user = getUser(username);
		if(user != null){
			if(password.equals(user.getPassword()))
				return user;
			else
				return null;
		}
		return null;
	}

	
}
