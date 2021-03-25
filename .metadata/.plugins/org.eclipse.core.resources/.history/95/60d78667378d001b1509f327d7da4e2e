package com.OkaneBanku.app.service.impl;


import java.util.List;


import com.OkaneBanku.app.dao.EmployeeDAO;

import com.OkaneBanku.app.dao.impl.EmployeeDAOImpl;
import com.OkaneBanku.app.exception.BusinessException;

import com.OkaneBanku.app.model.customer;

import com.OkaneBanku.app.model.transaction;
import com.OkaneBanku.app.service.EmployeeService;

public class EmployeeImpl implements EmployeeService{

	EmployeeDAO employeedao = new EmployeeDAOImpl();
	
	@Override
	public List<transaction> viewLogs(int customerid) throws BusinessException {
		// TODO Auto-generated method stub
		return employeedao.viewLogs(customerid); 
	}

	@Override
	public void createCustomer(customer customer) throws BusinessException {
		employeedao.createCustomer(customer);
		
	}

	@Override
	public void validateCustomer(int customerid, boolean verify) throws BusinessException {
		employeedao.validateCustomer(customerid, verify);
		
	}

	@Override
	public List<customer> getAllpendingaccounts() throws BusinessException {
		// TODO Auto-generated method stub
		return employeedao.getAllpendingaccounts();
	}

	@Override
	public List<customer> getAllverifiedaccounts() throws BusinessException {
		// TODO Auto-generated method stub
		return employeedao.getAllverifiedaccounts();
	}

	@Override
	public boolean logincheck(String username, String password) throws BusinessException {
		if (employeedao.logincheck(username).getEmployeeUsername() == null) {
			return false;
		}
		if (employeedao.logincheck(username).getEmployeeUsername().equals(username)
				&& employeedao.logincheck(username).getEmployeePassword().equals(password)) {
			return true;
		}
		return false;

	}
}
