package com.martin.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //POST
    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        //if email already exists. throw an error.
        if (customerOptional.isPresent()){
            throw new IllegalStateException("Error: Email already taken, please use a different email.");
        }
        //else
        customerRepository.save(customer);
    }

    //GET
    public List<Customer> getCustomers() {
        return  customerRepository.findAll();
    }
}
