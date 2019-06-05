package com.lms.code.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.code.dao.CustomerDao;
import com.lms.code.dto.CustomerDto;
import com.lms.code.entity.Company;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CustomerDto customerDto;

	@Override
	// @Bean
	public List<CustomerDto> getCustomersData() {

		List<Company> customerDaoList = customerDao.getCustomersDetails();
		List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();

		for (Company company : customerDaoList) {
			CustomerDto customerDto = new CustomerDto();
			// customerDto.setCustomerId(company.getCustomerId());
			customerDto.setCustomerName(company.getCustomerName());
			customerDto.setEmailId(company.getEmailId());
			customerDtoList.add(customerDto);
		}

		return customerDtoList;
		// List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();

		/*
		 * CustomerDto customerDto = new CustomerDto();
		 * 
		 * customerDto.setCustomerId(1); customerDto.setCustomerName("Sindhu");
		 * customerDto.setEmailId("kxk171030@utdallas.edu");
		 * 
		 * CustomerDto customerDto1 = new CustomerDto();
		 * 
		 * customerDto1.setCustomerId(1); customerDto1.setCustomerName("Harshi");
		 * customerDto1.setEmailId("harshi@utdallas.edu");
		 * customerDtoList.add(customerDto); customerDtoList.add(customerDto1);
		 */

	}

	public boolean addCustomers(CustomerDto customerDto) {

		Company addCustomer = new Company();
		// addCustomer.setCustomerId(customerDto.getCustomerId());
		addCustomer.setCustomerName(customerDto.getCustomerName());
		addCustomer.setEmailId(customerDto.getEmailId());
		int customerId = customerDao.addCustomers(addCustomer);
		if (customerId != 0) {
			customerDto.setMessage("Customer added successfully");
			return true;
		} else {
			customerDto.setMessage("Failed to add Customer");
			return false;
		}

	}

	public boolean updateCustomer(CustomerDto customerDto) {
		Company updateCustomer = customerDao.getCustomerDetails(customerDto.getCustomerId());

		// updateCustomer.setCustomerId(customerDto.getCustomerId());
		updateCustomer.setCustomerName(customerDto.getCustomerName());
		updateCustomer.setEmailId(customerDto.getEmailId());
		System.out.println(updateCustomer.getCustomerName());
		System.out.println(updateCustomer.getEmailId());
		if (customerDto.getCustomerId() != 0) {
			customerDto.setMessage("Customer updated successfully");
			return customerDao.updateCustomer(updateCustomer);
		} else {
			customerDto.setMessage("Failed to update Customer");
			return false;
		}

	}

	@Override
	public CustomerDto getCustomersById(Integer id) {
		Company customerDaoById = customerDao.getCustomerDetails(id);
		CustomerDto customerDtoById = new CustomerDto();
		// customerDto.setCustomerId(company.getCustomerId());
		customerDtoById.setCustomerName(customerDaoById.getCustomerName());
		customerDtoById.setEmailId(customerDaoById.getEmailId());
		return customerDtoById;

	}

	@Override
	public boolean deleteCustomer(Integer id) {

		Company deleteCustomer = customerDao.getCustomerDetails(id);
		boolean deleted = customerDao.deleteCustomer(deleteCustomer);
		/*
		 * deleteCustomer.setStatus("delete"); if (id != 0) {
		 * customerDto.setMessage("Customer deleted successfully"); return
		 * customerDao.updateCustomer(deleteCustomer); } else {
		 * customerDto.setMessage("Failed to delete Customer"); return false; }
		 */
		return true;

	}
}
