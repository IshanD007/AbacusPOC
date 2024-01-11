package com.vodafone.springexceptionhandling.repository;

import com.vodafone.springexceptionhandling.domain.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	List<User> findAll();
}
