package com.jroman5.api.controller;

import com.jroman5.api.Model.Customer;
import com.jroman5.api.Model.OrderListItem;
import com.jroman5.api.Model.Orders;
import com.jroman5.api.Model.Product;
import com.jroman5.api.service.CustomerService;
import com.jroman5.api.service.OrderListItemService;
import com.jroman5.api.service.OrderService;
import com.jroman5.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    private CustomerService cs;
    private OrderService os;

    private ProductService ps;

    private OrderListItemService olis;

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
    public void setOlis(OrderListItemService olis){
        this.olis = olis;
    }

    @PostMapping("/order")
    public ResponseEntity<Orders> saveOrder(@RequestBody Orders order){
        Orders res = null;
        res = os.saveOrder(order);
        return ResponseEntity.status(200).body(res);
    }

    @PostMapping("/item")
    public ResponseEntity<OrderListItem> saveOrderListItem(@RequestBody OrderListItem olir){
        OrderListItem res = olis.saveOrderListItem(olir);
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
}
