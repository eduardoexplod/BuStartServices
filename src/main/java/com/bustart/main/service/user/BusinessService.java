/**
 * 
 */
package com.bustart.main.service.user;

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
import com.bustart.main.bo.BusinessInputBO;
import com.bustart.main.bo.BusinessOutputBO;
import com.bustart.main.bo.ResponseErrorBO;
import com.bustart.main.constants.ErrorConstant;
import com.bustart.main.constants.NumberConstant;
import com.bustart.main.model.BusinessDO;
import com.bustart.main.model.UserDO;
import com.bustart.main.repository.BusinessRepository;

/**
 * @author Slam245
 *
 */
@Service
@Transactional
public class BusinessService {

	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private GeneralService generalService;

	/**
	 * Implement Logger
	 */
	Logger logger = Logger.getLogger(BusinessService.class.getName());

	/**
	 * @author Slam245
	 * @method createUser
	 * @param userInputBO UserInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 *
	 */
	@SuppressWarnings("rawtypes")
	@Transactional
	public ResponseEntity<BaseResponseBO> createBusiness(BusinessInputBO businessInputBO) {
		logger.info("BusinessService - Method createBusiness");
		BaseResponseBO<BusinessOutputBO> baseResponseBO = new BaseResponseBO<BusinessOutputBO>();
		List<ResponseErrorBO> listErrors = new ArrayList<ResponseErrorBO>();
		BusinessOutputBO businessOutputBO = null;

		logger.info(
				"createBusiness: Search the business in DB - " + businessInputBO.getBusiness());
		Optional<BusinessDO> optBusinessDO = null;
		optBusinessDO = businessRepository.findByBusiness(businessInputBO.getBusiness());
		if (optBusinessDO.isPresent()) {
			logger.severe("createBusiness - The business exist: " + optBusinessDO.get().getId());
			ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_3,
					ErrorConstant.ERROR_KEY_BUSINESS_EXIST, ErrorConstant.MSG_KEY_BUSINESS_EXIST);
			listErrors.add(responseErrorBO);
		} else {
			logger.info("createBusiness - Search creator username ");
			UserDO userDOCreator = null;
			userDOCreator = generalService.getUserDO(businessInputBO.getUserName());
			if(null != userDOCreator) {
				logger.info("createBusiness - Create new business");
				BusinessDO businessDO = new BusinessDO();
				businessDO.setBusiness(businessInputBO.getBusiness());
				businessDO.setDescription(businessInputBO.getBusinessDescription());
				businessDO.setCreationDate(new Date());
				businessDO.setCreatorUserDO(userDOCreator);
				businessDO.setLastModifiedDate(null);
				businessDO.setLastModifiedUserDO(null);
				businessDO.setStatusCode(Boolean.TRUE);
				businessRepository.save(businessDO);
				businessRepository.flush();
				logger.info("createBusiness - New business created");
				
				BusinessDO newBusinessDO = null;
				newBusinessDO = generalService.getBusinessDO(businessInputBO.getBusiness());
				if (null != newBusinessDO) {
					businessOutputBO = fillBusinessOutputBO(newBusinessDO);
				} else {
					logger.severe("createBusiness - The business not exist");
					ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_4,
							ErrorConstant.ERROR_KEY_BUSINESS_NOT_EXIST, ErrorConstant.MSG_KEY_BUSINESS_NOT_EXIST);
					listErrors.add(responseErrorBO);
				}
			}else {
				logger.severe("createBusiness - The usernaname not exist in db: " + businessInputBO.getUserName());
				ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_2,
						ErrorConstant.ERROR_KEY_USER_NOT_EXIST, ErrorConstant.MSG_KEY_USER_NOT_EXIST);
				listErrors.add(responseErrorBO);
			}
		}
		
		baseResponseBO.setData(listErrors.size() > 0 ? null : businessOutputBO);
		baseResponseBO.setErrors(listErrors);
		baseResponseBO.setSuccess(listErrors.size() > 0 ? Boolean.FALSE : Boolean.TRUE);
		baseResponseBO.setTotalSize(listErrors.size() > 0 ? NumberConstant.NUMBER_0 : NumberConstant.NUMBER_1);
		logger.info("createUser - Finish");
		return new ResponseEntity<>(baseResponseBO, HttpStatus.OK);
	}

	/**
	 * @author Slam245
	 * @method fillBusinessOutputBO
	 * @param businessDO BusinessDO
	 * @return BusinessOutputBO
	 *
	 */
	private BusinessOutputBO fillBusinessOutputBO(BusinessDO businessDO) {
		logger.info("UserService - Method fillBusinessOutputBO");
		BusinessOutputBO businessOutputBO = null;
		if(null != businessDO) {
			businessOutputBO = new BusinessOutputBO();
			businessOutputBO.setBusinessId(businessDO.getId());
			businessOutputBO.setBusiness(businessDO.getBusiness());
			businessOutputBO.setBusinessDescription(businessDO.getDescription());
			businessOutputBO.setCreationDate(businessDO.getCreationDate());
			if(null != businessDO.getCreatorUserDO()) {
				businessOutputBO.setUserNameCreator(businessDO.getCreatorUserDO().getUserName());
			}
			businessOutputBO.setModificationDate(businessDO.getLastModifiedDate());
			if(null != businessDO.getLastModifiedUserDO()) {
				businessOutputBO.setUserNameLastModifier(businessDO.getLastModifiedUserDO().getUserName());
			}
			businessOutputBO.setStatusCode(businessDO.getStatusCode());
		}
		return businessOutputBO;
	}
	
}
