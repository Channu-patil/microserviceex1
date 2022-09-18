package com.citius.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.citius.dto.Company;

@FeignClient(name="http://imc5bcp9-bll.mumbai1.corp.citiustech.com:8001/", url = "http://localhost:8001/")
public interface CompanyProxy {
	@GetMapping("/getCompany/{id}")
	public Company getCompanyById(@PathVariable Integer id) ;
}
