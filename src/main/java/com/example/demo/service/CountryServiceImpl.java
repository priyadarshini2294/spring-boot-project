package com.example.demo.service;

import com.example.demo.db.model.country.dao.ICountryDao;
import com.example.demo.db.model.country.pojo.Country;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private ICountryDao countryDao;

    @Override
    public List<Map<String, Object>> getAllCountries()
            throws Exception {

        List<Map<String, Object>> result = null;

        try {

        	result = countryDao
                    .getAllCountries();

        } catch (EmptyResultDataAccessException e) {
            return null;

        } catch (DataAccessException e) {
            return null;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return result;
    }

}