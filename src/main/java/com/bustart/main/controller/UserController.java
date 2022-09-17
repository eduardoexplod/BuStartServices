package com.bustart.main.controller;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bustart.main.bo.UserBO;
import com.bustart.main.model.UserDO;
import com.bustart.main.repository.UserRepository;
import com.bustart.main.repository.UserRoleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/v1/api/oauth/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDO register(@RequestBody UserBO userBO) {
		UserDO userDO = null;
		userDO = new ObjectMapper().convertValue(userBO, UserDO.class);
		//userDO.setPassword(passwordEncoder.encode(userBO.getPassword()));
		userDO.setRoles(Collections.singletonList(userRoleRepository.findByRoleNameContaining("USER")));
		
		Optional<UserDO> optUserDO= null;
		optUserDO = userRepository.findByUserNameOrEmail(userBO.getUserName(), userBO.getEmail());
		if(!optUserDO.isPresent()) {
			userRepository.save(userDO);
		}
		
		throw new RuntimeException("The username already exist");
	}
}
