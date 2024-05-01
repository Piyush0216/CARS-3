package com.implDao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.AdminDao;
import com.model.Agency;
import com.model.User;
import com.utility.DBConnection;

public class AdminDaoImpl implements AdminDao {

    @Override
    public boolean addUser(String username, String password, String role) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean added = false;
        
        try {
        	 conn = DBConnection.dbConnect();
            
            // Check if the username already exists
            String checkQuery = "SELECT COUNT(*) FROM user WHERE name = ?";
            ps = conn.prepareStatement(checkQuery);
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                // Username already exists
                added = false;
            } else {
                // Username doesn't exist, proceed to add
                String addQuery = "INSERT INTO user (name, password, role,status) VALUES (?, ?, ?, ?)";
                ps = conn.prepareStatement(addQuery);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, role);
                ps.setString(4, "Active");
                
                
                
                int rowsAffected = ps.executeUpdate();
                
                if (rowsAffected > 0) {
                    // User added successfully
                    added = true;
                }
             
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            // Close resources
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return added;
    }

    @Override
    public List<User> GetAllUsers() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();

        try {
            conn = DBConnection.dbConnect();
            String query = "SELECT * FROM User where role = 'Officer'";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("name");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String status = rs.getString("status");
                
                User user = new User(id, username, password, role,status);
                userList.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); 
            throw ex;
        } finally {
            // Close resources
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return userList;
    }

	@Override
	public boolean DeleteUserByID(int User_id) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
	        PreparedStatement ps = null;
	        boolean deleted = false;

	        try {
	            conn = DBConnection.dbConnect();
	            String query = "UPDATE User set status = 'InActive' WHERE user_id = ?";
	            ps = conn.prepareStatement(query);
	            ps.setInt(1, User_id);
	            
	            int rowsAffected = ps.executeUpdate();

	            // Check if any rows were affected by the deletion
	            if (rowsAffected > 0) {
	                deleted = true;
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw ex;
	        } finally {
	            // Close resources
	            if (ps != null) {
	                ps.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }

	        return deleted;
	}

	@Override
	public boolean UpdateUserPasswordByID(int User_id, String Password) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
	        PreparedStatement ps = null;
	        boolean updated = false;

	        try {
	            conn = DBConnection.dbConnect();
	            String query = "UPDATE User SET password = ? WHERE user_id = ?";
	            ps = conn.prepareStatement(query);
	            ps.setString(1, Password);
	            ps.setInt(2, User_id);
	            int rowsAffected = ps.executeUpdate();

	            // Check if any rows were affected by the update
	            if (rowsAffected > 0) {
	                updated = true;
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw ex;
	        } finally {
	            // Close resources
	            if (ps != null) {
	                ps.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }

	        return updated;
	}


}
