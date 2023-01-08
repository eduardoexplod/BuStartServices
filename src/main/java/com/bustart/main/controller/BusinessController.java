/**
 * 
 */
package com.bustart.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bustart.main.bo.BaseRequestBO;
import com.bustart.main.bo.BaseResponseBO;
import com.bustart.main.bo.BusinessInputBO;
import com.bustart.main.bo.BusinessUserInputBO;
import com.bustart.main.service.user.BusinessService;

/**
 * @author Slam245
 *
 */
@RestController
@Validated
@RequestMapping("/v1/api/business")
public class BusinessController {

	/**
	 * Constructor
	 */
	public BusinessController() {
	}
	
	@Autowired
	private BusinessService businessService;

	/**
	 * Method createBusiness
	 * 
	 * @method createBusiness
	 * @param businessInputBO BusinessInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createBusiness", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponseBO> createUser(@Valid @RequestBody BaseRequestBO<BusinessInputBO> request) {
		return businessService.createBusiness(request.getBusinessRequest());
	}
	
	/**
	 * Method addBusinessToUser
	 * 
	 * @method addBusinessToUser
	 * @param businessInputBO BusinessInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/addBusinessToUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponseBO> addBusinessToUser(@Valid @RequestBody BaseRequestBO<BusinessUserInputBO> request) {
		return businessService.addBusinessToUser(request.getBusinessRequest());
	}
}
