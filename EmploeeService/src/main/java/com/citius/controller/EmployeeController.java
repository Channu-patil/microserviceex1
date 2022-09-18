package com.citius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.citius.dto.Company;
import com.citius.dto.EmployeeDTO;
import com.citius.entity.Employee;
import com.citius.feign.CompanyProxy;
import com.citius.repo.EmployeeRepo;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CompanyProxy companyProxy;

	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		return new ResponseEntity<>(repo.save(employee), HttpStatus.OK);
	}

	@GetMapping("/getEmployee/{id}")
	public EmployeeDTO getEmployee(@PathVariable Integer id) {
		Employee employee = repo.findById(id).get();
		Company comp = getCompanyFromFeign(employee.getCompanyId());
		return new EmployeeDTO(employee.getId(), employee.getEmpName(), employee.getAddress(), comp);
	}
	
	private Company getCompanyFromRestTemp(Integer id) {
		return restTemplate.getForObject("http://localhost:8001/getCompany/" + id, Company.class);
	}
	
	private Company getCompanyFromFeign(Integer id) {
		 return companyProxy.getCompanyById(id);
	}
}
