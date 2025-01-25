package com.jroman5.api.service;

import com.jroman5.api.Model.DTO.CustomerDTO;
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
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
    this.mp = modelMapper;
    }

    public Product saveProduct(Product product){
        Product productSaved = pr.save(product);
        return productSaved;
    }

    public Product getProductById(Long id){
        Product fetchedProduct = pr.getReferenceById(id);
        return fetchedProduct;
    }

    public void deleteProductById(Long id){
        if(pr.existsById(id)) {
            pr.deleteById(id);
        }
    }

}
