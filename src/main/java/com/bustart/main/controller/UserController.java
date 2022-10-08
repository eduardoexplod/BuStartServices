package com.bustart.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bustart.main.bo.BaseRequestBO;
import com.bustart.main.bo.BaseResponseBO;
import com.bustart.main.bo.UserBO;
import com.bustart.main.model.UserDO;
import com.bustart.main.service.user.UserService;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @param userBO
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDO createUser(@RequestBody UserBO userBO) {
		return userService.createUser(userBO);
	}
	
	/**
	 * Method getBusinessByUser
	 * 
	 * @param userName String
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping
	@RequestMapping(value = "/getBusinessByUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponseBO> getBusinessByUser(@Valid @RequestBody BaseRequestBO<String> request) {
		return userService.getBusinessByUser(request.getBusinessRequest());
	}
}
