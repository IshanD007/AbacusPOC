package com.vodafone.uc1.service;

import java.util.List;

import com.vodafone.uc1.domain.Operator;
import com.vodafone.uc1.dto.OperatorDto;

public interface OperatorService {

	 	Operator findByOperatorId(int operatorId);

	    Operator add(OperatorDto operatorDto);

	    List<Operator> findAll();
	    
	    void deleteOperator(Integer operatorId);
	    
	    Operator update(OperatorDto operatorDto);
}
