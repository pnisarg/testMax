package com.projects.testMax.service;

import com.projects.testMax.entity.Users;


public interface UserService {
	public Users getUser(String username);

	public Users authenticate(String username, String password);
}
