package com.example.demoRestaurant1.service;


import com.example.demoRestaurant1.model.Products;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductsService {
    public Products saveProducts(Products products);
    public Products getProductsById(int productId);
    public List<Products> getAllProducts();


}
