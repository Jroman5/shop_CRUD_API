package com.jroman5.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jroman5.api.Model.Order;
import com.jroman5.api.repository.OrderRepository;
@Service
public class OrderService {

    private OrderRepository or;


    @Autowired
    public OrderService(OrderRepository repo){
        this.or = repo;
    }

    public Order getOrder(Integer orderId){
        Order res = or.getReferenceById(orderId);
        return res;
    }



}
