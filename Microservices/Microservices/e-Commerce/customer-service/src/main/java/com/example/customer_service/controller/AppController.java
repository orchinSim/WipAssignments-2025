package com.example.customer_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer_service.model.Customer;
import com.example.customer_service.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class AppController {
	
	@Autowired
	CustomerService customerService;
	
	//2
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	//1
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomers();
	}
	//3
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		System.out.println(" inside getCustomerById");
		Customer customer = customerService.getCustomerById(id);
		if(customer == null) {
		//	throw new CustomerNotFoundException("Customer not found with '"+id+"'");
		}
		return  new ResponseEntity<Customer>(customer,HttpStatus.OK) ;
	}
	//4
	@PutMapping("/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id)  {
		Customer existingCustomer = customerService.getCustomerById(id);
    	existingCustomer.setName(customer.getName());
    	existingCustomer.setPassword(customer.getPassword());
    	existingCustomer.setEmail(customer.getEmail());
    	
    	Customer result = customerService.saveCustomer(existingCustomer);
    	
    	return result;
	}
	//5
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return "Customer deleted with this "+id;
	}
	
	//6
	@GetMapping("/byName/{name}")
	public ResponseEntity<?> getCustomerByName(@PathVariable String name)  {
		/*
		 * Customer c = customerService.getCustomerByName(name); if(c!= null) { return
		 * ResponseEntity.status(HttpStatus.CREATED).body(c); } return
		 * ResponseEntity.status(HttpStatus.CREATED).body(new
		 * RuntimeException("Customer Not found"));
		 */
		
		Customer c = customerService.getCustomerByName(name);
		if(c == null) {
		//	throw new CustomerNotFoundException("Customer not found with '"+name+"'");
		}
		 return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}
	//7
	@GetMapping("/byNameAndEmail/{name}")
	public Customer getCustomerByName(@PathVariable String name, @RequestParam String email) {
		return customerService.getCustomerByNameAndEmail(name,email);
	}
	//8
	@GetMapping("/byNameStarts/{prefix}")
	public List<Customer> getCustomerByNameStartsWith(@PathVariable String prefix) {
		return customerService.getCustomerByNameStartsWith(prefix);
	}
	//9
	@GetMapping("/byCountNameStarts/{prefix}")
	public long countCustomerByNameStartsWith(@PathVariable String prefix) {
		return customerService.countCustomerByNameStartsWith(prefix);
	}
	//10
	//list of customers whose emails are ends with @gmail.com 
	@GetMapping("/byDomain/{domain}")
	public List<Customer> getCustomersByDomain(@PathVariable String domain) {
		return customerService.getCustomersByDomain(domain);
	}
	//11
	@GetMapping("/minAgeCustomer")
	public Customer getMinAgeCustomer() {
		return customerService.getMinAgeCustomer();
	}
}
