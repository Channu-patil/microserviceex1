package com.citius.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.citius.dto.Company;

@FeignClient(name="COMPANY-SERVICE", url = "http://localhost:8001/")
public interface CompanyProxy {
	@GetMapping("/getCompany/{id}")
	public Company getCompanyById(@PathVariable Integer id) ;
}
