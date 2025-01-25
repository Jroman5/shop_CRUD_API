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

    public Orders getOrderById(Long orderId){
        Orders orderFetched = or.getReferenceById(orderId);

        return orderFetched;
    }

    public Orders saveOrder(Orders order){
        Orders orderSaved = or.save(order);
        Customer customer = cs.getCustomerByid(order.getCustomer_id().getId());
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

        return orderSaved;
    }

    public void deleteOrderById(Long id){
        if(or.existsById(id)) {
            or.deleteById(id);
        }
    }



}
