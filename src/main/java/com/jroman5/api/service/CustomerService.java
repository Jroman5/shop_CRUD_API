package com.jroman5.api.service;

import com.jroman5.api.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jroman5.api.repository.CustomerRepository;


@Service
public class CustomerService {
    private CustomerRepository cr;

    @Autowired
    public CustomerService(CustomerRepository repo){
        this.cr = repo;
    }

    public Customer getCustomerByid(Integer id){
        return cr.getReferenceById(id);

    }
}
