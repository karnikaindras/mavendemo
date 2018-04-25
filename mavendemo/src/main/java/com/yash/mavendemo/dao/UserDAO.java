package com.yash.mavendemo.dao;

import java.util.List;

import com.yash.mavendemo.model.User;

public interface UserDAO {
	public void insertUser(User user);
	public User isExist(int id);
	public boolean update(User user);
	public boolean delete(int id);
	public List<User> listUsers();
}
