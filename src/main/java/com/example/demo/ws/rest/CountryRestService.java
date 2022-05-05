package com.example.demo.ws.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ICountryService;

@RestController
public class CountryRestService {

	 @Autowired
	 private ICountryService countryService;

	    @GetMapping(
	            value = "/countries",
	            produces = { MediaType.APPLICATION_JSON_VALUE })
	    public List<Map<String, Object>> getAllCountries(){

	        List<Map<String, Object>> result = null;

	        try {

	        	result = countryService.getAllCountries();

	        } catch (Exception e) {
	        	e.printStackTrace();
	        }

	        return result;
	    }
}
