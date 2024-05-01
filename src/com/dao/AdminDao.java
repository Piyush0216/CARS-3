package com.dao;

import java.sql.SQLException; 
import java.util.List;

import com.model.User;

public interface AdminDao {

	boolean addUser(String username, String password, String Role) throws SQLException;
	
	List<User> GetAllUsers()throws SQLException;
	
	boolean DeleteUserByID(int User_id) throws SQLException;
	
	boolean UpdateUserPasswordByID(int User_id , String Password) throws SQLException;

	
		
	
}