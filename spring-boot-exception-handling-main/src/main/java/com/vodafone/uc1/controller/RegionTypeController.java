package com.vodafone.uc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.uc1.domain.RegionType;
import com.vodafone.uc1.dto.RegionTypeDto;
import com.vodafone.uc1.service.RegionTypeService;

@RestController
@RequestMapping("/api/regionTypes")
public class RegionTypeController {

	@Autowired
	private RegionTypeService regionTypeService;
	
    @GetMapping("/{regionTypeId}")
    public ResponseEntity<RegionType> findUserById(@PathVariable("regionTypeId") int regionTypeId) {
        RegionType regionType = regionTypeService.findByRegionTypeId(regionTypeId);

        return new ResponseEntity<>(regionType,HttpStatus.OK);
    }

	@PostMapping("/addRegionType")
    public ResponseEntity<RegionType> addRegionType(@RequestBody RegionTypeDto regionTypeDto) {
        RegionType regionType = regionTypeService.addRegionType(regionTypeDto);

        return new ResponseEntity<>(regionType, HttpStatus.CREATED);
    }
    
    @GetMapping("/findRegionTypes")
    public ResponseEntity<List<RegionType>> findRegionTypeList() {
    	List<RegionType> regionTypeList = regionTypeService.findAllRegionType();

        return new ResponseEntity<>(regionTypeList,HttpStatus.OK);
    }
    
    @PutMapping("/updateRegionType")
    public ResponseEntity<RegionType> updateRegionType(@RequestBody RegionTypeDto regionTypeDto) {
    	RegionType regionType = regionTypeService.updateRegionType(regionTypeDto);

        return new ResponseEntity<>(regionType, HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/deleteRegionType/{regionTypeId}")
    public ResponseEntity<String> deleteRegionTypeById(@PathVariable("regionTypeId") int regionTypeId) {
    	regionTypeService.deleteRegionType(regionTypeId);;

        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
