package com.bustart.main.repository;
import com.bustart.main.model.CustomerDO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDO, Long> {
/**
     * Finds a customer by their phone number.
     * @param phoneNumber The 10-digit phone number.
     * @return An Optional containing the customer if found.
     */
    Optional<CustomerDO> findByPhoneNumber(String phoneNumber);
}