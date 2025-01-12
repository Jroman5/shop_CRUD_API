package com.jroman5.api.Model;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="order_list_item")
public class OrderListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="order_id")
    private Integer orderId;

    @Column(name="item_id")
    private Integer itemId;

    @Column(name="item_quantity")
    private Integer quantity;

    @Column(name= "cost", precision=5, scale=2)
    private BigDecimal cost;

    public OrderListItem(Integer id, Integer orderId, Integer itemId, Integer quantity, BigDecimal cost){
        this.id = id;
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public OrderListItem(Integer orderId, Integer itemId, Integer quantity, BigDecimal cost){
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public OrderListItem(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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
        return "OrderListItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderListItem that)) return false;
        return id.equals(that.id) && orderId.equals(that.orderId) && itemId.equals(that.itemId) && quantity.equals(that.quantity) && cost.equals(that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, itemId, quantity, cost);
    }
}
