package com.example.RESTeau.OrderService.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    private int restaurantID;
    private String restaurantName;
    private String restaurantCuisine;
    private String restaurantContact;
}
