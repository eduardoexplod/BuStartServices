package com.bustart.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String roleName;

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
	 * @return the role
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String roleName) {
		this.roleName = roleName;
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
