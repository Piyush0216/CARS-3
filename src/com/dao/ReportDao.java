package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.ReportDto;
import com.dto.ReportDto1;
import com.exception.ResourceNotFoundException;
import com.model.Report;

public interface ReportDao {
	int save(Report report) throws SQLException; //1:for successful insert / 0 for failure 
	void deleteById(int id) throws SQLException,ResourceNotFoundException;
	void softDeleteById(int id) throws SQLException,ResourceNotFoundException;
	int update(int id, Report updatedReport) throws SQLException,ResourceNotFoundException; //id of existing record, updated record 
	List<Report> findAll() throws SQLException;
	Boolean findOne(int id) throws SQLException; 
	List<ReportDto> getReportStats() throws SQLException;
	List<ReportDto1> getReportByStatus() throws SQLException;
	List<ReportDto1> getReportByStatus1() throws SQLException;
}
//ResourceNotFoundException 