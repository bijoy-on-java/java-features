package com.bijoy.java.facades;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bijoy.java.constants.BijoyOnJavaConstants;
import com.bijoy.java.dtos.BijoyOnJavaDTO;
import com.bijoy.java.exceptions.BijoyOnJavaException;
import com.bijoy.java.mappers.BijoyOnJavaMapper;
import com.bijoy.java.models.BijoyOnJavaModel;
import com.bijoy.java.services.BijoyOnJavaService;

/**
 * Java Engineering: Rest API Facade Implementation class.
 * 
 * @author Bijoy Baral
 * @since Monday, August 24, 2020 10:00 am
 *
 */

@Service
public class BijoyOnJavaFacadeImpl implements BijoyOnJavaFacade {

	private static final Logger LOGGER_FACADE = LoggerFactory.getLogger(BijoyOnJavaFacadeImpl.class);

	@Autowired
	private BijoyOnJavaService bijoyOnJavaService;

	@Override
	public ResponseEntity<?> createOperation(final BijoyOnJavaDTO bijoyOnJavaDto) {
		if (LOGGER_FACADE.isDebugEnabled()) {
			LOGGER_FACADE.debug("BijoyJavaFacadeImpl: Inside createOperation method of the facade class.");
		}
		BijoyOnJavaModel bijoyOnJavaModel = null;
		try {
			bijoyOnJavaModel = bijoyOnJavaService.createOperation(BijoyOnJavaMapper.dtoToModel(bijoyOnJavaDto));
		} catch (final BijoyOnJavaException bijoyOnJavaExcepion) {
			bijoyOnJavaExcepion.printStackTrace();
			return new ResponseEntity<String>(BijoyOnJavaConstants.BijoyJavaCrudConstants.CREATE_FAILURE_MESSAGE,
					HttpStatus.NOT_ACCEPTABLE);
		}
		if (null == bijoyOnJavaModel) {
			return new ResponseEntity<String>(BijoyOnJavaConstants.BijoyJavaCrudConstants.CREATE_FAILURE_MESSAGE,
					HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<BijoyOnJavaDTO>(BijoyOnJavaMapper.modelToDto(bijoyOnJavaModel), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> readOperation(String userName) {
		if (LOGGER_FACADE.isDebugEnabled()) {
			LOGGER_FACADE.debug("BijoyJavaFacadeImpl: Inside readOperation method of the facade class.");
		}
		BijoyOnJavaModel returnedBijoyOnJavaModel = null;
		try {
			returnedBijoyOnJavaModel = bijoyOnJavaService.readOperation(userName);
		} catch (BijoyOnJavaException bijoyOnJavaExcepion) {
			bijoyOnJavaExcepion.printStackTrace();
		}
		if (null == returnedBijoyOnJavaModel || null == returnedBijoyOnJavaModel.getUserName()) {
			return new ResponseEntity<String>(BijoyOnJavaConstants.BijoyJavaCrudConstants.BIJOYONJAVA_FAILURE_MESSAGE,
					HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BijoyOnJavaDTO>(BijoyOnJavaMapper.modelToDto(returnedBijoyOnJavaModel),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateOperation(final BijoyOnJavaDTO bijoyJavaDto) {
		if (LOGGER_FACADE.isDebugEnabled()) {
			LOGGER_FACADE.debug("BijoyJavaFacadeImpl: Inside updateOperation method of the facade class.");
		}
		BijoyOnJavaModel bijoyJavaModel = null;
		try {
			bijoyJavaModel = bijoyOnJavaService.updateOperation(BijoyOnJavaMapper.dtoToModel(bijoyJavaDto));
		} catch (BijoyOnJavaException bijoyOnJavaExcepion) {
			bijoyOnJavaExcepion.printStackTrace();
		}
		if (null == bijoyJavaModel || null == bijoyJavaModel.getUserName()) {
			return new ResponseEntity<String>(BijoyOnJavaConstants.BijoyJavaCrudConstants.BIJOYONJAVA_FAILURE_MESSAGE,
					HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>(BijoyOnJavaConstants.BijoyJavaCrudConstants.UPDATE_SUCCESS_MESSAGE,
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteOperation(final String userName) {
		if (LOGGER_FACADE.isDebugEnabled()) {
			LOGGER_FACADE.debug("BijoyJavaFacadeImpl: Inside deleteOperation method of the facade class.");
		}
		boolean isUserPresent = false;
		try {
			isUserPresent = bijoyOnJavaService.deleteOperation(userName);
		} catch (BijoyOnJavaException bijoyOnJavaExcepion) {
			bijoyOnJavaExcepion.printStackTrace();
		}
		if (isUserPresent) {
			return new ResponseEntity<String>(BijoyOnJavaConstants.BijoyJavaCrudConstants.DELETE_SUCCESS_MESSAGE,
					HttpStatus.OK);
		}
		return new ResponseEntity<String>(BijoyOnJavaConstants.BijoyJavaCrudConstants.BIJOYONJAVA_FAILURE_MESSAGE,
				HttpStatus.OK);
	}

}
