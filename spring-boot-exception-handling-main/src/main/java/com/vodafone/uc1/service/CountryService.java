package com.vodafone.uc1.service;

import java.util.List;

import com.vodafone.uc1.domain.Country;
import com.vodafone.uc1.dto.CountryDto;

public interface CountryService {
	
	    Country findByCountryId(int countryId);

	    Country add(CountryDto countryDto);

	    List<Country> findAll();
	    
	    void deleteCountry(Integer countryId);
	    
	    Country update(CountryDto countryDto);

}
