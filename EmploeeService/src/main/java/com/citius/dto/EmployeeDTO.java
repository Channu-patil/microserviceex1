package com.citius.dto;

public class EmployeeDTO {
	
	public EmployeeDTO(Integer id, String empName, String address, Company company) {
		super();
		this.id = id;
		this.empName = empName;
		this.address = address;
		this.company = company;
	}
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer id;
	private String empName;
	private String address;
	private Company company;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", empName=" + empName + ", address=" + address + ", company=" + company + "]";
	}
	
	
}
