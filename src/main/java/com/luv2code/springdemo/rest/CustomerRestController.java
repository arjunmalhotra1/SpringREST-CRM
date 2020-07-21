package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	//Autowire the customer service
	@Autowired
	private CustomerService customerService;//Injects the dependency
	
	
	//Add mapping for the GET, /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
		
	}
	
	//Add mapping for the GET, /customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId)
	{
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if(theCustomer==null)
		{
			throw new CustomerNotFoundException("Customer id not found - "+customerId);
		}
		
		return theCustomer; 
		
	}
	
	//Add mapping for POST /customers - add new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer)
	{
		//Also just in case the client passes an id in JSON ... set id to 0
		//This is force a save of new item ... instead of update
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	//Add mapping for PUT /customers -update existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer)
	{
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	//add mapping for DELETE, /customers/{customerId} - delete customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId)
	{
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		// throw exception if null
		if(tempCustomer==null)
		{
			throw new CustomerNotFoundException("Customer id not found "+customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Delete customer id - "+customerId;
	}
	
	

}
