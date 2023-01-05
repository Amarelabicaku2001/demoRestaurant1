package com.example.demoRestaurant1.ServiceImpl;


import com.example.demoRestaurant1.exception.NotFound;
import com.example.demoRestaurant1.model.Products;
import com.example.demoRestaurant1.service.ProductsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Products saveProducts(Products products) {
        entityManager.persist(products);
        return products;
    }

    @Override
    @Transactional
    public Products getProductsById(int productId) {
        Products products = entityManager.find(Products.class, productId);
        if (products == null)
            throw new NotFound("Products", "productId", productId);
        return products;
    }

    @Override
    @Transactional
    public List<Products> getAllProducts() {

        return entityManager.createQuery("SELECT products FROM Products products")
                .getResultList();
    }

}