package com.example.demoRestaurant1.Controller;


import com.example.demoRestaurant1.Dto.OrderDto;
import com.example.demoRestaurant1.model.Order;
import com.example.demoRestaurant1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<Order> findOrderById(@PathVariable int orderId) {
        return new ResponseEntity<Order>(orderService.getOrderById(orderId), HttpStatus.OK);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> findAll() {
        return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{orderId}", method = RequestMethod.PUT)
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, int orderId) {
        return new ResponseEntity<Order>(orderService.updateOrder(order, orderId), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/delete/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrder(int orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<String>("Succes", HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<OrderDto> takeOrderByWaiter(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<OrderDto>(orderService.createOrdertoAyable(orderDto), HttpStatus.OK);
    }
}

