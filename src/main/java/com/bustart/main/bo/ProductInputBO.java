package com.bustart.main.bo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.bustart.main.constants.ErrorConstant;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Business Object representing the input data for product creation and processing.
 * This class holds the core details required to register a product in the system.
 * 
 * @author Slam245
 * @version 1.0
 */
public class ProductInputBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String product;
    private String description;
    private BigDecimal sellingPrice;
    private String category;
    @NotNull(message = ErrorConstant.ERROR_VAL_USERNAME_CREATOR_REQUIRED)
	@NotEmpty(message = ErrorConstant.ERROR_VAL_USERNAME_CREATOR_REQUIRED)
	private String userNameCreator;

    /**
     * Default constructor.
     */
    public ProductInputBO() {
    }

    // --- GETTERS AND SETTERS ---

    /**
     * @return The name or title of the product.
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product The product name to set.
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @return A detailed description of the product's features.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The product description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The price at which the product is sold to customers.
     */
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice The public sale price to set.
     */
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * @return The category classification of the product.
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category The category name to set.
     */
    public void setCategory(String category) {
        this.category = category;
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
