package com.vodafone.uc1.mapper;

import com.vodafone.uc1.domain.Country;
import com.vodafone.uc1.dto.CountryDto;

public interface CountryMapper {
	public Country getConvertFromDtoCountryToEntityCountry(CountryDto countryDto);
	public CountryDto getConvertFromEntityCountryToDtoCountry(Country country);

}
