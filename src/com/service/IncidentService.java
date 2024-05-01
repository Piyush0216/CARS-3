package com.service;

import java.sql.SQLException;
import java.util.List;
import com.dao.*;
import com.implDao.*;
import com.dao.IncidentDao;
import com.exception.ResourceNotFoundException;
import com.model.Incident;

public class IncidentService {

	IncidentDao dao = new IncidentDaoImpl();
	OfficersDao officersDao = new OfficersDaoImpl();
	
	public int insert(Incident incident) throws SQLException {
		
	return dao.save(incident);
	
	}

	public void deleteByid(int id) throws SQLException, ResourceNotFoundException {
		boolean isIdValid =dao.findOne(id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id Given is invalid");
		
			dao.deleteById(id);
			
		
	}

	public void closeIncidentByid(int id) throws SQLException, ResourceNotFoundException {
		boolean isIdValid = dao.findOne(id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid !!");
		
		dao.closeIncidentById(id);
		
	}

	public List<Incident> findAll() throws ResourceNotFoundException,SQLException {
		
		return dao.findAll();
	}

	public List<Incident> getIncidentByOfficerId(int officerId) throws SQLException, ResourceNotFoundException {
		boolean isIdValid=officersDao.findOne(officerId);
		if(!isIdValid)
		throw new ResourceNotFoundException("Id given is Invalid!");
		return dao.getIncidentByOfficerId(officerId);
	}


	public List<Incident> getIncidentsInDateRange(String fromdate, String todate) throws ResourceNotFoundException, SQLException {
		IncidentDao dao = new IncidentDaoImpl();
		return dao.getIncidentsInDateRange(fromdate, todate);
	}

}