package com.bustart.main.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Business Object used to return the results of a processed sale.
 * Contains transaction metadata, including sale date and final balances.
 * * @author Gemini AI
 * @version 1.1
 */
public class SaleOutputBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long businessId;
    private Long customerId;
    private String createdBy;
    private LocalDateTime saleDate;
    private BigDecimal totalAmount;
    private BigDecimal balance;

    /**
     * Default constructor.
     */
    public SaleOutputBO() {
    }

    // --- GETTERS AND SETTERS ---

    /**
     * @return The unique identifier of the sale record.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id The unique sale identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return The unique identifier of the business where the sale occurred.
     */
    public Long getBusinessId() {
        return businessId;
    }

    /**
     * @param businessId The business identifier to set.
     */
    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    /**
     * @return The unique identifier of the customer who made the purchase.
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId The customer identifier to set.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return The username or system ID of the creator.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy The user identifier to set for the sale record.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return The specific date and time when the sale took place.
     */
    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    /**
     * @param saleDate The timestamp to set for the actual sale occurrence.
     */
    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    /**
     * @return The total monetary value of the sale.
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount The total sale amount to set.
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return The remaining balance or outstanding amount of the sale.
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * @param balance The current balance to set for the sale.
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}