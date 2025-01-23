package com.jroman5.api.controller;

import com.jroman5.api.Model.Customer;
import com.jroman5.api.Model.DTO.CustomerDTO;
import com.jroman5.api.Model.DTO.ItemDTO;
import com.jroman5.api.Model.DTO.OrderDTO;
import com.jroman5.api.Model.DTO.ProductDTO;
import com.jroman5.api.Model.Item;
import com.jroman5.api.Model.Orders;
import com.jroman5.api.Model.Product;
import com.jroman5.api.service.CustomerService;
import com.jroman5.api.service.ItemService;
import com.jroman5.api.service.OrderService;
import com.jroman5.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {
    private CustomerService cs;
    private OrderService os;

    private ProductService ps;

    private ItemService olis;

    public StoreController(){
    }

    @Autowired
    public void setCs(CustomerService cs) {
        this.cs = cs;
    }

    @Autowired
    public void setOs(OrderService os) {
        this.os = os;
    }

    @Autowired
    public void setPs(ProductService ps){
        this.ps = ps;
    }

    @Autowired
    public void setOlis(ItemService olis){
        this.olis = olis;
    }

    @PostMapping("/order")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody Orders order){
        OrderDTO res;
        res = os.saveOrder(order);
        System.out.println(res.toString());
        System.out.println(res.getItems().toString());
        return ResponseEntity.status(200).body(res);
    }

    @PostMapping("/item")
    public ResponseEntity<ItemDTO> saveItem(@RequestBody Item olir){
        ItemDTO res = olis.saveOrderListItem(olir);
        System.out.println(res.toString());
        return ResponseEntity.status(200).body(res);
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody Customer customer){
        CustomerDTO res;
        res = cs.saveCustomer(customer);
        System.out.println(res.toString());
        System.out.println(res.getOrders().toString());
        return ResponseEntity.status(200).body(res);
    }
    @PostMapping("/product")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody Product product){
        ProductDTO res = null;
        res = ps.saveProduct(product);
        System.out.println(res.toString());
        return ResponseEntity.status(200).body(res);
    }
    
    @GetMapping("/item/{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable Long id){
        ItemDTO res = olis.getItem(id);
        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id){
        CustomerDTO res = cs.getCustomerByid(id);
        System.out.println(res.toString());
        System.out.println(res.getOrders().toString());
        System.out.println(res.getOrders().get(0).getCustomerId().toString());
        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        ProductDTO res = ps.getProductById(id);
        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id){
        OrderDTO res = os.getOrderById(id);
        System.out.println(res.getItems().toString());
        return ResponseEntity.status(200).body(res);
    }
//    TODO: add PutMappings for all the objects to update them in teh database using the endpoints. Pass the data in the body
}
