package com.jroman5.api.repository;

import com.jroman5.api.Model.OrderListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListItemRepository extends JpaRepository<OrderListItem,Integer> {
}
