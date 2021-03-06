package com.OkaneBanku.app.dao;

import java.util.List;

import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.customer;
import com.OkaneBanku.app.model.employee;
import com.OkaneBanku.app.model.transaction;

public interface EmployeeDAO {
	public List<transaction> viewLogs(int customerid) throws BusinessException;
	public void validateCustomer(int customerid) throws BusinessException;
	public List<customer> getAllpendingaccounts() throws BusinessException;
	public List<customer> getAllverifiedaccounts() throws BusinessException;
	public employee logincheck(String username) throws BusinessException; 
}
