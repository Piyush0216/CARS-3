package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.VictimDto;
import com.exception.ResourceNotFoundException;
import com.model.Victim;
import com.service.VictimService;

public class VictimController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VictimService victimService = new VictimService();
		Scanner sc=new Scanner(System.in);
		
		
		while(true) {
			System.out.println("***************************************************");
			System.out.println("|                                                 |");
			System.out.println("--------------Victim Operations-------------------");
			System.out.println("|                                                 |");
			System.out.println("***************************************************");
			System.out.println("Press 1. Add Victim  ");
			System.out.println("Press 2. Remove Victim  ");
			System.out.println("Press 3. Deactivate Delete Victim[Soft delete] ");
			System.out.println("Press 4. Display all Victims");
			System.out.println("Press 5. Update Victim ");
			System.out.println("Press 6. See Victims Involved in Multiple Incidents");
			System.out.println("Press 7. See Victims By Incident Location");
			System.out.println("Press 8. Get Victims By Sorted Incident Id");
			System.out.println("Press 0. To Exit");
			
			int input=sc.nextInt();
			if(input==0) {
				System.out.println("Exiting Victim Module..");
				break;
			}
			switch(input) {
			case 1:
				Random random = new Random();
				int randomNumber = random.nextInt();
				int id = randomNumber < 0?randomNumber*-1:randomNumber;
				System.out.println(id);
				
				System.out.println("Enter First Name : ");
				sc.nextLine();
				String first_name = sc.nextLine();
				
				System.out.println("Enter Last Name : ");
				String last_name = sc.nextLine();
				
				System.out.println("Enter Date Of Birth In (yyyy-mm-dd) Format : ");
				String date_of_birth = sc.nextLine();
				
				System.out.println("Enter Gender : ");
				String gender = sc.nextLine();
				
				System.out.println("Enter Phone Number : ");
				String phone_number = sc.nextLine();
				
				System.out.println("Enter Address : ");
				String address = sc.nextLine();
				
				System.out.println("Enter Incident Id : ");
				int incident_id = sc.nextInt();
				
				// Attach values to Victim Object
				Victim victim = new Victim(id,first_name,last_name,date_of_birth,gender,phone_number,address,incident_id,"");
				try {
					int status=victimService.insert(victim);
					if(status==1) {
						System.out.println("Victim added to DB..");
					}
					else
						System.out.println("Insert op failed..");
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					List<Victim> list  = victimService.findAll();
					for(Victim v:list) {
						System.out.println(v);
					}
					System.out.println();
					System.out.println("Enter Victim ID : ");
					victimService.deleteById(sc.nextInt());
					System.out.println("Victim record deleted");
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}catch(ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					List<Victim> list  = victimService.findAll();
					for(Victim v:list) {
						System.out.println(v);
					}
					System.out.println();
					System.out.println("Enter Victim Id : ");
					victimService.softDeleteById(sc.nextInt());
					System.out.println("Victim record de-activated..");
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}catch(ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					List<Victim> list  = victimService.findAll();
					for(Victim v:list) {
						System.out.println(v);
					}
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					List<Victim> list  = victimService.findAll();
					for(Victim v:list) {
						System.out.println(v);
					}
					System.out.println("Enter victim id");
					int given_id=sc.nextInt();
					System.out.println("Enter updated address : ");
					sc.nextLine();
					String updatedAddress=sc.nextLine();
					victimService.updateVictim(given_id,updatedAddress);
					System.out.println("Succeesfully updated ");
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}catch(ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				try {
					List<VictimDto> list = victimService.findVictimWithMostIncidents();
					for(VictimDto v:list) {
						System.out.println(v);
					}
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				try { 
					List<Victim> list = victimService.getVictimsByIncidentLocation();
					for(Victim v:list) {
						System.out.println(v);
					}
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8:
				try {
					System.out.println("Enter Sort Direction 'ASC or DESC'");
					sc.nextLine();
					String sortDirection=sc.nextLine();
					List<Victim> list = victimService.findAll();
					list = victimService.sortVictimByIncidentId(list,sortDirection);
					for(Victim v:list) {
						System.out.println(v);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}
//		sc.close();
	}
	public static void victimMenu() {
		String[] sarry = {""};
		main(sarry);
	
	}

}