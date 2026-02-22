package com.bustart.main.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Slam245
 *
 */
@Entity
@Table(name = "DD_USER_ROLE")
public class UserRoleDO extends AuditBaseDO<Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3091227373696978356L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_USER_ROLE_ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = (CascadeType.PERSIST))
	@JoinColumn(name = "FK_USER_ID")
	private UserDO userDO;

	@ManyToOne(fetch = FetchType.EAGER, cascade = (CascadeType.PERSIST))
	@JoinColumn(name = "FK_ROLE_ID")
	private RoleDO roleDO;

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
	 * @return the roleDO
	 */
	public RoleDO getRoleDO() {
		return roleDO;
	}

	/**
	 * @param roleDO the roleDO to set
	 */
	public void setRoleDO(RoleDO roleDO) {
		this.roleDO = roleDO;
	}
}
