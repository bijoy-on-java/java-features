package com.bijoy.java.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijoy.java.exceptions.BijoyOnJavaException;
import com.bijoy.java.models.BijoyOnJavaModel;
import com.bijoy.java.repositories.BijoyOnJavaRepository;

/**
 * Java Engineering: Rest API Service Implementation class.
 * 
 * @author Bijoy Baral
 * @since Monday, August 24, 2020 10:00 am
 *
 */

@Service
public class BijoyOnJavaServicempl implements BijoyOnJavaService {

	private static final Logger LOGGER_SERVICE = LoggerFactory.getLogger(BijoyOnJavaServicempl.class);

	@Autowired
	private BijoyOnJavaRepository bijoyOnJavaRepository;

	@Override
	public BijoyOnJavaModel createOperation(final BijoyOnJavaModel bijoyOnJavaModel) throws BijoyOnJavaException{
		if (LOGGER_SERVICE.isDebugEnabled()) {
			LOGGER_SERVICE.debug("BijoyOnJavaServicempl: Inside createOperation method of the service class.");
		}
		final BijoyOnJavaModel returnedBijoyOnJavaModel = bijoyOnJavaRepository
				.findByUserName(bijoyOnJavaModel.getUserName());
		if (null == returnedBijoyOnJavaModel || null == returnedBijoyOnJavaModel.getUserName()) {
			return bijoyOnJavaRepository.save(bijoyOnJavaModel);
		}
		return null;
	}

	@Override
	public BijoyOnJavaModel readOperation(final String userName) throws BijoyOnJavaException{
		if (LOGGER_SERVICE.isDebugEnabled()) {
			LOGGER_SERVICE.debug("BijoyOnJavaServicempl: Inside readOperation method of the service class.");
		}
		return bijoyOnJavaRepository.findByUserName(userName);
	}

	@Override
	public BijoyOnJavaModel updateOperation(final BijoyOnJavaModel bijoyOnJavaModel) throws BijoyOnJavaException{
		if (LOGGER_SERVICE.isDebugEnabled()) {
			LOGGER_SERVICE.debug("BijoyOnJavaServicempl: Inside updateOperation method of the service class.");
		}
		final BijoyOnJavaModel returnedBijoyOnJavaModel = bijoyOnJavaRepository
				.findByUserName(bijoyOnJavaModel.getUserName());
		if (null != returnedBijoyOnJavaModel && null != returnedBijoyOnJavaModel.getUserName()) {
			bijoyOnJavaRepository.updateUserDetails(bijoyOnJavaModel.getUserName(), bijoyOnJavaModel.getPassword(),
					bijoyOnJavaModel.getFirstName(), bijoyOnJavaModel.getLastName(), bijoyOnJavaModel.getEmailAddress(),
					bijoyOnJavaModel.getDateOfBirth(), bijoyOnJavaModel.getAddress(), bijoyOnJavaModel.getCompany(),
					bijoyOnJavaModel.getSalary(), bijoyOnJavaModel.getMaritalStatus(), bijoyOnJavaModel.isAlive(),
					bijoyOnJavaModel.getDateOfDeath(), bijoyOnJavaModel.getFacebookURL(),
					bijoyOnJavaModel.getInstagramURL(), bijoyOnJavaModel.getRemarks());
		}
		return returnedBijoyOnJavaModel;
	}

	@Override
	public boolean deleteOperation(final String userName) throws BijoyOnJavaException{
		if (LOGGER_SERVICE.isDebugEnabled()) {
			LOGGER_SERVICE.debug("BijoyOnJavaServicempl: Inside deleteOperation method of the service class.");
		}
		final BijoyOnJavaModel bijoyOnJavaModel = bijoyOnJavaRepository.findByUserName(userName);
		if (null != bijoyOnJavaModel && null != bijoyOnJavaModel.getUserName()) {
			bijoyOnJavaRepository.deleteById(bijoyOnJavaModel.getId());
			return true;
		}
		return false;
	}
}
