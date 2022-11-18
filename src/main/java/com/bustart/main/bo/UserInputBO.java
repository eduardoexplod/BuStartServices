package com.bustart.main.bo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.bustart.main.constants.ErrorConstant;
import com.bustart.main.constants.PatternConstant;

/**
 * @author Slam245
 *
 */
public class UserInputBO {

	/**
	 * 
	 */
	public UserInputBO() {
	}

	@NotNull(message = ErrorConstant.ERROR_VAL_USERNAME_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_USERNAME_REQUIRED)
	private String userName;
	
	@NotNull(message = ErrorConstant.ERROR_VAL_EMAIL_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_EMAIL_REQUIRED)
	@Email (message = ErrorConstant.ERROR_VAL_EMAIL_FORMAT_REQUIRED)
	private String email;
	
	@NotNull(message = ErrorConstant.ERROR_VAL_PASSWORD_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_PASSWORD_REQUIRED)
	@Pattern (regexp= PatternConstant.PATTERN_PASSWORD, message = ErrorConstant.ERROR_VAL_PASSWORD_FORMAT)
	private String password;
	
	@NotNull(message = ErrorConstant.ERROR_VAL_FIRST_NAME_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_FIRST_NAME_REQUIRED)
	private String firstName;

	@NotNull(message = ErrorConstant.ERROR_VAL_LAST_NAME_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_LAST_NAME_REQUIRED)
	private String lastName;
	
	private String secondLastName;
	
	@NotNull(message = ErrorConstant.ERROR_VAL_PHONE_NUMBER_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_PHONE_NUMBER_REQUIRED)
	private String phoneNumber;
	
	@NotNull(message = ErrorConstant.ERROR_VAL_HAS_WHATSAPP_REQUIRED)
	private boolean hasWhatsApp;
	
	private String creatorUserName;
		
	
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
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the creatorUserName
	 */
	public String getCreatorUserName() {
		return creatorUserName;
	}
	/**
	 * @param creatorUserName the creatorUserName to set
	 */
	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the secondLastName
	 */
	public String getSecondLastName() {
		return secondLastName;
	}
	/**
	 * @param secondLastName the secondLastName to set
	 */
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the hasWhatsApp
	 */
	public boolean isHasWhatsApp() {
		return hasWhatsApp;
	}
	/**
	 * @param hasWhatsApp the hasWhatsApp to set
	 */
	public void setHasWhatsApp(boolean hasWhatsApp) {
		this.hasWhatsApp = hasWhatsApp;
	}

	

}
