package com.citius.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citius.entity.Company;
import com.citius.repo.CompanyRepo;

@RestController
public class CompanyController {

	@Autowired
	private CompanyRepo repo;
	
//	@Value("${app.message}")
//	private String message;
	
	@PostMapping("/save")
	public ResponseEntity<Company> saveCompany(@RequestBody Company company){
		return new ResponseEntity<>(repo.save(company),HttpStatus.OK); 
	}
	
//	@GetMapping("/message")
//	public String getMessage() {
//		return this.message;
//	}
	
	@GetMapping("/getCompany/{id}")
	public Company getCompanyById(@PathVariable Integer id) {
		Optional<Company> comp= repo.findById(id);
		return comp.get();
	}
}
