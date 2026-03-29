
package com.bustart.main.controller;


import jakarta.validation.Valid;

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
import com.bustart.main.bo.CustomerInputBO;
import com.bustart.main.service.customer.CustomerService;

@RestController
@Validated
@RequestMapping("/v1/api/customer")
public class CustomerController{

	/**
	 * Constructor
	 */
	public CustomerController() {
	}
	
	@Autowired
	private CustomerService customerService;

	/**
	 * Method addCustomer
	 * 
	 * @method addCustomer
	 * @param customerInputBO CustomerInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/addCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponseBO> addCustomer(@Valid @RequestBody BaseRequestBO<CustomerInputBO> request) {
		return customerService.addCustomer(request.getBusinessRequest());
	}

}
