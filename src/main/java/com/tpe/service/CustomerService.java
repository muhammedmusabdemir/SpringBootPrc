package com.tpe.service;

import com.tpe.domain.Customer;
import com.tpe.exception.ConflictException;
import com.tpe.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void saveCustomer(Customer customer) {
        boolean isExistCustomer = customerRepository.existsByEmail(customer.getEmail());

        if (isExistCustomer) {
            throw new ConflictException("Customer already exist by " + customer.getEmail());
        }

        customerRepository.save(customer);
    }
}
