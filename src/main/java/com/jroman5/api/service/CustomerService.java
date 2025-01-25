package com.jroman5.api.service;

import com.jroman5.api.Model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jroman5.api.repository.CustomerRepository;

import java.util.List;


@Service
public class CustomerService {
    private CustomerRepository cr;

    public CustomerService(){
    }

    @Autowired
    public void setCustomerRepo(CustomerRepository repo){
        this.cr = repo;
    }


    public Customer getCustomerByid(Long id){
        Customer customer = cr.getReferenceById(id);
        System.out.println(customer.toString());
        return customer;

    }

    public List<Customer> getAllCustomers(){
        List<Customer> res = cr.findAll();
        return res;
    }

    public Customer saveCustomer(Customer customer){
        Customer customerSaved = cr.save(customer);
        return customerSaved;
    }
    public void deleteCustomerById(Long id){
        if(cr.existsById(id)) {
            cr.deleteById(id);
        }
    }
}
