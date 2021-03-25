package com.OkaneBanku.app.model;

public class employee {
	private String employeeUsername;
	private String employeePassword;
	private int employeeid;
	
	
	public employee() {
		
	}



	public employee(String employeeUsername, String employeePassword) {
		super();
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
	}
	
	
	
	public employee(String employeeUsername, String employeePassword, int employeeid) {
		super();
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
		this.employeeid = employeeid;
	}



	public String getEmployeeUsername() {
		return employeeUsername;
	}
	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	@Override
	public String toString() {
		return "employee [employeeUsername=" + employeeUsername + ", employeePassword=" + employeePassword + "]";
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	

}
