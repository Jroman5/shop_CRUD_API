package com.jroman5.api.service.dtoMapper;

import com.jroman5.api.Model.Customer;
import com.jroman5.api.Model.DTO.CustomerDTO;
import com.jroman5.api.Model.DTO.ItemDTO;
import com.jroman5.api.Model.DTO.OrderDTO;
import com.jroman5.api.Model.DTO.ProductDTO;
import com.jroman5.api.Model.Item;
import com.jroman5.api.Model.Orders;
import com.jroman5.api.Model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ObjectDTOService {
    ModelMapper mp;

    public ObjectDTOService(ModelMapper mapper){
        this.mp = mapper;
    }

    public ItemDTO mapItem(Item item){
        return this.mp.map(item, ItemDTO.class);
    }

    public CustomerDTO mapCustomer(Customer customer){
        return this.mp.map(customer, CustomerDTO.class);
    }

    public OrderDTO mapOrders(Orders order){
        return this.mp.map(order, OrderDTO.class);
    }

    public ProductDTO mapProduct(Product product){
        return this.mp.map(product, ProductDTO.class);
    }
}
