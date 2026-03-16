package com.bustart.main.controller;


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
import com.bustart.main.service.sale.SaleService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/v1/api/sales")
public class SaleController {

	/**
	 * Constructor
	 */
	public SaleController() {
	}
	
	@Autowired
	private SaleService saleService;

	/**
	 * Method getBusinessByUser
	 * 
	 * @method addSaleToCustomer
	 * @param saleInputBO SaleInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/addSaleToCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponseBO> addSaleToCustomer(@Valid @RequestBody BaseRequestBO<saleInputBO> request) {
		return saleService.addSaleToCustomer(request.getBusinessRequest());
	}

}
