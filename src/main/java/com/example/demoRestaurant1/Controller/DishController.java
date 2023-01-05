package com.example.demoRestaurant1.Controller;


import com.example.demoRestaurant1.Dto.DishDto;
import com.example.demoRestaurant1.model.Dish;
import com.example.demoRestaurant1.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "dish")
public class DishController {
    @Autowired
    DishService dishService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Dish> saveDish(@RequestBody Dish dish) {

        return new ResponseEntity<Dish>(dishService.saveDish(dish), HttpStatus.CREATED);
    }

    @RequestMapping(value = "find/{dishId}", method = RequestMethod.GET)
    public ResponseEntity<Dish> getDishById(@PathVariable int dishId) {
        return new ResponseEntity<Dish>(dishService.getDishById(dishId), HttpStatus.OK);
    }

    @RequestMapping(value = "/adddish", method = RequestMethod.POST)
    public ResponseEntity<DishDto> createDishByCooker(@RequestBody DishDto dishDto) {
        return new ResponseEntity<>(dishService.createDishByCooker(dishDto), HttpStatus.OK);
    }
}
