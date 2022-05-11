package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface ICountryService {

    List<Map<String, Object>> getAllCountries() throws SQLException;
    
    Map<String, Object> getCountryData(long id);
}
