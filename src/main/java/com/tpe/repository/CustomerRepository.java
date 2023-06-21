package com.tpe.repository;

import com.tpe.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


    boolean existsByEmail(String email);

    List<Customer> findAllByName(String name);

    List<Customer> findAllByNameAndLastName(String name, String lastName);
}
