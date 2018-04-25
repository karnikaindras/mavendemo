package com.yash.mavendemo.serviceimpl;

import java.util.List;

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

	public User isExist(int id) {
		return userdao.isExist(id);
	}

	public boolean update(User user) {
		return userdao.update(user);
	}

	public boolean delete(int id) {
		return userdao.delete(id);
	}

	public List<User> listUsers() {
		return userdao.listUsers();
	}

}
