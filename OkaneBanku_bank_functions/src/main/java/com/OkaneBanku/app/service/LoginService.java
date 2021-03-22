package com.OkaneBanku.app.service;

import com.OkaneBanku.app.exception.BusinessException;

public interface LoginService {
	public String logincheck(String username, String password) throws BusinessException; 
}
