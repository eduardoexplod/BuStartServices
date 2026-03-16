package com.bustart.main.bo;

import com.bustart.main.constants.ErrorConstant;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LoginInputBO {
	/**
	 * 
	 */
	public LoginInputBO() {
	}

	@NotNull(message = ErrorConstant.ERROR_VAL_USERNAME_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_USERNAME_REQUIRED)
	private String userName;
	@NotNull(message = ErrorConstant.ERROR_VAL_PASSWORD_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_PASSWORD_REQUIRED)
	private String password;
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the username to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
}
