package com.service;

import java.sql.SQLException;
import java.util.List;
import com.dao.EvidenceDao;
import com.implDao.*;
import com.model.Evidence;
import com.model.EvidenceWithVictim;



public class EvidenceService {

	EvidenceDao officerDao = new EvidenceDaoImpl();
	
	public String addEvidence(String Description, String Location, int IncidentID) throws SQLException{
		
		if(officerDao.ValidateIncidentID(IncidentID)) {
			if(officerDao.addEvidence(Description,Location,IncidentID)) {
				
				return "For IncidentId " + IncidentID + " Evidence is Added";
				
			}else {
				return "Something Went Wrong Try Again!";
			}
			
		}else {
			return "IncidentID Does Not Exist Try Again!";
		}		
	}
	
	
	public List<Evidence> GetAllEvidenceByIncidentID(int IncidentID) throws SQLException{
		
		List<Evidence> output = null;
		
		if(officerDao.ValidateIncidentID(IncidentID)) {
			
			output =  officerDao.GetAllEvidenceByIncidentID(IncidentID);			
		}
		return output;
	}
	
    public List<EvidenceWithVictim> GetAllEvidenceFromVictim(int victimID) throws SQLException{
		
		List<EvidenceWithVictim> output = null;
		
		if(officerDao.ValidateVictimID(victimID)) {
			
			output =  officerDao.GetAllEvidenceFromVictim(victimID);			
		}
		return output;
	}
    public String updateEvidence(int evidenceId, String newDescription, String newLocation)throws SQLException {
        try {
            if (officerDao.updateEvidence(evidenceId, newDescription, newLocation)) {
                return "Evidence updated successfully";
            } else {
                return "Failed to update evidence";
            }
        } catch (SQLException e) {
            return "Error updating evidence: " + e.getMessage();
        }
    }
    
	
	
	
	
}