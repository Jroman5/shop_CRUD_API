package com.jroman5.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jroman5.api.Model.DTO.CustomerDTO;
import com.jroman5.api.Model.DTO.ItemDTO;
import com.jroman5.api.Model.Item;
import com.jroman5.api.Model.Orders;
import com.jroman5.api.repository.ItemRepository;
import com.jroman5.api.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ItemService {
    private ItemRepository olir;
    private OrderService os;

    public ItemService(){}

    @Autowired
    public void setOrderListItemRepo(ItemRepository olir){
        this.olir = olir;
    }

    @Autowired
    public void setOrderService(OrderService orderService){
        this.os = orderService;
    }

    public Item saveOrderListItem(Item oli){
        Item itemSaved = olir.save(oli);
        Orders order = os.getOrderById(itemSaved.getId());

        order.setTotal(order.getTotal().add(itemSaved.getTotalCost()));
        os.saveOrder(order);


        return itemSaved;
    }

    public List<Item> getAllItems(){
        List<Item> res = olir.findAll();
        return res;
    }

    public Item getItem(Long id){
        Item itemFetched = olir.getReferenceById(id);
        return itemFetched;
    }

    public void deleteItemById(Long id){
        if(olir.existsById(id)) {
            olir.deleteById(id);
        }
    }
}
