package com.OkaneBanku.app.service.impl;

import com.OkaneBanku.app.dao.CustomerCreateDAO;
import com.OkaneBanku.app.dao.impl.CustomerCreateDAOImpl;
import com.OkaneBanku.app.exception.BusinessException;
import com.OkaneBanku.app.model.customer;
import com.OkaneBanku.app.service.CreateService;

public class CustomerCreateImpl implements CreateService{
	private CustomerCreateDAO customercreatedao = new CustomerCreateDAOImpl();
	@Override
	public int createCustomer(customer customer) throws BusinessException {
		if(CustomerValidations.isFirstNameValid(customer.getFirstname())) {
			throw new BusinessException("Entered first name "+customer.getFirstname()+" is invalid");
		}
		if(CustomerValidations.isLastNameValid(customer.getLastname())) {
			throw new BusinessException("Entered Last name "+customer.getLastname()+" is invalid");
		}
		if(CustomerValidations.isEmailValid(customer.getEmail())) {
			throw new BusinessException("The entered email "+customer.getEmail()+" is invalid");
		}
		if(CustomerValidations.isPhoneValid(customer.getPhone())) {
			throw new BusinessException("The entered phone number "+customer.getPhone()+" is invalid");
		}
		if(CustomerValidations.isCityValid(customer.getCity())) {
			throw new BusinessException("The entered city "+customer.getCity()+" is invalid");
		}
		if(CustomerValidations.isUsernameValid(customer.getCustomerUsername())) {
			throw new BusinessException("The entered username "+customer.getCustomerUsername()+" is invalid");
		}
		if(CustomerValidations.isPasswordValid(customer.getCustomerPassword())) {
			throw new BusinessException("The entered password "+customer.getCustomerPassword()+" is invalid");
		}
		return customercreatedao.createCustomer(customer);
	}

}
