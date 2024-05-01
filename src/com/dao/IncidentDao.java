package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.ResourceNotFoundException;
import com.model.Incident;
import com.model.Report;


public interface IncidentDao {
	
	int save(Incident incident) throws SQLException; //1 for successful insert  , 0 for failure
	void deleteById(int id) throws SQLException,ResourceNotFoundException ;
	void softDeleteById(int id) throws SQLException, ResourceNotFoundException;
	int update(int id, Incident updateIncident) throws SQLException,ResourceNotFoundException; //id of existing record, updated record
	List<Incident>findAll() throws ResourceNotFoundException,SQLException;
	Boolean findOne(int id) throws SQLException;
	void closeIncidentById(int id) throws SQLException, ResourceNotFoundException;
	List<Incident> getIncidentByOfficerId(int officerId)throws SQLException;
	List<Incident> getIncidentsInDateRange(String fromdate,String todate)throws ResourceNotFoundException,SQLException;
	Report generateIncidentReport() throws ResourceNotFoundException, SQLException;
}