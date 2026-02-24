package com.bustart.main.service.customer;

import com.bustart.main.bo.BaseResponseBO;
import com.bustart.main.bo.BusinessJoinUserOutputBO;
import com.bustart.main.bo.BusinessUserInputBO;
import com.bustart.main.bo.CustomerInputBO;
import com.bustart.main.bo.CustomerOutputBO;
import com.bustart.main.bo.ResponseErrorBO;
import com.bustart.main.model.CustomerDO;
import com.bustart.main.repository.BusinessRepository;
import com.bustart.main.repository.CustomerRepository;
import com.bustart.main.repository.UserBusinessRepository;
import com.bustart.main.service.user.BusinessService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for handling customer-related business operations.
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

    /**
	 * Implement Logger
	 */
	Logger logger = Logger.getLogger(BusinessService.class.getName());

    /**
     * Creates a new customer in the system.
     * Validates if the phone number already exists to prevent duplicates.
     * * @param customerInputBO The business object containing customer information.
     * @return The persisted Customer entity.
     * @throws RuntimeException if the phone number is already registered.
     */
    @SuppressWarnings("rawtypes")
    @Transactional
    public ResponseEntity<BaseResponseBO> createCustomer(CustomerInputBO customerInputBO) {
		logger.info("CustomerService - Method createCustomer");
		BaseResponseBO<CustomerOutputBO> baseResponseBO = new BaseResponseBO<CustomerOutputBO>>();
		List<ResponseErrorBO> listErrors = new ArrayList<ResponseErrorBO>();

		logger.info("createCustomer - Search creator username ");

        
        // 1. Validate if customer already exists by phone number
        customerRepository.findByPhoneNumber(customerInputBO.getPhoneNumber())
            .ifPresent(c -> {
                // Here you can use a custom exception like BusinessException
                throw new RuntimeException("Customer with phone number " + customerInputBO.getPhoneNumber() + " already exists.");
            });

        // 2. Map BO to DO (Data Object / Entity)
        CustomerDO customerDO = new CustomerDO();
        customerDO.setFirstName(customerInputBO.getFirstName());
        customerDO.setLastName(customerInputBO.getLastName());
        customerDO.setSecondLastName(customerInputBO.getSecondLastName());
        customerDO.setAddress(customerInputBO.getAddress());
        customerDO.setPhoneNumber(customerInputBO.getPhoneNumber());
        customerDO.setEmail(customerInputBO.getEmail());
        customerDO.setHasWhatsapp(customerInputBO.getHasWhatsapp());

        // 3. Persist and return the response
        return customerRepository.save(customerDO);
    }
}