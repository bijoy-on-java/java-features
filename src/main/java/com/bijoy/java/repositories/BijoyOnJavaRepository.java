package com.bijoy.java.repositories;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bijoy.java.models.BijoyOnJavaModel;

/**
 * Java Engineering: Rest API Repository Interface.
 * 
 * @author Bijoy Baral
 * @since Monday, August 24, 2020 10:00 am
 *
 */

@Repository
public interface BijoyOnJavaRepository extends CrudRepository<BijoyOnJavaModel, Long> {

	/**
	 * Java Engineering: Method is used to find user details based on user name.
	 * 
	 * @param userName
	 * @return BijoyJavaModel
	 */
	@Query(value = "select * from bijoy_java where user_name=?1", nativeQuery = true)
	public BijoyOnJavaModel findByUserName(final String userName);

	/**
	 * Java Engineering: Method is used to update user details based on user
	 * input(s).
	 * 
	 * @param userName
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param dateOfBirth
	 * @param address
	 * @param company
	 * @param salary
	 * @param maritalStatus
	 * @param isAlive
	 * @param dateOfDeath
	 * @param facebookURL
	 * @param instagramURL
	 * @param remarks
	 */
	@Transactional
	@Modifying
	@Query(value = "update bijoy_java set user_name=?1,password=?2,first_name=?3,last_name=?4,email_address=?5,date_of_birth=?6, "
			+ "address=?7,company=?8,salary=?9,marital_status=?10,is_alive=?11,date_of_death=?12,facebookurl=?13,instagramurl=?14,remarks=?15 "
			+ "where user_name=?1", nativeQuery = true)
	public void updateUserDetails(final String userName, final String password, final String firstName,
			final String lastName, final String emailAddress, final Date dateOfBirth, final String address,
			final String company, final BigDecimal salary, final String maritalStatus, final boolean isAlive,
			final Date dateOfDeath, final String facebookURL, final String instagramURL, final String remarks);
}
