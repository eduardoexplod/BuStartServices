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
@Table(name = "MM_USER")
public class UserDO extends AuditBaseDO<Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8344863284896415021L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_USER_ID")
	private Long id;

	@Column(name = "DS_USER", nullable = false)
	private String userName;

	@Column(name = "DS_PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "DS_EMAIL", nullable = false)
	private String email;
	
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
}
