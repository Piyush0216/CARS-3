package com.controller;
import java.sql.SQLException;
import java.util.*;
import com.service.*;
import com.exception.ResourceNotFoundException;
import com.model.Incident;
import com.model.Officers;
import com.service.IncidentService;

public class IncidentController {
	
	public static void main(String[] args) {
			IncidentService incidentService = new IncidentService();
			OfficersService officerService = new OfficersService();
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("----------Incident Ops-------------");
				System.out.println("Press 1. Insert Incident ");
				System.out.println("Press 2. Delete Incident ");
				System.out.println("Press 3. close Incident  ");
				System.out.println("Press 4. Display all Incidents");
				System.out.println("press 5. Display Incident for officer Id");
				System.out.println("Press 6. Display incidents within the given Date range");
				System.out.println("Press 0. to Exit");
				int input = sc.nextInt();
				if(input == 0) {
					System.out.println("Exiting Incident Ops..");
					break; 
				
				}
				switch(input) {
				case 1:
					try {
					Incident i = new Incident();
					// System.out.println(UUID.randomUUID()); -- auto generating for ID
					Random random = new Random();
					int randomNumber = random.nextInt();
					int id = randomNumber<0?randomNumber*-1:randomNumber;
					i.setIncidentID(id);
					System.out.println("Enter Incident Type");
					sc.nextLine();
					i.setIncidentType(sc.nextLine());
					System.out.println("Enter Incident Date (YYYY-MM-DD): ");
				    String date = sc.nextLine();
				    i.setIncidentDate(date);
		            System.out.println("Enter Location: ");
		            i.setLocation(sc.nextLine());
		            System.out.println("Enter Description: ");
		           
		            i.setDescription(sc.nextLine());
		            System.out.println("Enter Status: ");
		           
		            i.setStatus(sc.nextLine());
		           
						int result = incidentService.insert(i);
						if (result == 1)
							System.out.println("Incident added to DB");
						else
							System.out.println("Insert op failed");
					} catch (Exception e) {
						
						System.out.println("Error" + e.getMessage());
					}
				break;	
				
				case 2:
					try {
						List<Incident>a = incidentService.findAll();
						for(Incident i : a) 
							System.out.println(i);
					} catch (SQLException | ResourceNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Enter Incident ID");
					try {
					incidentService.deleteByid(sc.nextInt());
					System.out.println("Incident record deleted");
					} catch(SQLException e) {
						System.out.println(e.getMessage());
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 3: 
					try {
						List<Incident>a = incidentService.findAll();
						for(Incident i : a) 
							System.out.println(i);
					} catch (SQLException | ResourceNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					System.out.println("Enter Incident ID");
				try {
					incidentService.closeIncidentByid(sc.nextInt());
					System.out.println("Incident closed");
				} catch(ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
	            break;
	            
				case 4:
					try {
						List<Incident> list = incidentService.findAll();
						for(Incident i : list) {
							System.out.println(i);
						}
					} catch (SQLException | ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
					break;
					
				case 5:
					try {
					System.out.println("============Officers List=============");
					List<Officers>plist = officerService.findAll();					
					for(Officers o : plist) 
						System.out.println(o);
					}catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println("Enter officer id");

					int officerId = sc.nextInt();
					
					try {
						List<Incident> list =incidentService.getIncidentByOfficerId(officerId);
						for(Incident i : list) {
							System.out.println(i);}
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (ResourceNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
					
					break;
				
					
				case 6:
				    System.out.println("Enter Start Date (YYYY-MM-DD): ");
				    String fromdate = sc.next();

				    System.out.println("Enter End Date (YYYY-MM-DD): ");
				    String todate = sc.next();

				    try {
				        List<Incident> list = incidentService.getIncidentsInDateRange(fromdate, todate);

				        if (list.isEmpty()) {
				            System.out.println("No incidents found between the provided dates.");
				        } else {
				            for (Incident incident : list) {
				                System.out.println(incident.toString());
				            }
				        }
				    } catch (ResourceNotFoundException e) {
				        System.out.println("No incidents found between the provided dates.");
				    } catch (SQLException e) {
				        System.out.println("An error occurred while retrieving incidents.");
				        e.printStackTrace();
				    }
				    break;

					
//					default :
//						System.out.println("Invalid choice Please try again");
				}					
	}

//			sc.close();
	}
	public static void incidentMenu() {
		String[] sarry = {""};
		main(sarry);
	}

	

	
}