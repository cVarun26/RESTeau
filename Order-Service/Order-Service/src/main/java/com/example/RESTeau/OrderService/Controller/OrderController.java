package com.example.RESTeau.OrderService.Controller;


import com.example.RESTeau.OrderService.Feign.OrderInterface;
import com.example.RESTeau.OrderService.Models.Order;
import com.example.RESTeau.OrderService.Models.OrderDTO;
import com.example.RESTeau.OrderService.Models.OrderItems;
import com.example.RESTeau.OrderService.Models.Restaurant;
import com.example.RESTeau.OrderService.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderInterface orderInterface;


    @PostMapping("/addOrder")
    public ResponseEntity<String> addOrder(@RequestBody OrderDTO orderDTO) {

        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/{orderId}/items")
    public ResponseEntity<List<OrderItems>> getOrderItems(@PathVariable Long orderId) {
        List<OrderItems> items = orderService.getOrder(orderId);
        if (items.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{orderID}/confirm")
    public ResponseEntity<String> confirmOrder(@PathVariable Long orderID){
        String response=orderService.confirmOrder(orderID);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/getSuggestions/{cuisine}")
    public ResponseEntity<List<Restaurant>> getSuggestionsByCuisine(@PathVariable String cuisine){
        List<Restaurant> restaurants=orderService.getRestaurantByCuisine(cuisine);
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/orderTotal/{orderId}")
    public ResponseEntity<BigDecimal> getOrderTotal(@PathVariable Long orderId){

        BigDecimal total=orderService.calculateTotal(orderId);
        return ResponseEntity.ok(total);
    }
}
