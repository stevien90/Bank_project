package com.OkaneBanku.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class employeeMain {
	private static Logger usermessage = Logger.getLogger(employeeMain.class);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String username = "";
		String password = "";
		int loginchoice = 0;
		if (username == username && password == password) {
			do {
				usermessage.info("*****************");
				usermessage.info("* Employee Menu *");
				usermessage.info("*****************");
				usermessage.info("1) Create customer account");
				usermessage.info("2) View Account");
				usermessage.info("3) Accept/Reject pending accounts");
				usermessage.info("4) View logs");
				usermessage.info("5) Log off\n");
				try {
					loginchoice = Integer.parseInt(sc.nextLine());
					switch (loginchoice) {
					case 1:
						usermessage.info("customer info inputs method");
						break;
					case 2:
						usermessage.info("Have a list of account number");
						break;
					case 3:
						usermessage.info("Here a list of accounts awaiting for approval");
						break;
					case 4:
						usermessage.info("Current logs");
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

	}

}
