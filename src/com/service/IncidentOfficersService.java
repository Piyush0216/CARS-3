package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.dto.IncidentOfficersDto;
import com.exception.ResourceNotFoundException;
import com.implDao.IncidentOfficersDaoImpl;
import com.model.IncidentOfficers;

public class IncidentOfficersService {

	IncidentOfficersDao dao = new IncidentOfficersDaoImpl();
	
	public int insert(IncidentOfficers incidentOfficers) throws SQLException {
		return dao.save(incidentOfficers);
	}

	public void deleteByid(int id) throws SQLException, ResourceNotFoundException {
		boolean isIdValid = dao.findOne(id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!!");
		 
		dao.deleteById(id);
	}

	public void softDeleteByid(int id) throws ResourceNotFoundException, SQLException {
		boolean isIdValid = dao.findOne(id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!!");
		 
		dao.softDeleteById(id);
		
	}

	public List<IncidentOfficers> findAll() throws SQLException {
		return dao.findAll();
	}

	public void UpdateById(int id) throws ResourceNotFoundException, SQLException {
		boolean isIdValid = dao.findOne(id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!!");
		 
		dao.UpdateById(id);
	}

	public List<IncidentOfficersDto> findIncidentOfficers() throws SQLException {
		return dao.findIncidentOfficers();
	}

}