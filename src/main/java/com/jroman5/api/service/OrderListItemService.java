package com.jroman5.api.service;

import com.jroman5.api.Model.OrderListItem;
import com.jroman5.api.repository.OrderListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderListItemService {
    private OrderListItemRepository olir;

    public OrderListItemService(){}

    @Autowired
    public void setOrderListItemRepo(OrderListItemRepository olir){
        this.olir = olir;
    }

    public OrderListItem saveOrderListItem(OrderListItem oli){
        OrderListItem res = olir.save(oli);
        return res;
    }
}
