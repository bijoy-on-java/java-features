package com.bijoy.java.services;

import com.bijoy.java.exceptions.BijoyOnJavaException;
import com.bijoy.java.models.BijoyOnJavaModel;

/**
 * Java Engineering: Rest API Service Interface.
 * 
 * @author Bijoy Baral
 * @since Monday, August 24, 2020 10:00 am
 *
 */

public interface BijoyOnJavaService {

	/**
	 * Service Interface Method: This method is responsible to save data into
	 * database table.
	 * 
	 * @param bijoyJavaModel
	 * @return BijoyOnJavaModel
	 * @throws BijoyOnJavaException
	 */
	public BijoyOnJavaModel createOperation(final BijoyOnJavaModel bijoyJavaModel) throws BijoyOnJavaException;
	
	/**
	 * Service Interface Method: This method is responsible to save data into
	 * database table.
	 * 
	 * @param bijoyJavaModel
	 * @return userName
	 * @throws BijoyOnJavaException
	 */
	public BijoyOnJavaModel readOperation(final String userName) throws BijoyOnJavaException;
	
	/**
	 * Service Interface Method: This method is responsible to update data in
	 * database table.
	 * 
	 * @param bijoyJavaModel
	 * @return BijoyOnJavaModel
	 * @throws BijoyOnJavaException
	 */
	public BijoyOnJavaModel updateOperation(final BijoyOnJavaModel bijoyJavaModel) throws BijoyOnJavaException;

	/**
	 * Service Interface Method: This method is responsible to delete data from
	 * database table.
	 * 
	 * @param userName
	 * @return boolean
	 * @throws BijoyOnJavaException
	 */
	public boolean deleteOperation(final String userName) throws BijoyOnJavaException;
}
