package com.bustart.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Slam245
 *
 */
@Entity
@Table(name = "MM_USER")
public class UserDO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_USER_ID")
	private Long id;

	@Column(name = "DS_USER")
	private String userName;

	@Column(name = "DS_PASSWORD")
	private String password;
	
	@Column(name = "DS_EMAIL")
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DD_USER_ROLE", joinColumns = @JoinColumn(name = "FK_USER_ID", referencedColumnName = "PK_USER_ID")
	, inverseJoinColumns = @JoinColumn(name = "FK_ROLE_ID", referencedColumnName = "PK_ROLE_ID"))
	private List<RoleDO> roles;
	
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the roles
	 */
	public List<RoleDO> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<RoleDO> roles) {
		this.roles = roles;
	}

	

}
