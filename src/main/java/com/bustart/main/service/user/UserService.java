/**
 * 
 */
package com.bustart.main.service.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bustart.main.bo.BaseResponseBO;
import com.bustart.main.bo.BusinessBO;
import com.bustart.main.bo.UserBO;
import com.bustart.main.constants.ErrorConstant;
import com.bustart.main.exception.ServiceException;
import com.bustart.main.model.UserBusinessDO;
import com.bustart.main.model.UserDO;
import com.bustart.main.repository.RoleRepository;
import com.bustart.main.repository.UserBusinessRepository;
import com.bustart.main.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Slam245
 *
 */
@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserBusinessRepository userBusinessRepository;
	
	/**
	 * @author Slam245
	 *
	 */
	public UserDO createUser(@RequestBody UserBO userBO) {
		UserDO userDO = null;
		userDO = new ObjectMapper().convertValue(userBO, UserDO.class);
		userDO.setPassword(passwordEncoder.encode(userBO.getPassword()));
		userDO.setRoles(Collections.singletonList(roleRepository.findByRoleNameContaining("USER")));
		
		Optional<UserDO> optUserDO= null;
		optUserDO = userRepository.findByUserNameOrEmail(userBO.getUserName(), userBO.getEmail());
		if(!optUserDO.isPresent()) {
			userRepository.save(userDO);
			return userDO;
		}
		throw new RuntimeException("The username already exist");
	}
	
	/**
	 * @author Slam245
	 * @throws ServiceException 
	 * @method 
	 *
	 */
	@SuppressWarnings("rawtypes")
	public ResponseEntity<BaseResponseBO> getBusinessByUser(String userName) throws ServiceException {
		BaseResponseBO<List<BusinessBO>> baseResponseBO = new BaseResponseBO<List<BusinessBO>>();
		
		List<BusinessBO> listBusinessBO = new ArrayList<BusinessBO>();
		
		Optional<UserDO> optUserDO = null;
		optUserDO = userRepository.findByUserName(userName);
		
		if(optUserDO.isPresent()) {
			UserDO userDO = null;
			userDO = optUserDO.get();
			

			List<UserBusinessDO> listUserBusinessDO = new ArrayList<UserBusinessDO>();
			listUserBusinessDO = userBusinessRepository.findByUserDO(userDO);
			
			for(UserBusinessDO userBusinessDO : listUserBusinessDO) {
				BusinessBO businessBO = new BusinessBO();
				businessBO.setIdBusiness(userBusinessDO.getBusinessDO().getId());
				businessBO.setBusiness(userBusinessDO.getBusinessDO().getDescription());
				//businessBO.setDateOfCreation(userBusinessDO.getCreationDate());
				//businessBO.setUserCreated(userBusinessDO.getCreatorUserDO().getUserName());
				listBusinessBO.add(businessBO);
			}
		}
		//else {
		//	throw new ServiceException(ErrorConstant.ERROR_400,ErrorConstant.ERROR_KEY_USER_NOT_EXIST);
		//}
		
		baseResponseBO.setData(listBusinessBO);
		baseResponseBO.setErrors(new ArrayList<>());
		baseResponseBO.setSuccess(Boolean.TRUE);
		baseResponseBO.setTotalSize(listBusinessBO.size());
		
		return new ResponseEntity<>(baseResponseBO, HttpStatus.OK);
	}
}
