package com.jroman5.api.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order")
public class Order {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customer_id;

    @Column(name= "product_id")
    private Integer product_id;


    @Column(name= "quantity")
    private Integer quantity;

    public Order() {
    }


    public Order(Integer id, Integer customer_id, Integer product_id, Integer quantity) {
        this.id = id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }


    public Order(Integer customer_id, Integer product_id, Integer quantity) {
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }



    public Integer getId() {
        return this.id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getCustomer_id() {
        return customer_id;
    }


    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }


    public Integer getProduct_id() {
        return product_id;
    }


    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }


    public Integer getQuantity() {
        return quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    

   
    
    

    
}
