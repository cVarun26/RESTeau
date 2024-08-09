package com.example.RESTeau.OrderService.Feign;

import com.example.RESTeau.OrderService.Models.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RESTAURANT-SERVICE")
public interface OrderInterface {

    @GetMapping("/getRestaurant/{cuisine}")
    List<Restaurant> getByRestaurantCuisine(@PathVariable String cuisine);
}
