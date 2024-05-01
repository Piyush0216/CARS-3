package com.controller;

import java.sql.SQLException; 
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.AgencyDto;
import com.exception.ResourceNotFoundException;
import com.model.Agency;

import com.service.AgencyService;


public class AgencyController {
      public static void main(String[] args) {
	  AgencyService agencyService=new AgencyService();
	  Scanner sc = new Scanner(System.in);
		 while(true) {
				System.out.println("Law Enforcement Agency Details");
				System.out.println("Press 1. Add Agency");
				System.out.println("Press 2. Remove Agency");
				System.out.println("Press 3. Display all Agency");
				System.out.println("Press 4. Get agency with most officers");
				System.out.println("Press 5. Display agency with juridiction");
				
				System.out.println("Press 0. to Exit");
				int input = sc.nextInt();
				if(input == 0) {
					System.out.println("Exiting Agency Module..");
					break; 
				}
				switch(input) {
				case 1: 
					Random random=new Random();
					int randomNumber=random.nextInt();
					int agency_id=randomNumber<0?randomNumber*-1:randomNumber;
					System.out.println("Enter agency_name");
					sc.nextLine();
					String agency_name=sc.nextLine();
					System.out.println("Enter jurisdiction");
					String jurisdiction=sc.nextLine();
					System.out.println("enter phone_number");
					int phone_number=sc.nextInt();
					System.out.println("enter address");
					sc.nextLine();
					String address=sc.nextLine();
					Agency agency=new Agency(agency_id,agency_name,jurisdiction,phone_number,address);
					try {
						int status=agencyService.insert(agency);
						if(status==1)
							System.out.println("Agency record added to DB..");
						else
							System.out.println("Insert operation failed..");
						
					}catch(SQLException e) {
						System.out.println(e.getMessage());
					}catch (ResourceNotFoundException e) {
					    System.out.println(e.getMessage());
					  }
					break;
				case 2:
					try {
					    List<Agency> list = agencyService.findAll();
					    for (Agency a : list) {
					      System.out.println(a); // Assuming Agency has a toString method
					    }
					  } catch (SQLException e) {
					    System.out.println(e.getMessage());
					  }catch (ResourceNotFoundException e) {
						    System.out.println(e.getMessage());
						  }
					  System.out.println("Enter Agency ID to remove");
					  try {
					    agencyService.deleteByid(sc.nextInt());
					    System.out.println("Agency record deleted..");
					  } catch (SQLException e) {
					    System.out.println(e.getMessage());
					  } catch (ResourceNotFoundException e) {
					    System.out.println(e.getMessage());
					  }
					  break;
				case 3:
					  try {
					    List<Agency> list = agencyService.findAll();
					    for (Agency a : list) {
					      System.out.println(a); // Assuming Agency has a toString method
					    }
					  } catch (SQLException e) {
					    System.out.println(e.getMessage());
					  }catch (ResourceNotFoundException e) {
						    System.out.println(e.getMessage());
						  }
					  break;
				case 4:
					try {
						List<AgencyDto> list = agencyService.getAgencyStats();
						System.out.println("------------------------------------------\n");
						System.out.format("%22s%30s", "Name of Agency", "Number of Officers");
						System.out.println("\n-----------------------------------------");
						for(AgencyDto a : list) {
							System.out.format("%22s%20d", a.getAgency_name(), a.getOfficer_count());
							System.out.print("\n");
					}
						System.out.println("-------------------------------------------");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}catch (ResourceNotFoundException e) {
					    System.out.println(e.getMessage());
					  }	
					break; 
				case 5:
					System.out.println("choose jurisdiction:\nCitywide\nCountywide\nStatewide\nNational");
					  System.out.println("Enter Jurisdiction");
					  sc.nextLine();
					  String j = sc.nextLine();
					  try {
					    List<Agency> list = agencyService.getAgenciesByJurisdiction(j);
					    if (list.isEmpty()) {
					      System.out.println("No agencies found with jurisdiction: " + j);
					    } else {
					      for (Agency a : list) {
					        System.out.println(a); // Assuming Agency has a toString method
					      }
					    }
					  } catch (SQLException e) {
					    System.out.println(e.getMessage());
					  }catch (ResourceNotFoundException e) {
						    System.out.println(e.getMessage());
						  }
					  break;
                      }
      }
//		sc.close();
  	}
      public static void AgencyMenu(){
 		 String[] ref= {""};
 		 main(ref);
 	 }
}


