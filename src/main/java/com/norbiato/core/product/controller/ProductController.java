package com.norbiato.core.product.controller;

import com.norbiato.core.product.domain.Product;
import com.norbiato.core.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@RequestParam Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping()
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PatchMapping("/{id}")
    public void updateProduct(@RequestParam Long productId ,@RequestBody Product product){
        productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@RequestParam Long productId){
        productService.deleteProduct(productId);
    }

}
