package com.yash.mavendemo.service;

import java.util.List;

import com.yash.mavendemo.model.User;

public interface UserService {
	public void addUser(User user);
	public User isExist(int id);
	public boolean update(User user);
	public boolean delete(int id);
	public List<User> listUsers();
}
