package com.example.demoRestaurant1.ServiceImpl;


import com.example.demoRestaurant1.Dto.DishDto;
import com.example.demoRestaurant1.exception.NotFound;
import com.example.demoRestaurant1.model.Dish;
import com.example.demoRestaurant1.model.User;
import com.example.demoRestaurant1.service.DishService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class DishServiceImpl implements DishService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Dish saveDish(Dish dish) {
        entityManager.persist(dish);
        return dish;
    }

    @Override
    @Transactional
    public Dish getDishById(int dishId) {
        Dish response = (Dish) entityManager.find(Dish.class, dishId);
        if (response == null)
            throw new NotFound("Dish", "dishId", dishId);
        return response;
    }
 @Override
    @Transactional
    public DishDto createDishByCooker(DishDto dishDto){
 User user=entityManager.find(User.class,dishDto.getUser().getUserId());
     dishDto.setUser(user);
        if(user==null ) {
            throw new RuntimeException("This user doesnt exist or isnt a cooker");
        }

        Dish dish1=new Dish();
     mapDtoToEntity(dishDto, dish1);
     entityManager.persist(dish1);
     return mapEntiyToDto(dish1);
 }
    private DishDto mapEntiyToDto(Dish dish) {
        DishDto dishDto = new DishDto();
        dishDto.setDishId(dish.getDishId());
        dishDto.setName(dish.getName());
        dishDto.setPrice(dish.getPrice());
        dishDto.setUser(dish.getUser());
        return dishDto;
    }
        private Dish mapDtoToEntity(DishDto dishDto, Dish dish) {

           dish.setDishId(dishDto.getDishId());
           dish.setName(dishDto.getName());
           dish.setPrice(dishDto.getPrice());
           dish.setUser(dishDto.getUser());
            return dish;
        }
}

