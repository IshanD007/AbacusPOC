package com.vodafone.uc1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vodafone.uc1.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	List<User> findAll();
}
