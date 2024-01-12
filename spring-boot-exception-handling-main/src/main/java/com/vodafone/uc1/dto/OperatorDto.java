package com.vodafone.uc1.dto;

public class OperatorDto {
	
	private Integer id;
    private String operatorName;
    private CountryDto countryDto;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public CountryDto getCountryDto() {
		return countryDto;
	}
	public void setCountryDto(CountryDto countryDto) {
		this.countryDto = countryDto;
	}

}
