package com.bustart.main.bo;

import java.io.Serializable;

/**
 * Business Object representing a single item within a sale transaction.
 * Contains product identification, quantity, and financial subtotal.
 * 
 * @author Slam245
 * @version 1.0
 */
public class SaleItemBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long productId;
    private Integer quantity;

    /**
     * Default constructor.
     */
    public SaleItemBO() {
    }

    // --- GETTERS AND SETTERS ---

    /**
     * @return The unique identifier of the product being sold.
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId The unique product identifier to set for this sale item.
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return The number of units sold for this specific product.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity The amount of items sold to be assigned to this line.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}