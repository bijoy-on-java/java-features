package com.bijoy.java.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bijoy.java.dtos.BijoyOnJavaDTO;
import com.bijoy.java.exceptions.BijoyOnJavaException;
import com.bijoy.java.facades.BijoyOnJavaFacade;

/**
 * Java Engineering: Rest API controller class.
 * 
 * @author Bijoy Baral
 * @since Monday, August 24, 2020 10:00 am
 *
 */
@RestController
@Validated
@RequestMapping("api/bijoy/java")
public class BijoyOnJavaController {

	private static final Logger LOGGER_CONTROLLER = LoggerFactory.getLogger(BijoyOnJavaController.class);

	@Autowired
	private BijoyOnJavaFacade bijoyJavaFacade;

	@Autowired
	private Validator validator;

	/**
	 * Controller method: This method is responsible to save data into database
	 * table.
	 * 
	 * @param bijoyJavaDto
	 * @return boolean
	 * @throws BijoyOnJavaException
	 */
	@PostMapping("/crud/create")
	public ResponseEntity<?> createOperation(@Valid @RequestBody final BijoyOnJavaDTO bijoyOnJavaDto)
			throws BijoyOnJavaException {
		if (LOGGER_CONTROLLER.isDebugEnabled()) {
			LOGGER_CONTROLLER.debug("BijoyJavaController: Inside createOperation method of the controller class.");
		}
		validateUserInput(bijoyOnJavaDto);
		return bijoyJavaFacade.createOperation(bijoyOnJavaDto);
	}

	/**
	 * Controller method: This method is responsible to read data from database
	 * table.
	 * 
	 * @param userName
	 * @return ResponseEntity<?>
	 * @throws BijoyOnJavaException 
	 */
	@GetMapping("/crud/read/{userName}")
	public ResponseEntity<?> readOperation(@Valid @PathVariable final String userName) throws BijoyOnJavaException {
		if (LOGGER_CONTROLLER.isDebugEnabled()) {
			LOGGER_CONTROLLER.debug("BijoyJavaController: Inside readOperation method of the controller class.");
		}
		return bijoyJavaFacade.readOperation(userName);
	}

	/**
	 * Controller method: This method is responsible to update data in database
	 * table.
	 * 
	 * @param userName
	 * @return boolean
	 */
	@PutMapping("/crud/update")
	public ResponseEntity<?> updateOperation(@Valid @RequestBody final BijoyOnJavaDTO bijoyOnJavaDto) {
		if (LOGGER_CONTROLLER.isDebugEnabled()) {
			LOGGER_CONTROLLER.debug("BijoyJavaController: Inside updateOperation method of the controller class.");
		}
		validateUserInput(bijoyOnJavaDto);
		return bijoyJavaFacade.updateOperation(bijoyOnJavaDto);
	}

	/**
	 * Controller method: This method is responsible to delete data from database
	 * table.
	 * 
	 * @param userName
	 * @return boolean
	 * @throws BijoyOnJavaException 
	 */
	@PostMapping("/crud/delete")
	public ResponseEntity<?> deleteOperation(@Valid @RequestBody final String userName) throws BijoyOnJavaException {
		if (LOGGER_CONTROLLER.isDebugEnabled()) {
			LOGGER_CONTROLLER.debug("BijoyJavaController: Inside deleteOperation method of the controller class.");
		}
		return bijoyJavaFacade.deleteOperation(userName);
	}

	/**
	 * Java Engineering: Method will throw error if bad input data provided.
	 * 
	 * @param methodArgumentNotValidException
	 * @return Map<String, String>
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		Map<String, String> errors = new HashMap<>();
		methodArgumentNotValidException.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return errors;
	}

	/**
	 * Java Engineering: Method will throw internal server error if thrown.
	 * 
	 * @param constraintViolationException
	 * @return Map<String, String>
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolation(ConstraintViolationException constraintViolationException) {
		Map<String, String> errors = new HashMap<>();
		constraintViolationException.getConstraintViolations().forEach(constraintViolations -> {
			errors.put("message", constraintViolations.getMessage());
			errors.put("path", (constraintViolations.getPropertyPath()).toString());
		});

		return errors;
	}

	/**
	 * Java Engineering: This method is responsible to validate user data.
	 * 
	 * @param bijoyOnJavaDto
	 */
	private void validateUserInput(final BijoyOnJavaDTO bijoyOnJavaDto) {
		Set<ConstraintViolation<BijoyOnJavaDTO>> constraintViolation = validator.validate(bijoyOnJavaDto);
		if (!constraintViolation.isEmpty()) {
			throw new ConstraintViolationException(constraintViolation);
		}
	}

}
