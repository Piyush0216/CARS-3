package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.IncidentOfficersDto;
import com.exception.ResourceNotFoundException;
import com.model.IncidentOfficers;
import com.service.IncidentOfficersService;


public class IncidentOfficersController {

	public static void main(String[] args) {
		IncidentOfficersService incidentOfficersService = new IncidentOfficersService();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("----------Incident Officer Ops-------------");
			System.out.println("Press 1. Insert Incident Officer ");
			System.out.println("Press 2. Delete Incident Officer ");
			System.out.println("Press 3. Deactivate Delete Incident Officer[Soft delete] ");
			System.out.println("Press 4. Display all Incident Officers");
			System.out.println("Press 5. Update Officers to new Incident");
			System.out.println("Press 6. Display All Officers who are Allocated to Incidents");
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Incident Officers Module..");
				break; 
			}
			
			switch(input) {
			case 1: 
				//System.out.println(UUID.randomUUID()); --auto generating alphanumeric for ID
				System.out.println("Enter Incident ID");
//				sc.nextLine();
				int incident_id = sc.nextInt();
				
				System.out.println("Enter Officer ID");
				int officers_id = sc.nextInt();
//				Random random = new Random(); 
//				int randomNumber = random.nextInt(); 
//				int officers_id =randomNumber<0?randomNumber*-1:randomNumber; 
//				System.out.println(officers_id);
//				System.out.println("Enter Incident ID");
//				sc.nextLine();
//				int incident_id = sc.nextInt();   
				System.out.println("Enter Date Assigned");
				sc.nextLine();
				String date_assigned=sc.nextLine(); 
				
				/* Attach values to Object  */
				IncidentOfficers incidentofficers = new IncidentOfficers(incident_id,officers_id,date_assigned);
				try {
					int IncidentStatus = incidentOfficersService.insert(incidentofficers);
					if(IncidentStatus == 1)
						System.out.println("Incident Officer added to DB...");
					else
						System.out.println("Insert op failed");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
				break; 
			case 2: 
				System.out.println("Enter Officer ID");
				try {
					incidentOfficersService.deleteByid(sc.nextInt());
					System.out.println("Incident Officer record deleted..");
				} catch (SQLException e) {
					 System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					 System.out.println(e.getMessage());
				}				
				break; 
			case 3: 
				System.out.println("Enter Officer ID");
				try {
					incidentOfficersService.softDeleteByid(sc.nextInt());
					System.out.println("Incident Officer record de-activated..");
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}				
				break; 
			case 4: 	 
				try {
					List<IncidentOfficers> list = incidentOfficersService.findAll();
					for(IncidentOfficers a : list) {
						System.out.println(a);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break; 
			case 5: 
				System.out.println("Enter Officer ID");
				try {
					incidentOfficersService.UpdateById(sc.nextInt());
					System.out.println("Incident Officer record updated..");
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}				
				break; 
			case 6: 	 
				try {
					List<IncidentOfficersDto> list = incidentOfficersService.findIncidentOfficers();
					for(IncidentOfficersDto a : list) {
						System.out.println(a);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break; 
			}
			
		}
		
		//sc.close();
	}
	
	public static void incidentOfficerMenu() {
		String[] sarry = {""};
		main(sarry);
	}

}