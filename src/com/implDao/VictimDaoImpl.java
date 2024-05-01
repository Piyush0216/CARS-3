package com.implDao;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.VictimDao;
import com.dto.VictimDto;
import com.exception.ResourceNotFoundException;
import com.model.Victim;
import com.utility.DBConnection;

public class VictimDaoImpl implements VictimDao{

	@Override
	public int save(Victim victim) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql = "insert into victim (victim_id,first_name,last_name,date_of_birth,gender,phone_number,address,incident_id) values (?,?,?,?,?,?,?,?)";
		// prepare the statement 
		PreparedStatement pstmt=con.prepareStatement(sql);
		// attach the statement 
		pstmt.setInt(1, victim.getVictim_id());
		pstmt.setString(2, victim.getFirst_name());
		pstmt.setString(3, victim.getLast_name());
		pstmt.setString(4, victim.getDate_of_birth());
		pstmt.setString(5, victim.getGender());
		pstmt.setString(6, victim.getPhone_number());
		pstmt.setString(7, victim.getAddress());
		pstmt.setInt(8, victim.getIncident_id());
		
		// execute the query
		int status=pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public void deleteById(int id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="delete from victim where victim_id=?";
		// prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

	@Override
	public void softDeleteById(int id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql = "update victim SET isActive='No' where victim_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
		
	}

	

	@Override
	public List<Victim> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select * from victim where isActive='yes'";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		List<Victim> list=new ArrayList<>();
		while(rst.next()==true) {
			int id=rst.getInt("victim_id");
			String first_name=rst.getString("first_name");
			String last_name=rst.getString("last_name");
			String date_of_birth=rst.getString("date_of_birth");
			String gender=rst.getString("gender");
			String phone_number=rst.getString("phone_number");
			String address=rst.getString("address");
			int incident_id=rst.getInt("incident_id");
			String isActive=rst.getString("isActive");
			Victim victim=new Victim(id,first_name,last_name,date_of_birth,gender,phone_number,address,incident_id,isActive);
			list.add(victim);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public boolean findOne(int id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select victim_id from victim where victim_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,id);
		ResultSet rst=pstmt.executeQuery();
		boolean status=rst.next(); // true / false
		DBConnection.dbClose();
		return status;
	}

	@Override
	public void update(int id,String updatedAddress) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="update victim SET address=?  where victim_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, updatedAddress);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

	@Override
	public List<VictimDto> findVictimWithMostIncidents() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select first_name, last_name, count(*) AS incident_count\r\n"
				+ "from victim\r\n"
				+ "group by incident_id\r\n"
				+ "having incident_count > 1";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		List<VictimDto> list=new ArrayList<>();
		while(rst.next()==true) {
			String first_name=rst.getString("first_name");
			String last_name=rst.getString("last_name");
			int incident_count=rst.getInt("incident_count");
			
			VictimDto victimDto = new VictimDto(first_name,last_name,incident_count);
			list.add(victimDto);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<Victim> getVictimsByIncidentLocation() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select v.*\r\n"
				+ "from victim v\r\n"
				+ "join incident i ON v.incident_id = i.incident_id\r\n"
				+ "where i.location = '123 Main St'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		List<Victim> list=new ArrayList<Victim>();
		while(rst.next()==true) {
			int id=rst.getInt("victim_id");
			String first_name=rst.getString("first_name");
			String last_name=rst.getString("last_name");
			String address=rst.getString("address");
			int incident_id=rst.getInt("incident_id");
			Victim victim=new Victim(id,first_name,last_name,"","","",address,incident_id,"");
			list.add(victim);
		}
		DBConnection.dbClose();
		return list;
	}

	

}