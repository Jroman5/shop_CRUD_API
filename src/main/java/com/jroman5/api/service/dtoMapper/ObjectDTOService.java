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

import java.util.ArrayList;
import java.util.List;

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


    public List<ItemDTO> mapItem(List<Item> items){
        List<ItemDTO> res = new ArrayList<>();
        if(items != null){
            for(Item item: items){
                res.add(mapItem(item));
            }
        }
        return res;
    }

    public List<CustomerDTO> mapCustomer(List<Customer> customers){
        List<CustomerDTO> res = new ArrayList<>();
        if(customers != null){
            for(Customer customer: customers){
                res.add(mapCustomer(customer));
            }
        }
        return res;
    }

    public List<OrderDTO> mapOrders(List<Orders> orders){
        List<OrderDTO> res = new ArrayList<>();
        if(orders != null){
            for(Orders order: orders){
                res.add(mapOrders(order));
            }
        }
        return res;
    }

    public List<ProductDTO> mapProduct(List<Product> products){
        List<ProductDTO> res = new ArrayList<>();
        if(products != null){
            for(Product product: products){
                res.add(mapProduct(product));
            }
        }
        return res;
    }
}
