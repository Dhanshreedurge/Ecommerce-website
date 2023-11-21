package com.ewa.project.controller;

import com.ewa.project.model.CustomerDto;
import com.ewa.project.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long customerId) {
        CustomerDto customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) {
        CustomerDto updatedCustomer = customerService.updateCustomer(customerId, customerDto);
        return ResponseEntity.ok(updatedCustomer);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    
    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
    	 return customerService.deleteCustomer(customerId); 
    }
}
