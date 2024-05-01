package com.model;

import java.util.Objects;

public class Incident {
	
	private  int incidentID;
	private String incidentType;
	private String incidentDate;
	private String location;
	private String description;
	private String Status;
	public Incident(int incidentID, String incidentType, String incidentDate, String location, String description,
			String status) {
		super();
		this.incidentID = incidentID;
		this.incidentType = incidentType;
		this.incidentDate = incidentDate;
		this.location = location;
		this.description = description;
		Status = status;
	}
	public Incident() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIncidentID() {
		return incidentID;
	}
	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}
	public String getIncidentType() {
		return incidentType;
	}
	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}
	public String getIncidentDate() {
		return incidentDate;
	}
	public void setIncidentDate(String incidentDateStr) {
		this.incidentDate = incidentDateStr;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Incident [incidentID=" + incidentID + ", incidentType=" + incidentType + ", incidentDate="
				+ incidentDate + ", location=" + location + ", description=" + description + ", Status=" + Status + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Status, description, incidentDate, incidentID, incidentType, location);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incident other = (Incident) obj;
		return Objects.equals(Status, other.Status) && Objects.equals(description, other.description)
				&& Objects.equals(incidentDate, other.incidentDate) && incidentID == other.incidentID
				&& Objects.equals(incidentType, other.incidentType) && Objects.equals(location, other.location);
	} 
	

}