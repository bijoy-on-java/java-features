package com.bijoy.java.facades;

import org.springframework.http.ResponseEntity;

import com.bijoy.java.dtos.BijoyOnJavaDTO;
import com.bijoy.java.exceptions.BijoyOnJavaException;

/**
 * Java Engineering: Rest API Facade Interface.
 * 
 * @author Bijoy Baral
 * @since Monday, August 24, 2020 10:00 am
 *
 */
public interface BijoyOnJavaFacade {

	/**
	 * Facade Interface Method: This method is responsible to save data into
	 * database table.
	 * 
	 * @param bijoyJavaDto
	 * @return ResponseEntity<?>
	 * @throws BijoyOnJavaException
	 */
	public ResponseEntity<?> createOperation(final BijoyOnJavaDTO bijoyJavaDto) throws BijoyOnJavaException;

	/**
	 * Facade Interface Method: This method is responsible to read data from
	 * database table.
	 * 
	 * @param userName
	 * @return ResponseEntity<?>
	 * @throws BijoyOnJavaException
	 */
	public ResponseEntity<?> readOperation(final String userName) throws BijoyOnJavaException;

	/**
	 * Facade Interface Method: This method is responsible to update data in
	 * database table.
	 * 
	 * @param bijoyJavaDto
	 * @return ResponseEntity<?>
	 * @throws BijoyOnJavaException
	 */
	public ResponseEntity<?> updateOperation(final BijoyOnJavaDTO bijoyJavaDto) ;

	/**
	 * Facade Interface Method: This method is responsible to delete data from
	 * database table.
	 * 
	 * @param userName
	 * @return ResponseEntity<?>
	 * @throws BijoyOnJavaException
	 */
	public ResponseEntity<?> deleteOperation(final String userName) throws BijoyOnJavaException;
}
