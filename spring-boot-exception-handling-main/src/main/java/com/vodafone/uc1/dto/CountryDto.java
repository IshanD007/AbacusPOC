package com.vodafone.uc1.dto;

public class CountryDto {
	
	private Integer id;
    private String countryName;
    private RegionDto regionDto;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public RegionDto getRegionDto() {
		return regionDto;
	}
	public void setRegionDto(RegionDto regionDto) {
		this.regionDto = regionDto;
	}

}
