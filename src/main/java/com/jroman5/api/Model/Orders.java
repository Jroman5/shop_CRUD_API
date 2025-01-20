package com.jroman5.api.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;
import java.util.List;

@Entity
@Table(name="orders")
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name="customers_id")
    @JsonBackReference
    Customer customer;

    @Column(name= "total", precision = 6, scale = 2)
    private BigDecimal total;


    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Item> items;



    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Orders() {
        this.items = new ArrayList<>();
    }


    public Orders(Long id, Customer customer, BigDecimal total) {
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.items = new ArrayList<>();
    }




    public Orders(Customer customer, BigDecimal total) {
        this.customer = customer;
        this.total = total;
        this.items = new ArrayList<>();

    }




    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Customer getCustomer_id() {
        return customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public BigDecimal getTotal() {
        return total;
    }


    public void setTotal(BigDecimal total) {
        this.total = total;
    }





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{");
        sb.append("id=").append(id);
        sb.append(", customer_id=").append(customer.getId());
        sb.append(", product_id=").append(total);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.customer.getId());
        hash = 97 * hash + Objects.hashCode(this.total);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orders other = (Orders) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return Objects.equals(this.total, other.total);
    }

    

   
    
    

    
}
