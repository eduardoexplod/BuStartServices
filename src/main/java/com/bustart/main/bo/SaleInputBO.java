package com.bustart.main.bo;

import java.io.Serializable;
import java.util.List;

import com.bustart.main.constants.ErrorConstant;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Business Object representing the input data for a new sale transaction.
 * Consists of header information (business, customer, user) and a list of products.
 * 
 * @author Slam245
 * @version 1.0
 */
public class SaleInputBO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = ErrorConstant.ERROR_VAL_BUSINESS_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_BUSINESS_REQUIRED)	
    private Long businessId;

    @NotNull(message = ErrorConstant.ERROR_VAL_CUSTOMER_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_CUSTOMER_REQUIRED)	
    private Long customerId;

    @NotNull(message = ErrorConstant.ERROR_VAL_SALE_ITEMS_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_SALE_ITEMS_REQUIRED)	
    private List<SaleItemBO> saleItems;

	@NotNull(message = ErrorConstant.ERROR_VAL_USERNAME_CREATOR_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_USERNAME_CREATOR_REQUIRED)
	private String userNameCreator;

    /**
     * Default constructor.
     */
    public SaleInputBO() {
    }

    // --- GETTERS AND SETTERS ---

    /**
     * @return The unique identifier of the business or branch.
     */
    public Long getBusinessId() {
        return businessId;
    }

    /**
     * @param businessId The business ID to set.
     */
    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    /**
     * @return The unique identifier of the customer making the purchase.
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return The list of individual products and quantities in this sale.
     */
    public List<SaleItemBO> getSaleItems() {
        return saleItems;
    }

    /**
     * @param items The list of sale items to set.
     */
    public void setSaleItems(List<SaleItemBO> saleItems) {
        this.saleItems = saleItems;
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