package com.bustart.main.bo;

import javax.validation.Valid;

/**
 * @author Slam245
 *
 */
public class BaseRequestBO<T> {

	/**
	 * Constructor
	 */
	public BaseRequestBO() {
	}

	@Valid
	private T businessRequest;

	/**
	 * @return the businessRequest
	 */
	public T getBusinessRequest() {
		return businessRequest;
	}

	/**
	 * @param businessRequest the businessRequest to set
	 */
	public void setBusinessRequest(T businessRequest) {
		this.businessRequest = businessRequest;
	}

}
