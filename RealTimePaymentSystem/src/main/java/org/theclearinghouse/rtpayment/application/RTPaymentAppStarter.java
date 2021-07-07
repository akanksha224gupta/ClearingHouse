package org.theclearinghouse.rtpayment.application;

import java.util.List;
import java.util.Scanner;

import org.theclearinghouse.rtpayment.common.Constants;
import org.theclearinghouse.rtpayment.model.RTPaymentBank;
import org.theclearinghouse.rtpayment.service.RTPaymentService;

public class RTPaymentAppStarter {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("|--------------------------------------------------------------------|");
		System.out.println("| WELCOME TO THE CLEARING HOUSE REAL TIME PAYMENTS MANAGEMENT SYSTEM |");
		System.out.println("|--------------------------------------------------------------------|");
		System.out.println("Please select from the below options:");
		System.out.println("1. Search by ID");
		System.out.println("2. Search by Bank Name");
		System.out.println("3. Search by Bank Type");
		System.out.println("4. Search by State");
		System.out.println("5. Search by City");
		System.out.println("6. Search by ZipCode");
		System.out.println("7. Exit");
		System.out.println("Please enter your choice as 1 or 2 or 3 or 4 or 5 or 6 or 7");
		
		while(sc.hasNext()) {
			int choice = sc.nextInt();
			List<RTPaymentBank> resultSet = null;
			if(choice==7) {
				System.exit(0);
			} else if(choice>=1 && choice<=6){
				String value = null;
				
				switch (choice) {
				case Constants.OPTION_ZIPCODE:
					System.out.println("Please enter the zipcode for the search");
					value = sc.next();
					resultSet = RTPaymentService.fetch(Constants.SEARCH_BY_ZIPCODE, value) ;	
					break;
				case Constants.OPTION_TYPE:
					System.out.println("Please enter the Type for the search");
					value = sc.next();
					resultSet = RTPaymentService.fetch(Constants.SEARCH_BY_TYPE, value) ;	
					break;

				case Constants.OPTION_STATE:
					System.out.println("Please enter the State for the search");
					value = sc.next();
					resultSet = RTPaymentService.fetch(Constants.SEARCH_BY_STATE, value) ;	
					break;

				case Constants.OPTION_ID:
					System.out.println("Please enter the Id for the search");
					value = sc.next();
					resultSet = RTPaymentService.fetch(Constants.SEARCH_BY_ID, value) ;	
					break;

				case Constants.OPTION_CITY:
					System.out.println("Please enter the City for the search");
					value = sc.next();
					resultSet = RTPaymentService.fetch(Constants.SEARCH_BY_CITY, value) ;	
					break;

				case Constants.OPTION_BANK_NAME:
					System.out.println("Please enter the Bank Name for the search");
					value = sc.next();
					resultSet = RTPaymentService.fetch(Constants.SEARCH_BY_BANK_NAME, value) ;	
					break;
				}
				
				System.out.println("The output list of real time banks are as follows:");
				resultSet.stream().forEach(System.out::println);
			} else {
				System.out.println("Please re-enter a valid option.");
			}
		}
	}

}
