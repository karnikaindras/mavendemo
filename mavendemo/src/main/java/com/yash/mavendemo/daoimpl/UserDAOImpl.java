package com.yash.mavendemo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.yash.mavendemo.dao.UserDAO;
import com.yash.mavendemo.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	Context ctx = null;
	Connection con = null;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null; 
	
	public UserDAOImpl() {
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/damsdb");
			con = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void insertUser(User user) {
		try {
			String query ="insert into users (email,password) values (?,?)";
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, user.getEmail());
			preparedStmt.setString(2, user.getPassword());
			preparedStmt.executeUpdate();
			con.close();				
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
