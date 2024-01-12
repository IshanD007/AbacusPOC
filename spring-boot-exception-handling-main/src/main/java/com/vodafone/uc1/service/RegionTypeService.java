package com.vodafone.uc1.service;

import java.util.List;

import com.vodafone.uc1.domain.RegionType;
import com.vodafone.uc1.dto.RegionTypeDto;

public interface RegionTypeService {

	RegionType addRegionType(RegionTypeDto regionTypeDto);
    
    List<RegionType> findAllRegionType();
    
    RegionType findByRegionTypeId(int regionTypeId);
    
    void deleteRegionType(Integer regionTypeId);
    
    RegionType updateRegionType(RegionTypeDto regionTypeDto);
}
