package com.example.RESTeau.RestaurantService.Controller;


import com.example.RESTeau.RestaurantService.Models.Restaurant;
import com.example.RESTeau.RestaurantService.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<Restaurant>> getAllAlumni(){

        return restaurantService.getAllRestaurants();
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<String> addAlumni(@RequestBody Restaurant restaurant){

        return restaurantService.addRestaurant(restaurant);

    }

    @DeleteMapping("/deleteRestaurant/{id}")
    public ResponseEntity<String> deleteAlumni(@PathVariable Restaurant id){

        return restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/getRestaurant/{cuisine}")
    public ResponseEntity<List<Restaurant>> getByRestaurantCuisine(@PathVariable String cuisine){

        return restaurantService.getByRestaurantCuisine(cuisine);
    }

}
