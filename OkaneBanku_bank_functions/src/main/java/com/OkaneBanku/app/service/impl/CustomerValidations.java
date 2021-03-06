package com.OkaneBanku.app.service.impl;

import com.OkaneBanku.app.dao.CustomerDAO;
import com.OkaneBanku.app.dao.impl.CustomerDAOImpl;

public class CustomerValidations {
	static CustomerDAO customerdao = new CustomerDAOImpl();
	public static boolean isFirstNameValid(String Firstname) {
		if (Firstname != null && Firstname.matches("[a-zA-Z]")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isLastNameValid(String Lastname) {
		if (Lastname != null && Lastname.matches("[a-zA-Z]{2,15}")) {
			return true;
		} else {
			return false;
		}
	}

	
	public static boolean isUsernameValid(String username) {
		if(username != null && username.matches("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$")) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isPasswordValid(String pw) {
		if(pw != null && pw.matches("^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$")) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isAmountValid(double m){
		return false;
	}
	
	
}
