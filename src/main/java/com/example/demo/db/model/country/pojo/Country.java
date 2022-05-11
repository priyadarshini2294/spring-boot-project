package com.example.demo.db.model.country.pojo;

import lombok.Data;

@Data
public class Country {

	private int id ;
	private String address;
	private String name;
	
	public Country(int id, String name, String address) {
		
		this.id = id ; 
		this.name = name;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
