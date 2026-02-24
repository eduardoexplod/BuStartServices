package com.bustart.main.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

/**
 * @author Slam245
 *
 */
@Entity
@Table(name = "MM_CUSTOMER")
public class CustomerDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Unique identifier for the customer. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_CUSTOMER_ID")
    private Long id;

    /** Customer's first name. Mandatory field. */
    @NotBlank
    @Column(name = "DS_FIRST_NAME", nullable = false)
    private String firstName;

    /** Customer's primary surname. Mandatory field. */
    @NotBlank
    @Column(name = "DS_LAST_NAME", nullable = false)
    private String lastName;

    /** Customer's secondary surname. Optional field. */
    @Column(name = "DS_SECOND_LAST_NAME")
    private String secondLastName;

    /** Full physical address. Maximum length 500. Mandatory field. */
    @NotBlank
    @Column(name = "DS_ADDRESS", nullable = false)
    private String address;

    /** 10-digit numeric phone number. Mandatory field. */
    @NotBlank
    @Size(min = 10, max = 10)
    @Column(name = "DS_PHONE_NUMBER", nullable = false, length = 10)
    private String phoneNumber;

    /** Customer's electronic mail. Must be unique and follow email format. Optional. */
    @Email
	@Column(name = "DS_EMAIL", nullable = false, unique = true)
    private String email;

    /** Indicates if the customer uses WhatsApp. Mandatory field. */
    @NotNull
	@Column(name = "DB_HAS_WHATSAPP", nullable = false)
    private Boolean hasWhatsapp;

    // --- CONSTRUCTORS ---
    public CustomerDO() {
    }

    // --- GETTERS AND SETTERS ---

    /**
     * @return The unique ID of the customer.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id The unique ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * @return The customer's physical address.
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
     * @param phoneNumber The 10-digit numeric string to set.
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
     * @return True if the customer has WhatsApp, false otherwise.
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

}