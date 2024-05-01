package com.implDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.SuspectDao;
import com.dto.SuspectDto;
import com.exception.ResourceNotFoundException;
import com.model.Suspect;
import com.utility.DBConnection;

public class SuspectDaoImpl implements SuspectDao{

	@Override
	public int save(Suspect suspect) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = DBConnection.dbConnect();
		String sql="insert into suspect (suspect_id,first_name,last_name,date_of_birth,gender,phone_number,address,incident_id)\r\n"
				+ "values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, suspect.getSuspect_id());
		pstmt.setString(2, suspect.getFirst_name());
		pstmt.setString(3, suspect.getLast_name());
		pstmt.setString(4, suspect.getDate_of_birth());
		pstmt.setString(5, suspect.getGender());
		pstmt.setString(6, suspect.getPhone_number());
		pstmt.setString(7, suspect.getAddress());
		pstmt.setInt(8, suspect.getIncident_id());

		int status=pstmt.executeUpdate();
		DBConnection.dbClose();
		
		return status;
	}

	@Override
	public void deleteById(int id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql= "delete from suspect where suspect_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
		
	}

	@Override
	public boolean findOne(int id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select suspect_id from suspect where suspect_id=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1,id);
		ResultSet rst=pstmt.executeQuery();
		boolean status=rst.next();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public void softDeleteById(int id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="update suspect SET isActive='No' where suspect_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

	@Override
	public void update(int id, String updatedAddress) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="update suspect SET address=? where suspect_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, updatedAddress);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

	@Override
	public List<Suspect> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select * from suspect where isActive='yes'";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		
		ResultSet rst=pstmt.executeQuery();
		List<Suspect> list=new ArrayList<Suspect>();
		
		while(rst.next()==true) {
			int id=rst.getInt("suspect_id");
			String first_name = rst.getString("first_name");
			String last_name= rst.getString("last_name");
			String date_of_birth=rst.getString("date_of_birth");
			String gender=rst.getString("gender");
			String phone_number=rst.getString("phone_number");
			String address=rst.getString("address");
			int incident_id=rst.getInt("incident_id");
			Suspect suspect=new Suspect(id,first_name,last_name,date_of_birth,gender,phone_number,address,incident_id);
			list.add(suspect);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<SuspectDto> getSuspectsInvolvedInManyIncidents() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select first_name, last_name, count(*) AS incident_count\r\n"
				+ "from suspect\r\n"
				+ "group by incident_id\r\n"
				+ "having incident_count > 1;";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		List<SuspectDto> list=new ArrayList<SuspectDto>();
		while(rst.next()==true) {
			String first_name=rst.getString("first_name");
			String last_name=rst.getString("last_name");
			int incident_count=rst.getInt("incident_count");
			SuspectDto suspectDto=new SuspectDto(first_name,last_name,incident_count);
			list.add(suspectDto);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<Suspect> getSuspectsbyIncidentType() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select s.*\r\n"
				+ "from suspect s\r\n"
				+ "join incident i ON s.incident_id = i.incident_id\r\n"
				+ "where incident_type='Theft'";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		List<Suspect> list=new ArrayList<Suspect>();
		while(rst.next()==true) {
			int id=rst.getInt("suspect_id");
			String first_name = rst.getString("first_name");
			String last_name= rst.getString("last_name");
			String date_of_birth=rst.getString("date_of_birth");
			String gender=rst.getString("gender");
			String phone_number=rst.getString("phone_number");
			String address=rst.getString("address");
			int incident_id=rst.getInt("incident_id");
			Suspect suspect=new Suspect(id,first_name,last_name,date_of_birth,gender,phone_number,address,incident_id);
			list.add(suspect);
		}
		DBConnection.dbClose();
		return list;
	}

}