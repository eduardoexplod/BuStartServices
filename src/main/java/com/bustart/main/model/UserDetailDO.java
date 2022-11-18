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
@Table(name = "MM_USER_DETAIL")
public class UserDetailDO extends AuditBaseDO<Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8344863284896415021L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_USER_DETAIL_ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = (CascadeType.PERSIST))
	@JoinColumn(name = "FK_USER_ID")
	private UserDO userDO;
	
	@Column(name = "DS_FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "DS_LAST_NAME", nullable = false)
	private String lastName;
	
	@Column(name = "DS_SECOND_LAST_NAME", nullable = true)
	private String secondLastName;
	
	@Column(name = "DS_PHONE_NUMBER", nullable = false)
	private String phoneNumber;
	
	@Column(name = "DB_HAS_WHATSAPP", nullable = false)
	private boolean hasWhatsApp;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the secondLastName
	 */
	public String getSecondLastName() {
		return secondLastName;
	}

	/**
	 * @param secondLastName the secondLastName to set
	 */
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the hasWhatsApp
	 */
	public boolean isHasWhatsApp() {
		return hasWhatsApp;
	}

	/**
	 * @param hasWhatsApp the hasWhatsApp to set
	 */
	public void setHasWhatsApp(boolean hasWhatsApp) {
		this.hasWhatsApp = hasWhatsApp;
	}
		
}
