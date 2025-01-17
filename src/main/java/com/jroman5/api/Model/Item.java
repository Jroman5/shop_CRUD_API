package com.jroman5.api.Model;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="order_list_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @Column(name="item_id")
    private Integer itemId;

    @Column(name="item_quantity")
    private Integer quantity;

    @Column(name= "cost", precision=5, scale=2)
    private BigDecimal cost;



    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Item(Long id, Orders order, Integer itemId, Integer quantity, BigDecimal cost){
        this.id = id;
        this.order = order;
        this.itemId = itemId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Item(Orders order, Integer itemId, Integer quantity, BigDecimal cost){
        this.order = order;
        this.itemId = itemId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Item(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrderId() {
        return order;
    }

    public void setOrderId(Orders order) {
        this.order = order;
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
                ", orderId=" + order.getId() +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item that)) return false;
        return id.equals(that.id) && order.equals(that.order) && itemId.equals(that.itemId) && quantity.equals(that.quantity) && cost.equals(that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order.getId(), itemId, quantity, cost);
    }
}
