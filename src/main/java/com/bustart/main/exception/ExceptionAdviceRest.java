package com.bustart.main.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bustart.main.bo.BaseResponseBO;
import com.bustart.main.bo.ResponseErrorBO;
import com.bustart.main.bo.UserOutputBO;
import com.bustart.main.constants.ErrorConstant;
import com.bustart.main.constants.NumberConstant;
import com.bustart.main.service.user.UserService;

@RestControllerAdvice
public class ExceptionAdviceRest {

	/**
	 * 
	 */
	public ExceptionAdviceRest() {
	}

	/**
	 * Implement Logger
	 */
	Logger logger = Logger.getLogger(UserService.class.getName());

	/**
	 * @author Slam245
	 * @method handleMultipartException
	 * @param userName String
	 *
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<BaseResponseBO> handleMultipartException(MethodArgumentNotValidException ex,
			BindingResult bindingResult) {
		logger.info("ExceptionAdviceRes: MethodArgumentNotValidException");
		BaseResponseBO<UserOutputBO> baseResponseBO = new BaseResponseBO<UserOutputBO>();
		List<ResponseErrorBO> listErrors = new ArrayList<ResponseErrorBO>();

		if (bindingResult.hasErrors()) {
			logger.severe("ExceptionAdviceRes: Filll Response with errors");
			List<ObjectError> listObjectError = null;
			listObjectError = bindingResult.getAllErrors();
			logger.severe("ExceptionAdviceRes: Count errors: " + bindingResult.getErrorCount());
			for (ObjectError objectError : listObjectError) {
				ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_99999,
						objectError.getDefaultMessage(), ErrorConstant.MSG_KEY_INPUT_ERROR + objectError.getCode());
				listErrors.add(responseErrorBO);
			}
			logger.severe(listObjectError.toString());
		}

		baseResponseBO.setData(null);
		baseResponseBO.setErrors(listErrors);
		baseResponseBO.setSuccess(Boolean.FALSE);
		baseResponseBO.setTotalSize(NumberConstant.NUMBER_0);

		return new ResponseEntity<BaseResponseBO>(baseResponseBO, HttpStatus.BAD_REQUEST);
	}

}
