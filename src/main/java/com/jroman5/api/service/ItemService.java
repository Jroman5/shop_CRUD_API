package com.jroman5.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jroman5.api.Model.DTO.ItemDTO;
import com.jroman5.api.Model.Item;
import com.jroman5.api.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemRepository olir;
    private ModelMapper mp;

    public ItemService(){}

    @Autowired
    public void setOrderListItemRepo(ItemRepository olir){
        this.olir = olir;
        this.mp = new ModelMapper();
    }

    public ItemDTO saveOrderListItem(Item oli){
        Item itemSaved = olir.save(oli);
        ItemDTO res = this.mp.map(itemSaved, ItemDTO.class);
        return res;
    }

    public ItemDTO getItem(Long id){
        Item itemFetched = olir.getReferenceById(id);
        ItemDTO res = this.mp.map(itemFetched, ItemDTO.class);
        return res;
    }
}
