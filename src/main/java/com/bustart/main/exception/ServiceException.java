package com.bustart.main.exception;

import org.springframework.http.HttpStatus;

import java.util.AbstractMap;


/**
 * The Class ServiceException.
 */
public class ServiceException extends Throwable {
	
/** The Constant GENERIC_ERROR. */
private static final String GENERIC_ERROR = "GENERIC_ERROR";

/** The Constant serialVersionUID. */
private static final long serialVersionUID = 1L;
	
	/** The error code. */
	private int errorCode;
	
	/** The message. */
	private String message;
	
	/** The error identifier. */
	private String errorIdentifier;
	
	/**
	 * Gets the error code.
	 *
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Instantiates a new service exception.
	 *
	 * @param resultCode the result code
	 * @param errordetail the error detail
	 */
	public ServiceException(int resultCode, String errordetail) {
		this(resultCode,errordetail, GENERIC_ERROR);
	}

	/**
	 * Instantiates a new service exception.
	 *
	 * @param status the status
	 * @param errordetail the error detail
	 */
	public ServiceException( HttpStatus status, String errordetail) {
		this(status.value(),errordetail, GENERIC_ERROR);
	}
	
	/**
	 * Instantiates a new service exception.
	 *
	 * @param httpStatusCode the HTTP status code
	 * @param errorDetail the error detail
	 * @param identifier the identifier
	 */
	public ServiceException(int httpStatusCode, String errorDetail, String identifier) {
		super();
		this.errorCode = httpStatusCode;
		this.message = errorDetail;
		this.errorIdentifier = identifier;
	}
	
	/**
	 * Instantiates a new service exception.
	 *
	 * @param httpStatusCode the HTTP status code
	 * @param error the error
	 */
	public ServiceException(int httpStatusCode, AbstractMap.SimpleEntry<String, String> error) {
		this(httpStatusCode,error.getValue(), error.getKey());
	}
	
	/**
	 * Instantiates a new service exception.
	 *
	 * @param resultCode the result code
	 */
	public ServiceException(int resultCode) {
		super();
		this.errorCode = resultCode;
	}
	
	/**
	 * Gets the result code.
	 *
	 * @return the resultCode
	 */
	public int getResultCode() {
		return getErrorCode();
	}

	/**
	 * Sets the result code.
	 *
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(int resultCode) {
		this.errorCode = resultCode;
	}

	/**
	 * Gets the error detail.
	 *
	 * @return the error detail
	 */
	public String getErrordetail() {
		return getMessage();
	}

	/**
	 * Sets the error detail.
	 *
	 * @param errordetail the error detail to set
	 */
	public void setErrordetail(String errordetail) {
		this.message = errordetail;
	}

	/**
	 * Gets the error identifier.
	 *
	 * @return the error identifier
	 */
	public String getErrorIdentifier() {
		return errorIdentifier;
	}

	/**
	 * Sets the error identifier.
	 *
	 * @param errorIdentifier the new error identifier
	 */
	public void setErrorIdentifier(String errorIdentifier) {
		this.errorIdentifier = errorIdentifier;
	}



}
