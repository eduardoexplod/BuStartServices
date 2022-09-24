/**
 * 
 */
package com.bustart.main.service.auth;

import java.util.List;
import java.util.Optional;
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

/**
 * @author Slam245
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UserDO> optUserDO = null;
		
		optUserDO = userRepository.findByUserName(userName);
		if(optUserDO.isPresent()) {
			UserDO userDO = null;
			userDO = optUserDO.get();			
			
			List<SimpleGrantedAuthority> listRoles = userDO.getRoles()
					.stream()
					.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
					.collect(Collectors.toList());
			return new User(userDO.getUserName(), userDO.getPassword(), listRoles);
		}
		
		throw new UsernameNotFoundException("User not exist");
		
	}
}
