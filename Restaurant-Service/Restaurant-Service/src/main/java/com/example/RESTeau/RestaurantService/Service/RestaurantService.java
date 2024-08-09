package com.example.RESTeau.RestaurantService.Service;


import com.example.RESTeau.RestaurantService.DAO.RestaurantDAO;
import com.example.RESTeau.RestaurantService.Models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantDAO restaurantDAO;
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {


        try {
            return new ResponseEntity<>(restaurantDAO.findAll(), HttpStatus.OK) ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;

    }

    public ResponseEntity<String> addRestaurant(Restaurant restaurant) {

        try {
            restaurantDAO.save(restaurant);
            return new ResponseEntity<>("DONE", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred while adding the question", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteRestaurant(Restaurant id) {

        try {
            restaurantDAO.delete(id);
            return new ResponseEntity<>("DELETED", HttpStatus.OK);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace(); // or log the exception
            return new ResponseEntity<>("An error occurred while deleting the question", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Restaurant>> getByRestaurantCuisine(String cuisine) {
        try {
            return new ResponseEntity<>(restaurantDAO.findByRestaurantCuisine(cuisine),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
    }
}

