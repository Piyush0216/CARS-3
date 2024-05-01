package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.SuspectDto;
import com.exception.ResourceNotFoundException;
import com.model.Suspect;
import com.service.SuspectService;

public class SuspectController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuspectService suspectService = new SuspectService();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("*******************************************************************");
			System.out.println("*************************Suspect Operations************************");
			System.out.println("*******************************************************************");
			System.out.println("Press 1. Add Suspect");
			System.out.println("Press 2. Removing Suspect");
			System.out.println("Press 3. Soft Delete Suspect Record");
			System.out.println("Press 4. Update");
			System.out.println("Press 5. Display All Suspects");
			System.out.println("Press 6. Display Suspects Involved In More Than One Incidents");
			System.out.println("Press 7. Display Suspects By Their Incident Type");
			System.out.println("Press 8. Get Suspects By Sorted Incident Id");
			System.out.println("Press 0. To Exit");
			int input=sc.nextInt();
			if(input==0) {
				System.out.println("Exiting Suspect Module ...");
				break;
			}
			
			Random random = new Random();
			int randomNumber = random.nextInt();
			int id = randomNumber<0 ? randomNumber*-1:randomNumber;
			
			switch(input) {
			case 1:
				System.out.println(id);

				System.out.println("Enter First Name : ");
				sc.nextLine();
				String first_name=sc.nextLine();
				
				System.out.println("Enter Last Name : ");
				String last_name=sc.nextLine();
				
				System.out.println("Enter Date Of Birth in yyyy-mm-dd format : ");
				String date_of_birth=sc.nextLine();
				
				System.out.println("Enter Gender : ");
				String gender=sc.nextLine();
				
				System.out.println("Enter Phone Number : ");
				String phone_number=sc.nextLine();
				
				System.out.println("Enter Address : ");
				String address=sc.nextLine();
				
				System.out.println("Enter Incident Id : ");
				int incident_id=sc.nextInt();
				
				Suspect suspect =  new Suspect(id,first_name,last_name,date_of_birth,gender,phone_number,address,incident_id);	
				int status;
				try {
					status = suspectService.save(suspect);
					if(status==1) {
						System.out.println("Insert Added to DB...");
					}else {
						System.out.println("Insertion Failed...");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					List<Suspect> list = suspectService.findAll();
					for(Suspect s:list) {
						System.out.println(s);
					}
					System.out.println("Enter Suspect Id : ");
					suspectService.deleteByID(sc.nextInt());
					System.out.println("Suspect record deleted...");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					List<Suspect> listS = suspectService.findAll();
					for(Suspect s:listS) {
						System.out.println(s);
					}
					System.out.println("Enter Suspect Id : ");
					suspectService.softDeleteByID(sc.nextInt());
					System.out.println("Suspect record de-activated");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					List<Suspect> listSuspect = suspectService.findAll();
					for(Suspect s:listSuspect) {
						System.out.println(s);
					}
					System.out.println("Enter suspect id : ");
					int given_id=sc.nextInt();
					System.out.println("Enter updated address : ");
					sc.nextLine();
					String updatedAddress=sc.nextLine();
					suspectService.update(given_id,updatedAddress);
					System.out.println("Updated Successfully...");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				
				try {
					List<Suspect> l = suspectService.findAll();
					for(Suspect s:l) {
						System.out.println(s);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				try {
					List<SuspectDto> li=suspectService.getSuspectsInvolvedInManyIncidents();
					for(SuspectDto s:li) {
						System.out.println(s);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				try {
					List<Suspect> lis=suspectService.getSuspectsbyIncidentType();
					for(Suspect s:lis) {
						System.out.println(s);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8:
				try {
					System.out.println("Enter Sort Direction 'ASC or DESC'");
					sc.nextLine();
					String sortDirection=sc.nextLine();
					List<Suspect> list = suspectService.findAll();
					list = suspectService.sortSuspectByIncidentId(list,sortDirection);
					for(Suspect v:list) {
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
	public static void suspectMenu() {
		String[] sarry = {""};
		main(sarry);
	
	}

}