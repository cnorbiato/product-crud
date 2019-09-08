package com.norbiato.core.product.service;

import com.norbiato.core.product.domain.Product;
import com.norbiato.core.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List getAllProducts(){
        List products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).orElseGet(Product::new);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Long id, Product product){
        productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
