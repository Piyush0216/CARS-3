package com.service;

import java.sql.SQLException; 
import java.util.List;

import com.dao.AdminDao;
import com.implDao.*;
import com.model.User;


public class AdminService {

	AdminDao adminDao = new AdminDaoImpl();
	
	public boolean addUser(String username, String password, String Role) throws SQLException{
		 
		return adminDao.addUser(username, password, Role);
		
	}
	
	public List<User> GetAllUsers()throws SQLException{
		return adminDao.GetAllUsers();
	}
	
	
	public boolean DeleteUserByID(int id) throws SQLException{
		return adminDao.DeleteUserByID(id);
	}
	
	public boolean UpdateUSerPasswordByID(int id , String Password) throws SQLException{
		return adminDao.UpdateUserPasswordByID(id, Password);
	}
	
	public boolean MatchPassword(String Password, String ConfirmPassword) {
		if(Password.equals(ConfirmPassword)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean ValidatePassword(String Password) {
		
		 if (Password.length() < 6) {
	            return false;
	        }
		 return true;
	}
	
}