package com.vodafone.springexceptionhandling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vodafone.springexceptionhandling.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

	List<Role> findAll();
}
