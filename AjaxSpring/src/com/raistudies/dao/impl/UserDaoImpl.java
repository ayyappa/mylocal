package com.raistudies.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raistudies.dao.UserDao;
import com.raistudies.domain.User;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	public SessionFactory sessionFactory;

	
	@Override
	public String toString() {
		return "UserDaoImpl [sessionFactory=" + sessionFactory + "]";
	}

	public User get(int id) {
		// TODO Auto-generated method stub
		return (User)sessionFactory.getCurrentSession().get(User.class,id);
		
	}
	public void save(User user) {
		// TODO Auto-generated method stub
		System.out.println("Save Method:"+sessionFactory.isClosed());
		sessionFactory.getCurrentSession().save(user);
		
	}
	public List<User> getUserList()
	{
		return (List)sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	
	

}
