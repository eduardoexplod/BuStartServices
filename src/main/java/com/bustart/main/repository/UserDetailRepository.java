package com.bustart.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bustart.main.model.UserDO;
import com.bustart.main.model.UserDetailDO;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailDO, Long>{
	
	UserDetailDO findByUserDO(UserDO userDO);

}
