package com.martin.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer , Integer> { //Integer is customer id data type

    Optional<Customer> findCustomerByEmail(String email);
}
