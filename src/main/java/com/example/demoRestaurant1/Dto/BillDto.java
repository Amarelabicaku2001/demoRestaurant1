package com.example.demoRestaurant1.Dto;


import com.example.demoRestaurant1.model.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BillDto {

    private int billId;

    private String name;

    private LocalDateTime date;

    private int totalPrice;
    private Order order;
}
