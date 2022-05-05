package com.example.demo.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.example.demo.db.model.country.pojo.Country;

@Service
public interface ICountryService {

    List<Map<String, Object>> getAllCountries() throws Exception;
}
