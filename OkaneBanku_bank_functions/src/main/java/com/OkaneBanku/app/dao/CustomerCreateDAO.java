package com.OkaneBanku.app.dao;

import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.customer;

public interface CustomerCreateDAO {

	public int createCustomer(customer customer) throws BusinessException;
	
	
}
