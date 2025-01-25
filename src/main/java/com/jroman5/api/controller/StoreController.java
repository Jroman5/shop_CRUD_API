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
import com.jroman5.api.service.dtoMapper.ObjectDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {
    private CustomerService cs;
    private OrderService os;

    private ProductService ps;

    private ItemService olis;

    private ObjectDTOService objDTOMap;

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

    @Autowired
    public void setObjDTOMap(ObjectDTOService objectMap){
        this.objDTOMap = objectMap;
    }

    @PostMapping("/order")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody Orders order){
        Orders res;
        res = os.saveOrder(order);
        OrderDTO resDTO = this.objDTOMap.mapOrders(res);
        System.out.println(res.toString());
        System.out.println(res.getItems().toString());
        return ResponseEntity.status(200).body(resDTO);
    }

    @PostMapping("/item")
    public ResponseEntity<ItemDTO> saveItem(@RequestBody Item olir){
        Item res = olis.saveOrderListItem(olir);
        ItemDTO resDTO = this.objDTOMap.mapItem(res);
        System.out.println(res.toString());
        return ResponseEntity.status(200).body(resDTO);
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody Customer customer){
        Customer res;
        res = cs.saveCustomer(customer);
        CustomerDTO resDTO = this.objDTOMap.mapCustomer(res);

        return ResponseEntity.status(200).body(resDTO);
    }
    @PostMapping("/product")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody Product product){
        Product res = null;
        res = ps.saveProduct(product);
        ProductDTO resDTO = this.objDTOMap.mapProduct(res);
        System.out.println(res.toString());
        return ResponseEntity.status(200).body(resDTO);
    }
    
    @GetMapping("/item/{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable Long id){
        Item res = olis.getItem(id);
        ItemDTO resDTO = objDTOMap.mapItem(res);
        return ResponseEntity.status(200).body(resDTO);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id){
        Customer res = cs.getCustomerByid(id);
        CustomerDTO resDTO = objDTOMap.mapCustomer(res);
        System.out.println(res.toString());
//        System.out.println(res.getOrders().toString());
        return ResponseEntity.status(200).body(resDTO);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        Product res = ps.getProductById(id);
        ProductDTO resDTO = objDTOMap.mapProduct(res);
        return ResponseEntity.status(200).body(resDTO);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id){
        Orders res = os.getOrderById(id);
        OrderDTO resDTO = objDTOMap.mapOrders(res);
        System.out.println(res.getItems().toString());
        return ResponseEntity.status(200).body(resDTO);
    }

    @PutMapping("/order")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody Orders order){
        Orders res = os.getOrderById(order.getId());
        if(res != null){
            res = os.saveOrder(order);
            OrderDTO resDTO = objDTOMap.mapOrders(res);
            return ResponseEntity.status(200).body(resDTO);
        }
        else {
            // throw an exception and handle it seperately
            return ResponseEntity.status(400).body(null);
        }
    }

    @PutMapping("/item")
    public ResponseEntity<ItemDTO> updateItem(@RequestBody Item item) {
        Item res = olis.getItem(item.getId());
        if (res != null) {
            res = olis.saveOrderListItem(item);
            ItemDTO resDTO = objDTOMap.mapItem(res);
            return ResponseEntity.status(200).body(resDTO);
        } else {
            // throw an exception and handle it seperately
            return ResponseEntity.status(400).body(null);
        }
    }

    @PutMapping("/customer")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer) {
        Customer res = cs.getCustomerByid(customer.getId());
        if (res != null) {
            res = cs.saveCustomer(customer);
            CustomerDTO resDTO = objDTOMap.mapCustomer(res);
            return ResponseEntity.status(200).body(resDTO);
        } else {
            // throw an exception and handle it seperately
            return ResponseEntity.status(400).body(null);
        }
    }

    @PutMapping("/product")
    public ResponseEntity<ProductDTO> updateproduct(@RequestBody Product product) {
        Product res = ps.getProductById(product.getId());
        if (res != null) {
            res = ps.saveProduct(product);
            ProductDTO resDTO = objDTOMap.mapProduct(res);
            return ResponseEntity.status(200).body(resDTO);
        } else {
            // throw an exception and handle it seperately
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomerById(@PathVariable Long id){
        cs.deleteCustomerById(id);
        return ResponseEntity.status(200).body(null);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ProductDTO> deleteProductById(@PathVariable Long id){
        ps.deleteProductById(id);
        return ResponseEntity.status(200).body(null);
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Customer> deleteItemById(@PathVariable Long id){
        olis.deleteItemById(id);
        return ResponseEntity.status(200).body(null);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Customer> deleteOrderById(@PathVariable Long id){
        os.deleteOrderById(id);
        return ResponseEntity.status(200).body(null);
    }

//    TODO: add PutMappings for all the objects to update them in teh database using the endpoints. Pass the data in the body
}


