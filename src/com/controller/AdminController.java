package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.User;
import com.service.AdminService;

public class AdminController {

    public static void Options() {
    	
        Scanner sc = new Scanner(System.in);
        AdminService adminservice = new AdminService();
        

        try {
            while (true) {
            	
                System.out.println("Press 1. Add User");
                System.out.println("Press 2. Display All Users");
                System.out.println("Press 3. Delete User");
                System.out.println("Press 4. Update User Password");
  
                System.out.println("Press 5. Logout");
                
           
                
                int input = sc.nextInt();
                
                if(input == 5 ) break;

                switch (input) {

                    case 1:
                        System.out.println("Enter New User Name: ");
                        sc.nextLine();
                        String username = sc.nextLine();

                        System.out.println("Enter Password: ");
                        String password = sc.nextLine();

                        System.out.println("Enter Confirm Password: ");
                        String confirmPassword = sc.nextLine();

                        if (!adminservice.MatchPassword(password, confirmPassword)) {
                            System.out.println("Password Does Not Match");
                            break;
                        }
                        if(!adminservice.ValidatePassword(password)) {
                        	 System.out.println("Password should be Minimum 6 in length");
                             break;
                        }

                        System.out.println("Choose Roles:  Officer or Admin");
                        String role = sc.nextLine();

                        if (role.equalsIgnoreCase("Officer") || role.equalsIgnoreCase("Admin")) {

                            boolean result = adminservice.addUser(username, password, role);

                            if (result) {
                                System.out.println("Officer credential Added Successfully");
                            } else {
                                System.out.println("Officer UserName is Already Exist");
                            }
                        } else {
                            System.out.println("Invalid Role Please Try Again");
                        }
                        break;
                        
                    case 2:
                    	                   	
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

                    	
                    	break;
                    	
                    case 3:
	                   	
                    	try {
                    		
                    		 System.out.println("Enter the UserId to Delete the User "); 
                    		 int id = sc.nextInt();
                    		 
                    		 boolean result = adminservice.DeleteUserByID(id);
                    		 
                    		 if(result == false) {
                    			 System.out.println("Invalid UserID Try Again" );
                    			 break;
                    		 }
                    		 else {
                    			 System.out.println("User is Deleted Successfully" );
                    			 break;
                    		 }
                                
                            
                        } catch (SQLException e) {
                            System.out.println("Error fetching users: " + e.getMessage());
                        }

                    	
                    	break;
                    	
                       case 4:
	                   	
                    	try {
                    		
                    		 System.out.println("Enter the UserId to Update the Password "); 
                    		 int id = sc.nextInt();
                    		  sc.nextLine(); 
                    		 
                    		 System.out.println("Enter New Password: ");
                             String pass = sc.nextLine();

                             System.out.println("Enter Confirm Password: ");
                             String confirmPass = sc.nextLine();

                             if (!adminservice.MatchPassword(pass, confirmPass)) {
                                 System.out.println("Password Does Not Match");
                                 break;
                             }
                             if(!adminservice.ValidatePassword(pass)) {
                             	 System.out.println("Password should be Minimum 6 in length");
                                  break;
                             }

                             
                             
                    		 
                    		 boolean result = adminservice.UpdateUSerPasswordByID(id,pass);
                    		 
                    		 if(result == false) {
                    			 System.out.println("Invalid UserID Try Again" );
                    			 break;
                    		 }
                    		 else {
                    			 System.out.println("Password is Updated Successfully" );
                    			 break;
                    		 }
                                
                            
                        } catch (SQLException e) {
                            System.out.println("Error fetching users: " + e.getMessage());
                        }

                    	
                    	break;
                       
                    	                	   

//                    default:
//                        System.out.println("Invalid input given, try again!!!");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the scanner after the loop
//            sc.close();
        }
    }
}
