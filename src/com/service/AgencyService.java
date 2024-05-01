package com.service;

import java.sql.SQLException; 

import java.util.List;

import com.dao.AgencyDao;
import com.implDao.AgencyDaoImpl;
import com.dto.AgencyDto;
import com.exception.ResourceNotFoundException;
import com.model.Agency;


public class AgencyService {
	
	private static final String Jurisdiction = null;
	AgencyDao agencyDao = new AgencyDaoImpl();
	public int insert(Agency agency) throws SQLException, ResourceNotFoundException {
		return agencyDao.save(agency);
	}

	public List<Agency> findAll() throws SQLException, ResourceNotFoundException {
		return agencyDao.findAll();
	}

	public void deleteByid(int agency_id) throws SQLException, ResourceNotFoundException {
		boolean isIdValid=agencyDao.findOne(agency_id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!");		 
		agencyDao.deleteById(agency_id);
		
	}

	public List<Agency> getAgenciesByJurisdiction(String j) throws SQLException, ResourceNotFoundException{
		boolean isJurisdictionValid = agencyDao.findOne(j);
		if(!isJurisdictionValid)
			throw new ResourceNotFoundException("Jurisdiction invalid");
	
        return agencyDao.getAgenciesByJurisdiction(j);
	}

	public List<AgencyDto> getAgencyStats() throws SQLException, ResourceNotFoundException{
		
		return agencyDao.getAgencyStats();
	}
	
	
	
}
