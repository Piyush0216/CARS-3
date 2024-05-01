package com.model;

public class Victim {
	private int victim_id;
	private String first_name;
	private String last_name;
	private String date_of_birth;
	private String gender;
	private String phone_number;
	private String address;
	private int incident_id;
	private String isActive;

	public Victim(int victim_id, String first_name, String last_name, String date_of_birth, String gender,
			String phone_number, String address, int incident_id,String isActive) {
		super();
		this.victim_id = victim_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.phone_number = phone_number;
		this.address = address;
		this.incident_id = incident_id;
		this.isActive=isActive;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	

	public Victim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getVictim_id() {
		return victim_id;
	}

	public void setVictim_id(int victim_id) {
		this.victim_id = victim_id;
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

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIncident_id() {
		return incident_id;
	}

	public void setIncident_id(int incident_id) {
		this.incident_id = incident_id;
	}

	@Override
	public String toString() {
		return "Victim [victim_id=" + victim_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", date_of_birth=" + date_of_birth + ", gender=" + gender + ", phone_number=" + phone_number
				+ ", address=" + address + ", incident_id=" + incident_id + ", isActive=" + isActive + "]";
	}

	

}