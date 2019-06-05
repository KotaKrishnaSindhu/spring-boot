package com.lms.code.dao;

import java.util.List;

import com.lms.code.entity.Company;

public interface CustomerDao {

	// public void save(CustomerDto c);

	public List<Company> getCustomersDetails();

	public Integer addCustomers(Company company);

	public Company getCustomerDetails(Integer customerId);

	public boolean updateCustomer(Company company);

	public boolean deleteCustomer(Company company);

}
