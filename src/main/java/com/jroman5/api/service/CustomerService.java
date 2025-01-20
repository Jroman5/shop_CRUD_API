package com.jroman5.api.service;

import com.jroman5.api.Model.Customer;
import com.jroman5.api.Model.DTO.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jroman5.api.repository.CustomerRepository;


@Service
public class CustomerService {
    private CustomerRepository cr;
    private ModelMapper mp;

    @Autowired
    public CustomerService(CustomerRepository repo){
        this.cr = repo;
        this.mp = new ModelMapper();
    }

    public CustomerDTO getCustomerByid(Long id){
        Customer customer = cr.getReferenceById(id);
        CustomerDTO res = this.mp.map(customer, CustomerDTO.class);
        return res;

    }

    public CustomerDTO saveCustomer(Customer customer){
        Customer customerSaved = cr.save(customer);
        CustomerDTO res = this.mp.map(customerSaved, CustomerDTO.class);
        return res;
    }
}
