package com.example.demo.ws.rest;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	        } catch (SQLException e) {
	        	e.getLocalizedMessage();
	        }

	        return result;
	    }
	    
	    @GetMapping(value = "/country/by/id",produces = { MediaType.APPLICATION_JSON_VALUE })
	    public Map<String, Object> getCountryDataById( @RequestParam( value = "id",
                required = true) long id){

	       Map<String, Object> result = null;

	        try {

	        	result = countryService.getCountryData(id);
	        	
	        } catch (EmptyResultDataAccessException e) {
	        	e.getLocalizedMessage();
	        }

	        return result;
	    }
}
