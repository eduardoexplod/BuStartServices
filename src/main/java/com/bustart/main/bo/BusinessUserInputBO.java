package com.bustart.main.bo;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bustart.main.constants.ErrorConstant;

/**
 * @author Slam245
 *
 */
public class BusinessUserInputBO {
	
	/**
	 * Constructor
	 */
	public BusinessUserInputBO() {
	}

	@NotNull(message = ErrorConstant.ERROR_VAL_USERNAME_CREATOR_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_USERNAME_CREATOR_REQUIRED)
	private String userNameCreator;
	
	@NotNull(message = ErrorConstant.ERROR_VAL_USERNAME_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_USERNAME_REQUIRED)
	private String userName;
	
	@NotNull(message = ErrorConstant.ERROR_VAL_BUSINESS_LIST_REQUIRED)
	@NotEmpty (message = ErrorConstant.ERROR_VAL_BUSINESS_LIST_REQUIRED)
	private List<Long> listBusinessId;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the listBusinessId
	 */
	public List<Long> getListBusinessId() {
		return listBusinessId;
	}

	/**
	 * @param listBusinessId the listBusinessId to set
	 */
	public void setListBusinessId(List<Long> listBusinessId) {
		this.listBusinessId = listBusinessId;
	}

	/**
	 * @return the userNameCreator
	 */
	public String getUserNameCreator() {
		return userNameCreator;
	}

	/**
	 * @param userNameCreator the userNameCreator to set
	 */
	public void setUserNameCreator(String userNameCreator) {
		this.userNameCreator = userNameCreator;
	}	
}
