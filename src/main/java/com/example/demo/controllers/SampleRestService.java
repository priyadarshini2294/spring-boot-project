package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestService {
	
	@GetMapping("/")
	public String getValue(){
		return "Spring Boot Maven Project";
	}
}
