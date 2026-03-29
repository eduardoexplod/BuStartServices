package com.bustart.main.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Business Object used to return product information to external clients.
 * It includes all product details along with its unique system identifier.
 * @version 1.0
 */
public class ProductOutputBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String product;
    private String description;
    private BigDecimal purchasePrice;
    private BigDecimal sellingPrice;
    private String category;
    private String userNameCreator;
	private Date creationDate;
	private String userNameLastModifier;
	private Date lastModifiedDate; 
	private Boolean statusCode;

    /**
     * Default constructor.
     */
    public ProductOutputBO() {
    }

    // --- GETTERS AND SETTERS ---

    /**
     * @return The unique system identifier for the product.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id The unique identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return The name of the product.
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
     * @return The product's detailed description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The cost price of the product.
     */
    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * @param purchasePrice The acquisition cost to set.
     */
    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * @return The public selling price.
     */
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice The sales price to set.
     */
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * @return The category the product belongs to.
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
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the userNameLastModifier
	 */
	public String getUserNameLastModifier() {
		return userNameLastModifier;
	}
	/**
	 * @param userNameLastModifier the userNameLastModifier to set
	 */
	public void setUserNameLastModifier(String userNameLastModifier) {
		this.userNameLastModifier = userNameLastModifier;
	}
	/**
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	/**
	 * @return the statusCode
	 */
	public Boolean getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Boolean statusCode) {
		this.statusCode = statusCode;
	}
}