package com.bustart.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bustart.main.model.BusinessDO;

@Repository
public interface BusinessRepository extends JpaRepository<BusinessDO, Long>{

	Optional<BusinessDO> findByBusiness(String business);
	
	Optional<BusinessDO> findById(Long id);
}
