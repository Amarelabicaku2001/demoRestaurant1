package com.example.demoRestaurant1.Controller;


import com.example.demoRestaurant1.model.Products;
import com.example.demoRestaurant1.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "products")

public class ProductsController {
    @Autowired
    ProductsService productsService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Products> saveProducts(@RequestBody Products products) {
        return new ResponseEntity<Products>(productsService.saveProducts(products), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/find/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Products> getProductsbyId(@PathVariable int productId) {
        return new ResponseEntity<Products>(productsService.getProductsById(productId), HttpStatus.OK);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Products>> getAllProducts() {
        return new ResponseEntity<List<Products>>(productsService.getAllProducts(), HttpStatus.OK);
    }

}
