package com.implDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ReportDao;
import com.dto.ReportDto;
import com.dto.ReportDto1;
import com.exception.ResourceNotFoundException;
import com.model.Report;
import com.utility.DBConnection;

public class ReportDaoImpl implements ReportDao {

	@Override
	public int save(Report report) throws SQLException {
		// insert artist record in DB
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO reports (report_id, report_date, report_details, status, officers_id) VALUES (?,?,?,?,?)";
		// prepare the statement
		PreparedStatement pstmt = con.prepareStatement(sql);
		// attach the data
		pstmt.setInt(1, report.getReport_id());
		pstmt.setString(2, report.getReport_date());
		pstmt.setString(3, report.getReport_details());
		pstmt.setString(4, report.getStatus());
		pstmt.setInt(5, report.getOfficers_id());
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
		String sql = "delete from reports where report_id =?";
		// prepare the statement
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

	@Override
	public Boolean findOne(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select report_id from reports where report_id=?";
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
		String sql = "update reports SET status='closed' where report_id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

	@Override
	public int update(int report_id, Report updatedReport) throws ResourceNotFoundException {
		return 0;
	}

	@Override
	public List<Report> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from reports";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Report> list = new ArrayList<>();
		while (rst.next() == true) {
			int report_id = rst.getInt("report_id");
			String reportDate = rst.getString("report_date");
			String reportDetails = rst.getString("report_details");
			String status = rst.getString("status");
			int officersID = rst.getInt("officers_id");
			Report report = new Report(report_id, reportDate, reportDetails, status, officersID);
			list.add(report);
		}
		DBConnection.dbClose();
		return list;
	}
	
//	@Override
//	public List<ReportDto> getReportStats() throws SQLException {
//		Connection con = DBConnection.dbConnect();
//		String sql="select a.name,count(a.artistID) as numberOfArtworks  "
//				+ " from artists a JOIN artworks art ON art.artistID = a.artistID "
//				+ " group by a.name";
//		PreparedStatement pstmt = con.prepareStatement(sql);
//		 
//		ResultSet rst = pstmt.executeQuery();
//		List<ReportDto> list = new ArrayList<>();
//		while(rst.next() == true) {
//			String name  = rst.getString("name");
//			int numberOfArtworks = rst.getInt("numberOfArtworks");
//			 
//			ReportDto report = new ReportDto(name,numberOfArtworks); //100X 200X 300X
//			list.add(report);
//		}
//		DBConnection.dbClose();		
//		return list;
//	}

	@Override
	public List<ReportDto> getReportStats() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT r.report_id AS ID, r.report_date AS DATE, r.report_details AS REPORT, o.officer_id AS OFFICER_ID, i.incident_type AS INCIDENT  \r\n"
				+ "from reports r\r\n"
				+ "JOIN officers o ON r.officers_id = o.officer_id\r\n"
				+ "JOIN incident_officers ic ON o.officer_id = ic.officers_id\r\n"
				+ "JOIN incident i ON ic.incident_id = i.incident_id\r\n"
				+ "GROUP BY o.officer_id;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		 
		ResultSet rst = pstmt.executeQuery();
		List<ReportDto> list = new ArrayList<>();
		while(rst.next() == true) {
			int ID  = rst.getInt("ID");
			String DATE = rst.getString("DATE");
			String REPORT = rst.getString("REPORT");
			int OFFICER_ID = rst.getInt("OFFICER_ID");
			String INCIDENT = rst.getString("INCIDENT");
			 
			ReportDto Report = new ReportDto(ID,DATE,REPORT,OFFICER_ID,INCIDENT); //100X 200X 300X
			list.add(Report);
		}
		DBConnection.dbClose();		
		return list;
	}

	
	@Override
	public List<ReportDto1> getReportByStatus() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT r.report_id AS ID, r.report_date AS DATE, r.report_details AS REPORT, r.status AS STATUS, o.officer_id AS OFFICER_ID, i.incident_type AS INCIDENT, i.description AS INCIDENT_DESCRIPTION\r\n"
				+ "from reports r\r\n"
				+ "JOIN officers o ON r.officers_id = o.officer_id\r\n"
				+ "JOIN incident_officers ic ON o.officer_id = ic.officers_id\r\n"
				+ "JOIN incident i ON ic.incident_id = i.incident_id\r\n"
				+ "WHERE r.status = \"open\" OR r.status = \"under investigation\"\r\n"
				+ "ORDER BY r.status;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		 
		ResultSet rst = pstmt.executeQuery();
		List<ReportDto1> list = new ArrayList<>();
		while(rst.next() == true) {
			int ID  = rst.getInt("ID");
			String DATE = rst.getString("DATE");
			String REPORT = rst.getString("REPORT");
			int OFFICER_ID = rst.getInt("OFFICER_ID");
			String INCIDENT = rst.getString("INCIDENT");
			String STATUS = rst.getString("STATUS");
			String INCIDENT_DESCRIPTION = rst.getString("INCIDENT_DESCRIPTION");
			ReportDto1 Report = new ReportDto1(ID,DATE,REPORT,OFFICER_ID,INCIDENT,STATUS,INCIDENT_DESCRIPTION); //100X 200X 300X
			list.add(Report);
		}
		DBConnection.dbClose();		
		return list;
	}
	
	@Override
	public List<ReportDto1> getReportByStatus1() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT r.report_id AS ID, r.report_date AS DATE, r.report_details AS REPORT, r.status AS STATUS, o.officer_id AS OFFICER_ID, i.incident_type AS INCIDENT, i.description AS INCIDENT_DESCRIPTION\r\n"
				+ "from reports r\r\n"
				+ "JOIN officers o ON r.officers_id = o.officer_id\r\n"
				+ "JOIN incident_officers ic ON o.officer_id = ic.officers_id\r\n"
				+ "JOIN incident i ON ic.incident_id = i.incident_id\r\n"
				+ "WHERE r.status = \"closed\"\r\n"
				+ "ORDER BY r.status;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		 
		ResultSet rst = pstmt.executeQuery();
		List<ReportDto1> list = new ArrayList<>();
		while(rst.next() == true) {
			int ID  = rst.getInt("ID");
			String DATE = rst.getString("DATE");
			String REPORT = rst.getString("REPORT");
			int OFFICER_ID = rst.getInt("OFFICER_ID");
			String INCIDENT = rst.getString("INCIDENT");
			String STATUS = rst.getString("STATUS");
			String INCIDENT_DESCRIPTION = rst.getString("INCIDENT_DESCRIPTION");
			ReportDto1 Report = new ReportDto1(ID,DATE,REPORT,OFFICER_ID,INCIDENT,STATUS,INCIDENT_DESCRIPTION); //100X 200X 300X
			list.add(Report);
		}
		DBConnection.dbClose();		
		return list;
	}
	


}