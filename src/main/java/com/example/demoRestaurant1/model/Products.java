package com.example.demoRestaurant1.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue
    private int productId;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="product_quantity")
    private int quantity;

    @Column(name="total_price_of_products")
    private int totalPrice;

}
