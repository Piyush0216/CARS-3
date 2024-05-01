package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.ReportDto;
import com.dto.ReportDto1;
import com.exception.ResourceNotFoundException;
import com.model.Report;
import com.service.ReportService;

public class ReportController {

	public static void main(String[] args) {
		ReportService reportService = new ReportService();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("----------Report Ops-------------");
			System.out.println("Press 1. Insert Report ");
			System.out.println("Press 2. Delete Report ");
			System.out.println("Press 3. Deactivate Delete Report[Soft delete] ");
			System.out.println("Press 4. Display all reports");
			System.out.println("Press 5. Display all reports submitted by officers");
			System.out.println("Press 6. Display reports for open and under investigation incidents");
			System.out.println("Press 7. Display reports for closed incidents");
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Report Module..");
				break; 
			}
			
			switch(input) {
			case 1: 
				//System.out.println(UUID.randomUUID()); --auto generating alphanumeric for ID
				Random random = new Random(); 
				int randomNumber = random.nextInt(); 
				int report_id =randomNumber<0?randomNumber*-1:randomNumber; 
				System.out.println("Enter Report Date");
				sc.nextLine();
				String report_date = sc.nextLine();   
				System.out.println("Enter Report deatails");
				String report_details=sc.nextLine(); //email
				System.out.println("Enter Status");
				String status=sc.nextLine();
				System.out.println("Enter Officer ID");
				int officers_id=sc.nextInt();
				/* Attach values to Object  */
				Report report = new Report(report_id,report_date,report_details,status,officers_id);
				try {
					int IncidentStatus = reportService.insert(report);
					if(IncidentStatus == 1)
						System.out.println("Report added to DB...");
					else
						System.out.println("Insert op failed");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
				break; 
			case 2: 
				System.out.println("Enter Report ID");
				try {
					reportService.deleteByid(sc.nextInt());
					System.out.println("Report record deleted..");
				} catch (SQLException e) {
					 System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					 System.out.println(e.getMessage());
				}				
				break; 
			case 3: 
				System.out.println("Enter Artist ID");
				try {
					reportService.softDeleteByid(sc.nextInt());
					System.out.println("Report record de-activated..");
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}				
				break; 
			case 4: 	 
				try {
					List<Report> list = reportService.findAll();
					for(Report a : list) {
						System.out.println(a);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break; 
				
			case 5: 	 
				try {
					List<ReportDto> list = reportService.getReportStats();
					for(ReportDto a : list) {
						System.out.println(a);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break; 
				
			case 6: 	 
				try {
					List<ReportDto1> list = reportService.getReportByStatus();
					for(ReportDto1 a : list) {
						System.out.println(a);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break; 
				
			case 7: 	 
				try {
					List<ReportDto1> list = reportService.getReportByStatus1();
					for(ReportDto1 a : list) {
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
	
	public static void reportMenu() {
		String[] sarry = {""};
		main(sarry);
	}

}