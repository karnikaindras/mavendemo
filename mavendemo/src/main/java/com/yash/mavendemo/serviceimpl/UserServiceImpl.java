package com.yash.mavendemo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.mavendemo.dao.UserDAO;
import com.yash.mavendemo.model.User;
import com.yash.mavendemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userdao;
	
	public void addUser(User user) {
		userdao.insertUser(user);
	}

}
