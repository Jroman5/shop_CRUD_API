package com.jroman5.api.service;

import com.jroman5.api.Model.Customer;
import com.jroman5.api.Model.DTO.CustomerDTO;
import com.jroman5.api.Model.DTO.OrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jroman5.api.Model.Orders;
import com.jroman5.api.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository or;
    private CustomerService cs;
    private ModelMapper mp;



    public OrderService(){

    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        this.mp = modelMapper;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepo){
        this.or = orderRepo;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.cs = customerService;
    }

    public OrderDTO getOrderById(Long orderId){
        Orders orderFetched = or.getReferenceById(orderId);
        OrderDTO res = this.mp.map(orderFetched, OrderDTO.class);
        return res;
    }

    public OrderDTO saveOrder(Orders order){
        Orders orderSaved = or.save(order);
        Customer customer = mp.map(cs.getCustomerByid(orderSaved.getCustomer_id().getId()), Customer.class);
        List<Orders> orders = customer.getOrders();
        if(orders != null){
            for(Orders od: orders){
                if(od.getId() == orderSaved.getId()){
                    orders.remove(od);
                    orders.add(orderSaved);
                    break;
                }
            }
        }

        customer.setOrders(orders);
        cs.saveCustomer(customer);
        OrderDTO res = mp.map(orderSaved, OrderDTO.class);
        return res;
    }



}
