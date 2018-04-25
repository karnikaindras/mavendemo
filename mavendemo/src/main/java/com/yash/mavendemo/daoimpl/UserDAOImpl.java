package com.yash.mavendemo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yash.mavendemo.dao.UserDAO;
import com.yash.mavendemo.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void insertUser(User user) {		
		sessionFactory.getCurrentSession().save(user);
	}
	
	@Transactional
	public User isExist(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		User user = (User) session.load(User.class, new Integer(id));
		return user;
	}
	
	@Transactional
	public boolean update(User user) {
		boolean success = false;
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.update(user);
			success =true;
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return success;		
	}
	
	@Transactional
	public boolean delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));
		if(null != user){
			session.delete(user);
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("select id, email from User").list();
		return userList;
	}

}
