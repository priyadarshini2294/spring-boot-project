package com.example.demo.db.model.country.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.example.demo.db.model.country.pojo.Country;

@Component
public class CountryDaoImpl implements ICountryDao{
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public long insert(Country country)  {
		
		long key = 0;
	        String query = " INSERT INTO customers ( name, address, id)"
	               + " VALUES ( ?, ?, ? )";
	        KeyHolder keyHolder = new GeneratedKeyHolder();
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection con)
	                    throws SQLException {
	                int index = 0;
	                PreparedStatement ps = con.prepareStatement(query,
	                        new String[] { "id" });

	                ps.setString(++index, country.getName());
	                ps.setString(++index, country.getAddress());
	                return ps;
	            }
	        }, keyHolder);

	        Number number = keyHolder.getKey();
	        if (number != null) {
	            key = number.longValue();
	        }
	        return key;
	    }

	@Override
	public List<Map<String, Object>> getAllCountries() {
		 List<Map<String, Object>> results = null;
	        String query = "SELECT * FROM customers";
	        results = jdbcTemplate.queryForList(query);
	        return results;
	}

	@Override
	public Map<String, Object> getCountryData(long id) {
		 Map<String, Object> result = null;
		 
		String query = "SELECT name , address, id FROM customers WHERE id = :id ";
		
		Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", id);

             result = namedParameterJdbcTemplate.queryForMap(query, parameters);
             
             return result;
	}

}
