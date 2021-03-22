package com.OkaneBanku.app.service.impl;

public class CustomerValidations {

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

	public static boolean isEmailValid(String Email) {
		if (Email != null && Email.matches(
				"^[\\\\w!#$%&�*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&�*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPhoneValid(String Phone) {
		if (Phone != null && Phone.matches("^((\\\\(\\\\d{3}\\\\))|\\\\d{3})[- .]?\\\\d{3}[- .]?\\\\d{4}$")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isCityValid(String City) {
		if (City != null && City.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")) {
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
	
	
	public static boolean isValidMoney(float money) {
		if(money > 0 && money < 10000) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isAccountidValid(String id) {
		if (id != null && id.matches("[0-9]")) {
			return true;
		}else {
			return false;
		}
		
		
	}
}