/**
 * 
 */
package com.bustart.main.service.auth;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bustart.main.model.UserDO;
import com.bustart.main.repository.UserRepository;
import com.bustart.main.repository.UserRoleRepository;
import com.bustart.main.service.user.UserService;

/**
 * @author Slam245
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	/**
	 * Implement Logger
	 */
	Logger logger = Logger.getLogger(UserService.class.getName());

	/**
	 * @author Slam245
	 * @method createUser
	 * @param userInputBO UserInputBO
	 * @return ResponseEntity<BaseResponseBO>
	 *
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		logger.info("loadUserByUsername - Init method");
		Optional<UserDO> optUserDO = null;
		optUserDO = userRepository.findByUserName(userName);
		if(optUserDO.isPresent()) {
			logger.info("loadUserByUsername - Load details of user");
			UserDO userDO = null;
			userDO = optUserDO.get();						
			List<SimpleGrantedAuthority> listRoles = userRoleRepository.findByUserDO(userDO)
					.stream()
					.map(userRoleDO -> new SimpleGrantedAuthority(userRoleDO.getRoleDO().getRoleName()))
					.collect(Collectors.toList());
			logger.info("loadUserByUsername - Finish method");
			return new User(userDO.getUserName(), userDO.getPassword(), listRoles);
		}
		logger.info("loadUserByUsername - User not exist");
		throw new UsernameNotFoundException("User not exist");
		
	}
}
