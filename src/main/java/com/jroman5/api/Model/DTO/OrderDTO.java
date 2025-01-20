package com.jroman5.api.Model.DTO;

import org.hibernate.query.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

        private Long id;
        private Long customerId;
        private BigDecimal total;
        private List<ItemDTO> items;

    public OrderDTO(Long id, Long customerId, BigDecimal total, List<ItemDTO> items) {
        this.id = id;
        this.customerId = customerId;
        this.total = total;
        this.items = items;
    }

    public OrderDTO(Long id, Long customerId, BigDecimal total) {
        this.id = id;
        this.customerId = customerId;
        this.total = total;
        this.items = new ArrayList<>();
    }
    public OrderDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}
