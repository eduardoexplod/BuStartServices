/**
 * 
 */
package com.bustart.main.service.general;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bustart.main.model.BusinessDO;
import com.bustart.main.model.CustomerDO;
import com.bustart.main.model.ProductDO;
import com.bustart.main.model.UserDO;
import com.bustart.main.repository.BusinessRepository;
import com.bustart.main.repository.CustomerRepository;
import com.bustart.main.repository.ProductRepository;
import com.bustart.main.repository.UserRepository;

/**
 * @author Slam245
 *
 */
@Service
@Transactional
public class GeneralService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
    private ProductRepository productRepository;
	
	/**
	 * Implement Logger
	 */
	Logger logger = Logger.getLogger(GeneralService.class.getName());

	/**
	 * @author Slam245
	 * @method getUserDO
	 * @param userName String
	 * @return UserDO
	 *
	 */
	public UserDO getUserDO(String userName) {
		logger.info("GeneralService - Get userName: " + userName);
		UserDO userDO = null;
		if (null != userName) {
			Optional<UserDO> optUserDO = null;
			optUserDO = userRepository.findByUserName(userName);
			logger.info(optUserDO.toString());
			if (optUserDO.isPresent()) {
				userDO = optUserDO.get();
				logger.info("getUserDO - userDO exist: " + userDO.getId());
			}
		}
		return userDO;
	}

	/**
	 * @author Slam245
	 * @method getBusinessDO
	 * @param business String
	 * @return BusinessDO
	 *
	 */
	public BusinessDO getBusinessDO(String business) {
		logger.info("GeneralService - Get businessDO: " + business);
		BusinessDO businessDO = null;
		if (null != business) {
			Optional<BusinessDO> optBusinessDO = null;
			optBusinessDO = businessRepository.findByBusiness(business);
			logger.info(optBusinessDO.toString());
			if (optBusinessDO.isPresent()) {
				businessDO = optBusinessDO.get();
				logger.info("getBusinessDO - businessDO exist: " + businessDO.getId());
			}
		}
		return businessDO;
	}

	/**
	 * @author Slam245
	 * @method getCustomerDO
	 * @param phoneNumber String
	 * @return CustomerDO
	 *
	 */
	public CustomerDO getCustomerDO(String phoneNumber) {
		logger.info("GeneralService - Get customerDO: " + phoneNumber);
		CustomerDO customerDO = null;
		if (null != phoneNumber) {
			Optional<CustomerDO> optCustomerDO = null;
			optCustomerDO = customerRepository.findByPhoneNumber(phoneNumber);
			logger.info(optCustomerDO.toString());
			if (optCustomerDO.isPresent()) {
				customerDO = optCustomerDO.get();
				logger.info("getCustomerDO - customerDO exist: " + customerDO.getId());
			}
		}
		return customerDO;
	}
	/**
	 * @author Slam245
	 * @method getProductDO
	 * @param product String
	 * @return ProductDO
	 *
	 */
	public ProductDO getProductDO(String product) {
		logger.info("GeneralService - Get productDO: " + product);
		ProductDO productDO = null;
		if (null != product) {
			Optional<ProductDO> optProductDO = null;
			optProductDO = productRepository.findByProduct(product);
			logger.info(optProductDO.toString());
			if (optProductDO.isPresent()) {
				productDO = optProductDO.get();
				logger.info("getProductDO - productDO exist: " + productDO.getId());
			}
		}
		return productDO;
	}
}
