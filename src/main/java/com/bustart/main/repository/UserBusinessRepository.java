package com.bustart.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bustart.main.model.UserBusinessDO;
import com.bustart.main.model.UserDO;

@Repository
public interface UserBusinessRepository extends JpaRepository<UserBusinessDO, Long>{

	List<UserBusinessDO> findByUserDO(UserDO userDO);

}
