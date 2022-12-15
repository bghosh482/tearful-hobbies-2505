package com.paykaro.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paykaro.exception.LoginException;
import com.paykaro.model.CurrentUserSession;
import com.paykaro.model.Customer;
import com.paykaro.model.LoginDTO;
import com.paykaro.repository.CustomerDAO;
import com.paykaro.repository.SessionDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerDAO cDao;

	@Autowired
	private SessionDAO sDao;

	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {

		Customer existingCustomer = cDao.findByMobileNo(dto.getMobileNo());

		if (existingCustomer == null) {

			throw new LoginException("Please Enter a valid mobile number");

		}

		Optional<CurrentUserSession> validCustomerSessionOpt = sDao.findById(existingCustomer.getCid());

		if (validCustomerSessionOpt.isPresent()) {

			throw new LoginException("User already Logged In with this number");

		}

		if (existingCustomer.getPassword().equals(dto.getPassword())) {

			String key = RandomString.make(6);

			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCid(), key,
					LocalDateTime.now());

			sDao.save(currentUserSession);

			return currentUserSession.toString();
		} else
			throw new LoginException("Please Enter a valid password");

	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {

		CurrentUserSession validCustomerSession = sDao.findByUuid(key);

		if (validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");

		}

		sDao.delete(validCustomerSession);

		return "Logged Out !";

	}

}
