package com.citius.dto;

public class Company {

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(Integer id, String companyName, String address) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.address = address;
	}

	private Integer id;
	private String companyName;
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
