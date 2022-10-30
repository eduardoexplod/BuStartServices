package com.bustart.main.constants;

/**
 * The Class ErrorConstant.
 */
public class ErrorConstant {


    /**
	 * Instantiates a new error constant.
	 */
	private ErrorConstant() {
	}

	/** The Constant ERROR_400. */
	public static final int ERROR_400 = 400;
	
	/** The Constant ERROR_401. */
	public static final int ERROR_401 = 401;
	
	/** The Constant ERROR_403. */
	public static final int ERROR_403 = 403;
	
	/** The Constant ERROR_404. */
	public static final int ERROR_404 = 404;
	
	/** The Constant ERROR_500. */
	public static final int ERROR_500 = 500;
	
	/** The Constant ERROR_502. */
	public static final int ERROR_502 = 502;
	
	/** The Constant ERROR_1. */
	public static final Long SYSTEM_ERROR_1 = 1L;
	/** The Constant ERROR_KEY_USER_EXIST. */
	public static final String ERROR_KEY_USER_EXIST = "KEY_USER_EXIST";
	/** The Constant MSG_KEY_USER_EXIST. */
	public static final String MSG_KEY_USER_EXIST = "The user exist in DB.";
	
	/** The Constant ERROR_2. */
	public static final Long SYSTEM_ERROR_2 = 2L;
	/** The Constant ERROR_KEY_USER_NOT_EXIST. */
	public static final String ERROR_KEY_USER_NOT_EXIST = "KEY_USER_NOT_EXIST";
	/** The Constant MSG_KEY_USER_EXIST. */
	public static final String MSG_KEY_USER_NOT_EXIST = "The user not exist in DB.";
	
	
	/** The Constant ERROR_2. */
	public static final Long SYSTEM_ERROR_99999 = 99999L;
	/** The Constant MSG_KEY_USER_EXIST. */
	public static final String MSG_KEY_INPUT_ERROR = "Data entry error in backend service: ";
	
	/** The Constant VAL_USERNAME_REQUIRED */
	public static final String ERROR_VALIDATION_USERNAME_REQUIRED = "VAL_USERNAME_REQUIRED";
	/** The Constant VAL_EMAIL_REQUIRED */
	public static final String ERROR_VALIDATION_EMAIL_REQUIRED = "ERROR_VALIDATION_EMAIL_REQUIRED";
	/** The Constant VAL_EMAIL_FORMAT_REQUIRED */
	public static final String ERROR_VALIDATION_EMAIL_FORMAT_REQUIRED = "ERROR_VALIDATION_EMAIL_FORMAT_REQUIRED";
	/** The Constant VAL_PASSWORD_REQUIRED */
	public static final String ERROR_VALIDATION_PASSWORD_REQUIRED = "ERROR_VALIDATION_PASSWORD_REQUIRED";
	/** The Constant VAL_PASSWORD_FORMAT */
	public static final String ERROR_VALIDATION_PASSWORD_FORMAT = "ERROR_VALIDATION_PASSWORD_FORMAT";
}

