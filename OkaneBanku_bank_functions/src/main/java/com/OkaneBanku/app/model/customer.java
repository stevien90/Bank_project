package com.OkaneBanku.app.model;

public class customer {

	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String city;
	private String state;
	private String customerUsername;
	private String customerPassword;
	private checking checkingbalance;
	private saving savingbalance;
	private account accountid;
	public customer() {

	}

	public customer(String firstname, String lastname, String email, String phone, String city, String state, int deposit,
			int withdraw, int transfer, String customerUsername, String customerPassword) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public checking getCheckingbalance() {
		return checkingbalance;
	}

	public void setCheckingbalance(checking checkingbalance) {
		this.checkingbalance = checkingbalance;
	}

	public saving getSavingbalance() {
		return savingbalance;
	}

	public void setSavingsbalance(saving savingsbalance) {
		this.savingbalance = savingsbalance;
	}

	@Override
	public String toString() {
		return "customer [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", phone=" + phone
				+ ", city=" + city + ", state=" + state + ", customerUsername=" + customerUsername
				+ ", customerPassword=" + customerPassword + ", checkingbalance=" + checkingbalance
				+ ", savingbalance=" + savingbalance + "]";
	}





}
