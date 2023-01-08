package com.bustart.main.bo;

/**
 * @author Slam245
 *
 */
public class BusinessJoinUserOutputBO {

	/**
	 * Constructor
	 */
	public BusinessJoinUserOutputBO() {
	}

	private Long businessId;
	private Boolean status;
	private String message;
	
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
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
	
