package com.example.dynamictable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dynamictable.model.QueryResultDetails;
import com.example.dynamictable.repository.QueryDetailsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DynamicDataController {

	@Autowired
	private QueryDetailsRepository repository;

	@GetMapping("/data")
	
	@Transactional()
	public QueryResultDetails getData(@RequestParam(required = false) boolean getAllData) {
		return repository.getData(getAllData);
	}

}
