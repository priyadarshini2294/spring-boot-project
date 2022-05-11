package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.db.model.country.dao.ICountryDao;

@Component
public class CountryServiceImpl implements ICountryService{

    @Autowired
    private ICountryDao countryDao;

    @Override
    public List<Map<String, Object>> getAllCountries()
            throws SQLException {

        List<Map<String, Object>> result = null;

        	result = countryDao
                    .getAllCountries();

        return result;
    }

	@Override
	public Map<String, Object> getCountryData(long id) {
		
		Map<String, Object> result = countryDao.getCountryData(id);
		
		return result;
	}

}