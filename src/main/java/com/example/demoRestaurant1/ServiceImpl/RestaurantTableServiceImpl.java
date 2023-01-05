package com.example.demoRestaurant1.ServiceImpl;


import com.example.demoRestaurant1.exception.NotFound;
import com.example.demoRestaurant1.model.RestaurantTable;
import com.example.demoRestaurant1.service.RestaurantableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class RestaurantTableServiceImpl implements RestaurantableService {

    @PersistenceContext

    private EntityManager entityManager;



    @Override
    @Transactional
    public RestaurantTable saveRestaurantTable(RestaurantTable restaurantTable) {
        entityManager.persist(restaurantTable);
        return restaurantTable;
    }

    @Override
    @Transactional
    public RestaurantTable getRestaurantTable(int restaurantTableId) {
        RestaurantTable response = entityManager.find(RestaurantTable.class, restaurantTableId);
        if (response==null)
            throw new NotFound("RestaurantTable","restaurantTableId",restaurantTableId);
        return response;

    }
}
