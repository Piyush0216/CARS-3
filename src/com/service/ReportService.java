package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ReportDao;

import com.dto.ReportDto;
import com.dto.ReportDto1;
import com.exception.ResourceNotFoundException;
import com.implDao.ReportDaoImpl;
import com.model.Report;

public class ReportService {

	ReportDao dao = new ReportDaoImpl(); //poly
	
	public int insert(Report report) throws SQLException {
		return dao.save(report);
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

	public List<Report> findAll() throws SQLException {
		return dao.findAll();
	}
	
	public List<ReportDto> getReportStats() throws SQLException {
		return dao.getReportStats();
	
	}
	

	public List<ReportDto1> getReportByStatus() throws SQLException {
		return dao.getReportByStatus();
	}
	
	public List<ReportDto1> getReportByStatus1() throws SQLException {
		return dao.getReportByStatus1();
	}
	
}