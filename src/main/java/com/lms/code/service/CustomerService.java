package com.lms.code.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.code.dto.CustomerDto;

@Service
public interface CustomerService {
	public List<CustomerDto> getCustomersData();

	public boolean addCustomers(CustomerDto customerDto);

	public boolean updateCustomer(CustomerDto customerDto);

	public CustomerDto getCustomersById(Integer id);

	public boolean deleteCustomer(Integer id);

}
