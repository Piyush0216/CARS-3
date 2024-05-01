package com.dao;

import java.sql.SQLException;

import com.model.User;

public interface AuthDao {

	User login(String username, String password) throws SQLException;

}