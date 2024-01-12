package com.vodafone.uc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vodafone.uc1.domain.RegionType;

@Repository
public interface RegionTypeRepository extends JpaRepository<RegionType,Integer> {

}
