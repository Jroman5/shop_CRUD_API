package com.jroman5.api.Model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="orders")
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customer_id;

    @Column(name= "total", precision = 6, scale = 2)
    private BigDecimal total;

    public Orders() {
    }


    public Orders(Integer id, Integer customer_id, BigDecimal total) {
        this.id = id;
        this.customer_id = customer_id;
        this.total = total;
    }


    public Orders(Integer customer_id, BigDecimal total) {
        this.customer_id = customer_id;
        this.total = total;

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
        sb.append(", customer_id=").append(customer_id);
        sb.append(", product_id=").append(total);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.customer_id);
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
        if (!Objects.equals(this.customer_id, other.customer_id)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return Objects.equals(this.total, other.total);
    }

    

   
    
    

    
}
