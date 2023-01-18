package com.greatLearning.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.crm.dao.CustomerDAO;
import com.greatLearning.crm.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public List<Customer> listCustomers() {
		return customerDAO.listCustomers();
	}
	
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}
	
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	public Customer getCustomerById(int id) {
		return customerDAO.getCustomerById(id);
	}
	
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomerById(customer);
	}

}
