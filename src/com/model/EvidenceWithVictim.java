package com.model;

import java.sql.Date;

public class EvidenceWithVictim {   
	
	 	
	    private String first_name;
	    private String last_name;
	    private Date date_of_birth;
	    private String address;
	    private String gender;
	    
	    private int evidenceID;
	    private String evidence_description;
	    private String evidence_locationFound;
	    
	    
	    
		
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public Date getDate_of_birth() {
			return date_of_birth;
		}
		public void setDate_of_birth(Date date_of_birth) {
			this.date_of_birth = date_of_birth;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
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
	    
	   
		
	    

}