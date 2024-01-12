package com.vodafone.uc1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vodafone.uc1.domain.RegionType;
import com.vodafone.uc1.dto.RegionTypeDto;
import com.vodafone.uc1.exceptions.EntityNotFoundException;
import com.vodafone.uc1.exceptions.RegionTypeListEmptyException;
import com.vodafone.uc1.repository.RegionTypeRepository;
import com.vodafone.uc1.service.RegionTypeService;

@Service
public class RegionTypeServiceImpl implements RegionTypeService {

	 @Autowired
	    private RegionTypeRepository regionTypeRepository;
		
	    @Override
	    public RegionType findByRegionTypeId(int regionTypeId) {
	    	RegionType regionType =  regionTypeRepository.findById(regionTypeId)
	               .orElseThrow(() -> new EntityNotFoundException("regionType Not Found with id : " + regionTypeId));
	        return regionType;
	    }


		@Override
		public RegionType addRegionType(RegionTypeDto regionTypeDto) {
			RegionType regionType = new RegionType();
			regionType.setRegionTypeName(regionTypeDto.getRegionTypeName());
			return regionTypeRepository.save(regionType);
		}

		@Override
		public List<RegionType> findAllRegionType() {
			List<RegionType> regionTypeList = regionTypeRepository.findAll();
			
			if (regionTypeList == null || regionTypeList.isEmpty()) {
				new RegionTypeListEmptyException("regionType List Not Found.");
			}
			
			return regionTypeList;
		}

		@Override
		public void deleteRegionType(Integer regionTypeId) {
			RegionType regionType =  findByRegionTypeId(regionTypeId);
			if (regionType == null) {
				new EntityNotFoundException("RegionType Not Found with id : " + regionTypeId);
			} else {
				regionTypeRepository.deleteById(regionTypeId);
			}
		}
		
		@Override
		public RegionType updateRegionType(RegionTypeDto regionTypeDto) {
			RegionType regionType = findByRegionTypeId(regionTypeDto.getId());
	        regionType.setRegionTypeName(regionTypeDto.getRegionTypeName());

	        return regionTypeRepository.save(regionType);
		}
}
