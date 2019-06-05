package com.lms.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.code.bean.ErrorCode;
import com.lms.code.dto.CustomerDto;
import com.lms.code.dto.ResponseDto;
import com.lms.code.service.CustomerService;

@RestController
@RequestMapping(value = "/api")

public class CustomerController {

	private static final String TRUE = "true";

	private static final String FALSE = "false";

	@Autowired
	public CustomerService customerService;

	@Autowired
	public CustomerDto customerDto;

	@Autowired
	public ResponseDto responseDto;

	@RequestMapping(value = "/customer-details", method = RequestMethod.GET)
	public @ResponseBody ResponseDto getAllCustomers() {
		List<CustomerDto> customerDtoList = customerService.getCustomersData();
		if (customerDtoList != null && !customerDtoList.isEmpty()) {
			responseDto.setSuccess(TRUE);
			responseDto.setPayload(customerDtoList);
			ErrorCode error = new ErrorCode();
			error.setCode(200);
			error.setMessage("");
			responseDto.setError(error);

		} else {
			responseDto.setSuccess(FALSE);
			responseDto.setPayload(null);
			ErrorCode error = new ErrorCode();
			error.setCode(500);
			error.setMessage("No customers found");
			responseDto.setError(error);
		}
		return responseDto;

	}

	@RequestMapping(value = "/add-customers", method = RequestMethod.POST)
	public @ResponseBody ResponseDto addCustomers(@RequestBody CustomerDto customerDto) {
		if (customerService.addCustomers(customerDto)) {
			responseDto.setSuccess(TRUE);
			responseDto.setPayload(customerDto.getMessage());
			ErrorCode error = new ErrorCode();
			error.setCode(200);
			error.setMessage("");
			responseDto.setError(error);

		} else {
			responseDto.setSuccess(FALSE);
			responseDto.setPayload("Failed to add Company");
			ErrorCode error = new ErrorCode();
			error.setCode(500);
			error.setMessage(customerDto.getMessage());
			responseDto.setError(error);
		}
		return responseDto;

	}

	@RequestMapping(value = "/update-customers", method = RequestMethod.POST)
	public @ResponseBody ResponseDto updateCustomer(@RequestBody CustomerDto customerDto) {
		if (customerService.updateCustomer(customerDto)) {
			responseDto.setSuccess(TRUE);
			responseDto.setPayload(customerDto.getMessage());
			ErrorCode error = new ErrorCode();
			error.setCode(200);
			error.setMessage("");
			responseDto.setError(error);

		} else {
			responseDto.setSuccess(FALSE);
			responseDto.setPayload("Failed to update Company");
			ErrorCode error = new ErrorCode();
			error.setCode(500);
			error.setMessage(customerDto.getMessage());
			responseDto.setError(error);
		}

		return responseDto;

	}

	@RequestMapping(value = "/customer-details/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseDto getCustomerbyId(@PathVariable("id") Integer id) {
		CustomerDto customerDtoById = customerService.getCustomersById(id);
		if (customerDtoById != null) {
			responseDto.setSuccess(TRUE);
			responseDto.setPayload(customerDtoById);
			ErrorCode error = new ErrorCode();
			error.setCode(200);
			error.setMessage("");
			responseDto.setError(error);

		} else {
			responseDto.setSuccess(FALSE);
			responseDto.setPayload(null);
			ErrorCode error = new ErrorCode();
			error.setCode(500);
			error.setMessage("No customer found for given id");
			responseDto.setError(error);
		}

		return responseDto;

	}

	@RequestMapping(value = "/delete-customer/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseDto deleteCustomer(@PathVariable("id") Integer id) {
		if (customerService.deleteCustomer(3)) {
			responseDto.setSuccess(TRUE);
			responseDto.setPayload(customerDto.getMessage());
			ErrorCode error = new ErrorCode();
			error.setCode(200);
			error.setMessage("");
			responseDto.setError(error);

		} else {
			responseDto.setSuccess(FALSE);
			responseDto.setPayload("Failed to delete Company");
			ErrorCode error = new ErrorCode();
			error.setCode(500);
			error.setMessage(customerDto.getMessage());
			responseDto.setError(error);
		}

		return responseDto;
	}

}
