package com.bustart.main.constants;

/**
 * The Class GeneralConstant.
 */
public class PatternConstant {

    /**
	 * Instantiates a new general constant.
	 */
	private PatternConstant() {
	}
	
	/** The Constant EMPTY_STRING. */
	public static final String PATTERN_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	
	
}
