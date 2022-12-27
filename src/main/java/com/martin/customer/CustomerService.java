package com.martin.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //POST
    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        //if email already exists. throw an error.
        if (customerOptional.isPresent()){
            log.error("Error: Email already taken, please use a different email.");
            throw new IllegalStateException("Error: Email already taken, please use a different email.");
        }
        //else
        customerRepository.save(customer);
    }

    //GET
    public List<Customer> getCustomers() {
        return  customerRepository.findAll();
    }

    //PUT
    public void updateCustomer(Integer customerId, Customer customer){
        //get data from request
        String name = customer.getName();
        String email = customer.getEmail();
        Integer age = customer.getAge();

        //validate data
        Customer customerFromDB = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Error: Customer with id "+customerId+" does not exist."));
        if (name != null &&
                name.length() > 0
                &&
                !Objects.equals(customerFromDB.getName(), name)
        ) {

            customerFromDB.setName(name);
        }
        if (email != null &&
                email.length() > 0
                &&
                !Objects.equals(customerFromDB.getEmail(), email)
        ) {
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
            //if email already exists. throw an error.
            if (customerOptional.isPresent()){
                log.error("Error: Email already taken, please use a different email.");
                throw new IllegalStateException("Error: Email already taken, please use a different email.");
            }

            customerFromDB.setEmail(email);
        }
        if (age != null &&
                age > 0
                &&
                !Objects.equals(customerFromDB.getAge(), age)
        ) {

            customerFromDB.setAge(age);
        }
        customerRepository.save(customerFromDB);
    }
}
