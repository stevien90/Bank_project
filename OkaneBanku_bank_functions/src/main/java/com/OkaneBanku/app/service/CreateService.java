package com.OkaneBanku.app.service;

import com.OkaneBanku.app.exception.BusinessException;

import com.OkaneBanku.app.model.customer;

public interface CreateService {
	
	public int createCustomer(customer customer) throws BusinessException;
	
	
}
