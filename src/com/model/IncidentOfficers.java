



package com.model;

public class IncidentOfficers {
	private int incident_id;
	private int officers_id;
	private String date_assigned;
	

	public IncidentOfficers(int incident_id, int officers_id, String date_assigned) {
		super();
		this.setIncident_id(incident_id);
		this.setOfficers_id(officers_id);
		this.setDate_assigned(date_assigned);
	}

	@Override
	public String toString() {
		return "IncidentOfficer [incident_id=" + incident_id + ", officers_id=" + officers_id + ", date_assigned="
				+ date_assigned + "]";
	}

	public int getIncident_id() {
		return incident_id;
	}

	public void setIncident_id(int incident_id) {
		this.incident_id = incident_id;
	}

	public int getOfficers_id() {
		return officers_id;
	}

	public void setOfficers_id(int officers_id) {
		this.officers_id = officers_id;
	}

	public String getDate_assigned() {
		return date_assigned;
	}

	public void setDate_assigned(String date_assigned) {
		this.date_assigned = date_assigned;
	}

	public IncidentOfficers() {
		super();
		// TODO Auto-generated constructor stub
	}


}
