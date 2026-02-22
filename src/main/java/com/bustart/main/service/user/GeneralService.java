/**
 * 
 */
package com.bustart.main.service.user;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bustart.main.model.BusinessDO;
import com.bustart.main.model.UserDO;
import com.bustart.main.repository.BusinessRepository;
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
		logger.info("GeneralService - Get userDO: " + userName);
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
}
