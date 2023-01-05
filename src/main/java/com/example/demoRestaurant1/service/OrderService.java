package com.example.demoRestaurant1.service;


import com.example.demoRestaurant1.Dto.OrderDto;
import com.example.demoRestaurant1.model.Order;

import java.util.List;

public interface OrderService {
    public Order saveOrder(Order order);
    public Order getOrderById(int orderId);
    public List<Order> getAllOrders();
    public Order updateOrder( Order order,int orderId);
    public void deleteOrder(int orderId);





    OrderDto createOrdertoAyable(OrderDto orderDto);
}
