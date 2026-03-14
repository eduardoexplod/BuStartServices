package com.bustart.main.service.auth;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bustart.main.bo.AuthOutputBO;
import com.bustart.main.bo.BaseResponseBO;
import com.bustart.main.bo.LoginInputBO;
import com.bustart.main.bo.ResponseErrorBO;
import com.bustart.main.constants.ErrorConstant;
import com.bustart.main.constants.NumberConstant;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * @author Slam245
 *
 */
@Service
@Transactional
public class JwtService {

	@Autowired
	private UserDetailsService userDetailsService;

	// Clave secreta (en producción debe ir en variables de entorno)
	private static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

	/**
	 * Implement Logger
	 */
	Logger logger = Logger.getLogger(JwtService.class.getName());

	private final PasswordEncoder passwordEncoder;

	public JwtService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * @author Slam245
	 * @method createUser
	 * @param userInputBO UserInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 *
	 */
	@SuppressWarnings("rawtypes")
	@Transactional
	public ResponseEntity<BaseResponseBO> createToken(LoginInputBO loginInputBO) {
		logger.info("JwtService - Method createToken");
		BaseResponseBO<AuthOutputBO> baseResponseBO = new BaseResponseBO<AuthOutputBO>();
		List<ResponseErrorBO> listErrors = new ArrayList<ResponseErrorBO>();
		AuthOutputBO authOutputBO = null;
		UserDetails userDetails = null;
		logger.info("JwtService - Search user in the DB.");
		try {
			userDetails = userDetailsService.loadUserByUsername(loginInputBO.getUserName());
			logger.info("userDetails: " + userDetails.toString());
			if (loginInputBO.getUserName().equals(userDetails.getUsername()) &&
					passwordEncoder.matches(loginInputBO.getPassword(), userDetails.getPassword())) {
				logger.info("JwtService - Start the process for create the token");
				String token = null;
				token = generateToken(loginInputBO.getUserName());
				authOutputBO = new AuthOutputBO();
				authOutputBO.setToken(token);
				authOutputBO.setUserName(userDetails.getUsername());
			} else {
				logger.severe("JwtService - The user not exist");
				ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_2,
						ErrorConstant.ERROR_KEY_USER_NOT_EXIST, ErrorConstant.MSG_KEY_USER_NOT_EXIST);
				listErrors.add(responseErrorBO);
			}
		} catch (UsernameNotFoundException e) {
			logger.severe("JwtService - The user not exist");
			ResponseErrorBO responseErrorBO = new ResponseErrorBO(ErrorConstant.SYSTEM_ERROR_2,
					ErrorConstant.ERROR_KEY_USER_NOT_EXIST, ErrorConstant.MSG_KEY_USER_NOT_EXIST);
			listErrors.add(responseErrorBO);
		}
		baseResponseBO.setData(listErrors.size() > 0 ? null : authOutputBO);
		baseResponseBO.setErrors(listErrors);
		baseResponseBO.setSuccess(listErrors.size() > 0 ? Boolean.FALSE : Boolean.TRUE);
		baseResponseBO.setTotalSize(listErrors.size() > 0 ? NumberConstant.NUMBER_0 : NumberConstant.NUMBER_1);
		logger.info("JwtService - Finish");
		return new ResponseEntity<>(baseResponseBO, HttpStatus.OK);
	}

	public String generateToken(String username) {
		return Jwts.builder()
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
				.signWith(getSigningKey())
				.compact();
	}

	private SecretKey getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
