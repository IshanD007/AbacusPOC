package com.vodafone.uc1.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vodafone.uc1.domain.Country;
import com.vodafone.uc1.domain.Operator;
import com.vodafone.uc1.dto.CountryDto;
import com.vodafone.uc1.dto.OperatorDto;
import com.vodafone.uc1.dto.RegionDto;
import com.vodafone.uc1.dto.RegionTypeDto;
import com.vodafone.uc1.mapper.OperatorMapper;
import com.vodafone.uc1.service.CountryService;

@Component
public class OperatorMapperImpl implements OperatorMapper {
	
	@Autowired
	private CountryService countryServices;

	@Override
	public Operator getConvertFromDtoOperatorToEntityOperator(OperatorDto operatorDto) {
		Operator operator = new Operator();
		operator.setOpertorName(operatorDto.getOperatorName());
		Country country = countryServices.findByCountryId(operatorDto.getCountryDto().getId());
		operator.setCountry(country);
		return operator;
	}

	@Override
	public OperatorDto getConvertFromEntityOperatorToDtoOperator(Operator operator) {
		OperatorDto operatorDto = new OperatorDto();
		operatorDto.setId(operator.getId());
		operatorDto.setOperatorName(operator.getOpertorName());
		
		CountryDto countryDto = new CountryDto();
		countryDto.setId(operator.getCountry().getId());
		countryDto.setCountryName(operator.getCountry().getCountryName());
		
		RegionDto regionDto = new RegionDto();
		regionDto.setId(operator.getCountry().getRegion().getId());
		regionDto.setRegionName(operator.getCountry().getRegion().getRegionName());
		
		RegionTypeDto regionTypeDto = new RegionTypeDto();
		regionTypeDto.setId(operator.getCountry().getRegion().getRegionType().getId());
		regionTypeDto.setRegionTypeName(operator.getCountry().getRegion().getRegionType().getRegionTypeName());
		
		regionDto.setRegionTypeDto(regionTypeDto);
		countryDto.setRegionDto(regionDto);
		
		operatorDto.setCountryDto(countryDto);
		
		return operatorDto;
	}

}
