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
import com.bustart.main.bo.SaleItemBO;
import com.bustart.main.bo.SaleOutputBO;
import com.bustart.main.constants.ErrorConstant;
import com.bustart.main.constants.NumberConstant;
import com.bustart.main.model.BusinessDO;
import com.bustart.main.model.CustomerDO;
import com.bustart.main.model.ProductDO;
import com.bustart.main.model.UserDO;
import com.bustart.main.repository.BusinessRepository;
import com.bustart.main.repository.CustomerRepository;
import com.bustart.main.repository.ProductRepository;
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

    @Autowired
    private GeneralService generalService;
    
    @Autowired
    private ProductRepository productRepository;

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
                "addSaleToCustomer: Validate input object- saleInputBO");
        listErrors = validateSaleInput(saleInputBO);

        if (null == listErrors || listErrors.isEmpty() ){
            listErrors = new ArrayList<ResponseErrorBO>();
            
        }
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
        listErrors = new ArrayList<ResponseErrorBO>();
        if (null != saleInputBO) {
            logger.info("validateSaleInput - Validate creator username ");
            UserDO userDOCreator = null;
            userDOCreator = generalService.getUserDO(saleInputBO.getUserNameCreator());
            if (null == userDOCreator) {
                logger.severe(
                        "validateSaleInput - The user that create, not exist in db: " + saleInputBO.getUserNameCreator());
                ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_5,
                        ErrorConstant.ERROR_KEY_USER_CREATOR_NOT_EXIST, ErrorConstant.MSG_KEY_USER_CREATOR_NOT_EXIST);
                listErrors.add(responseErrorBO);
            } 
            logger.info("validateSaleInput - Validate Business ");
            Optional<BusinessDO> optBusinessDO = null;
            optBusinessDO = businessRepository.findById(saleInputBO.getBusinessId());
            if (!optBusinessDO.isPresent()) {
                logger.severe("validateSaleInput - The business not exist: " + saleInputBO.getBusinessId());
                ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_4,
                        ErrorConstant.ERROR_KEY_BUSINESS_NOT_EXIST, ErrorConstant.MSG_KEY_BUSINESS_NOT_EXIST);
                listErrors.add(responseErrorBO);
            }
            logger.info("validateSaleInput - Validate Customer ");
            Optional<CustomerDO> optCustomerDO = null;
            optCustomerDO = customerRepository.findById(saleInputBO.getCustomerId());
            if (!optCustomerDO.isPresent()) {
                logger.severe("validateSaleInput - The customer not exist: " + saleInputBO.getCustomerId());
                ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_11,
                        ErrorConstant.ERROR_KEY_CUSTOMER_NOT_EXIST, ErrorConstant.MSG_KEY_CUSTOMER_NOT_EXIST);
                listErrors.add(responseErrorBO);
            } 
            List<ResponseErrorBO> listErrorsSalesItems = null;
            listErrorsSalesItems = validateSaleItems(saleInputBO.getSaleItems());
            listErrors.addAll(listErrorsSalesItems);
        } else {
            logger.severe("validateSaleInput - The object that you need validate is null: saleInputBO");
            ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_9,
                    ErrorConstant.ERROR_KEY_SALE_INPUT_BO_IS_NULL, ErrorConstant.MSG_KEY_SALE_INPUT_BO_IS_NULL);
            listErrors.add(responseErrorBO);
        }
        return listErrors;
    }
    /**
     * @author Slam245
     * @method validateSaleItems
     * @param List<SaleItemBO> listSaleItemsBO
     * @return List<ResponseErrorBO>
     *
     */
    public List<ResponseErrorBO> validateSaleItems(List<SaleItemBO> listSaleItemsBO) {
        logger.info("validateSaleItems - Start the process for validate sales items.");
        List<ResponseErrorBO> listErrorsSales = null;
        listErrorsSales = new ArrayList<ResponseErrorBO>();
        if (null == listSaleItemsBO || listSaleItemsBO.isEmpty()) {
            logger.severe("validateSaleItems - The object saleItemsBO is null or is empty: " + listSaleItemsBO);
            ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_10,
                    ErrorConstant.ERROR_KEY_SALE_ITEMS_IS_NULL_OR_EMPTY, ErrorConstant.MSG_KEY_SALE_ITEMS_IS_NULL_OR_EMPTY);
            listErrorsSales.add(responseErrorBO);
        } else{
            for (SaleItemBO  saleItemsBO : listSaleItemsBO) {
                logger.info("validateSaleItems - Validate product.");
                Optional<ProductDO> optProductDO = null;
                optProductDO = productRepository.findById(saleItemsBO.getProductId());
                if (!optProductDO.isPresent()) {
                    logger.severe("validateSaleItems - The product not exist: " + saleItemsBO.getProductId());
                    ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_12,
                    ErrorConstant.ERROR_KEY_PRODUCT_NOT_EXIST, ErrorConstant.MSG_KEY_PRODUCT_NOT_EXIST);
                    listErrorsSales.add(responseErrorBO);
                }
                logger.info("validateSaleItems - Validate quantity.");
                Integer quantity = null;
                quantity=saleItemsBO.getQuantity();
                if (null == quantity || quantity.equals(0)) {
                    logger.severe("validateSaleItems - The quantity cannot be null or 0: " + quantity);
                    ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_13,
                    ErrorConstant.ERROR_KEY_QUANTITY_IS_NULL_OR_ZERO, ErrorConstant.MSG_KEY_QUANTITY_IS_NULL_OR_ZERO);
                    listErrorsSales.add(responseErrorBO);
                }
            }
        }
        return listErrorsSales;
    }

}