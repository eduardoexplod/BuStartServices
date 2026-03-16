package com.bustart.main.service.product;

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
import com.bustart.main.bo.ProductInputBO;
import com.bustart.main.bo.ProductOutputBO;
import com.bustart.main.bo.ResponseErrorBO;
import com.bustart.main.bo.SaleInputBO;
import com.bustart.main.constants.ErrorConstant;
import com.bustart.main.constants.NumberConstant;
import com.bustart.main.model.CustomerDO;
import com.bustart.main.model.UserDO;
import com.bustart.main.repository.CustomerRepository;

import com.bustart.main.service.general.GeneralService;

/**
 * Service class for handling product-related business operations.
 */
@Service
public class ProductService {

    /**
     * Implement Logger
     */
    Logger logger = Logger.getLogger(ProductService.class.getName());

    /**
     * Add new product in the business
     * 
	 * @author Slam245
	 * @method addProduct
	 * @param productInputBO ProductInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 *
	 */
    @SuppressWarnings("rawtypes")
    @Transactional
    public ResponseEntity<BaseResponseBO> addProduct(ProductInputBO productInputBO) {
        logger.info("ProductService - Method addProduct");
        BaseResponseBO<ProductOutputBO> baseResponseBO = new BaseResponseBO<ProductOutputBO>();
        List<ResponseErrorBO> listErrors = new ArrayList<ResponseErrorBO>();
        ProductOutputBO productOutputBO = null;

       
        baseResponseBO.setData(listErrors.size() > 0 ? null : productOutputBO);
        baseResponseBO.setErrors(listErrors);
        baseResponseBO.setSuccess(listErrors.size() > 0 ? Boolean.FALSE : Boolean.TRUE);
        baseResponseBO.setTotalSize(listErrors.size() > 0 ? NumberConstant.NUMBER_0 : NumberConstant.NUMBER_1);
        logger.info("addProduct - Finish");
        return new ResponseEntity<>(baseResponseBO, HttpStatus.OK);
    }

}