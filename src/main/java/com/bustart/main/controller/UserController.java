
package com.bustart.main.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bustart.main.bo.BaseRequestBO;
import com.bustart.main.bo.BaseResponseBO;
import com.bustart.main.bo.UserInputBO;
import com.bustart.main.service.user.UserService;

@RestController
@Validated
@RequestMapping("/v1/api/user")
public class UserController{

	/**
	 * Constructor
	 */
	public UserController() {
	}
	
	@Autowired
	private UserService userService;

	/**
	 * Method getBusinessByUser
	 * 
	 * @method createUser
	 * @param userInputBO UserInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponseBO> createUser(@Valid @RequestBody BaseRequestBO<UserInputBO> request) {
		return userService.createUser(request.getBusinessRequest());
	}


	/**
	 * Method getBusinessByUser
	 * 
	 * @method getBusinessByUser
	 * @param userName String
	 * @return ResponseEntity<BaseResponseBO>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/getBusinessByUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponseBO> getBusinessByUser(@Valid @RequestParam String userName) {
		return userService.getBusinessByUser(userName);
	}
	
	/**
	 * Method getUserDetails
	 * 
	 * @method getUserDetails
	 * @param userName String
	 * @return ResponseEntity<BaseResponseBO>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/getUserDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponseBO> getUserDetails(@Valid @RequestParam String userName) {
		return userService.getUserDetails(userName);
	}
}
