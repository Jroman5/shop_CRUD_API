package com.jroman5.api.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jroman5.api.Model.Item;
import com.jroman5.api.Model.Orders;
import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemDTO {

    private Long id;
    private Long orderId;
    private Integer itemId;
    private Integer quantity;
    private BigDecimal cost;

    public ItemDTO(Long id, Long orderId, Integer itemId, Integer quantity, BigDecimal cost) {
        this.id = id;
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public ItemDTO() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}




