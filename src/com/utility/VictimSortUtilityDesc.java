package com.utility;

import java.util.Comparator;

import com.model.Victim;

public class VictimSortUtilityDesc implements Comparator<Victim>{

	@Override
	public int compare(Victim v1, Victim v2) {
		// TODO Auto-generated method stub
		if(v1.getIncident_id()>v2.getIncident_id()) {
			return -1;
		}
		if(v1.getIncident_id()<v2.getIncident_id()) {
			return 1;
		}
		if(v1.getIncident_id()==v2.getIncident_id()) {
			return 0;
		}
		return 0;
	}
}
