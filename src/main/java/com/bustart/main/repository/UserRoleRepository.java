package com.bustart.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bustart.main.model.RoleDO;

@Repository
public interface UserRoleRepository extends JpaRepository<RoleDO, Long>{

	RoleDO findByRoleNameContaining(String roleName);

}
