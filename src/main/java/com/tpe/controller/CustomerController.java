package com.tpe.controller;

import com.tpe.domain.Customer;
import com.tpe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //1-Spring boot u selamlama http://localhost:8080/customers/greet

    @GetMapping("/greet")
    public String greetSpringBoot(){
        return "Hello Spring Boot";
    }

    //2-Customer oluşturma/kaydetme http://localhost:8080/customers/save

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@Valid @RequestBody Customer customer){
        customerService.saveCustomer(customer);
        String message="Customer saved successfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);

    }



}
