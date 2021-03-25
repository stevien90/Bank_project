package com.OkaneBanku.app.service;

import java.util.List;

import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.customer;
import com.OkaneBanku.app.model.transaction;


public interface EmployeeService {
	public List<transaction> viewLogs(int customerid) throws BusinessException;
	public void createCustomer(customer customer) throws BusinessException;
	public void validateCustomer(int customerid, boolean verify) throws BusinessException;//false to true
	public List<customer> getAllpendingaccounts() throws BusinessException;
	public List<customer> getAllverifiedaccounts() throws BusinessException;
	public boolean logincheck(String username, String password) throws BusinessException;
	
}
