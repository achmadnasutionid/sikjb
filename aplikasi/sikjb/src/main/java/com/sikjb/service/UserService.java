package com.sikjb.service;

import java.util.List;

import com.sikjb.model.User;

public interface UserService {
	
	List<User> listUser();
	
	User saveOrUpdate(User user);
	
	User getUserById(Long userId);
	
	void deleteUser(Long userId);

}