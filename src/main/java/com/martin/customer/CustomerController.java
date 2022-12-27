package com.martin.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired //for dependency injection. This instantiates the customer
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //http://localhost:8080/api/v1/customers/add-customer
    @PostMapping("/add-customer")
    public void registerNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

    //http://localhost:8080/api/v1/customers/customers-list
    @GetMapping("customers-list")
    public List<Customer> getAllCustomers(){
        return  customerService.getCustomers();
    }
}
