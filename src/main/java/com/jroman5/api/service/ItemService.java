package com.jroman5.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jroman5.api.Model.DTO.ItemDTO;
import com.jroman5.api.Model.Item;
import com.jroman5.api.Model.Orders;
import com.jroman5.api.repository.ItemRepository;
import com.jroman5.api.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ItemService {
    private ItemRepository olir;
    private OrderService os;
    private ModelMapper mp;

    public ItemService(){}

    @Autowired
    public void setOrderListItemRepo(ItemRepository olir){
        this.olir = olir;
        this.mp = new ModelMapper();
    }

    @Autowired
    public void setOrderService(OrderService orderService){
        this.os = orderService;
    }

    public ItemDTO saveOrderListItem(Item oli){
        Item itemSaved = olir.save(oli);
        Orders order = itemSaved.getOrderId();

        order.setTotal(order.getTotal().add(itemSaved.getTotalCost()));
        os.saveOrder(order);

        ItemDTO res = this.mp.map(itemSaved, ItemDTO.class);
        return res;
    }

    public ItemDTO getItem(Long id){
        Item itemFetched = olir.getReferenceById(id);
        ItemDTO res = this.mp.map(itemFetched, ItemDTO.class);
        return res;
    }
}
