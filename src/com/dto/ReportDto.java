package com.dto;

public class ReportDto {
	private int ID;
	private String DATE;
	private String REPORT;
	private int OFFICER_ID;
	private String INCIDENT;

	public ReportDto(int ID, String DATE, String REPORT, int OFFICER_ID, String INCIDENT) {
		super();
		this.ID = ID;
		this.DATE = DATE;
		this.REPORT = REPORT;
		this.OFFICER_ID = OFFICER_ID;
		this.INCIDENT = INCIDENT;
	}

	public ReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDATE() {
		return DATE;
	}

	public void setDATE(String dATE) {
		DATE = dATE;
	}

	public String getREPORT() {
		return REPORT;
	}

	public void setREPORT(String rEPORT) {
		REPORT = rEPORT;
	}

	public int getOFFICER_ID() {
		return OFFICER_ID;
	}

	public void setOFFICER_ID(int oFFICER_ID) {
		OFFICER_ID = oFFICER_ID;
	}

	public String getINCIDENT() {
		return INCIDENT;
	}

	public void setINCIDENT(String iNCIDENT) {
		INCIDENT = iNCIDENT;
	}

	@Override
	public String toString() {
		return "ReportDto [ID=" + ID + ", DATE=" + DATE + ", REPORT=" + REPORT + ", OFFICER_ID=" + OFFICER_ID
				+ ", INCIDENT=" + INCIDENT + "]";
	}


}
//ID,DATE,REPORT,OFFICER_ID,INCIDENT