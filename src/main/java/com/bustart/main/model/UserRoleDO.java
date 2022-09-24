package com.bustart.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "DD_USER_ROLE")
public class UserRoleDO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_USER_ROLE_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "FK_USER_ID")
	private UserDO userDO;

	@ManyToOne
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
