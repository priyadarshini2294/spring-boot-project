package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.db.model.country.pojo.Country;
import com.example.demo.service.ICountryService;
import com.example.demo.ws.rest.CountryRestService;

@SpringBootTest(classes={TestWebApp.class})
class TestWebApp {

	@Mock
	ICountryService countryService;
	
	@InjectMocks
	CountryRestService countryRestService;
	
	@Test
	@Order(1)
	 void test_getAllCountries() {
		
		List<Map<String, Object>> countries;
		
		countries = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		Country con = new Country(1 , "India", "Bogadhi");
		
		map.put("con1", con);
		countries.add(map);
		
		try {
			when(countryService.getAllCountries()).thenReturn(countries);
			
			List<Map<String, Object>> result = countryRestService.getAllCountries();
			
			assertEquals(1, result.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	@Order(1)
	 void test_getCountryById() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Country con = new Country(1 , "India", "Bogadhi");
		
		map.put("con", con);
		
		System.out.println(map);
		
		long id = 1;
		
		when(countryService.getCountryData(id)).thenReturn(map);
		
		Map<String, Object> result = countryRestService.getCountryDataById(id);
		
		Country con1 = (Country) result.get("con");

		System.out.println(con1.getName());
		
		assertEquals("India", con1.getName());
	}
}
