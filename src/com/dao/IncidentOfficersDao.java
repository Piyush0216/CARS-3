package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.IncidentOfficersDto;
import com.exception.ResourceNotFoundException;
import com.model.IncidentOfficers;

public interface IncidentOfficersDao {
	int save(IncidentOfficers incidentIncidentOfficer) throws SQLException; //1:for successful insert / 0 for failure 
	void deleteById(int id) throws SQLException,ResourceNotFoundException;
	void softDeleteById(int id) throws SQLException,ResourceNotFoundException;
	int update(int id, IncidentOfficers updatedIncidentOfficer) throws SQLException,ResourceNotFoundException; //id of existing record, updated record 
	List<IncidentOfficers> findAll() throws SQLException;
	Boolean findOne(int id) throws SQLException; 
	List<IncidentOfficersDao> getIncidentOfficersStats() throws SQLException;
	int UpdateById(int id) throws SQLException, ResourceNotFoundException;
	int UpdateById(int officer_id, IncidentOfficers updatedIncidentOfficers) throws ResourceNotFoundException;
	List<IncidentOfficersDto> findIncidentOfficers() throws SQLException;
}
//ResourceNotFoundException 