package com.onlinemusicstore.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemusicstore.app.dao.UsersDao;
import com.onlinemusicstore.app.models.User;


@Service
public class UserServices {
	
	@Autowired
	private UsersDao userDao;
	
	public User getUserbyEmail(String email) {
		return userDao.getUserByEmail(email);
	}

}
