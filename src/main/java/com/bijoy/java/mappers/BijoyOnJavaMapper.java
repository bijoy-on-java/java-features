package com.bijoy.java.mappers;

import com.bijoy.java.dtos.BijoyOnJavaDTO;
import com.bijoy.java.models.BijoyOnJavaModel;

/**
 * Java Engineering: Mapper object is used to convert/parse DTO to Model object
 * and vice versa.
 * 
 * @author Bijoy Baral
 * @since Monday, August 24, 2020 10:00 am
 *
 */
public class BijoyOnJavaMapper {

	/**
	 * Java Engineering: Method to convert dto object to model object.
	 * 
	 * @param bijoyJavaDto
	 * @return BijoyJavaModel
	 */
	public static BijoyOnJavaModel dtoToModel(final BijoyOnJavaDTO bijoyJavaDto) {
		return new BijoyOnJavaModel().setUserName(bijoyJavaDto.getUserName()).setPassword(bijoyJavaDto.getPassword())
				.setFirstName(bijoyJavaDto.getFirstName()).setLastName(bijoyJavaDto.getLastName())
				.setEmailAddress(bijoyJavaDto.getEmailAddress()).setDateOfBirth(bijoyJavaDto.getDateOfBirth())
				.setCompany(bijoyJavaDto.getCompany()).setSalary(bijoyJavaDto.getSalary())
				.setMaritalStatus(bijoyJavaDto.getMaritalStatus()).setAlive(bijoyJavaDto.isAlive())
				.setDateOfDeath(bijoyJavaDto.getDateOfDeath()).setAddress(bijoyJavaDto.getAddress())
				.setFacebookURL(bijoyJavaDto.getFacebookURL()).setInstagramURL(bijoyJavaDto.getInstagramURL())
				.setRemarks(bijoyJavaDto.getRemarks());
	}

	/**
	 * Java Engineering: Method to convert model object to dto object.
	 * 
	 * @param bijoyJavaModel
	 * @return BijoyOnJavaDTO
	 */
	public static BijoyOnJavaDTO modelToDto(final BijoyOnJavaModel bijoyJavaModel) {
		return new BijoyOnJavaDTO().setUserName(bijoyJavaModel.getUserName()).setPassword(bijoyJavaModel.getPassword())
				.setFirstName(bijoyJavaModel.getFirstName()).setLastName(bijoyJavaModel.getLastName())
				.setEmailAddress(bijoyJavaModel.getEmailAddress()).setDateOfBirth(bijoyJavaModel.getDateOfBirth())
				.setAddress(bijoyJavaModel.getAddress()).setCompany(bijoyJavaModel.getCompany())
				.setSalary(bijoyJavaModel.getSalary()).setMaritalStatus(bijoyJavaModel.getMaritalStatus())
				.setAlive(bijoyJavaModel.isAlive()).setDateOfBirth(bijoyJavaModel.getDateOfDeath())
				.setFacebookURL(bijoyJavaModel.getFacebookURL()).setInstagramURL(bijoyJavaModel.getInstagramURL())
				.setRemarks(bijoyJavaModel.getRemarks());
	}
}
