package com.controller;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Evidence;
import com.model.EvidenceWithVictim;
import com.service.EvidenceService;

public class EvidenceController {
	 public static void main(String[] args) {
	    	
	        Scanner sc = new Scanner(System.in);
	        EvidenceService evidenceservice = new EvidenceService();
	        

	        try {
	        	
	        
	            while (true) {
	            	
	                System.out.println("Press 1. Register Evidence");
	                System.out.println("Press 2. Update Evidence");
                
	                System.out.println("Press 3. GetAll Evidence of Incident");
	             
	                System.out.println("Press 4. GetAll Evidence from Victim"); 
	            
	               
		            System.out.println("Press 0. Logout");
	           
	                // description,location_found,incident_id
		            
	                int input = sc.nextInt();
	                sc.nextLine();
	                
	                if(input == 0 ) break;

	                switch (input) {

	                    case 1:
	                    	try {
	                    		 System.out.println("Enter Description for the Evidence ");
	                    		 
	 		                    String description = sc.nextLine();
	 		                    

	 	                        System.out.println("Enter Location of the Evidence ");
	 	                        String location = sc.nextLine();

	 	                        System.out.println("Enter IncidentID");
	 	                        int incidentId = sc.nextInt();
	                             sc.nextLine();
	                             
	                             
	                            String output =  evidenceservice.addEvidence(description, location, incidentId);
	                            
	                            System.out.println(output);
	                          
	                    	
	                  
	                        } catch (SQLException e) {
	                            System.out.println("Error fetching users: " + e.getMessage());
	                        }

	                       

	                        break;
	                        
	                    case 2:
	                        try {
	                            System.out.println("Enter the Evidence ID to update: ");
	                            int evidenceId = sc.nextInt();
	                            sc.nextLine();
	                            
	                            System.out.println("Enter new Description for the Evidence: ");
                            String newDescription = sc.nextLine();

	                            System.out.println("Enter new Location of the Evidence: ");
	                            String newLocation = sc.nextLine();

	                            String output = evidenceservice.updateEvidence(evidenceId, newDescription, newLocation);

	                            System.out.println(output);
	                        } catch (SQLException e) {
	                            System.out.println("Error updating evidence: " + e.getMessage());
	                        }
	                        break;
	                        
	                 case 3:
	                    	try {
	                    		
	                    		 System.out.println("Enter the Incident ID for Evidence ");
	 	                 	     int incidentId = sc.nextInt();
	                             sc.nextLine();
	                             
	                             
	                            List<Evidence> output =  evidenceservice.GetAllEvidenceByIncidentID(incidentId);
	                            
	                           if(output!=null) {
	                        	   for(Evidence evidence : output ) {
	                        		   
	                        		   System.out.println("Evidence ID: " + evidence.getEvidenceID());
	                                    System.out.println("Evidence Description: " + evidence.getEvidence_description());
	                                    System.out.println("Evidence Location: " + evidence.getEvidence_locationFound());
	                                    System.out.println("Incident Type: " + evidence.getIncident_Type());
	                                    System.out.println("Incident Status: " + evidence.getIncident_Status());
	                           	        System.out.println("Incident Date: " + evidence.getIncident_date());
	                                    System.out.println("Incident Location: " + evidence.getIncident_location());
	                                    
	                                    System.out.println("-------------------------------------------------------------------------------------");
		                                    
	                        	   }
	                           }
	                           else {
	                        	   System.out.println("No Evidence Exist for the IncidentId " + incidentId);
	                           }
	                          
	                    	
	                  
	                        } catch (SQLException e) {
	                            System.out.println("Error fetching users: " + e.getMessage());
	                        }

	                       
	                        break;  
	                   
	                  
	                        
	                  case 4:  //  GetAll Evidence from Victim
	                    	try {
	                    		
	                    		 System.out.println("Enter the Victim ID for Evidence ");
	 	                 	     int victimtId = sc.nextInt();
	                             sc.nextLine();
	                             
	                             
	                            List<EvidenceWithVictim> result =  evidenceservice.GetAllEvidenceFromVictim( victimtId);
	                            
	                           if(result!=null) {                         	   
       	   
	                        	   for(EvidenceWithVictim evidence : result ) {
	                        		   
	                        		   System.out.println("Evidence ID: " + evidence.getEvidenceID());
	                                    System.out.println("Evidence Description: " + evidence.getEvidence_description());
	                                    System.out.println("Evidence Location: " + evidence.getEvidence_locationFound());
	                                    System.out.println("Victim first_name: " + evidence.getFirst_name());
	                           	        System.out.println("Victim last_name: " + evidence.getLast_name());
	                                    System.out.println("Victim date_of_birth: " + evidence.getDate_of_birth());
	                                    System.out.println("Victim address: " + evidence.getAddress());
	                                    System.out.println("Victim gender: " + evidence.getGender());
	                                    
	                                    System.out.println("-------------------------------------------------------------------------------------");
		                                    
	                        	   }
	                           }
	                           else {
	                        	   System.out.println("No Evidence Exist for the VictimId " +  victimtId);
	                           }
	                          
	                    	
	                  
	                        } catch (SQLException e) {
	                            System.out.println("Error fetching users: " + e.getMessage());
	                        }

	                       
	                        break;  
	                   

//	                    default:
//	                        System.out.println("Invalid input given, try again!!!");
	                }
	            
	         }
	            
	        } finally {
	            // Close the scanner after the loop
//	            sc.close();
	        }
	        
	    }
	 public static void evidenceMenu(){
		 String[] ref= {""};
		 main(ref);
	 }

}
