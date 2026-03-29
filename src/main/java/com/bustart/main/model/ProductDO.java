package com.bustart.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Entity representing a Product within the system.
 * Maps to the 'MM_PRODUCT' table in the MariaDB database.
 * 
 * @author Slam245
 * @version 1.0
 */
@Entity
@Table(name = "MM_PRODUCT")
public class ProductDO extends AuditBaseDO<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Unique identifier for the product. Managed by the database. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PRODUCT_ID")
    private Long id;

    /** Name of the product. Mandatory field. */
    @NotBlank
    @Column(name = "DS_PRODUCT", nullable = false)
    private String product;

    /** Detailed description of the product. */
    @NotBlank
    @Column(name = "DS_DESCRIPTION", length = 1000)
    private String description;

    /** Public sale price of the product. Mandatory field. */
    @NotNull
    @Column(name = "DN_SELLING_PRICE", nullable = false, precision = 12, scale = 2)
    private BigDecimal sellingPrice;

    /** Category classification. Mandatory field. */
    @NotBlank
    @Column(name = "DS_CATEGORY", nullable = false)
    private String category;

    // --- CONSTRUCTORS ---

    /**
     * Default constructor required by JPA.
     */
    public ProductDO() {
    }

    // --- GETTERS AND SETTERS ---

    /**
     * @return The unique product ID.
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
     * @return The product's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The detailed description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The sales price.
     */
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice The selling price to set.
     */
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * @return The product category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category The classification category to set.
     */
    public void setCategory(String category) {
        this.category = category;
    }
}