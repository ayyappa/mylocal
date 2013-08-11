package com.raistudies.service;

import com.raistudies.domain.User;

public interface UserService {
	
	public void save(User user);
	public User get(int id);

}
