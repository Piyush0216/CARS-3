package com.model;

import java.sql.Date;

public class Evidence {
	
	 	private int    evidenceID;
	    private String evidence_description;
	    private String evidence_locationFound;
	    private String incident_location;
	    private String incident_Type;
	    private String incident_Status;
	    private Date incident_date;
	    
	    
		public int getEvidenceID() {
			return evidenceID;
		}
		public void setEvidenceID(int evidenceID) {
			this.evidenceID = evidenceID;
		}
		public String getEvidence_description() {
			return evidence_description;
		}
		public void setEvidence_description(String evidence_description) {
			this.evidence_description = evidence_description;
		}
		public String getEvidence_locationFound() {
			return evidence_locationFound;
		}
		public void setEvidence_locationFound(String evidence_locationFound) {
			this.evidence_locationFound = evidence_locationFound;
		}
		
		public String getIncident_location() {
			return incident_location;
		}
		public void setIncident_location(String incident_location) {
			this.incident_location = incident_location;
		}
		public String getIncident_Type() {
			return incident_Type;
		}
		public void setIncident_Type(String incident_Type) {
			this.incident_Type = incident_Type;
		}
		public String getIncident_Status() {
			return incident_Status;
		}
		public void setIncident_Status(String incident_Status) {
			this.incident_Status = incident_Status;
		}
		public Date getIncident_date() {
			return incident_date;
		}
		public void setIncident_date(Date incident_date) {
			this.incident_date = incident_date;
		}
	    
		
		
	    

}