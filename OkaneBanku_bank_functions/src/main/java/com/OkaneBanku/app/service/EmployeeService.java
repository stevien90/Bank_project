package com.OkaneBanku.app.service;

import java.util.List;

import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.customer;
import com.OkaneBanku.app.model.transaction;


public interface EmployeeService {
	public List<transaction> viewLogs(int customerid) throws BusinessException; //UNDER CONSTRUCTION
	public void validateCustomer(int customerid) throws BusinessException;
	public List<customer> getAllpendingaccounts() throws BusinessException;
	public List<customer> getAllverifiedaccounts() throws BusinessException;
	public boolean logincheck(String username, String password) throws BusinessException;
	
}
