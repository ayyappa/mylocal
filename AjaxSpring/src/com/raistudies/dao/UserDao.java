package com.raistudies.dao;

import com.raistudies.domain.User;

public interface UserDao {
	
	public void save(User user);
	public User get(int id);

}
