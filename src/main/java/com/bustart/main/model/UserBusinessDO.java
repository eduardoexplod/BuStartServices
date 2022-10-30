package com.bustart.main.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Slam245
 *
 */
@Entity
@Table(name = "DD_USER_BUSINESS")
public class UserBusinessDO extends AuditBaseDO<Long> implements Serializable{

	private static final long serialVersionUID = -999549459288549775L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_USER_BUSINESS_ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = (CascadeType.PERSIST))
	@JoinColumn(name = "FK_USER_ID")
	private UserDO userDO;

	@ManyToOne(fetch = FetchType.EAGER, cascade = (CascadeType.PERSIST))
	@JoinColumn(name = "FK_BUSINESS_ID")
	private BusinessDO businessDO;

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
	 * @return the userDO
	 */
	public UserDO getUserDO() {
		return userDO;
	}

	/**
	 * @param userDO the userDO to set
	 */
	public void setUserDO(UserDO userDO) {
		this.userDO = userDO;
	}

	/**
	 * @return the businessDO
	 */
	public BusinessDO getBusinessDO() {
		return businessDO;
	}

	/**
	 * @param businessDO the businessDO to set
	 */
	public void setBusinessDO(BusinessDO businessDO) {
		this.businessDO = businessDO;
	}

	
}
