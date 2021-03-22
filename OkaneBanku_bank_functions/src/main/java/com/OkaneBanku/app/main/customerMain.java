package com.OkaneBanku.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.customer;
import com.OkaneBanku.app.service.CreateService;
import com.OkaneBanku.app.service.impl.CustomerCreateImpl;

public class customerMain {
	private static Logger usermessage = Logger.getLogger(customerMain.class);

	public static void main(String[] args) {
		usermessage.info("=====================================");
		usermessage.info("|| Welcome to Okane Banku App V1.0 ||");
		usermessage.info("=====================================");
		usermessage.info("");

		int choice = 0;
		CreateService createcustomer = new CustomerCreateImpl();
		Scanner sc = new Scanner(System.in);
		do {
			usermessage.info(" _________________");
			usermessage.info("|    Main Menu    |");
			usermessage.info(" -----------------");
			usermessage.info("1) Log in");
			usermessage.info("2) Create New Account");
			usermessage.info("3) Exit Application\n");

			try {
				choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					String username;
					String password;
					usermessage.info("\nEnter username: ");
					username = sc.nextLine();
					usermessage.info("\nEnter password: ");
					password = sc.nextLine();
					if (username == username && password == password) {
						int loginchoice = 0;
						do {
							usermessage.info("\nCustomer Menu");
							usermessage.info("==============");
							usermessage.info("1) Check account balance");
							usermessage.info("2) Deposit to account balance");
							usermessage.info("3) Withdraw from account balance");
							usermessage.info("4) Perform transfer");
							usermessage.info("5) Check pending transfer");
							usermessage.info("6) Exit\n");
							try {
								usermessage.info("Enter an option between 1 - 6:\n");
								loginchoice = Integer.parseInt(sc.nextLine());
								switch (loginchoice) {
								case 1:
									usermessage.info("1) Checking");
									usermessage.info("2) Saving\n");
									try {
										int accountchoice = 0;
										accountchoice = Integer.parseInt(sc.nextLine());
										if(accountchoice == 1){
											usermessage.info("under construction");
										}
										if(accountchoice == 2) {
											usermessage.info("\nunder construction");
										}
									}catch(NumberFormatException e) {
											usermessage.info("Incorrect option... please choose an option between 1 and 2\n");
									}
								
									
									break;
								case 2:
									usermessage.info("Enter the amount you would like to deposit");
									int deposit = 0;
									try {
										deposit = Integer.parseInt(sc.nextLine());
										usermessage.info("\nInsert method to deposit money and make sure it not negative deposit");
									}catch(NumberFormatException e){
										usermessage.info("Invalid input, please try again\n");
									}
									
									break;
								case 3:
									usermessage.info("Enter the amount you would like to withdraw\n");
									int withdraw = 0;
									try {
										withdraw = Integer.parseInt(sc.nextLine());
										usermessage.info("Insert method to withdraw money and make sure it not negative deposit\n");
									}catch(NumberFormatException e){
										usermessage.info("Invalid input, please try again\n");
									}
									break;
								case 4:
									usermessage.info("Enter the amount you would like to transfer\n");
									int transfer = 0;
									try {
										transfer = Integer.parseInt(sc.nextLine());
										usermessage.info("Insert method to transfer money and make sure it not negative deposit\n");
									}catch(NumberFormatException e){
										usermessage.info("Invalid input, please try again\n");
									}
									usermessage.info("Enter the account number you want to transfer money into\n");
									int accountNumber = 0;
									try {
										accountNumber = Integer.parseInt(sc.nextLine());
										usermessage.info("Insert method to check if account exist and perform money transfer\n");
									}catch(NumberFormatException e){
										usermessage.info("account number does not exist\n");
									}
									break;
								case 5:
									usermessage.info("method to show any pending transfer awaiting for acceptance\n");
									break;
								case 6:
									usermessage.info("Returning to Main Menu\n");
									break;

								default:
									usermessage.info("Invalid option... Please enter an option between 1-6\n");
									break;
								}
							} catch (NumberFormatException e) {
								
							}
						} while (loginchoice != 6);

					}
					break;
				case 2:
					usermessage.info("Please fill out all the criteria below to create a new account");
					customer customer = new customer();
					usermessage.info("Enter First Name ");
					customer.setFirstname(sc.nextLine());
					usermessage.info("Enter Last Name ");
					customer.setLastname(sc.nextLine());
					usermessage.info("Enter phone number ");
					customer.setPhone(sc.nextLine());
					usermessage.info("Enter City ");
					customer.setCity(sc.nextLine());
					usermessage.info("Enter State ");
					customer.setState(sc.nextLine());
					usermessage.info("Enter username ");
					customer.setCustomerUsername(sc.nextLine());
					usermessage.info("Enter password ");
					customer.setCustomerPassword(sc.nextLine());
					try {
						if(createcustomer.createCustomer(customer)==1) {
							usermessage.info("Customer Account created successfully");
						}
					}catch(BusinessException e) {
						usermessage.info(e.getMessage());
					}
					break;
				case 3:
					usermessage.info("\nThank you for choosing Okane Banku to perform your banking needs");
					break;
				default:
					usermessage.info("Invalid selection... Please enter a choice between 1-3 only");
					break;
				}
			} catch (NumberFormatException e) {

			}
		} while (choice != 3);
	}
}
