package com.model;

public class Officers {
	private int officer_id;
	private String first_name;
	private String last_name;
	private int badge_number;
	private int rank;
	private int phone_number;
	private String address;
	private int law_enforcement_agency_id;
	private int user_id;
	
	public Officers(int officer_id, String first_name, String last_name, int badge_number, int rank, int phone_number,
			String address, int law_enforcement_agency_id, int user_id) {
		super();
		this.officer_id = officer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.badge_number = badge_number;
		this.rank = rank;
		this.phone_number = phone_number;
		this.address = address;
		this.law_enforcement_agency_id = law_enforcement_agency_id;
		this.user_id = user_id;
	}

	public int getOfficer_id() {
		return officer_id;
	}

	public void setOfficer_id(int officer_id) {
		this.officer_id = officer_id;
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

	public int getBadge_number() {
		return badge_number;
	}

	public void setBadge_number(int badge_number) {
		this.badge_number = badge_number;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
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

	public int getLaw_enforcement_agency_id() {
		return law_enforcement_agency_id;
	}

	public void setLaw_enforcement_agency_id(int law_enforcement_agency_id) {
		this.law_enforcement_agency_id = law_enforcement_agency_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Officers [officer_id=" + officer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", badge_number=" + badge_number + ", rank=" + rank + ", phone_number=" + phone_number + ", address="
				+ address + ", law_enforcement_agency_id=" + law_enforcement_agency_id + ", user_id=" + user_id + "]";
	}
}
