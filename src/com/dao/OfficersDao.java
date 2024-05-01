package com.dao;

import java.sql.SQLException; 
import java.util.List;

import com.exception.ResourceNotFoundException;
import com.model.Officers;


public interface OfficersDao {
	    int save(Officers officer) throws SQLException;
	    void deleteById(int id) throws SQLException, ResourceNotFoundException;
	    void softdeleteById(int id) throws SQLException, ResourceNotFoundException;
//	    int update(int id,Officers updateArtist) throws SQLException, ResourceNotFoundException;
	    List<Officers> findAll() throws SQLException;
	    boolean findOne(int id) throws SQLException;
		List<Officers> getOfficersByRankBetween(int minRank, int maxRank) throws SQLException;
}

