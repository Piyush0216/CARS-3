package com.controller;

import java.sql.SQLException;   
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.exception.ResourceNotFoundException;
import com.model.Agency;
import com.model.Incident;
import com.model.Officers;
import com.model.User;
import com.service.AdminService;
import com.service.AgencyService;
import com.service.OfficersService;

public class OfficersController {
 public static void main(String[] args) {
	 OfficersService officersService=new OfficersService();
	 AgencyService agencyService=new AgencyService();
	 AdminService adminservice = new AdminService();
	 Scanner sc = new Scanner(System.in);
	 while(true) {
			System.out.println("----------Officer Module-------------");
			System.out.println("Press 1. Insert Officer ");
			System.out.println("Press 2. Delete Officer ");
			System.out.println("Press 3. SoftDelete Officer ");
			System.out.println("Press 4. Display all Officer ");
			System.out.println("Press 5. Display officer by agencyId");
			System.out.println("Press 6. Display officer by rank");
			
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Officer Module..");
				break; 
			}
			switch(input) {
			case 1: 
				Random random=new Random();
				int randomNumber=random.nextInt();
				int officer_id=randomNumber<0?randomNumber*-1:randomNumber;
				System.out.println("Enter first_name");
				sc.nextLine();
				String first_name=sc.nextLine();
				System.out.println("Enter last_name");
				String last_name=sc.nextLine();
				System.out.println("enter badge_number");
				int badge_number=sc.nextInt();
				System.out.println("enter rank");
				int rank=sc.nextInt();
				System.out.println("enter phone_number");
				int phone_number=sc.nextInt();
				System.out.println("enter address");
				sc.nextLine();
				String address=sc.nextLine();
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
				System.out.println("enter law_enforcement_agency_id");
				int law_enforcement_agency_id=sc.nextInt();
				try {
                    List<User> users = adminservice.GetAllUsers();
                    if (users.isEmpty()) {
                        System.out.println("No users found.");
                    } else {
                        System.out.println("List of Users:");
                        for (User user : users) {
                            System.out.println("User ID: " + user.getId());
                            System.out.println("Username: " + user.getUsername());
                            System.out.println("Password: " + user.getPassword());
                            System.out.println("Role: " + user.getRole());
                            System.out.println("Status: " + user.getStatus());
                            System.out.println("-----------------------------------");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("Error fetching users: " + e.getMessage());
                }
				System.out.println("enter user_id");
				int user_id=sc.nextInt();
				Officers officers=new Officers(officer_id,first_name,last_name,badge_number,rank,phone_number,address,law_enforcement_agency_id,user_id);
				try {
					int status=officersService.insert(officers);
					if(status==1)
						System.out.println("Officer record added to DB..");
					else
						System.out.println("Insert op failed..");
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break; 
			case 2:
				try {
					List<Officers> list=officersService.findAll();
					for(Officers a:list) {
						System.out.println(a);
					}
					}catch(SQLException e) {
						System.out.println(e.getMessage());
					}
					
				System.out.println("Enter Officer ID");
				try {
					officersService.deleteByid(sc.nextInt());
						System.out.println("Officer record deleted..");
						
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}catch(ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					List<Officers> list=officersService.findAll();
					for(Officers a:list) {
						System.out.println(a);
					}
					}catch(SQLException e) {
						System.out.println(e.getMessage());
					}
					
				System.out.println("Enter Officer ID");
				try {
					officersService.softdeleteByid(sc.nextInt());
						System.out.println("Officer record de-activated..");
						
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}catch(ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
				List<Officers> list=officersService.findAll();
				for(Officers a:list) {
					System.out.println(a);
				}
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					//display all agencies 
					List<Agency> list = agencyService.findAll();
					for(Agency a : list) {
						System.out.println(a);
					}
					//read agency id
					System.out.println("Enter agency ID");
					int agency_id = sc.nextInt();
					
					//fetch officer of this agency
					List<Officers> listofficers = officersService.getOfficersByAgencyId(agency_id);
					for(Officers o : listofficers) {
						System.out.println(o);
					}
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}				
				break;
			case 6:
				  System.out.println("Enter Minimum Rank");
				  int minRank = sc.nextInt();
				  System.out.println("Enter Maximum Rank");
				  int maxRank = sc.nextInt();

				  try {
				    List<Officers> listOfficers = officersService.getOfficersByRankBetween(minRank, maxRank);
				    if (listOfficers.isEmpty()) {
				      System.out.println("No Officers found with rank between " + minRank + " and " + maxRank);
				    } else {
				      for (Officers officer : listOfficers) {
				        System.out.println(officer);
				      }
				    }
				  } catch (SQLException e) {
				    System.out.println(e.getMessage());
				  }
				  break;
			}
		}
//		sc.close();
	}
 public static void officersControllerMenu(){
	 String[] ref= {""};
	 main(ref);
 }
}

