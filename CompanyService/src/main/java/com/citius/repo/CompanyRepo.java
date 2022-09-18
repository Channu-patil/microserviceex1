package com.citius.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citius.entity.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
