package com.jroman5.api.service;

import com.jroman5.api.Model.DTO.ProductDTO;
import com.jroman5.api.Model.Product;
import com.jroman5.api.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository pr;
    private ModelMapper mp;

    public ProductService(){

    }

    @Autowired
    public void setProductRepository(ProductRepository pr){
        this.pr = pr;
        this.mp = new ModelMapper();
    }

    public ProductDTO saveProduct(Product product){
        Product productSaved = pr.save(product);
        ProductDTO res = this.mp.map(productSaved, ProductDTO.class);
        return res;
    }

    public ProductDTO getProductById(Long id){
        Product fetchedProduct = pr.getReferenceById(id);
        ProductDTO res =this.mp.map(fetchedProduct, ProductDTO.class);
        return res;
    }

}
