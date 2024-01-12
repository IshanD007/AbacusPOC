package com.vodafone.uc1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vodafone.uc1.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

	List<Role> findAll();
}
