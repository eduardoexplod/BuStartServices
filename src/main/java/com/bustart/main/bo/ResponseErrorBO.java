package com.bustart.main.bo;

/**
 * @author Slam245
 *
 */
public class ResponseErrorBO {

	/**
	 * 
	 */
	public ResponseErrorBO() {
	}

	/**
	 * @author Slam245
	 * @method ResponseErrorBO
	 * @param code       Long
	 * @param identifier String
	 * @param message    String
	 */
	public ResponseErrorBO(Long code, String identifier, String message) {
		this.code = code;
		this.identifier = identifier;
		this.message = message;
	}

	private Long code;
	private String identifier;
	private String message;

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
