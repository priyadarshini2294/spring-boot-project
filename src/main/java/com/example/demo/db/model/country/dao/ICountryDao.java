package com.example.demo.db.model.country.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.db.model.country.pojo.Country;

@Repository
public interface ICountryDao {
	
    long insert(Country country) throws Exception;

    List<Map<String, Object>> getAllCountries() throws Exception;
}
