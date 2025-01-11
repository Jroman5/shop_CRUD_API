package com.jroman5.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jroman5.api.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    //getbyid()
    //getbyname()
}
