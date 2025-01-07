package com.jroman5.api.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Column(name="product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name="name")
    private String name;

    @Column(name="quantity")
    private Integer quantity;

    public Product(){

    }
    public Product(String name, Integer quantity){
        this.name = name;
        this.quantity = quantity;
        
    }
    public Product(Integer Id, String name, Integer quantity){
        this.id = Id;
        this.name = name;
        this.quantity = quantity;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String toString(){
        return "Product{ " + 
            "id: " + getId() + 
            ", name: " + getName() + 
            ", quantity: " + getQuantity() + 
            "}";

    }




    
}
