package com.OkaneBanku.app.main;

import java.util.List;
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
				usermessage.info("**Enter an option between 1-4");
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
							customer customerinfo = customerservice.retrieveCustomer(username);
							int loginchoice = 0;
							do {
								usermessage.info("\n=============");
								usermessage.info("Customer Menu");
								usermessage.info("==============");
								usermessage.info("1) Check account balance");
								usermessage.info("2) Deposit to account balance");
								usermessage.info("3) Withdraw from account balance");
								usermessage.info("4) Perform transfer");
								usermessage.info("5) Check pending transfer");
								usermessage.info("6) Exit\n");
								try {
									usermessage.info("**Enter an option between 1 - 6:");
									loginchoice = Integer.parseInt(sc.nextLine());
									switch (loginchoice) {
									case 1:
										usermessage.info("\nAccount |");
										usermessage.info("---------");
										usermessage.info("1) Checking");
										usermessage.info("2) Saving\n");
										usermessage.info("**Enter an option between 1 - 2:");
										try {
											int accountchoice = 0;
											accountchoice = Integer.parseInt(sc.nextLine());
											if (accountchoice == 1) {
												try {
													usermessage.info("\nCurrent Balance: $" + customerservice
															.viewCheckingAcc(customerinfo.getCustomerid()));
												} catch (BusinessException e) {
													usermessage.info(
															"Incorrect option... please choose an option between 1 and 2\n");
												}
											}
											if (accountchoice == 2) {
												try {
													usermessage.info("\nCurrent balance: $" + customerservice
															.viewSavingAcc(customerinfo.getCustomerid()));
												} catch (BusinessException e) {
													usermessage.info(
															"Incorrect option... please choose an option between 1 and 2\n");
												}
											}
										} catch (NumberFormatException e) {
											usermessage.info(
													"Enter numbers only");
										}

										break;
									case 2:
										usermessage.info("\nAccount |");
										usermessage.info("---------");
										usermessage.info("1) Checking");
										usermessage.info("2) Saving\n");
										usermessage.info("Enter an option between 1 - 2:");
										double deposit = 0.00;
										try {
											int accountchoice = 0;
											accountchoice = Integer.parseInt(sc.nextLine());
											if (accountchoice == 1) {
												try {
													usermessage.info(
															"Enter the amount you would like to depsoit to your Checking Account");
													deposit = Double.parseDouble(sc.nextLine());
													usermessage.info("\nNew Checking balance: $" + customerservice
															.depositChecking(customerinfo.getCustomerid(), deposit));
												} catch (BusinessException e) {
													e.getMessage();
												}
											}
											if (accountchoice == 2) {
												try {
													usermessage.info(
															"Enter the amount you would like to depsoit to your Saving Account");
													deposit = Double.parseDouble(sc.nextLine());
													usermessage.info("\nNew Saving balance: $" + customerservice
															.depositSaving(customerinfo.getCustomerid(), deposit));
												} catch (BusinessException | NumberFormatException e) {
													e.getMessage();
												}
											}
										} catch (NumberFormatException e) {
											usermessage.info(
													"Please enter numbers only");
										}
										break;
									case 3:
										usermessage.info("\nAccount |");
										usermessage.info("---------");
										usermessage.info("1) Checking");
										usermessage.info("2) Saving\n");
										usermessage.info("Enter an option between 1 - 2:");
										double withdraw = 0.00;
										try {
											int accountchoice = 0;
											accountchoice = Integer.parseInt(sc.nextLine());
											if (accountchoice == 1) {
												try {
													usermessage.info("Current Checking balance: $" + customerservice
															.viewCheckingAcc(customerinfo.getCustomerid()));
													usermessage.info(
															"\nEnter the amount you would like to withdraw from your Checking Account");
													withdraw = Double.parseDouble(sc.nextLine());
													customerservice.withdrawChecking(customerinfo.getCustomerid(),
															withdraw);
													usermessage.info("New Checking balance: $" + customerservice
															.viewCheckingAcc(customerinfo.getCustomerid()));
												} catch (BusinessException e) {
													e.getMessage();
												}
											}
											if (accountchoice == 2) {
												try {
													usermessage.info("Current Saving balance: $" + customerservice
															.viewSavingAcc(customerinfo.getCustomerid()));
													usermessage.info(
															"\nEnter the amount you would like to withdraw from your Saving Account");
													withdraw = Double.parseDouble(sc.nextLine());
													customerservice.withdrawSaving(customerinfo.getCustomerid(),
															withdraw);
													usermessage.info("New Saving balance: $" + customerservice
															.viewSavingAcc(customerinfo.getCustomerid()));
												} catch (BusinessException e) {
													e.getMessage();
												}
											}
										} catch (NumberFormatException e) {
											usermessage.info(
													"Enter numbers only");
										}
										break;
									case 4:
										usermessage.info("\nAccount |");
										usermessage.info("---------");
										usermessage.info("1) Transfer Checking Account");
										usermessage.info("2) Transfer Saving Account\n");
										usermessage.info("Enter an option between 1 - 2:");
										double transfer = 0.00;
										try {
											int accountchoice = 0;
											accountchoice = Integer.parseInt(sc.nextLine());
											if (accountchoice == 1) {
												try {
													usermessage.info("Current Checking balance: $" + customerservice
															.viewCheckingAcc(customerinfo.getCustomerid()));
													usermessage.info("Current Saving balance: $" + customerservice
															.viewSavingAcc(customerinfo.getCustomerid()));
													usermessage.info(
															"\nEnter the amount you would like to transfer to your Saving Account: ");
													transfer = Double.parseDouble(sc.nextLine());
													customerservice.transferChecking(customerinfo.getCustomerid(),
															transfer);
													usermessage.info("\n*Transfer Success");
													usermessage.info("New Checking balance: $" + customerservice
															.viewCheckingAcc(customerinfo.getCustomerid()));
													usermessage.info("New Saving Balance: $" + customerservice
															.viewSavingAcc(customerinfo.getCustomerid()));
												} catch (BusinessException e) {
													e.getMessage();
												}
											}
											if (accountchoice == 2) {
												try {
													usermessage.info("Current Saving balance: $" + customerservice
															.viewSavingAcc(customerinfo.getCustomerid()));
													usermessage.info("Current Checking balance: $" + customerservice
															.viewCheckingAcc(customerinfo.getCustomerid()));
													usermessage.info(
															"\nEnter the amount you would like to transfer to your Checking Account:");
													transfer = Double.parseDouble(sc.nextLine());
													customerservice.transferSaving(customerinfo.getCustomerid(),
															transfer);
													usermessage.info("\n*Transfer Success");
													usermessage.info("New Checking Balance: $" + customerservice
															.viewCheckingAcc(customerinfo.getCustomerid()));
													usermessage.info("New Saving Balance: $" + customerservice
															.viewSavingAcc(customerinfo.getCustomerid()));
												} catch (BusinessException e) {
													e.getMessage();
												}
											}
										} catch (NumberFormatException e) {
											usermessage.info(
													"Enter numbers only");
										}
										break;
									case 5:
										usermessage.info("Pending transactions: ");
										usermessage.info("Under Construction");
										int pchoice = 0;
										try {
											// customerservice.viewPendingTransfer(c.getCustomerid());
											usermessage.info("__________________");
											usermessage.info("1) Accept");
											usermessage.info("2) Decline");
											usermessage.info("Enter an option above");
											pchoice = Integer.parseInt(sc.nextLine());
											if (pchoice == 1) {
												// try {
												// customerservice.approvePendingTransfer(customerinfo.getCustomerid());
												// usermessage.info("Transfer Success");
												// } catch (BusinessException e) {
												// e.getMessage();
												// }
											}
											if (pchoice == 2) {
												// try {
												// customerservice.deleteTransfer(customerinfo.getCustomerid());
												// .info("Transfer Denied");
												// } catch (BusinessException e) {
												// e.getMessage();
												// }
											}
										} catch (NumberFormatException e) {
											usermessage.info(
													"Incorrect option... please choose an option between 1 and 2");
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
					} catch (BusinessException e) {
						usermessage.info("login failed");
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
								usermessage.info("5) Log off");
								usermessage.info("\nEnter option from 1 - 5");
								try {
									loginchoice = Integer.parseInt(sc.nextLine());
									switch (loginchoice) {
									case 1:
										usermessage.info("Enter Customer details below to create a new account");

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
											customerservice.createCustomer(customer, ch, sv);
											usermessage.info("New Account Created Sucessfully");
										} catch (BusinessException e) {
											e.getMessage();
										}
										break;
									case 2:
										usermessage.info("\nList of verified accounts:");
										usermessage.info("_____________________________");
										List<customer> verified = employeeservice.getAllverifiedaccounts();
										for (customer v : verified) {
											usermessage.info(v.toString());
										}
										break;
									case 3:
										usermessage.info("\nList of accounts awaiting for approval");
										usermessage.info("_________________________________________");
										List<customer> acc = employeeservice.getAllpendingaccounts();
										for (customer account : acc) {
											usermessage.info(account.toString());
										}

										usermessage.info("\nSelect customerid to verify");
										employeeservice.validateCustomer(Integer.parseInt(sc.nextLine()));
										usermessage.info("Customer's account is now verified\n");
										break;
									case 4:
										usermessage.info("Curent Logs");
										usermessage.info("Under construction");
										// employeeservice.viewLogs(customerid);
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
						customerservice.createCustomer(customer, ch, sv);
						usermessage.info("New Account Successfully Created");
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
