package com.dto;

public class AgencyDto {
	private String agency_name;
	private int officer_count;
	
	public String getAgency_name() {
		return agency_name;
	}

	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}

	public int getOfficer_count() {
		return officer_count;
	}

	public void setOfficer_count(int officer_count) {
		this.officer_count = officer_count;
	}

	public AgencyDto(String agency_name, int officer_count) {
		super();
		this.agency_name = agency_name;
		this.officer_count = officer_count;
	}

	@Override
	public String toString() {
		return "AgencyDto [agency_name=" + agency_name + ", officer_count=" + officer_count + "]";
	}

	
	
}
