package com.bustart.main.bo;

import java.util.Date;

/**
 * @author Slam245
 *
 */
public class BusinessOutputBO {

	/**
	 * Constructor
	 */
	public BusinessOutputBO() {
	}

	private Long businessId;
	private String business;
	private String businessDescription;
	private String userNameCreator;
	private Date creationDate;
	private String userNameLastModifier;
	private Date modificationDate; 
	private Boolean statusCode;
	/**
	 * @return the businessId
	 */
	public Long getBusinessId() {
		return businessId;
	}
	/**
	 * @param businessId the businessId to set
	 */
	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
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
	 * @return the userNameCreator
	 */
	public String getUserNameCreator() {
		return userNameCreator;
	}
	/**
	 * @param userNameCreator the userNameCreator to set
	 */
	public void setUserNameCreator(String userNameCreator) {
		this.userNameCreator = userNameCreator;
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
	 * @return the userNameLastModifier
	 */
	public String getUserNameLastModifier() {
		return userNameLastModifier;
	}
	/**
	 * @param userNameLastModifier the userNameLastModifier to set
	 */
	public void setUserNameLastModifier(String userNameLastModifier) {
		this.userNameLastModifier = userNameLastModifier;
	}
	/**
	 * @return the modificationDate
	 */
	public Date getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
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
}
	
