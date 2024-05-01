package com.model;

public class Agency {
      private int agency_id;
      private String agency_name; 
      private String jurisdiction;
      private int phone_number; 
      private String address;
	public Agency(int agency_id, String agency_name, String jurisdiction, int phone_number, String address) {
		super();
		this.agency_id = agency_id;
		this.agency_name = agency_name;
		this.jurisdiction = jurisdiction;
		this.phone_number = phone_number;
		this.address = address;
	}
	public int getAgency_id() {
		return agency_id;
	}
	public void setAgency_id(int agency_id) {
		this.agency_id = agency_id;
	}
	public String getAgency_name() {
		return agency_name;
	}
	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
	public String getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "agency [agency_id=" + agency_id + ", agency_name=" + agency_name + ", jurisdiction=" + jurisdiction
				+ ", phone_number=" + phone_number + ", address=" + address + "]";
	}
      
}
