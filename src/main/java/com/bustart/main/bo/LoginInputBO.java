package com.bustart.main.bo;

public class LoginInputBO {
	/**
	 * 
	 */
	public LoginInputBO() {
	}

	private String userName;
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
