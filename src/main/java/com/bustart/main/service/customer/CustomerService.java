package com.bustart.main.service.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bustart.main.bo.BaseResponseBO;
import com.bustart.main.bo.CustomerInputBO;
import com.bustart.main.bo.CustomerOutputBO;
import com.bustart.main.bo.ResponseErrorBO;
import com.bustart.main.constants.ErrorConstant;
import com.bustart.main.constants.NumberConstant;
import com.bustart.main.model.CustomerDO;
import com.bustart.main.model.UserDO;
import com.bustart.main.repository.CustomerRepository;
import com.bustart.main.service.business.BusinessService;
import com.bustart.main.service.general.GeneralService;

/**
 * Service class for handling customer-related business operations.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private GeneralService generalService;

    /**
     * Implement Logger
     */
    Logger logger = Logger.getLogger(BusinessService.class.getName());

    /**
     * Creates a new customer in the system.
     * Validates if the phone number already exists to prevent duplicates.
     * * @param customerInputBO The business object containing customer information.
     * 
     * @return The persisted Customer entity.
     * @throws RuntimeException if the phone number is already registered.
     */
    @SuppressWarnings("rawtypes")
    @Transactional
    public ResponseEntity<BaseResponseBO> createCustomer(CustomerInputBO customerInputBO) {
        logger.info("CustomerService - Method createCustomer");
        BaseResponseBO<CustomerOutputBO> baseResponseBO = new BaseResponseBO<CustomerOutputBO>();
        List<ResponseErrorBO> listErrors = new ArrayList<ResponseErrorBO>();
        CustomerOutputBO customerOutputBO = null;
        logger.info(
                "createCustomer: Search the customer by phoneNumber - " + customerInputBO.getPhoneNumber());
        Optional<CustomerDO> optCustomerDO = null;
        optCustomerDO = customerRepository.findByPhoneNumber(customerInputBO.getPhoneNumber());
        if (optCustomerDO.isPresent()) {
            logger.severe("createCustomer - The customer exist: " + optCustomerDO.get().getId());
            ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_1,
                    ErrorConstant.ERROR_KEY_CUSTOMER_EXIST, ErrorConstant.MSG_KEY_CUSTOMER_EXIST);
            listErrors.add(responseErrorBO);
        } else {
            logger.info("createCustomer - Search creator username ");
			UserDO userDOCreator = null;
			userDOCreator = generalService.getUserDO(customerInputBO.getUserNameCreator());
            logger.info("createCustomer - llegue");
			if (null != userDOCreator) {
                // Map BO to DO (Data Object / Entity)
                logger.info("createCustomer - Save the customer in the DB ");
                CustomerDO customerDO = new CustomerDO();
                customerDO.setFirstName(customerInputBO.getFirstName());
                customerDO.setLastName(customerInputBO.getLastName());
                customerDO.setSecondLastName(customerInputBO.getSecondLastName());
                customerDO.setAddress(customerInputBO.getAddress());
                customerDO.setPhoneNumber(customerInputBO.getPhoneNumber());
                customerDO.setEmail(customerInputBO.getEmail());
                customerDO.setHasWhatsapp(customerInputBO.getHasWhatsapp());
                customerDO.setCreationDate(new Date());
                customerDO.setCreatorUserDO(userDOCreator);
                customerDO.setLastModifiedDate(null);
                customerDO.setLastModifiedUserDO(null);
                customerDO.setStatusCode(Boolean.TRUE);
                // Persist 
                customerRepository.save(customerDO);
                customerRepository.flush();
                logger.info("createCustomer - New customer created");
                CustomerDO newCustomerDO = null;
                newCustomerDO = generalService.getCustomerDO(customerInputBO.getPhoneNumber());
                customerOutputBO = fillCustomerOutputBO(newCustomerDO);
			} else {
				logger.severe("createCustomer - The user that create, not exist in db: "
						+ customerInputBO.getUserNameCreator());
				ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_5,
						ErrorConstant.ERROR_KEY_USER_CREATOR_NOT_EXIST, ErrorConstant.MSG_KEY_USER_CREATOR_NOT_EXIST);
				listErrors.add(responseErrorBO);
			}
        }
        baseResponseBO.setData(listErrors.size() > 0 ? null : customerOutputBO);
        baseResponseBO.setErrors(listErrors);
        baseResponseBO.setSuccess(listErrors.size() > 0 ? Boolean.FALSE : Boolean.TRUE);
        baseResponseBO.setTotalSize(listErrors.size() > 0 ? NumberConstant.NUMBER_0 : NumberConstant.NUMBER_1);
        logger.info("createCustomer - Finish");
        return new ResponseEntity<>(baseResponseBO, HttpStatus.OK);
    }

    /**
     * @author Slam245
     * @method fillCustomerOutputBO
     * @param customerDO CustomerDO
     * @return CustomerOutputBO
     *
     */
    private CustomerOutputBO fillCustomerOutputBO(CustomerDO customerDO) {
        logger.info("CustomerrService - Method fillCustomerOutputBO");
        CustomerOutputBO customerOutputBO = null;
        if (null != customerDO) {
            customerOutputBO = new CustomerOutputBO();
            customerOutputBO.setId(customerDO.getId());
            customerOutputBO.setFirstName(customerDO.getFirstName());
            customerOutputBO.setLastName(customerDO.getLastName());
            customerOutputBO.setSecondLastName(customerDO.getSecondLastName());
            customerOutputBO.setAddress(customerDO.getAddress());
            customerOutputBO.setPhoneNumber(customerDO.getPhoneNumber());
            customerOutputBO.setEmail(customerDO.getEmail());
            customerOutputBO.setHasWhatsapp(customerDO.getHasWhatsapp());
            customerOutputBO.setCreationDate(customerDO.getCreationDate());
            if (null != customerDO.getCreatorUserDO()) {
                customerOutputBO.setUserNameCreator(customerDO.getCreatorUserDO().getUserName());
            }
            customerOutputBO.setLastModifiedDate(customerDO.getLastModifiedDate());
            if (null != customerDO.getLastModifiedUserDO()) {
                customerOutputBO.setUserNameLastModifier(customerDO.getLastModifiedUserDO().getUserName());
            }
            customerOutputBO.setStatusCode(customerDO.getStatusCode());
        }
        return customerOutputBO;
    }
}