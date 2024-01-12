package com.vodafone.uc1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vodafone.uc1.domain.Region;
import com.vodafone.uc1.domain.RegionType;
import com.vodafone.uc1.dto.RegionDto;
import com.vodafone.uc1.exceptions.EntityNotFoundException;
import com.vodafone.uc1.exceptions.RegionTypeListEmptyException;
import com.vodafone.uc1.repository.RegionRepository;
import com.vodafone.uc1.service.RegionServices;
import com.vodafone.uc1.service.RegionTypeService;

@Service
public class RegionServiceImpl implements RegionServices {
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private RegionTypeService regionTypeService;
	

	@Override
	public Region addRegion(RegionDto regionDto) {
		Region region = new Region();
		region.setRegionName(regionDto.getRegionName());
		RegionType regionType = regionTypeService.findByRegionTypeId(regionDto.getRegionTypeDto().getId());
		region.setRegionType(regionType);
		
		return regionRepository.save(region);
	}

	@Override
	public List<Region> findAllRegion() {
		List<Region> regionList = regionRepository.findAll();
		
		if (regionList == null || regionList.isEmpty()) {
			new RegionTypeListEmptyException("Region List Not Found.");
		}
		
		return regionList;
	}

	@Override
	public Region findByRegionId(int regionId) {
		Region region =  regionRepository.findById(regionId)
	               .orElseThrow(() -> new EntityNotFoundException("region Not Found with id : " + regionId));
	        return region;
	}

	@Override
	public void deleteRegion(Integer regionId) {
		Region region =  findByRegionId(regionId);
		if (region == null) {
			new EntityNotFoundException("regionType Not Found with id : " + regionId);
		} else {
			regionRepository.deleteById(regionId);
		}
	}

	@Override
	public Region updateRegion(RegionDto regionDto) {
		Region region = findByRegionId(regionDto.getId());
        region.setRegionName(regionDto.getRegionName());
        RegionType regionType = regionTypeService.findByRegionTypeId(regionDto.getRegionTypeDto().getId());
		region.setRegionType(regionType);

        return regionRepository.save(region);
	}

}
