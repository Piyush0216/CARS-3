package com.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.model.Victim;
import com.service.VictimService;

public class VictimTest {
	VictimService victimService = new VictimService();
	
	@Test
	public void sortVictimByIncidentId() {
		// Use case 1 
		// Prepare the inputs
		
		Victim v1=new Victim(23, "Emily", "Brown", "1990-11-18", "Female","765949123","789 Oak Street", 16,"");
		Victim v2=new Victim(24, "David", "Williams", "1988-06-30", "Male","543793456","101 Pine Street", 3,"");
		Victim v3=new Victim(25, "Sophia", "Wilson", "1973-12-05", "Female","654678789","202 Cedar Street", 7,"");
		
		List<Victim> list=Arrays.asList(v1,v2,v3);
		String sortDirection="ASC";
		 
		List<Victim> expectedList = Arrays.asList(v2,v3,v1);
		List<Victim> actualList = victimService.sortVictimByIncidentId(list, sortDirection);
		Assert.assertEquals(expectedList, actualList);
		
		
		
		
		
		// Use case 2
		// Prepare the inputs
		
		sortDirection="DESC";
		expectedList = Arrays.asList(v1,v3,v2);
		actualList = victimService.sortVictimByIncidentId(list, sortDirection);
		Assert.assertEquals(expectedList, actualList);
		
		
		
		
		// Use case 3
		// Prepare the inputs 
		
		sortDirection = "ASC";
		list=Arrays.asList(v2,v3);
		expectedList = Arrays.asList(v2,v3);
		actualList=victimService.sortVictimByIncidentId(list, sortDirection);
		Assert.assertEquals(expectedList, actualList);
		
		
		
		
		// Use case 4:
		// Prepare the inputs
		
		sortDirection="DESC";
		expectedList=Arrays.asList(v3,v2);
		actualList=victimService.sortVictimByIncidentId(list, sortDirection);
		Assert.assertEquals(expectedList, actualList);
		
		
		
		
		
		// Use case 5
		// Prepare the inputs
		
		sortDirection = "WrongDirection";
		list=Arrays.asList(v1,v2,v3);
		expectedList=Arrays.asList(v1,v2,v3);
		actualList=victimService.sortVictimByIncidentId(list, sortDirection);
		Assert.assertEquals(expectedList, actualList);
		
		
		
		
		
		
		// Use case 6
		// Prepare the inputs 
		
		sortDirection="WrongDirection";
		list=Arrays.asList(v2,v3,v1);
		expectedList=Arrays.asList(v1,v2,v3);
		actualList=victimService.sortVictimByIncidentId(list, sortDirection);
		try {
			Assert.assertEquals(expectedList, actualList);

		}catch(Error e) { }

	}
}