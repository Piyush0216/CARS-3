package com.dto;

public class SuspectDto {
	private String first_name;
	private String last_name;
	private int incident_count;

	public SuspectDto(String first_name, String last_name, int incident_count) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.incident_count = incident_count;
	}

	public SuspectDto() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public int getIncident_count() {
		return incident_count;
	}

	public void setIncident_count(int incident_count) {
		this.incident_count = incident_count;
	}

	@Override
	public String toString() {
		return "SuspectDto [first_name=" + first_name + ", last_name=" + last_name + ", incident_count="
				+ incident_count + "]";
	}

}