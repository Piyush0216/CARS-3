package com.implDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Evidence;
import com.model.EvidenceWithVictim;
import com.dao.EvidenceDao;
import com.utility.DBConnection;

public class EvidenceDaoImpl implements EvidenceDao {

	@Override
	public boolean addEvidence(String Description, String Location, int IncidentID) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn =  DBConnection.dbConnect();
            String query = "INSERT INTO Evidence (description, location_found, incident_id) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, Description);
            stmt.setString(2, Location);
            stmt.setInt(3, IncidentID);
            
            int rowsAffected = stmt.executeUpdate();
            // If rowsAffected > 0, it means the evidence was added successfully
            return rowsAffected > 0;
        } finally {
            // Close the resources in reverse order to avoid potential resource leaks
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
	}

	@Override
	public boolean ValidateIncidentID(int IncidentID) throws SQLException {
		// TODO Auto-generated method stub
		  Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        boolean exists = false;

	        try {
	            conn = DBConnection.dbConnect();
	            String query = "SELECT COUNT(*) FROM incident WHERE incident_id = ?";
	            stmt = conn.prepareStatement(query);
	            stmt.setInt(1, IncidentID);
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                int count = rs.getInt(1);
	                exists = (count > 0);
	            }
	        } finally {
	            // Close the resources in reverse order to avoid potential resource leaks
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	        return exists;
	}

	@Override
	public List<Evidence> GetAllEvidenceByIncidentID(int IncidentID) throws SQLException {
		// TODO Auto-generated method stub
		
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<Evidence> evidences = new ArrayList<>();
	       
	        
	        try {
	            conn = DBConnection.dbConnect();
	            String query = "SELECT e.evidence_id,e.description,e.location_found,i.location,i.status,i.incident_type,i.incident_date FROM evidence as e JOIN incident as i ON e.incident_id = i.incident_id WHERE e.incident_id = ?";
	            stmt = conn.prepareStatement(query);
	            stmt.setInt(1, IncidentID);
	            rs = stmt.executeQuery();

	            while(rs.next()) {
	               
	            	 Evidence evidence = new Evidence();
	                 evidence.setEvidenceID(rs.getInt("evidence_id"));
	                 evidence.setEvidence_description(rs.getString("description"));
	                 evidence.setEvidence_locationFound(rs.getString("location_found"));
	                 evidence.setIncident_location(rs.getString("location"));
	                 evidence.setIncident_Type(rs.getString("incident_type"));
	                 evidence.setIncident_Status(rs.getString("status"));
	                 evidence.setIncident_date(rs.getDate("incident_date"));
	                 evidences.add(evidence);
	                
	                
	            }
	        } finally {
	            // Close the resources in reverse order to avoid potential resource leaks
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	        return evidences;
	}

	@Override
	public List<EvidenceWithVictim> GetAllEvidenceFromVictim(int victimID) throws SQLException {
		// TODO Auto-generated method stub
		
		 Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<EvidenceWithVictim> evidences = new ArrayList<>();
	       
	        
	        try {
	            conn = DBConnection.dbConnect();
	            String query = "SELECT ev.evidence_id,ev.description ,ev.location_found,v.first_name,v.last_name,v.date_of_birth, v.address,v.gender FROM evidence AS ev JOIN incident AS i ON ev.incident_id = i.incident_id JOIN victim AS v ON i.incident_id = v.incident_id WHERE v.victim_id = ?";
  stmt = conn.prepareStatement(query);
	            stmt.setInt(1, victimID);
	            rs = stmt.executeQuery();

	            while(rs.next()) {
	            	
	    	               
	            	 EvidenceWithVictim evidence = new EvidenceWithVictim();
	                 evidence.setEvidenceID(rs.getInt("evidence_id"));
	                 evidence.setEvidence_description(rs.getString("description"));
	                 evidence.setEvidence_locationFound(rs.getString("location_found"));
	                 evidence.setFirst_name(rs.getString("first_name"));
	                 evidence.setLast_name(rs.getString("last_name"));
	                 evidence.setGender(rs.getString("gender"));
	                 evidence.setAddress(rs.getString("address"));
	                 evidence.setDate_of_birth(rs.getDate("date_of_birth"));
	                 
	                 evidences.add(evidence);
	                
	                
	            }
	        } finally {
	            // Close the resources in reverse order to avoid potential resource leaks
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	        return evidences;
	}

	@Override
	public boolean ValidateVictimID(int victimID) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean exists = false;

        try {
            conn = DBConnection.dbConnect();
            String query = "SELECT COUNT(*) FROM victim WHERE victim_id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, victimID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                exists = (count > 0);
            }
        } finally {
            // Close the resources in reverse order to avoid potential resource leaks
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return exists;
	}
	
	@Override
	public boolean ValidateEvidenceID(int evidenceID) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean exists = false;

        try {
            conn = DBConnection.dbConnect();
            String query = "SELECT COUNT(*) FROM evidence WHERE evidence_id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, evidenceID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                exists = (count > 0);
            }
        } finally {
            // Close the resources in reverse order to avoid potential resource leaks
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return exists;
	}
	@Override
	public boolean updateEvidence(int evidenceId, String newDescription, String newLocation) throws SQLException {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = DBConnection.dbConnect();
	        String query = "UPDATE evidence SET description = ?, location_found = ? WHERE evidence_id = ?";
	        stmt = conn.prepareStatement(query);
	        stmt.setString(1, newDescription);
	        stmt.setString(2, newLocation);
	        stmt.setInt(3, evidenceId);

	        int rowsAffected = stmt.executeUpdate();
	        // If rowsAffected > 0, it means the evidence was updated successfully
	        return rowsAffected > 0;
	    } finally {
	        // Close the resources in reverse order to avoid potential resource leaks
	        if (stmt != null) {
	            stmt.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }
	}

	

  }
