package com.service;

import java.sql.SQLException;  
import java.util.List;
import com.implDao.OfficersDaoImpl;
import com.dao.OfficersDao;
import com.implDao.AgencyDaoImpl;
import com.dao.AgencyDao;
import com.exception.ResourceNotFoundException;
import com.model.Officers;

public class OfficersService {
      
	OfficersDao officersDao=new OfficersDaoImpl();
	AgencyDao agencyDao=new AgencyDaoImpl();
	public int insert(Officers officers) throws SQLException {
		return officersDao.save(officers);
	}

	public void deleteByid(int officer_id)throws SQLException, ResourceNotFoundException  {
		boolean isIdValid=officersDao.findOne(officer_id);
		if(!isIdValid)
		throw new ResourceNotFoundException("Id given is Invalid!");
		officersDao.deleteById(officer_id);
		
	}
	public void softdeleteByid(int officer_id) throws SQLException, ResourceNotFoundException {
		boolean isIdValid=officersDao.findOne(officer_id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is Invalid!");
            officersDao.softdeleteById(officer_id);
    }

	public List<Officers> findAll() throws SQLException {
		return officersDao.findAll();
	}

	public List<Officers> getOfficersByAgencyId(int agency_id) throws SQLException, ResourceNotFoundException {
		boolean isAgencyIdValid = agencyDao.findOne(agency_id);
		if(!isAgencyIdValid)
			throw new ResourceNotFoundException("Agency ID invalid");
          return agencyDao.getOfficersByAgencyId(agency_id);
	}

	public List<Officers> getOfficersByRankBetween(int minRank, int maxRank) throws SQLException{
          return officersDao.getOfficersByRankBetween(minRank, maxRank);
	}

}
