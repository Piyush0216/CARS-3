package com.implDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.IncidentOfficersDao;
import com.dto.IncidentOfficersDto;
import com.exception.ResourceNotFoundException;
import com.model.IncidentOfficers;
import com.utility.DBConnection;

public class IncidentOfficersDaoImpl implements IncidentOfficersDao {

	@Override
	public int save(IncidentOfficers incidentOfficers) throws SQLException {
		// insert artist record in DB
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO incident_officers (incident_id, officers_id, date_assigned) VALUES (?,?,?)";
		// prepare the statement
		PreparedStatement pstmt = con.prepareStatement(sql);
		// attach the data
		pstmt.setInt(1, incidentOfficers.getIncident_id());
		pstmt.setInt(2, incidentOfficers.getOfficers_id());
		pstmt.setString(3, incidentOfficers.getDate_assigned());
		// execute the query
		int status = pstmt.executeUpdate(); // 1: if all good., 0 - if op fails
		DBConnection.dbClose();
		return status;
	}

	/*
	 * executeQuery(); -- select update,insert,delete == executeUpdate();
	 */
	@Override
	public void deleteById(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "delete from incident_officers where officers_id =?";
		// prepare the statement
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

	@Override
	public Boolean findOne(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select officers_id from incident_officers where officers_id=?";
		// prepare the statement
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next(); // true / false
		DBConnection.dbClose();
		return status;
	}

	@Override
	public void softDeleteById(int id) throws SQLException, ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "update incident_officers SET officers_id='22' where incident_id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

	@Override
	public int update(int incident_id, IncidentOfficers updatedIncidentOfficers) throws ResourceNotFoundException {
		return 0;
	}

	@Override
	public List<IncidentOfficers> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * from incident_officers io\r\n"
				+ "JOIN incident i ON io.incident_id = i.incident_id;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<IncidentOfficers> list = new ArrayList<>();
		while (rst.next() == true) {
			int incident_id = rst.getInt("incident_id");
			int officers_id = rst.getInt("officers_id");
			String date_assigned = rst.getString("date_assigned");
			IncidentOfficers incidentOfficers = new IncidentOfficers(incident_id, officers_id, date_assigned);
			list.add(incidentOfficers);
		}
		DBConnection.dbClose();
		return list;
	}
	
	
	@Override
	public int UpdateById(int id) throws SQLException, ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "update incident_officers SET incident_id='22' where officers_id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
		return id;
	}
	@Override
	public int UpdateById(int officer_id, IncidentOfficers updatedIncidentOfficers) throws ResourceNotFoundException {
		return 0;
	}
	

	@Override
	public List<IncidentOfficersDao> getIncidentOfficersStats() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<IncidentOfficersDto> findIncidentOfficers() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT o.officer_id AS ID, CONCAT(o.first_name,' ',o.last_name) AS OFFICER_NAME, i.incident_date AS INCIDENT_DATE, io.date_assigned AS DATE_ASSIGNED, lea.agency_name AS AGENCY\r\n"
				+ "from incident_officers io\r\n"
				+ "JOIN incident i ON io.incident_id = i.incident_id\r\n"
				+ "JOIN officers o ON o.officer_id = io.officers_id\r\n"
				+ "JOIN law_enforcement_agency lea ON o.law_enforcement_agency_id = lea.agency_id\r\n"
				+ "ORDER BY o.officer_id;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<IncidentOfficersDto> list = new ArrayList<>();
		while (rst.next() == true) {
			int ID = rst.getInt("ID");
			String OFFICER_NAME = rst.getString("OFFICER_NAME");
			String INCIDENT_DATE = rst.getString("INCIDENT_DATE");
			String DATE_ASSIGNED = rst.getString("DATE_ASSIGNED");
			String AGENCY = rst.getString("AGENCY");
			IncidentOfficersDto incidentOfficersDto = new IncidentOfficersDto(ID, OFFICER_NAME, INCIDENT_DATE, DATE_ASSIGNED, AGENCY);
			list.add(incidentOfficersDto);
		}
		DBConnection.dbClose();
		return list;
	}
	
	


	






}