package com.dto;

public class IncidentOfficersDto {
	private int ID;
	private String OFFICER_NAME;
	private String INCIDENT_DATE;
	private String DATE_ASSIGNED;
	private String AGENCY;
//ID, OFFICER_NAME, INCIDENT_DATE, DATE_ASSIGNED, AGENCY
	public IncidentOfficersDto(int iD, String oFFICER_NAME, String iNCIDENT_DATE, String dATE_ASSIGNED, String aGENCY) {
		super();
		ID = iD;
		OFFICER_NAME = oFFICER_NAME;
		INCIDENT_DATE = iNCIDENT_DATE;
		DATE_ASSIGNED = dATE_ASSIGNED;
		AGENCY = aGENCY;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getOFFICER_NAME() {
		return OFFICER_NAME;
	}
	public void setOFFICER_NAME(String oFFICER_NAME) {
		OFFICER_NAME = oFFICER_NAME;
	}
	public String getINCIDENT_DATE() {
		return INCIDENT_DATE;
	}
	public void setINCIDENT_DATE(String iNCIDENT_DATE) {
		INCIDENT_DATE = iNCIDENT_DATE;
	}
	public String getDATE_ASSIGNED() {
		return DATE_ASSIGNED;
	}
	public void setDATE_ASSIGNED(String dATE_ASSIGNED) {
		DATE_ASSIGNED = dATE_ASSIGNED;
	}
	public String getAGENCY() {
		return AGENCY;
	}
	public void setAGENCY(String aGENCY) {
		AGENCY = aGENCY;
	}
	@Override
	public String toString() {
		return "IncidentOfficerDto [ID=" + ID + ", OFFICER_NAME=" + OFFICER_NAME + ", INCIDENT_DATE=" + INCIDENT_DATE
				+ ", DATE_ASSIGNED=" + DATE_ASSIGNED + ", AGENCY=" + AGENCY + "]";
	}
	


}
//ID,DATE,REPORT,OFFICER_ID,INCIDENT