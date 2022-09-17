package com.bustart.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bustart.main.model.UserDO;

@Repository
public interface UserRepository extends JpaRepository<UserDO, Long>{

	Optional<UserDO> findByUserName(String userName);
	
	Optional<UserDO> findByUserNameOrEmail(String userName, String email);
}
