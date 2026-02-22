package com.bustart.main.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Slam245
 *
 */
public class BaseResponseBO<T> {

	/**
	 * 
	 */
	public BaseResponseBO() {
	}
	/**
	 * Instantiates a new BaseRequestBO
	 * 
	 * @author Slam245
	 * @param success
	 * @param errors
	 * @param data
	 * @param totalSize
	 */
	public BaseResponseBO( Boolean success, List<ResponseErrorBO> errors, T data, Integer totalSize) {
		this.success = success;
		this.errors = errors;
		this.data = data;
		this.totalSize = totalSize;
	}

	private Boolean success;
	private List<ResponseErrorBO> errors;
	private T data;
	private Integer totalSize;

	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * @return the errors
	 */
	public List<ResponseErrorBO> getErrors() {
		if(null == errors) {
			errors = new ArrayList<ResponseErrorBO>();
		}
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<ResponseErrorBO> errors) {
		this.errors = errors;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the totalSize
	 */
	public Integer getTotalSize() {
		return totalSize;
	}

	/**
	 * @param totalSize the totalSize to set
	 */
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

}
