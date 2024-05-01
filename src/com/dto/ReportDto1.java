package com.dto;

public class ReportDto1 {
	private int ID;
	private String DATE;
	private String REPORT;
	private int OFFICER_ID;
	private String INCIDENT;
	private String STATUS;
	private String INCIDENT_DESCRIPTION;
	
	public ReportDto1(int ID, String DATE, String REPORT, int OFFICER_ID, String INCIDENT,String STATUS, String INCIDENT_DESCRIPTION) {
		super();
		this.ID = ID;
		this.DATE = DATE;
		this.REPORT = REPORT;
		this.OFFICER_ID = OFFICER_ID;
		this.INCIDENT = INCIDENT;
		this.STATUS = STATUS;
		this.INCIDENT_DESCRIPTION = INCIDENT_DESCRIPTION;
	}

	public ReportDto1() {
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


	public String getINCIDENT_DESCRIPTION() {
		return INCIDENT_DESCRIPTION;
	}

	public void setINCIDENT_DESCRIPTION(String iNCIDENT_DESCRIPTION) {
		INCIDENT_DESCRIPTION = iNCIDENT_DESCRIPTION;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	@Override
	public String toString() {
		return "ReportDto1 [ID=" + ID + ", DATE=" + DATE + ", REPORT=" + REPORT + ", OFFICER_ID=" + OFFICER_ID
				+ ", INCIDENT=" + INCIDENT + ", STATUS=" + STATUS + ", INCIDENT_DESCRIPTION=" + INCIDENT_DESCRIPTION
				+ "]";
	}


}
//ID,DATE,REPORT,OFFICER_ID,INCIDENT