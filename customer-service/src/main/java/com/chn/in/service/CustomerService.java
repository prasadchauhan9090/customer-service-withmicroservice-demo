package com.chn.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chn.in.exception.ResourceNotFoundException;
import com.chn.in.model.Customer;
import com.chn.in.repo.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public Customer addCutomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
		
	}


	public Customer getCustomerById(int custId) {
	
		return customerRepository.findById(custId).orElseThrow(()-> new ResourceNotFoundException("ID NOT FOUND"));
	}

	public Customer updateCustomer(Customer customer) {
	   
		Customer cust= customerRepository.findById(customer.getCustId()).orElseThrow(()-> new ResourceNotFoundException("ID NOT FOUND"));
		
		cust.setCustName(customer.getCustName());
		cust.setCustAdd(customer.getCustAdd());
		
		return customerRepository.save(customer);
		
		
		
	}

	public String deleteCustomer(int custId) {
		
		Customer cust=customerRepository.findById(custId).orElseThrow(()-> new ResourceNotFoundException("ID NOT FOUND"));
		customerRepository.delete(cust);
		return "RECORD DELETED SUCCESSFULLY";
	}

}
