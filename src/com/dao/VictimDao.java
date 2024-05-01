package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.VictimDto;
import com.exception.ResourceNotFoundException;
import com.model.Victim;

public interface VictimDao {
	
	int save(Victim victim) throws SQLException;
	void deleteById(int id) throws SQLException,ResourceNotFoundException;
	void softDeleteById(int id) throws SQLException,ResourceNotFoundException;
	void update(int id,String updatedAddress) throws SQLException,ResourceNotFoundException;
	List<Victim> findAll() throws SQLException;
	boolean findOne(int id) throws SQLException,ResourceNotFoundException;
	
	List<VictimDto> findVictimWithMostIncidents() throws SQLException;
	List<Victim> getVictimsByIncidentLocation() throws SQLException;
}