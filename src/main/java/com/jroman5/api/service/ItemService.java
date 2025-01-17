package com.jroman5.api.service;

import com.jroman5.api.Model.Item;
import com.jroman5.api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemRepository olir;

    public ItemService(){}

    @Autowired
    public void setOrderListItemRepo(ItemRepository olir){
        this.olir = olir;
    }

    public Item saveOrderListItem(Item oli){
        Item res = olir.save(oli);
        return res;
    }

    public Item getItem(Long id){
        Item res = olir.getReferenceById(id);
        return res;
    }
}
