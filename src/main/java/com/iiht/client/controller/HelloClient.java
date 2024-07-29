package com.iiht.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController()
@RequestMapping("/rest/client")
public class HelloClient {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping
	public String connect() { 
		String url = "http://localhost:8090/rest/service";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response.toString();
	}
	
	@GetMapping(path="/add/{a}/{b}")
	public String add(@PathVariable int a,@PathVariable int b) { 
		String url = "http://localhost:8090/rest/service/add/"+a+"/"+b;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response.toString();
	}
	
	@GetMapping(path="/fact/{a}")
	public String add(@PathVariable int a) { 
		String url = "http://localhost:8090/rest/service/fact/"+a;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response.toString();
	}
}
