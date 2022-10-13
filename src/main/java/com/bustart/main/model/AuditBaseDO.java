package com.bustart.main.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;


/**
 * The Class AuditBase.
 *
 */
public class AuditBaseDO<T extends Serializable> {

	/** The status code. */
	@Column(name = "DB_STATUS_CODE", nullable = true)
	private Boolean statusCode;

	/** The creator user name. */
	@Column(name = "FK_USER_ID_CREATOR",  nullable = true)
	protected UserDO creatorUserDO;

	/** The creation date. */
	@Column(name = "DD_CREATION_DATE",  nullable = true)
	protected Date creationDate;
	
	/** The last modified user name. */
	@Column(name = "FK_USER_ID_LAST_MODIFIER", nullable = true)
	protected String lastModifiedUserDO;

	/** The last modified date. */
	@Column(name = "DD_MODIFICATION_DATE", nullable = true)
	protected Date lastModifiedDate;

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
	 * @return the creatorUserDO
	 */
	public UserDO getCreatorUserDO() {
		return creatorUserDO;
	}

	/**
	 * @param creatorUserDO the creatorUserDO to set
	 */
	public void setCreatorUserDO(UserDO creatorUserDO) {
		this.creatorUserDO = creatorUserDO;
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
	 * @return the lastModifiedUserDO
	 */
	public String getLastModifiedUserDO() {
		return lastModifiedUserDO;
	}

	/**
	 * @param lastModifiedUserDO the lastModifiedUserDO to set
	 */
	public void setLastModifiedUserDO(String lastModifiedUserDO) {
		this.lastModifiedUserDO = lastModifiedUserDO;
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


}