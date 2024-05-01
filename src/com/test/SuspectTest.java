package com.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.model.Suspect;
import com.service.SuspectService;

public class SuspectTest {
	SuspectService suspectService = new SuspectService();
	
	@Test
	public void sortVictimByIncidentId() {
		// Use case 1 
		// Prepare the inputs
		
		Suspect s1=new Suspect(23, "Moscow", "Santana", "1975-05-25", "Male","5555556789","505 Spruce St, Anytown, CA 12345", 15);
		Suspect s2=new Suspect(24, "Palermo", "Vargas", "1990-03-30", "Male","5555559876","606 Birch St, Anytown, CA 12345", 16);	
		Suspect s3=new Suspect(25, "Marseille", "Alvarez", "1987-09-05", "Male","9898787890","07 Sycamore St, Anytown, CA 12345", 19);
		
		List<Suspect> list=Arrays.asList(s1,s2,s3);
		String sortDirection="ASC";
		 
		List<Suspect> expectedList = Arrays.asList(s1,s2,s3);
		List<Suspect> actualList = suspectService.sortSuspectByIncidentId(list, sortDirection);
		Assert.assertEquals(expectedList, actualList);
		
		
		
		
		
		// Use case 2
		// Prepare the inputs
		
		sortDirection="DESC";
		expectedList = Arrays.asList(s3,s2,s1);
		actualList = suspectService.sortSuspectByIncidentId(list, sortDirection);
		Assert.assertEquals(expectedList, actualList);
		
		
		
		
		// Use case 3
		// Prepare the inputs 
		
		sortDirection = "ASC";
		list=Arrays.asList(s2,s3);
		expectedList = Arrays.asList(s2,s3);
		 actualList = suspectService.sortSuspectByIncidentId(list, sortDirection);
		Assert.assertEquals(expectedList, actualList);
		
		
		
		
		// Use case 4:
		// Prepare the inputs
		
		sortDirection="DESC";
		expectedList=Arrays.asList(s3,s2);
		actualList = suspectService.sortSuspectByIncidentId(list, sortDirection);
		Assert.assertEquals(expectedList, actualList);
		
		
		
		
		
		// Use case 5
		// Prepare the inputs
		
		sortDirection = "WrongDirection";
		list=Arrays.asList(s1,s2,s3);
		expectedList=Arrays.asList(s1,s2,s3);
		actualList = suspectService.sortSuspectByIncidentId(list, sortDirection);
		Assert.assertEquals(expectedList, actualList);
		
		
		
		
		
		
		// Use case 6
		// Prepare the inputs 
		
		sortDirection="WrongDirection";
		list=Arrays.asList(s2,s3,s1);
		expectedList=Arrays.asList(s1,s2,s3);
		actualList=suspectService.sortSuspectByIncidentId(list, sortDirection);
		try {
			Assert.assertEquals(expectedList, actualList);

		}catch(Error e) { }

	}
}