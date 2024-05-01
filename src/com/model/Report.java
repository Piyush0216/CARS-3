package com.model;

public class Report {
	private int report_id;
	private String report_date;
	private String report_details;
	private String status;
	private int officers_id;

	public Report(int report_id, String report_date, String report_details, String status, int officers_id) {
		super();
		this.report_id = report_id;
		this.report_date = report_date;
		this.report_details = report_details;
		this.status = status;
		this.officers_id = officers_id;
	}

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public String getReport_date() {
		return report_date;
	}

	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}

	public String getReport_details() {
		return report_details;
	}

	public void setReport_details(String report_details) {
		this.report_details = report_details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOfficers_id() {
		return officers_id;
	}

	public void setOfficers_id(int officers_id) {
		this.officers_id = officers_id;
	}

	@Override
	public String toString() {
		return "Report [report_id=" + report_id + ", report_date=" + report_date + ", report_details=" + report_details
				+ ", status=" + status + ", officers_id=" + officers_id + "]";
	}


	

}