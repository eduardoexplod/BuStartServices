package com.bustart.main.bo;

import java.util.Date;

/**
 * @author Slam245
 *
 */
public class BusinessBO {

	/**
	 * 
	 */
	public BusinessBO() {
	}

	private Long idBusiness;
	private String business;
	private Date dateOfCreation;
	private String userCreated;
	/**
	 * @return the idBusiness
	 */
	public Long getIdBusiness() {
		return idBusiness;
	}
	/**
	 * @param idBusiness the idBusiness to set
	 */
	public void setIdBusiness(Long idBusiness) {
		this.idBusiness = idBusiness;
	}
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
	 * @return the dateOfCreation
	 */
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	/**
	 * @param dateOfCreation the dateOfCreation to set
	 */
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	/**
	 * @return the userCreated
	 */
	public String getUserCreated() {
		return userCreated;
	}
	/**
	 * @param userCreated the userCreated to set
	 */
	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}
	
	
}
