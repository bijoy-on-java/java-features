package com.bijoy.java.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Java Engineering: Model object holds user properties information.
 * 
 * @author Bijoy Baral
 * @since Monday, August 24, 2020 10:00 am
 *
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "bijoy_java")
@EntityListeners(AuditingEntityListener.class)
public class BijoyOnJavaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Username can not be empty. Please provide user name.")
	private String userName;

	@NotEmpty(message = "Password can not be empty. Please provide password.")
	private String password;

	@NotEmpty(message = "First name can not be empty. Please provide first name.")
	private String firstName;

	private String lastName;

	@Email(message = "Email address is wrong. Please provide valid email address.")
	private String emailAddress;

	private Date dateOfBirth;

	private String address;

	private String company;

	@NotNull(message = "Salary can not be empty. Please provide Salary.")
	@DecimalMin("10000.00")
	private BigDecimal salary;

	@NotEmpty(message = "Marital status can not be empty. Please provide marital status.")
	private String maritalStatus;

	private boolean isAlive;

	private Date dateOfDeath;

	private String facebookURL;

	private String instagramURL;

	private String remarks;

}
