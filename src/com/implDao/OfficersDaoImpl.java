package com.implDao;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.OfficersDao;
import com.exception.ResourceNotFoundException;
import com.model.Officers;
import com.mysql.jdbc.PreparedStatement;
import com.utility.DBConnection;

public class OfficersDaoImpl implements OfficersDao{

	@Override
	public int save(Officers officer) throws SQLException {
		Connection con=DBConnection.dbConnect();
		String sql="INSERT INTO Officers(officer_id,first_name,last_name,badge_number,rank,phone_number,address,law_enforcement_agency_id,user_id) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(sql);
		pstmt.setInt(1, officer.getOfficer_id());
		pstmt.setString(2, officer.getFirst_name());
		pstmt.setString(3, officer.getLast_name());
		pstmt.setInt(4, officer.getBadge_number());
		pstmt.setInt(5, officer.getRank());
		pstmt.setInt(6, officer.getPhone_number());
		pstmt.setString(7, officer.getAddress());
		pstmt.setInt(8, officer.getLaw_enforcement_agency_id());
		pstmt.setInt(9, officer.getUser_id());
		int status=pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}
	@Override
	public void deleteById(int officer_id) throws SQLException, ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql="delete from officers where officer_id =?";
		//prepare the statement
		PreparedStatement pstmt = (PreparedStatement) con. prepareStatement (sql);
		pstmt. setInt (1, officer_id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
		
	}

	@Override
	public void softdeleteById(int officer_id) throws SQLException, ResourceNotFoundException {
		Connection con=DBConnection.dbConnect();
		String sql="update officers SET status='not active' where officer_id=?";
		PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(sql);
		pstmt.setInt(1, officer_id);
		pstmt.executeUpdate();
	    DBConnection.dbClose();	
		
	}

//	@Override
//	public int update(int id, Officers updateArtist) throws SQLException, ResourceNotFoundException {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public List<Officers> findAll() throws SQLException {
		Connection con=DBConnection.dbConnect();
		String sql="select * from officers where status='active'";
		PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		List<Officers> olist = new ArrayList<>();
		while(rst.next()==true) {
			int officer_id=rst.getInt("officer_id");
			String first_name=rst.getString("first_name");
			String last_name=rst.getString("last_name");
			int badge_number=rst.getInt("badge_number");
			int rank=rst.getInt("rank");
			int phone_number=rst.getInt("phone_number");
			String address=rst.getString("address");
			int law_enforcement_agency_id=rst.getInt("law_enforcement_agency_id");
			int user_id=rst.getInt("user_id");
			Officers officer=new Officers(officer_id,first_name,last_name,badge_number,rank,phone_number,address,law_enforcement_agency_id,user_id);
			olist.add(officer);
		}
		DBConnection.dbClose();
		return olist;
	}

	@Override
	public boolean findOne(int officer_id) throws SQLException {
		Connection con=DBConnection.dbConnect();
		String sql="select officer_id from officers where officer_id=?";
		PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(sql);
		pstmt.setInt(1, officer_id);
		ResultSet rst=pstmt.executeQuery();
		boolean status=rst.next();
		DBConnection.dbClose(); 
		return status;
	}
	@Override
	public List<Officers> getOfficersByRankBetween(int minRank, int maxRank) throws SQLException {
		 Connection con = DBConnection.dbConnect();
		 List<Officers> officersList = new ArrayList<>();
		 String sql = "SELECT * FROM officers WHERE rank BETWEEN ? AND ?";
	
			PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(sql); 
	        pstmt.setInt(1, minRank);
		    pstmt.setInt(2, maxRank);
		    ResultSet rst = pstmt.executeQuery();
		    while (rst.next()) {
		      int officerId = rst.getInt("officer_id");
		      String firstName = rst.getString("first_name");
		      String lastName = rst.getString("last_name");
		      int badgeNumber = rst.getInt("badge_number");
		      int rank = rst.getInt("rank");
		      int phoneNumber = rst.getInt("phone_number");
		      String address = rst.getString("address");
		      int lawEnforcementAgencyId = rst.getInt("law_enforcement_agency_id");
		      int userId = rst.getInt("user_id");
		      Officers officer = new Officers(officerId, firstName, lastName, badgeNumber, rank, phoneNumber, address, lawEnforcementAgencyId, userId);
		      officersList.add(officer);
		    }
		 
		  DBConnection.dbClose();
		  return officersList;
		}

}
