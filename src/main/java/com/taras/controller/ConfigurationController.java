package com.taras.controller;

import com.taras.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taras.repository.ConfigurationRepository;
import com.taras.services.ConfigurationService;

@CrossOrigin(origins= "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class ConfigurationController {
	
	@Autowired
	private ConfigurationService configurationService;
	
	
	//get all configuration
	@GetMapping("/configuration")
	public ResponseEntity<List<Configuration>> getAllConfiguration() {
		List<Configuration> allConfiguration = configurationService.getAllConfiguration();
		return ResponseEntity.ok(allConfiguration);		
		
	}
	
	//save configuration 
	@PostMapping("/configuration")
	public ResponseEntity<Configuration> saveConfiguration(@RequestBody Configuration configuration) {
		Configuration configurationRetrieved = configurationService.saveConfiguration(configuration);
		return ResponseEntity.ok(configurationRetrieved);		 
	}

}
