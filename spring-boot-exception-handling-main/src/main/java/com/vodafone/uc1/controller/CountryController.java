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

import com.vodafone.uc1.domain.Country;
import com.vodafone.uc1.dto.CountryDto;
import com.vodafone.uc1.service.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
	
	@Autowired
    private CountryService countryService;

    @GetMapping("/{countryId}")
    public ResponseEntity<Country> findCountryById(@PathVariable("countryId") int countryId) {
        Country country = countryService.findByCountryId(countryId);

        return new ResponseEntity<>(country,HttpStatus.OK);
    }
    
    @PostMapping("/addCountry")
    public ResponseEntity<Country> addCountry(@RequestBody CountryDto countryDto) {
        Country country = countryService.add(countryDto);

        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }
    
    @GetMapping("/findCountries")
    public ResponseEntity<List<Country>> findCountryList() {
    	List<Country> countryList = countryService.findAll();

        return new ResponseEntity<>(countryList,HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteCountry/{countryId}")
    public ResponseEntity<String> deleteById(@PathVariable("countryId") int countryId) {
    	countryService.deleteCountry(countryId);;

        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
    
    @PutMapping("/updateCountry")
    public ResponseEntity<Country> updateCountry(@RequestBody CountryDto countryDto) {
    	Country country = countryService.update(countryDto);

        return new ResponseEntity<>(country, HttpStatus.ACCEPTED);
    }
}
