package com.bustart.main.bo;

import java.io.Serializable;

import com.bustart.main.constants.ErrorConstant;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Business Object representing the customer data for business logic processing.
 * This class is used as a data transfer container for the customer creation service.
 */
public class CustomerInputBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String secondLastName;
    private String address;
    private String phoneNumber;
    private String email;
    private Boolean hasWhatsapp;
    @NotNull(message = ErrorConstant.ERROR_VAL_USERNAME_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_USERNAME_REQUIRED)
	private String userNameCreator;

    /**
     * Default constructor.
     */
    public CustomerInputBO() {
    }

    // --- GETTERS AND SETTERS ---

    /**
     * @return The customer's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return The customer's primary surname.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName The primary surname to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return The customer's secondary surname.
     */
    public String getSecondLastName() {
        return secondLastName;
    }

    /**
     * @param secondLastName The secondary surname to set.
     */
    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    /**
     * @return The customer's full address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address The address string to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return The 10-digit phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber The 10-digit numeric phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return The customer's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The WhatsApp availability status.
     */
    public Boolean getHasWhatsapp() {
        return hasWhatsapp;
    }

    /**
     * @param hasWhatsapp The WhatsApp status to set.
     */
    public void setHasWhatsapp(Boolean hasWhatsapp) {
        this.hasWhatsapp = hasWhatsapp;
    }
    /**
	 * @return the userNameCreator
	 */
	public String getUserNameCreator() {
		return userNameCreator;
	}
	/**
	 * @param userNameCreator the userNameCreator to set
	 */
	public void setUserNameCreator(String userNameCreator) {
		this.userNameCreator = userNameCreator;
	}
}