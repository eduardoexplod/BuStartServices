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

	@NotNull(message = ErrorConstant.ERROR_VALIDATION_USERNAME_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VALIDATION_USERNAME_REQUIRED)
	private String userName;
	
	@NotNull(message = ErrorConstant.ERROR_VALIDATION_EMAIL_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VALIDATION_EMAIL_REQUIRED)
	@Email (message = ErrorConstant.ERROR_VALIDATION_EMAIL_FORMAT_REQUIRED)
	private String email;
	
	@NotNull(message = ErrorConstant.ERROR_VALIDATION_PASSWORD_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VALIDATION_PASSWORD_REQUIRED)
	@Pattern (regexp= PatternConstant.PATTERN_PASSWORD, message = ErrorConstant.ERROR_VALIDATION_PASSWORD_FORMAT)
	private String password;
	
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
	
}
