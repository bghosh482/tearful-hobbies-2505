package com.paykaro.service;

import com.paykaro.exception.LoginException;
import com.paykaro.model.LoginDTO;

public interface LoginService {

	public String logIntoAccount(LoginDTO dto) throws LoginException;

	public String logOutFromAccount(String key) throws LoginException;

}
