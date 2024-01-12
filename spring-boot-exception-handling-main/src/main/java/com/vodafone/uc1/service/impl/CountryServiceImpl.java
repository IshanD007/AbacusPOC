package com.vodafone.uc1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vodafone.uc1.domain.Country;
import com.vodafone.uc1.domain.Region;
import com.vodafone.uc1.dto.CountryDto;
import com.vodafone.uc1.exceptions.CountryListEmptyException;
import com.vodafone.uc1.exceptions.EntityNotFoundException;
import com.vodafone.uc1.mapper.CountryMapper;
import com.vodafone.uc1.repository.CountryRepository;
import com.vodafone.uc1.service.CountryService;
import com.vodafone.uc1.service.RegionServices;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CountryMapper countryMapper;
	
	@Autowired
	private RegionServices regionServices;

	@Override
	public Country findByCountryId(int countryId) {
		Country country =  countryRepository.findById(countryId)
	               .orElseThrow(() -> new EntityNotFoundException("Country Not Found with id : " + countryId));
	    return country;
	}

	@Override
	public Country add(CountryDto countryDto) {
		Country country = countryMapper.getConvertFromDtoCountryToEntityCountry(countryDto);
        return countryRepository.save(country);
	}

	@Override
	public List<Country> findAll() {
		List<Country> countryList = countryRepository.findAll();
		
		if (countryList == null || countryList.isEmpty()) {
			new CountryListEmptyException("Country List Not Found.");
		}
		
		return countryList;
	}

	@Override
	public void deleteCountry(Integer countryId) {
		Country country =  findByCountryId(countryId);
		if (country == null) {
			new EntityNotFoundException("User Not Found with id : " + countryId);
		} else {
			countryRepository.deleteById(countryId);
		}
	}

	@Override
	public Country update(CountryDto countryDto) {
		Country country = findByCountryId(countryDto.getId());
		country.setCountryName(countryDto.getCountryName());
		Region region = regionServices.findByRegionId(countryDto.getRegionDto().getId());
		country.setRegion(region);
		return country;
	}

}
