package com.bustart.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bustart.main.model.RoleDO;

@Repository
public interface RoleRepository extends JpaRepository<RoleDO, Long>{

	List<RoleDO> findByRoleNameContaining(String roleName);

}
