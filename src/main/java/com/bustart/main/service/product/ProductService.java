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
import com.bustart.main.bo.ProductInputBO;
import com.bustart.main.bo.ProductOutputBO;
import com.bustart.main.bo.ResponseErrorBO;
import com.bustart.main.constants.ErrorConstant;
import com.bustart.main.constants.NumberConstant;
import com.bustart.main.model.ProductDO;
import com.bustart.main.model.UserDO;
import com.bustart.main.repository.ProductRepository;
import com.bustart.main.service.general.GeneralService;

/**
 * Service class for handling product-related business operations.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GeneralService generalService;

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
        logger.info(
                "addProduct: Search the product by name - " + productInputBO.getProduct());
        Optional<ProductDO> optProductDO = null;
        optProductDO = productRepository.findByProduct(productInputBO.getProduct());
        if (optProductDO.isPresent()) {
            logger.severe("addProduct - The product exist: " + optProductDO.get().getId());
            ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_8,
                    ErrorConstant.ERROR_KEY_PRODUCT_EXIST, ErrorConstant.MSG_KEY_PRODUCT_EXIST);
            listErrors.add(responseErrorBO);
        } else {
            logger.info("addProduct - Search creator username ");
			UserDO userDOCreator = null;
			userDOCreator = generalService.getUserDO(productInputBO.getUserNameCreator());
			if (null != userDOCreator) {
                // Map BO to DO (Data Object / Entity)
                logger.info("addProduct - Save the product in the DB ");
                ProductDO productDO = new ProductDO();
                productDO.setProduct(productInputBO.getProduct());
                productDO.setDescription(productInputBO.getDescription());
                productDO.setSellingPrice(productInputBO.getSellingPrice());
                productDO.setCategory(productInputBO.getCategory());
                productDO.setCreationDate(new Date());
                productDO.setCreatorUserDO(userDOCreator);
                productDO.setLastModifiedDate(null);
                productDO.setLastModifiedUserDO(null);
                productDO.setStatusCode(Boolean.TRUE);
                // Persist 
                productRepository.save(productDO);
                productRepository.flush();
                logger.info("productDO - New product created");
                ProductDO newProductDO = null;
                newProductDO = generalService.getProductDO(productInputBO.getProduct());
                productOutputBO = fillProductOutputBO(newProductDO);
            } else {
				logger.severe("addProduct - The user that create, not exist in db: "
						+ productInputBO.getUserNameCreator());
				ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_5,
						ErrorConstant.ERROR_KEY_USER_CREATOR_NOT_EXIST, ErrorConstant.MSG_KEY_USER_CREATOR_NOT_EXIST);
				listErrors.add(responseErrorBO);
			}
        }
        baseResponseBO.setData(listErrors.size() > 0 ? null : productOutputBO);
        baseResponseBO.setErrors(listErrors);
        baseResponseBO.setSuccess(listErrors.size() > 0 ? Boolean.FALSE : Boolean.TRUE);
        baseResponseBO.setTotalSize(listErrors.size() > 0 ? NumberConstant.NUMBER_0 : NumberConstant.NUMBER_1);
        logger.info("addProduct - Finish");
        return new ResponseEntity<>(baseResponseBO, HttpStatus.OK);
    }

    /**
     * @author Slam245
     * @method fillProductOutputBO
     * @param productDO ProductDO
     * @return ProductOutputBO
     *
     */
    private ProductOutputBO fillProductOutputBO(ProductDO productDO) {
        logger.info("ProductService - Method fillProductOutputBO");
        ProductOutputBO productOutputBO = null;
        if (null != productDO) {
            productOutputBO = new ProductOutputBO();
            productOutputBO.setId(productDO.getId());
            productOutputBO.setProduct(productDO.getProduct());
            productOutputBO.setDescription(productDO.getDescription());
            productOutputBO.setSellingPrice(productDO.getSellingPrice());
            productOutputBO.setCategory(productDO.getCategory());
            productOutputBO.setCreationDate(productDO.getCreationDate());
            if (null != productDO.getCreatorUserDO()) {
                productOutputBO.setUserNameCreator(productDO.getCreatorUserDO().getUserName());
            }
            productOutputBO.setLastModifiedDate(productDO.getLastModifiedDate());
            if (null != productDO.getLastModifiedUserDO()) {
                productOutputBO.setUserNameLastModifier(productDO.getLastModifiedUserDO().getUserName());
            }
            productOutputBO.setStatusCode(productDO.getStatusCode());
        }
        return productOutputBO;
    }
}