package com.vodafone.uc1.service;

import java.util.List;

import com.vodafone.uc1.domain.Region;
import com.vodafone.uc1.dto.RegionDto;

public interface RegionServices {
	
	Region addRegion(RegionDto regionDto);
    
    List<Region> findAllRegion();
    
    Region findByRegionId(int regionId);
    
    void deleteRegion(Integer regionId);
    
    Region updateRegion(RegionDto regionDto);

}
