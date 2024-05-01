package com.implDao;

import java.sql.Connection;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.AgencyDao;
import com.dto.AgencyDto;
import com.exception.ResourceNotFoundException;
import com.model.Agency;
import com.model.Officers;
import com.mysql.jdbc.PreparedStatement;
import com.utility.DBConnection;

public class AgencyDaoImpl implements AgencyDao {

	@Override
	public List<Agency> findAll() throws SQLException, ResourceNotFoundException{
		Connection con=DBConnection.dbConnect();
		String sql="select * from  law_enforcement_agency;";
		PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		List<Agency> alist = new ArrayList<>();
		while(rst.next()==true) {
			int agency_id=rst.getInt("agency_id");
			String agency_name=rst.getString("agency_name");
			String jurisdiction=rst.getString("jurisdiction");
			
			int phone_number=rst.getInt("phone_number");
			String address=rst.getString("address");
			
			Agency agency=new Agency(agency_id,agency_name,jurisdiction,phone_number,address);
			alist.add(agency);
		}
		DBConnection.dbClose();
		return alist;
	}

	@Override
	public boolean findOne(int agency_id) throws SQLException ,ResourceNotFoundException{
		Connection con=DBConnection.dbConnect();
		String sql="select agency_id from law_enforcement_agency where agency_id=?";
		PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(sql);
		pstmt.setInt(1, agency_id);
		ResultSet rst=pstmt.executeQuery();
		boolean status=rst.next();
		DBConnection.dbClose(); 
		return status;
	}

	@Override
	public int save(Agency agency) throws SQLException,ResourceNotFoundException {
		Connection con=DBConnection.dbConnect();
		String sql="INSERT INTO law_enforcement_agency(agency_id,agency_name,jurisdiction,phone_number,address) VALUES (?,?,?,?,?)";
		PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(sql);
		pstmt.setInt(1, agency.getAgency_id());
		pstmt.setString(2, agency.getAgency_name());
		pstmt.setString(3, agency.getJurisdiction());
		pstmt.setInt(4, agency.getPhone_number());
		pstmt.setString(5, agency.getAddress());
		int status=pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public List<Officers> getOfficersByAgencyId(int agency_id) throws SQLException,ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
	    String sql = "SELECT * FROM officers WHERE law_enforcement_agency_id = ?";
	    PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
	    pstmt.setInt(1, agency_id);
	    ResultSet rst = pstmt.executeQuery();
	    List<Officers> officersList = new ArrayList<>();
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

	@Override
	public void deleteById(int agency_id) throws SQLException,ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql=" delete from law_enforcement_agency where agency_id=?";
		//prepare the statement
		PreparedStatement pstmt = (PreparedStatement) con. prepareStatement (sql);
		pstmt. setInt (1, agency_id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

	@Override
	public List<AgencyDto> getAgencyStats() throws SQLException,ResourceNotFoundException {
		
		Connection con = DBConnection.dbConnect();
		String sql=" SELECT agency_name, COUNT(*) AS officer_count FROM law_enforcement_agency la JOIN officers ao ON la.agency_id = ao.law_enforcement_agency_id GROUP BY agency_name ORDER BY officer_count DESC";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		 
		ResultSet rst = pstmt.executeQuery();
		List<AgencyDto> list = new ArrayList<>();
		while(rst.next() == true) {
			String agency_name  = rst.getString("agency_name");
			int officer_count = rst.getInt("officer_count");
			 
			AgencyDto agency = new AgencyDto(agency_name,officer_count); //100X 200X 300X
			list.add(agency);
		}
		DBConnection.dbClose();		
		return list;
	}

	@Override
	public boolean findOne(String j) throws SQLException,ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
	    String sql = "SELECT * FROM law_enforcement_agency WHERE jurisdiction=?";
	    PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
	      pstmt.setString(1, j);
	      ResultSet rst = pstmt.executeQuery();
	      boolean status = rst.next();
	      if (!status) {
	        throw new ResourceNotFoundException("Agency with jurisdiction '" + j + "' not found.");
	      }
	      DBConnection.dbClose();		
	      return status;
	      }

	@Override
	public List<Agency> getAgenciesByJurisdiction(String jurisdiction) throws SQLException,ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql=" SELECT * FROM law_enforcement_agency WHERE jurisdiction = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, jurisdiction);
		ResultSet rst = pstmt.executeQuery();
		List<Agency> list = new ArrayList<>();
		 while (rst.next()) {
		      int agencyId = rst.getInt("agency_id");
		      String agencyName = rst.getString("agency_name");
		      String jursdiction = rst.getString("jurisdiction");
		      int phoneNumber = rst.getInt("phone_number");
		      String address = rst.getString("address");
		      Agency agency = new Agency(agencyId, agencyName, jursdiction, phoneNumber, address);
		      list.add(agency);
		    }
		DBConnection.dbClose();		
		return list;
	}
	

}
