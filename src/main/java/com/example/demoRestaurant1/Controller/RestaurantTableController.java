package com.example.demoRestaurant1.Controller;


import com.example.demoRestaurant1.model.RestaurantTable;
import com.example.demoRestaurant1.service.RestaurantableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/table")
public class RestaurantTableController {
    @Autowired
    private RestaurantableService restaurantableService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<RestaurantTable> saveRestaurantTable(@RequestBody RestaurantTable restaurantTable) {
        return new ResponseEntity<RestaurantTable>(restaurantableService.saveRestaurantTable(restaurantTable), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/find/{restaurantTableId}", method = RequestMethod.GET)

    public ResponseEntity<RestaurantTable> getRestaurantTable(@PathVariable int restaurantTableId) {

        return new ResponseEntity<>(restaurantableService.getRestaurantTable(restaurantTableId), HttpStatus.OK);
    }
}

