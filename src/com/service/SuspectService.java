package com.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.dao.SuspectDao;
import com.implDao.SuspectDaoImpl;
import com.dto.SuspectDto;
import com.exception.ResourceNotFoundException;
import com.model.Suspect;
import com.utility.SuspectSortUtilityAsc;
import com.utility.SuspectSortUtilityDesc;

public class SuspectService {

	SuspectDao dao = new SuspectDaoImpl();
	
	public int save(Suspect suspect) throws SQLException {
		// TODO Auto-generated method stub
		
		return dao.save(suspect);
	}

	public void deleteByID(int id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean isIdValid=dao.findOne(id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given id Invalid");
		dao.deleteById(id);
	}

	public void softDeleteByID(int id) throws SQLException,ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean isIdValid=dao.findOne(id);
		
		if(!isIdValid){
			throw new ResourceNotFoundException("Id given is Invalid");
		}
		dao.softDeleteById(id);
	}

	public void update(int given_id, String updatedAddress) throws SQLException,ResourceNotFoundException {
		// TODO Auto-generated method stub
		dao.update(given_id, updatedAddress);
	}

	public List<Suspect> findAll() throws SQLException{
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<SuspectDto> getSuspectsInvolvedInManyIncidents() throws SQLException{
		// TODO Auto-generated method stub
		return dao.getSuspectsInvolvedInManyIncidents();
	}

	public List<Suspect> getSuspectsbyIncidentType() throws SQLException{
		// TODO Auto-generated method stub
		return dao.getSuspectsbyIncidentType();
	}
	
	
	
	public List<Suspect> sortSuspectByIncidentId(List<Suspect> list,String sortDirection){
		if(sortDirection.equalsIgnoreCase("ASC")) {
			Collections.sort(list,new SuspectSortUtilityAsc());
		}
		if(sortDirection.equalsIgnoreCase("DESC")) {
			Collections.sort(list,new SuspectSortUtilityDesc());
		}
		return list;
	}

}