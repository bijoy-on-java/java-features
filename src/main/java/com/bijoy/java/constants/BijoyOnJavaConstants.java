package com.bijoy.java.constants;

/**
 * Java Engineering: Interface contains constant(s) variable(s) for the
 * application.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
public interface BijoyOnJavaConstants {

	/**
	 * Java Engineering: Interface definition contains constant related to CRUD API
	 * operations.
	 * 
	 * @author Baral
	 *
	 */
	public interface BijoyJavaCrudConstants {
		
		public static final String UPDATE_SUCCESS_MESSAGE = "Message: User details successfully updated in the system.";
		public static final String DELETE_SUCCESS_MESSAGE = "Message: User details successfully removed from the system.";
		public static final String CREATE_FAILURE_MESSAGE = "Message: Error in creating user details or user details already present in the system.";
		public static final String BIJOYONJAVA_FAILURE_MESSAGE = "Message: User details not present in the system.";
	}
}
