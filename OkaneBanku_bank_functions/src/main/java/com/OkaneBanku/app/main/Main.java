package com.OkaneBanku.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.customer;
import com.OkaneBanku.app.service.CustomerService;
import com.OkaneBanku.app.service.EmployeeService;
import com.OkaneBanku.app.service.impl.CustomerImpl;
import com.OkaneBanku.app.service.impl.EmployeeImpl;

public class Main {
	private static Logger usermessage = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		usermessage.info("=====================================");
		usermessage.info("|| Welcome to Okane Banku App V1.0 ||");
		usermessage.info("=====================================");
		usermessage.info("");

		int choice = 0;
		CustomerService customerservice = new CustomerImpl();
		EmployeeService employeeservice = new EmployeeImpl();
		Scanner sc = new Scanner(System.in);

		do {
			usermessage.info(" _________________");
			usermessage.info("|    Main Menu    |");
			usermessage.info(" -----------------");
			usermessage.info("1) Customer Log in");
			usermessage.info("2) Employee Log in");
			usermessage.info("3) Create New Account");
			usermessage.info("4) Exit Application\n");

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
					try {
						if (customerservice.logincheck(username, password)) {
							customer c = customerservice.retrieveCustomer(username);
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
										usermessage.info("Enter an option between 1 - 2:\n");
										try {
											int accountchoice = 0;
											accountchoice = Integer.parseInt(sc.nextLine());
											if (accountchoice == 1) {
												try {
													customerservice.viewCheckingAcc(c.getCustomerid());
												} catch (BusinessException e) {
													e.getMessage();
												}
											}
											if (accountchoice == 2) {
												try {
													customerservice.viewSavingAcc(c.getCustomerid());
												} catch (BusinessException e) {
													e.getMessage();
												}
											}
										} catch (NumberFormatException e) {
											usermessage.info("Incorrect option... please choose an option between 1 and 2\n");
										}

										break;
									case 2:
										usermessage.info("1) Checking");
										usermessage.info("2) Saving\n");
										usermessage.info("Enter an option between 1 - 2:\n");
										double deposit = 0.00;
										try {
											int accountchoice = 0;
											accountchoice = Integer.parseInt(sc.nextLine());
											if (accountchoice == 1) {
												try {
													usermessage.info(
															"Enter the amount you would like to depsoit to your Checking Account");
													deposit = Double.parseDouble(sc.nextLine());
													customerservice.depositChecking(c.getCustomerid(), deposit);
												} catch (BusinessException e) {
													e.getMessage();
												}
											}
											if (accountchoice == 2) {
												try {
													usermessage.info(
															"Enter the amount you would like to depsoit to your Saving Account");
													deposit = Double.parseDouble(sc.nextLine());
													customerservice.depositSaving(c.getCustomerid(), deposit);
												} catch (BusinessException e) {
													e.getMessage();
												}
											}
										} catch (NumberFormatException e) {
											usermessage
													.info("Incorrect option... please choose an option between 1 and 2\n");
										}
										break;
									case 3:
										usermessage.info("1) Checking");
										usermessage.info("2) Saving\n");
										usermessage.info("Enter an option between 1 - 2:\n");
										double withdraw = 0.00;
										try {
											int accountchoice = 0;
											accountchoice = Integer.parseInt(sc.nextLine());
											if (accountchoice == 1) {
												try {
													usermessage.info(
															"Enter the amount you would like to withdraw from your Checking Account");
													withdraw = Double.parseDouble(sc.nextLine());
													customerservice.withdrawChecking(c.getCustomerid(), withdraw);
												} catch (BusinessException e) {
													e.getMessage();
												}
												if (accountchoice == 2) {
													try {
														usermessage.info(
																"Enter the amount you would like to withdraw from your Saving Account");
														deposit = Double.parseDouble(sc.nextLine());
														customerservice.depositSaving(c.getCustomerid(), withdraw);
													} catch (BusinessException e) {
														e.getMessage();
													}
												}
											}
										} catch (NumberFormatException e) {
											usermessage
													.info("Incorrect option... please choose an option between 1 and 2\n");
										}
										break;
									case 4:
										usermessage.info("1) Transfer Checking Account");
										usermessage.info("2) Transfer Saving Account\n");
										usermessage.info("Enter an option between 1 - 2:\n");
										double transfer = 0.00;
										try {
											int accountchoice = 0;
											accountchoice = Integer.parseInt(sc.nextLine());
											if (accountchoice == 1) {
												try {
													usermessage.info(
															"Enter the amount you would like to transfer to your Saving Account");
													transfer = Double.parseDouble(sc.nextLine());
													customerservice.addPendingTransfer(c.getCustomerid(), transfer);
													usermessage.info("Transfer is now pending");
												} catch (BusinessException e) {
													e.getMessage();
												}
											}
											if (accountchoice == 2) {
												try {
													usermessage.info(
															"Enter the amount you would like to transfer to your Checking Account");
													transfer = Double.parseDouble(sc.nextLine());
													customerservice.addPendingTransfer(c.getCustomerid(), transfer);
													usermessage.info("Transfer is now pending");
												} catch (BusinessException e) {
													e.getMessage();
												}
											}
										} catch (NumberFormatException e) {
											usermessage
													.info("Incorrect option... please choose an option between 1 and 2\n");
										}
										break;
									case 5:
										usermessage.info("Pending transactions: ");
										try {
											customerservice.viewPendingTransfer(c.getCustomerid());
										} catch (BusinessException e) {
											e.printStackTrace();
										}
										usermessage.info("\n1) Accept");
										usermessage.info("2) Decline");
										int pchoice = 0;
										if(pchoice == 1) {
											try {
												customerservice.approvePendingTransfer(c.getCustomerid());
											} catch (BusinessException e) {
												e.printStackTrace();
											}
										}if(pchoice ==2) {
											try {
												customerservice.deleteTransfer(c.getCustomerid());
											} catch (BusinessException e) {
											
												e.printStackTrace();
											}
										}
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
					} catch (BusinessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 2:
					String employeeUN;
					String employeePW;
					int loginchoice = 0;
					usermessage.info("\nEnter username: ");
					employeeUN = sc.nextLine();
					usermessage.info("\nEnter password: ");
					employeePW = sc.nextLine();
					try {
						if (employeeservice.logincheck(employeeUN, employeePW)) {
							do {
								usermessage.info("*****************");
								usermessage.info("* Employee Menu *");
								usermessage.info("*****************");
								usermessage.info("1) Create customer account");
								usermessage.info("2) View Accounts");
								usermessage.info("3) Accept/Reject pending accounts");
								usermessage.info("4) View logs");
								usermessage.info("5) Log off\n");
								try {
									loginchoice = Integer.parseInt(sc.nextLine());
									switch (loginchoice) {
									case 1: usermessage.info("Enter Customer detials below to create a new account");
									customer customer = new customer();
											usermessage.info("Enter First name");
											customer.setFirstname(sc.nextLine());
											usermessage.info("Enter Last name");
											customer.setLastname(sc.nextLine());
											usermessage.info("Create new username");
											customer.setCustomerUsername(sc.nextLine());
											usermessage.info("Create new passowrd");
											customer.setCustomerPassword(sc.nextLine());
											employeeservice.createCustomer(customer);
										
										break;
									case 2:
										usermessage.info("List of verified accounts:");
										usermessage.info("Under construction");
										//employeeservice.getAllverifiedaccounts();
										break;
									case 3:
										usermessage.info("List of accounts awaiting for approval");
										usermessage.info("Under construction");
										//employeeservice.getAllpendingaccounts();
										break;
									case 4:
										usermessage.info("Curent Logs");
										usermessage.info("Under construction");
										//employeeservice.viewLogs(customerid);
										break;
									case 5:
										usermessage.info("Logged off sucessfully");
										break;
									default:
										usermessage.info("Invalid option, please try again");
										break;
									}

								} catch (NumberFormatException e) {
								}
							} while (loginchoice != 5);

						}
					} catch (BusinessException e) {
						
						e.getMessage();
					}
					break;
				case 3:
					usermessage.info("Fill out the details below to create a new account");
				
							
							usermessage.info("Enter First name");
							String firstname = sc.nextLine();
							usermessage.info("Enter Last name");
							String lastname = sc.nextLine();
							usermessage.info("Create new username");
							String un = sc.nextLine();
							usermessage.info("Create new passowrd");
							String pw = sc.nextLine();
							usermessage.info("Enter your starting checking balance");
							double ch = Double.parseDouble(sc.nextLine());
							usermessage.info("Enter your starting saving balance");
							double sv = Double.parseDouble(sc.nextLine());
							customer customer = new customer(firstname, lastname, un, pw);
							
					try {
						customerservice.createCustomer(customer,ch,sv);
					} catch (BusinessException e) {
					e.getMessage();
					}
					break;
				case 4:
					usermessage.info("\nThank you for choosing Okane Banku to perform your banking needs");
					break;
				default:
					usermessage.info("Invalid selection... Please enter a choice between 1-4 only");
					break;
				}
			} catch (NumberFormatException e) {

			}
		} while (choice != 4);
	}
}
