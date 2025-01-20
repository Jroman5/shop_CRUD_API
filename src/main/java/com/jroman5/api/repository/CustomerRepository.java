package com.jroman5.api.repository;

import com.jroman5.api.Model.DTO.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jroman5.api.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    //getbyname()
    
}
