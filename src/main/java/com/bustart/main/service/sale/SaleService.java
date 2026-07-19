package com.bustart.main.service.sale;

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
import com.bustart.main.bo.SaleInputBO;
import com.bustart.main.bo.SaleOutputBO;
import com.bustart.main.constants.ErrorConstant;
import com.bustart.main.constants.NumberConstant;
import com.bustart.main.model.BusinessDO;
import com.bustart.main.model.CustomerDO;
import com.bustart.main.model.ProductDO;
import com.bustart.main.model.UserDO;
import com.bustart.main.repository.BusinessRepository;
import com.bustart.main.repository.CustomerRepository;
import com.bustart.main.service.business.BusinessService;
import com.bustart.main.service.general.GeneralService;

/**
 * Service class for handling sales-related business operations.
 */
@Service
public class SaleService {

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Implement Logger
     */
    Logger logger = Logger.getLogger(SaleService.class.getName());

    /**
     * Add new sales to the customer
     * 
	 * @author Slam245
	 * @method addSaleToCustomer
	 * @param saleInputBO SalesInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 *
	 */
    @SuppressWarnings("rawtypes")
    @Transactional
    public ResponseEntity<BaseResponseBO> addSaleToCustomer(SaleInputBO saleInputBO) {
        logger.info("SaleService - Method addSaleToCustomer");
        BaseResponseBO<SaleOutputBO> baseResponseBO = new BaseResponseBO<SaleOutputBO>();
        List<ResponseErrorBO> listErrors = new ArrayList<ResponseErrorBO>();
        SaleOutputBO saleOutputBO = null;
        logger.info(
                "addSaleToCustomer: Validate input object- " + saleInputBO.toString());


       
        baseResponseBO.setData(listErrors.size() > 0 ? null : saleOutputBO);
        baseResponseBO.setErrors(listErrors);
        baseResponseBO.setSuccess(listErrors.size() > 0 ? Boolean.FALSE : Boolean.TRUE);
        baseResponseBO.setTotalSize(listErrors.size() > 0 ? NumberConstant.NUMBER_0 : NumberConstant.NUMBER_1);
        logger.info("addSaleToCustomer - Finish");
        return new ResponseEntity<>(baseResponseBO, HttpStatus.OK);
    }

    /**
	 * @author Slam245
	 * @method validateSaleInput
	 * @param saleInputBO SaleInputBO
	 * @return List<ResponseErrorBO>
	 *
	 */
	public List<ResponseErrorBO> validateSaleInput(SaleInputBO saleInputBO) {
		logger.info("validateSaleInput - Start the process of input validation.");
        List<ResponseErrorBO> listErrors = null;
		if (null != saleInputBO) {
            listErrors = new ArrayList<ResponseErrorBO>();
            Optional<BusinessDO> optBusinessDO = null;
            optBusinessDO = businessRepository.findById(saleInputBO.getBusinessId());
            if (optBusinessDO.isPresent()) {
                Optional<CustomerDO> optCustomerDO = null;
                optCustomerDO = customerRepository.findById(saleInputBO.getCustomerId());
                if (optCustomerDO.isPresent()) {

                } else {
                    logger.severe("addCustomer - The customer exist: " + optCustomerDO.get().getId());
                    ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_7,
                            ErrorConstant.ERROR_KEY_CUSTOMER_EXIST, ErrorConstant.MSG_KEY_CUSTOMER_EXIST);
                    listErrors.add(responseErrorBO);
                }
            } else {
                logger.severe("validateSaleInput - The business not exist: " + saleInputBO.getBusinessId());
                ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_4,
                        ErrorConstant.ERROR_KEY_BUSINESS_NOT_EXIST, ErrorConstant.MSG_KEY_BUSINESS_NOT_EXIST);
                listErrors.add(responseErrorBO);
            }
		}
		return listErrors;
	}

}