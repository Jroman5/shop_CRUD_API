package com.jroman5.api.service;

import com.jroman5.api.Model.DTO.OrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jroman5.api.Model.Orders;
import com.jroman5.api.repository.OrderRepository;
@Service
public class OrderService {

    private OrderRepository or;
    private ModelMapper mp;


    @Autowired
    public OrderService(OrderRepository repo){
        this.or = repo;
        this.mp = new ModelMapper();
    }

    public OrderDTO getOrderById(Long orderId){
        Orders orderFetched = or.getReferenceById(orderId);
        OrderDTO res = this.mp.map(orderFetched, OrderDTO.class);
        return res;
    }

    public OrderDTO saveOrder(Orders order){
        Orders orderSaved = or.save(order);
        OrderDTO res = mp.map(orderSaved, OrderDTO.class);
        return res;
    }



}
