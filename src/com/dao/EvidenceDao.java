package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Evidence;
import com.model.EvidenceWithVictim;


public interface EvidenceDao {

	boolean addEvidence(String Description, String Location, int IncidentID) throws SQLException;
	
	boolean ValidateIncidentID(int IncidentID) throws SQLException;
	
	List<Evidence> GetAllEvidenceByIncidentID(int IncidentID) throws SQLException;

	List<EvidenceWithVictim> GetAllEvidenceFromVictim(int incidentID)throws SQLException;

	boolean ValidateVictimID(int victimID) throws SQLException;

	boolean ValidateEvidenceID(int evidenceID) throws SQLException;
	boolean updateEvidence(int evidenceId, String newDescription, String newLocation)throws SQLException;
		
	
}