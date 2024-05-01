package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.SuspectDto;
import com.exception.ResourceNotFoundException;
import com.model.Suspect;

public interface SuspectDao {
	int save (Suspect suspect) throws SQLException;
	void deleteById(int id) throws SQLException,ResourceNotFoundException;
	void softDeleteById(int id) throws SQLException,ResourceNotFoundException;
	void update(int id,String updatedAddress) throws SQLException,ResourceNotFoundException;
	List<Suspect> findAll() throws SQLException;
	boolean findOne(int id) throws SQLException,ResourceNotFoundException;
	
	List<SuspectDto> getSuspectsInvolvedInManyIncidents() throws SQLException;
	List<Suspect> getSuspectsbyIncidentType() throws SQLException;
}