package com.utility;

import java.util.Comparator;

import com.model.Suspect;

public class SuspectSortUtilityDesc implements Comparator<Suspect>{

	@Override
	public int compare(Suspect s1, Suspect s2) {
		// TODO Auto-generated method stub
		if(s1.getIncident_id()>s2.getIncident_id()) {
			return -1;
		}
		if(s1.getIncident_id()<s2.getIncident_id()) {
			return 1;
		}
		if(s1.getIncident_id()==s2.getIncident_id()) {
			return 0;
		}
		return 0;
	}

}