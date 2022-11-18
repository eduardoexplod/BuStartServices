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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bustart.main.bo.BaseResponseBO;
import com.bustart.main.bo.BusinessBO;
import com.bustart.main.bo.ResponseErrorBO;
import com.bustart.main.bo.UserInputBO;
import com.bustart.main.bo.UserOutputBO;
import com.bustart.main.constants.ErrorConstant;
import com.bustart.main.constants.GeneralConstant;
import com.bustart.main.constants.NumberConstant;
import com.bustart.main.model.RoleDO;
import com.bustart.main.model.UserBusinessDO;
import com.bustart.main.model.UserDO;
import com.bustart.main.model.UserDetailDO;
import com.bustart.main.model.UserRoleDO;
import com.bustart.main.repository.RoleRepository;
import com.bustart.main.repository.UserBusinessRepository;
import com.bustart.main.repository.UserDetailRepository;
import com.bustart.main.repository.UserRepository;
import com.bustart.main.repository.UserRoleRepository;

/**
 * @author Slam245
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserBusinessRepository userBusinessRepository;
	
	@Autowired
	private GeneralService generalService;

	/**
	 * Implement Logger
	 */
	Logger logger = Logger.getLogger(UserService.class.getName());

	/**
	 * @author Slam245
	 * @method createUser
	 * @param userInputBO UserInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 *
	 */
	@SuppressWarnings("rawtypes")
	@Transactional
	public ResponseEntity<BaseResponseBO> createUser(UserInputBO userInputBO) {
		logger.info("UserService - Method createUser");
		BaseResponseBO<UserOutputBO> baseResponseBO = new BaseResponseBO<UserOutputBO>();
		List<ResponseErrorBO> listErrors = new ArrayList<ResponseErrorBO>();
		UserOutputBO userOutputBO = null;

		logger.info(
				"createUser: Search the username in DB - " + userInputBO.getUserName() + ", " + userInputBO.getEmail());
		Optional<UserDO> optUserDO = null;
		optUserDO = userRepository.findByUserNameOrEmail(userInputBO.getUserName(), userInputBO.getEmail());
		if (optUserDO.isPresent()) {
			logger.severe("createUser - The user exist: " + optUserDO.get().getId());
			ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_1,
					ErrorConstant.ERROR_KEY_USER_EXIST, ErrorConstant.MSG_KEY_USER_EXIST);
			listErrors.add(responseErrorBO);
		} else {
			logger.info("createUser - Search creator username ");
			UserDO userDOCreator = null;
			userDOCreator = generalService.getUserDO(userInputBO.getCreatorUserName());

			logger.info("createUser - Create new user");
			UserDO userDO = new UserDO();
			userDO.setUserName(userInputBO.getUserName());
			userDO.setEmail(userInputBO.getEmail());
			userDO.setPassword(passwordEncoder.encode(userInputBO.getPassword()));
			userDO.setStatusCode(true);
			userDO.setCreationDate(new Date());
			userDO.setCreatorUserDO(userDOCreator);
			userDO.setLastModifiedDate(null);
			userDO.setLastModifiedUserDO(null);
			userRepository.save(userDO);
			userRepository.flush();
			logger.info("createUser - New user created");

			UserDO newUserDO = null;
			newUserDO = generalService.getUserDO(userInputBO.getUserName());
			if (null != newUserDO) {
				listErrors = saveUserRolDO(newUserDO, userDOCreator, listErrors);
				listErrors = saveUserDetailsDO(userInputBO, newUserDO, userDOCreator, listErrors);
				userOutputBO = fillUserOutputBO(newUserDO);
			} else {
				logger.severe("getBusinessByUser - The user not exist");
				ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_2,
						ErrorConstant.ERROR_KEY_USER_NOT_EXIST, ErrorConstant.MSG_KEY_USER_NOT_EXIST);
				listErrors.add(responseErrorBO);
			}

		}
		baseResponseBO.setData(listErrors.size() > 0 ? null : userOutputBO);
		baseResponseBO.setErrors(listErrors);
		baseResponseBO.setSuccess(listErrors.size() > 0 ? Boolean.FALSE : Boolean.TRUE);
		baseResponseBO.setTotalSize(listErrors.size() > 0 ? NumberConstant.NUMBER_0 : NumberConstant.NUMBER_1);
		logger.info("createUser - Finish");
		return new ResponseEntity<>(baseResponseBO, HttpStatus.OK);
	}

	/**
	 * @author Slam245
	 * @method getBusinessByUser
	 * @param userName String
	 * @return ResponseEntity<BaseResponseBO>
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public ResponseEntity<BaseResponseBO> getBusinessByUser(String userName) {
		logger.info("UserService - Method getBusinessByUser");
		BaseResponseBO<List<BusinessBO>> baseResponseBO = new BaseResponseBO<List<BusinessBO>>();
		List<ResponseErrorBO> listErrors = new ArrayList<ResponseErrorBO>();
		List<BusinessBO> listBusinessBO = null;

		UserDO userDO = null;
		userDO = generalService.getUserDO(userName);
		if (null != userDO) {
			logger.info("getBusinessByUser - Search business of User");
			listBusinessBO = new ArrayList<BusinessBO>();
			List<UserBusinessDO> listUserBusinessDO = new ArrayList<UserBusinessDO>();
			listUserBusinessDO = userBusinessRepository.findByUserDO(userDO);
			logger.info("getBusinessByUser - Load business of user");
			for (UserBusinessDO userBusinessDO : listUserBusinessDO) {
				BusinessBO businessBO = new BusinessBO();
				businessBO.setIdBusiness(userBusinessDO.getBusinessDO().getId());
				businessBO.setBusiness(userBusinessDO.getBusinessDO().getDescription());
				businessBO.setDateOfCreation(userBusinessDO.getCreationDate());
				businessBO.setUserCreated(userBusinessDO.getCreatorUserDO().getUserName());
				listBusinessBO.add(businessBO);
			}
		} else {
			logger.severe("getBusinessByUser - The user not exist");
			ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_2,
					ErrorConstant.ERROR_KEY_USER_NOT_EXIST, ErrorConstant.MSG_KEY_USER_NOT_EXIST);
			listErrors.add(responseErrorBO);
		}
		baseResponseBO.setData(listErrors.size() > 0 ? null : listBusinessBO);
		baseResponseBO.setErrors(listErrors);
		baseResponseBO.setSuccess(listErrors.size() > 0 ? Boolean.FALSE : Boolean.TRUE);
		baseResponseBO.setTotalSize(listErrors.size() > 0 ? NumberConstant.NUMBER_0 : listBusinessBO.size());

		return new ResponseEntity<>(baseResponseBO, HttpStatus.OK);
	}
	
	/**
	 * @author Slam245
	 * @method getUserDetails
	 * @param userName String
	 * @return ResponseEntity<BaseResponseBO>
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public ResponseEntity<BaseResponseBO> getUserDetails(String userName) {
		logger.info("UserService - Method getUserDetails");
		BaseResponseBO<UserOutputBO> baseResponseBO = new BaseResponseBO<UserOutputBO>();
		List<ResponseErrorBO> listErrors = new ArrayList<ResponseErrorBO>();
		UserOutputBO userOutputBO = null;

		logger.info("getUserDetails - Search user in the DB.");
		UserDO userDO = null;
		userDO = generalService.getUserDO(userName);
		if(null != userDO) {
			userOutputBO = fillUserOutputBO(userDO);
		}else {
			logger.severe("getUserDetails - The user not exist");
			ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_2,
					ErrorConstant.ERROR_KEY_USER_NOT_EXIST, ErrorConstant.MSG_KEY_USER_NOT_EXIST);
			listErrors.add(responseErrorBO);
		}
		
		baseResponseBO.setData(listErrors.size() > 0 ? null : userOutputBO);
		baseResponseBO.setErrors(listErrors);
		baseResponseBO.setSuccess(listErrors.size() > 0 ? Boolean.FALSE : Boolean.TRUE);
		baseResponseBO.setTotalSize(listErrors.size() > 0 ? NumberConstant.NUMBER_0 : NumberConstant.NUMBER_1);

		return new ResponseEntity<>(baseResponseBO, HttpStatus.OK);
	}
	
	/**
	 * @author Slam245
	 * @method fillUserOutputBO
	 * @param userDO UserDO
	 * @return UserOutputBO
	 *
	 */
	private UserOutputBO fillUserOutputBO(UserDO userDO) {
		logger.info("UserService - Method fillUserOutputBO");
		UserOutputBO userOutputBO = null;
		if(null != userDO) {
			userOutputBO = new UserOutputBO();
			userOutputBO.setUserId(userDO.getId());
			userOutputBO.setUserName(userDO.getUserName());
			userOutputBO.setEmail(userDO.getEmail());
			userOutputBO.setStatusCode(userDO.getStatusCode());
			userOutputBO.setCreationDate(userDO.getCreationDate());
			userOutputBO.setLastModifiedDate(userDO.getLastModifiedDate());
			logger.info("fillUserOutputBO - Fill roles");
			List<String> listRoles = null;
			listRoles = getUserRoles(userDO);
			userOutputBO.setRoles(listRoles);
			logger.info("fillUserOutputBO - Get details");
			UserDetailDO userDetailDO = null;
			userDetailDO = userDetailRepository.findByUserDO(userDO);
			userOutputBO.setFirstName(userDetailDO.getFirstName());
			userOutputBO.setLastName(userDetailDO.getLastName());
			userOutputBO.setSecondLastName(userDetailDO.getSecondLastName());
			userOutputBO.setPhoneNumber(userDetailDO.getPhoneNumber());
			userOutputBO.setHasWhatsApp(userDetailDO.isHasWhatsApp());
		}
		return userOutputBO;
	}

	/**
	 * @author Slam245
	 * @method saveUserRolDO
	 * @param newUserDO     UserDO
	 * @param userDOCreator UserDO
	 * @param listErrors    List<ResponseErrorBO>
	 * @return List<ResponseErrorBO>
	 *
	 */
	private List<ResponseErrorBO> saveUserRolDO(UserDO newUserDO, UserDO userDOCreator,
			List<ResponseErrorBO> listErrors) {
		logger.info("createUser - Save the roles for the new user");
		List<ResponseErrorBO> newListErrors = new ArrayList<ResponseErrorBO>();
		;
		newListErrors.addAll(listErrors);
		if (null != newUserDO) {
			logger.info("createUser - Search roles");
			List<RoleDO> listRoles = new ArrayList<RoleDO>();
			listRoles = roleRepository.findByRoleNameContaining(GeneralConstant.GENERIC_STRING_ROLE);
			for (RoleDO roleDO : listRoles) {
				UserRoleDO userRoleDO = new UserRoleDO();
				userRoleDO.setRoleDO(roleDO);
				userRoleDO.setUserDO(newUserDO);
				userRoleDO.setStatusCode(Boolean.TRUE);
				userRoleDO.setCreationDate(new Date());
				userRoleDO.setCreatorUserDO(userDOCreator);
				userRoleRepository.save(userRoleDO);
				userRoleRepository.flush();
				logger.info("createUser - Save Roles OK");
			}
		}
		return newListErrors;
	}

	/**
	 * @author Slam245
	 * @method getUserRoles
	 * @param userDO UserDO
	 * @return List<String>
	 *
	 */
	private List<String> getUserRoles(UserDO userDO) {
		logger.info("createUser - Get user roles: " + userDO.getUserName());
		List<String> listRoles = new ArrayList<String>();
		if (null != userDO) {
			List<UserRoleDO> listUserRoleDO = null;
			logger.info("createUser: Extract user roles");
			listUserRoleDO = userRoleRepository.findByUserDO(userDO);
			for (UserRoleDO userRoleDO : listUserRoleDO) {
				listRoles.add(userRoleDO.getRoleDO().getRoleName());
			}
		}
		return listRoles;
	}

	/**
	 * @author Slam245
	 * @method saveUserDetailsDO
	 * @param userInputBO   UserInputBO
	 * @param newUserDO     UserDO
	 * @param userDOCreator UserDO
	 * @param listErrors    List<ResponseErrorBO>
	 * @return List<ResponseErrorBO>
	 *
	 */
	private List<ResponseErrorBO> saveUserDetailsDO(UserInputBO userInputBO, UserDO newUserDO, UserDO userDOCreator,
			List<ResponseErrorBO> listErrors) {
		logger.info("createUser - Save details for the new user");
		List<ResponseErrorBO> newListErrors = new ArrayList<ResponseErrorBO>();
		;
		newListErrors.addAll(listErrors);
		if (null != newUserDO) {
			logger.info("createUser - Fill details of the user");
			UserDetailDO userDetailDO = new UserDetailDO();
			userDetailDO.setUserDO(newUserDO);
			userDetailDO.setFirstName(userInputBO.getFirstName());
			userDetailDO.setLastName(userInputBO.getLastName());
			userDetailDO.setSecondLastName(userInputBO.getSecondLastName());
			userDetailDO.setPhoneNumber(userInputBO.getPhoneNumber());
			userDetailDO.setHasWhatsApp(userInputBO.isHasWhatsApp());
			userDetailDO.setStatusCode(Boolean.TRUE);
			userDetailDO.setCreationDate(new Date());
			userDetailDO.setCreatorUserDO(userDOCreator);
			userDetailRepository.save(userDetailDO);
			userDetailRepository.flush();
			logger.info("createUser - Save record OK");
		}
		return newListErrors;
	}
}
