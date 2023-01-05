package com.example.demoRestaurant1.ServiceImpl;


import com.example.demoRestaurant1.Dto.OrderDto;
import com.example.demoRestaurant1.exception.NotFound;
import com.example.demoRestaurant1.model.Order;
import com.example.demoRestaurant1.model.RestaurantTable;
import com.example.demoRestaurant1.model.User;
import com.example.demoRestaurant1.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class OrderSerivceImpl implements OrderService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Order saveOrder(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    @Transactional
    public Order getOrderById(int orderId) {
        Order order = entityManager.find(Order.class, orderId);
        if (order == null)
            throw new NotFound("Order", "orderId", orderId);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return entityManager.createQuery("Select orders from Order orders").getResultList();
    }

    @Override
    public Order updateOrder(Order order, int orderId) {
        Order order1 = entityManager.find(Order.class, orderId);
        if (order1 == null)
            throw new NotFound("Order", "orderId", orderId);
        return entityManager.merge(order);
    }

    @Override
    public void deleteOrder(int orderId) {
        Order order1 = entityManager.find(Order.class, orderId);
        if (order1 == null)
            throw new NotFound("Order", "orderId", orderId);
        entityManager.remove(order1);
    }

    @Override
    @Transactional
    public OrderDto createOrdertoAyable(OrderDto orderDto) {


        RestaurantTable restaurantTable = entityManager.find(Order.class, orderDto.getRestaurantTable().getRestaurantTableId()).getRestaurantTable();
        orderDto.setRestaurantTable(restaurantTable);
User user=entityManager.find(User.class,orderDto.getUser().getUserId());
orderDto.setUser(user);
//Dish dish=entityManager.find(Dish.class,orderDto.getDish().getDishId());
//orderDto.setDish(dish);

        if (restaurantTable == null &&user==null ) {
            throw new RuntimeException("we cant create order ");


        }
        Order order = new Order();
        mapDtoToEntity(orderDto, order);
        entityManager.persist(order);
        return mapEntiyToDto(order);
    }

    private OrderDto mapEntiyToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        orderDto.setName(order.getName());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setDateCreated(order.getDateCreated());
        orderDto.setRestaurantTable(order.getRestaurantTable());
        orderDto.setUser(order.getUser());
         orderDto.setDishList(order.getDish());
        return orderDto;
    }

    private Order mapDtoToEntity(OrderDto orderDto, Order order) {
        order.setOrderId(orderDto.getOrderId());
        order.setName(orderDto.getName());
        order.setQuantity(orderDto.getQuantity());
        order.setDateCreated(orderDto.getDateCreated());
        order.setRestaurantTable(orderDto.getRestaurantTable());
        order.setUser(orderDto.getUser());
       order.setDish(orderDto.getDishList());
        return order;
    }
}


