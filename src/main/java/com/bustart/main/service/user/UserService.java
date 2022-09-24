/**
 * 
 */
package com.bustart.main.service.user;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bustart.main.bo.UserBO;
import com.bustart.main.model.UserDO;
import com.bustart.main.repository.RoleRepository;
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
}
