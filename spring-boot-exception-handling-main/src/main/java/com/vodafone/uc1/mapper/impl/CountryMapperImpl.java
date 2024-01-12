package com.vodafone.uc1.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vodafone.uc1.domain.Country;
import com.vodafone.uc1.domain.Region;
import com.vodafone.uc1.dto.CountryDto;
import com.vodafone.uc1.dto.RegionDto;
import com.vodafone.uc1.dto.RegionTypeDto;
import com.vodafone.uc1.mapper.CountryMapper;
import com.vodafone.uc1.service.RegionServices;

@Component
public class CountryMapperImpl implements CountryMapper {

	@Autowired
	private RegionServices regionServices;
	
	@Override
	public Country getConvertFromDtoCountryToEntityCountry(CountryDto countryDto) {
		Country country = new Country();
		country.setCountryName(countryDto.getCountryName());
		Region region = regionServices.findByRegionId(countryDto.getRegionDto().getId());
		country.setRegion(region);
		return country;
	}

	@Override
	public CountryDto getConvertFromEntityCountryToDtoCountry(Country country) {
		CountryDto countryDto = new CountryDto();
		countryDto.setId(country.getId());
		countryDto.setCountryName(country.getCountryName());
		
		RegionDto regionDto = new RegionDto();
		regionDto.setId(country.getRegion().getId());
		regionDto.setRegionName(country.getRegion().getRegionName());
		
		RegionTypeDto regionTypeDto = new RegionTypeDto();
		regionTypeDto.setId(country.getRegion().getRegionType().getId());
		regionTypeDto.setRegionTypeName(country.getRegion().getRegionType().getRegionTypeName());
		
		regionDto.setRegionTypeDto(regionTypeDto);
		countryDto.setRegionDto(regionDto);
		return countryDto;
	}

}
