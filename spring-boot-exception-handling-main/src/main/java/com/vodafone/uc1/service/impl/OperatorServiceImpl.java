package com.vodafone.uc1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vodafone.uc1.domain.Country;
import com.vodafone.uc1.domain.Operator;
import com.vodafone.uc1.dto.OperatorDto;
import com.vodafone.uc1.exceptions.CountryListEmptyException;
import com.vodafone.uc1.exceptions.EntityNotFoundException;
import com.vodafone.uc1.exceptions.OperatorListEmptyException;
import com.vodafone.uc1.mapper.OperatorMapper;
import com.vodafone.uc1.repository.OperatorRepository;
import com.vodafone.uc1.service.CountryService;
import com.vodafone.uc1.service.OperatorService;

@Service
public class OperatorServiceImpl implements OperatorService {
	
	@Autowired
	private OperatorRepository operatorRepository;
	
	@Autowired
	private OperatorMapper operatorMapper;
	
	@Autowired
	private CountryService countryServices;

	@Override
	public Operator findByOperatorId(int operatorId) {
		Operator operator =  operatorRepository.findById(operatorId)
	               .orElseThrow(() -> new EntityNotFoundException("Operator Not Found with id : " + operatorId));
	    return operator;
	}

	@Override
	public Operator add(OperatorDto operatorDto) {
		Operator operator = operatorMapper.getConvertFromDtoOperatorToEntityOperator(operatorDto);
        return operatorRepository.save(operator);
	}

	@Override
	public List<Operator> findAll() {
		List<Operator> operatorList = operatorRepository.findAll();
		
		if (operatorList == null || operatorList.isEmpty()) {
			new OperatorListEmptyException("Operator List Not Found.");
		}
		
		return operatorList;
	}

	@Override
	public void deleteOperator(Integer operatorId) {
		Operator operator =  findByOperatorId(operatorId);
		if (operator == null) {
			new EntityNotFoundException("Operator Not Found with id : " + operatorId);
		} else {
			operatorRepository.deleteById(operatorId);
		}
	}

	@Override
	public Operator update(OperatorDto operatorDto) {
		Operator operator = findByOperatorId(operatorDto.getId());
		operator.setOpertorName(operatorDto.getOperatorName());
		Country country = countryServices.findByCountryId(operatorDto.getCountryDto().getId());
		operator.setCountry(country);
		return operator;
	}

}
