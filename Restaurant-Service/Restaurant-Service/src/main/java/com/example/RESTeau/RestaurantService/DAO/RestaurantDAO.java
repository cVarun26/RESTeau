package com.example.RESTeau.RestaurantService.DAO;


import com.example.RESTeau.RestaurantService.Models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant,Integer> {
    List<Restaurant> findByRestaurantCuisine(String restaurantCuisine);
}
