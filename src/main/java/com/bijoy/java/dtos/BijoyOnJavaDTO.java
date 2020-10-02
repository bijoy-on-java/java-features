package com.bijoy.java.dtos;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Java Engineering: DTO object holds user properties information.
 * 
 * @author Bijoy Baral
 * @since Monday, August 24, 2020 10:00 am
 *
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class BijoyOnJavaDTO {

	private String userName;

	private String password;

	private String firstName;

	private String lastName;

	private String emailAddress;

	private Date dateOfBirth;

	private String address;

	private String company;

	private BigDecimal salary;

	private String maritalStatus;

	private boolean isAlive = true;

	private Date dateOfDeath;

	private String facebookURL;

	private String instagramURL;

	private String remarks;

}
