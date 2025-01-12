package com.jroman5.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jroman5.api.Model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>{
    //getbyid()
    //getbyname()
}
