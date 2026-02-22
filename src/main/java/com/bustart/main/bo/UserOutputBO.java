package com.bustart.main.bo;

import java.util.Date;
import java.util.List;

/**
 * @author Slam245
 *
 */
public class UserOutputBO {

	/**
	 * 
	 */
	public UserOutputBO() {
	}

	private Long userId;
	private String userName;
	private String email;
	private String firstName;
	private String lastName;
	private String secondLastName;
	private String phoneNumber;
	private boolean hasWhatsApp;
	private Date creationDate;
	private Date lastModifiedDate; 
	private Boolean statusCode;
	private List<String> roles;
	
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	/**
	 * @return the statusCode
	 */
	public Boolean getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Boolean statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
