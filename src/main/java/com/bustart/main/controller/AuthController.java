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
import com.bustart.main.bo.LoginInputBO;
import com.bustart.main.service.auth.JwtService;

import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping("/v1/api/auth")
public class AuthController {

    @Autowired
	private JwtService jwtService;

    /**
	 * Method addBusinessToUser
	 * 
	 * @method addBusinessToUser
	 * @param businessInputBO BusinessInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 */
	@SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponseBO> login(@Valid @RequestBody BaseRequestBO<LoginInputBO> request) {
		return jwtService.createToken(request.getBusinessRequest());
	}
}


