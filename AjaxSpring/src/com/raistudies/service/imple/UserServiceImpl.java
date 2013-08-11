package com.raistudies.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raistudies.dao.UserDao;
import com.raistudies.domain.User;
import com.raistudies.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	public User get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}
	@Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);

	}

}
