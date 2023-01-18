package com.greatLearning.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatLearning.crm.model.Customer;
import com.greatLearning.crm.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/")
	public String homePage(Model model) {
		List<Customer> customers = customerService.listCustomers();
		model.addAttribute("customers", customers);
		return "home-page";
	}

	@RequestMapping("/deleteUser/{id}")
	public String deleteCustomer(@PathVariable int id, Model model) {
		customerService.deleteCustomer(id);
		List<Customer> customers = customerService.listCustomers();
		model.addAttribute("customers", customers);
		return "home-page";
	}
	
	@RequestMapping("/addCustomer")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute Customer customer, Model model) {
		customerService.addCustomer(customer);
		List<Customer> customers = customerService.listCustomers();
		model.addAttribute("customers", customers);
		return "home-page";
	}
	
	@RequestMapping("/editCustomer/{id}")
	public String editCustomer(Model model, @PathVariable int id) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "edit-customer";
	}
	
	@RequestMapping("/editForm")
	public String editForm(@ModelAttribute Customer customer, Model model) {
		customerService.updateCustomer(customer);
		List<Customer> customers = customerService.listCustomers();
		model.addAttribute("customers", customers);
		return "home-page";
	}

}
