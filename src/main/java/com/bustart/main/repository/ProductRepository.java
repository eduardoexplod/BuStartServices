package com.bustart.main.repository;

import com.bustart.main.model.ProductDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for {@link ProductDO} entity.
 * Provides abstraction for database operations on the 'MM_PRODUCT' table.
 * 
 * @author Slam245
 * @version 1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductDO, Long> {

    /**
     * Retrieves a product by its unique system identifier.
     * Note: This method is inherited from JpaRepository, but explicitly 
     * documented here for clarity in your business logic.
     * 
     * * @param id The unique ID of the product.
     * @return An Optional containing the product if found, or empty if not.
     */
    @SuppressWarnings("null")
    Optional<ProductDO> findById(Long id);

    /**
     * Finds a product by its exact name (product field).
     * This is useful for validation or specific product searches.
     * * @param product The name of the product to search for.
     * @return An Optional containing the product if a match exists.
     */
    Optional<ProductDO> findByProduct(String product);
    
}