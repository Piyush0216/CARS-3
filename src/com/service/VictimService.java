package com.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.dao.VictimDao;
import com.dto.VictimDto;
import com.exception.ResourceNotFoundException;
import com.implDao.VictimDaoImpl;
import com.model.Victim;
import com.utility.VictimSortUtilityAsc;
import com.utility.VictimSortUtilityDesc;

public class VictimService {

	VictimDao dao = new VictimDaoImpl();
	
	public int insert(Victim victim) throws SQLException{
		// TODO Auto-generated method stub
		return dao.save(victim);
	}

	public void deleteById(int id) throws SQLException,ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean isIdValid = dao.findOne(id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid");
		dao.deleteById(id);
	}

	public void softDeleteById(int id) throws SQLException,ResourceNotFoundException{
		// TODO Auto-generated method stub
		boolean isIdValid = dao.findOne(id);
		if (!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid !!");
		dao.softDeleteById(id);
	}

	public List<Victim> findAll() throws SQLException{
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void updateVictim(int id,String updatedAddress) throws SQLException,ResourceNotFoundException{
		// TODO Auto-generated method stub
		dao.update(id,updatedAddress);
	}

	public List<VictimDto> findVictimWithMostIncidents() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findVictimWithMostIncidents();
	}

	public List<Victim> getVictimsByIncidentLocation() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getVictimsByIncidentLocation();
	}

	public List<Victim> sortVictimByIncidentId(List<Victim> list,String sortDirection){
		if(sortDirection.equalsIgnoreCase("ASC")) {
			Collections.sort(list,new VictimSortUtilityAsc());
		}
		if(sortDirection.equalsIgnoreCase("DESC")) {
			Collections.sort(list,new VictimSortUtilityDesc());
		}
		return list;
	}
	
}