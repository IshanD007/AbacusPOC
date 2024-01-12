package com.vodafone.uc1.dto;

public class RegionDto {
	
	private Integer id;
	private String regionName;
	private RegionTypeDto regionTypeDto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public RegionTypeDto getRegionTypeDto() {
		return regionTypeDto;
	}
	public void setRegionTypeDto(RegionTypeDto regionTypeDto) {
		this.regionTypeDto = regionTypeDto;
	}

}
