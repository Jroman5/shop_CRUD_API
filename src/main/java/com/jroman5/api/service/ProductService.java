package com.jroman5.api.service;

import com.jroman5.api.Model.Product;
import com.jroman5.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository pr;

    public ProductService(){

    }

    @Autowired
    public void setProductRepository(ProductRepository pr){
        this.pr = pr;
    }

    public Product saveProduct(Product product){
        Product res = pr.save(product);
        return res;
    }

    public Product getProductById(Long id){
        Product res = pr.getReferenceById(id);
        return res;
    }

}
