package com.jroman5.api.controller;

import com.jroman5.api.Model.Customer;
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
    public ResponseEntity<Orders> saveOrder(@RequestBody Orders order){
        Orders res = null;
        res = os.saveOrder(order);
        return ResponseEntity.status(200).body(res);
    }

    @PostMapping("/item")
    public ResponseEntity<Item> saveItem(@RequestBody Item olir){
        Item res = olis.saveOrderListItem(olir);
        return ResponseEntity.status(200).body(res);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        Customer res = null;
        res = cs.saveCustomer(customer);
        return ResponseEntity.status(200).body(res);
    }
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product res = null;
        res = ps.saveProduct(product);
        return ResponseEntity.status(200).body(product);
    }
    
    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id){
        Item res = olis.getItem(id);
        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Customer res = cs.getCustomerByid(id);
        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product res = ps.getProductById(id);
        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id){
        Orders res = os.getOrderById(id);
        return ResponseEntity.status(200).body(res);
    }
}
