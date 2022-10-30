package com.bustart.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bustart.main.model.UserDO;
import com.bustart.main.model.UserRoleDO;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleDO, Long>{

	List<UserRoleDO> findByUserDO(UserDO userDO);
	
}
