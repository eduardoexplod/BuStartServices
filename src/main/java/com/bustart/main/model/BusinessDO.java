package com.bustart.main.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Slam245
 *
 */
@Entity
@Table(name = "CS_BUSINESS")
public class BusinessDO extends AuditBaseDO<Long> implements Serializable{

	private static final long serialVersionUID = -7141690668005974154L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_BUSINESS_ID")
	private Long id;

	@Column(name = "DS_BUSINESS", nullable = false)
	private String business;

	@Column(name = "DS_DESCRIPTION", nullable = false)
	private String description;
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


}
