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

import com.vodafone.uc1.domain.Region;
import com.vodafone.uc1.dto.RegionDto;
import com.vodafone.uc1.service.RegionServices;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

	@Autowired
    private RegionServices regionService;

    @GetMapping("/{regionId}")
    public ResponseEntity<Region> findRegionById(@PathVariable("regionId") int regionId) {
        Region region = regionService.findByRegionId(regionId);

        return new ResponseEntity<>(region,HttpStatus.OK);
    }
    
    @PostMapping("/addRegion")
    public ResponseEntity<Region> addRegion(@RequestBody RegionDto regionDto) {
        Region region = regionService.addRegion(regionDto);

        return new ResponseEntity<>(region, HttpStatus.CREATED);
    }
    
    @GetMapping("/findRegions")
    public ResponseEntity<List<Region>> findRegionList() {
    	List<Region> regionList = regionService.findAllRegion();

        return new ResponseEntity<>(regionList,HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteRegion/{regionId}")
    public ResponseEntity<String> deleteById(@PathVariable("regionId") int regionId) {
    	regionService.deleteRegion(regionId);;

        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
    
    @PutMapping("/updateRegion")
    public ResponseEntity<Region> updateRegion(@RequestBody RegionDto regionDto) {
    	Region region = regionService.updateRegion(regionDto);

        return new ResponseEntity<>(region, HttpStatus.ACCEPTED);
    }
}
