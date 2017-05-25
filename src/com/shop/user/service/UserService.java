package com.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.shop.user.dao.UserDao;
import com.shop.user.model.User;

@Transactional
public class UserService {  
     
	  
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User findByusnameifexit(String username){
		return userDao.findByusnameifexit(username);
	}
}
