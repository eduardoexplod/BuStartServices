package com.bustart.main.bo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bustart.main.constants.ErrorConstant;

/**
 * @author Slam245
 *
 */
public class BusinessInputBO {

	/**
	 * Constructor
	 */
	public BusinessInputBO() {
	}

	@NotNull(message = ErrorConstant.ERROR_VAL_BUSINESS_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_BUSINESS_REQUIRED)	
	private String business;
	@NotNull(message = ErrorConstant.ERROR_VAL_BUSINESS_DESCRIPTION_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_BUSINESS_DESCRIPTION_REQUIRED)
	private String businessDescription;
	@NotNull(message = ErrorConstant.ERROR_VAL_USERNAME_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_USERNAME_REQUIRED)
	private String userName;
	
	/**
	 * @return the business
	 */
	public String getBusiness() {
		return business;
	}
	/**
	 * @param business the business to set
	 */
	public void setBusiness(String business) {
		this.business = business;
	}
	/**
	 * @return the businessDescription
	 */
	public String getBusinessDescription() {
		return businessDescription;
	}
	/**
	 * @param businessDescription the businessDescription to set
	 */
	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
