package com.service;

import java.sql.SQLException;


import com.dao.AuthDao;
import com.implDao.*;
import com.exception.InvalidCredentialsException;
import com.model.User;

public class AuthService {

	AuthDao authDao = new AuthDaoImpl();


	public User login(String username, String password) throws SQLException, InvalidCredentialsException {
		 
		User user = authDao.login(username,password);
		if(user == null) {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
		return user;
	}
	
	
	
	
}