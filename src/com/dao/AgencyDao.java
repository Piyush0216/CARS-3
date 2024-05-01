package com.dao;

import java.sql.SQLException;  
import java.util.List;

import com.dto.AgencyDto;
import com.exception.ResourceNotFoundException;
import com.model.Agency;

import com.model.Officers;


public interface AgencyDao {
	int save(Agency agency) throws SQLException,ResourceNotFoundException;
	List<Agency> findAll() throws SQLException,ResourceNotFoundException;
	boolean findOne(int agencyID) throws SQLException,ResourceNotFoundException;
	boolean findOne(String Jurisdiction) throws SQLException,ResourceNotFoundException;
	List<Officers> getOfficersByAgencyId(int agency_id) throws SQLException,ResourceNotFoundException;
	void deleteById(int agency_id)throws SQLException,ResourceNotFoundException;
	List<AgencyDto> getAgencyStats() throws SQLException,ResourceNotFoundException;
	List<Agency> getAgenciesByJurisdiction(String j)throws SQLException,ResourceNotFoundException;

}
