package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.exception.InvalidCredentialsException;
import com.model.User;
import com.service.AuthService;


public class AuthController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AuthService userService = new AuthService();
		
		
		int flag = 0;
	
		
		while(true) {
			System.out.println("Press 1. Login");   
			System.out.println("Press 0. Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Login Page....");
				break; 
			}
			
			switch(input) {
			
			case 1:
				try {
					
					System.out.println("Enter username: ");
					sc.nextLine();
					String username = sc.nextLine();
					System.out.println("Enter password: ");
					String password = sc.nextLine();
					/* go to DB and check if this credentials are valid, if yes then return object*/
					 
					User userObj = userService.login(username,password);
						if(userObj.getRole().equalsIgnoreCase("Officer")) {
							//load officer menu
							//System.out.println("Redirect to the Officer Menu");
							OfficerController.Options();
							flag = 1;
						}
						else if(userObj.getRole().equalsIgnoreCase("Admin")) {
							
							//load Admin menu
							//System.out.println("Redirect to the Admin Menu");
							
							AdminController.Options();
							flag = 1;
					
													
						}
						else {
							System.out.println("Invalid Login Credentials Try Again !!");
							
						}
				} catch (SQLException e) {
					 System.out.println(e.getMessage());
				} catch (InvalidCredentialsException e) {
					 System.out.println(e.getMessage());
				}
				break; 
//			 default: 
//				 System.out.println("Invalid input given, try again!!!");
//				
		}
			
			if(flag==1) break;
			
		}
//		sc.close();
	}

}