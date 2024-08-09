package com.example.RESTeau.OrderService.Service;

import com.example.RESTeau.OrderService.DAO.OrderDAO;
import com.example.RESTeau.OrderService.Feign.OrderInterface;
import com.example.RESTeau.OrderService.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderInterface orderInterface;



    public ResponseEntity<String> createOrder(OrderDTO orderDTO) {

        Order order = new Order();

        for (OrderItemDTO itemDTO : orderDTO.getItems()) {
            OrderItems items = new OrderItems();
            items.setItemName(itemDTO.getItemName());
            items.setPrice(itemDTO.getPrice());
            order.addItem(items);
        }
        try {
            orderDAO.save(order);
            return new ResponseEntity<>("DONE", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred while adding the order", HttpStatus.BAD_REQUEST);
        }
    }

    public List<OrderItems> getOrder(Long orderID) {
        return orderDAO.findByOrderId(orderID);

    }

    public String confirmOrder(Long orderID) {
        Optional<Order> orderOptional=orderDAO.findById(orderID);
        if(orderOptional.isPresent()){

            Order order=orderOptional.get();
            order.setStatus("CONFIRMED");
            orderDAO.save(order);
            return "Order confirmed";
        }
        else {
            return "Order not found";
        }
    }

    public List<Order> getSuggestions(String cuisine) {
           return orderDAO.findByCuisine(cuisine);

    }


    public List<Restaurant> getRestaurantByCuisine(String cuisine) {
        return orderInterface.getByRestaurantCuisine(cuisine);
    }

    public BigDecimal calculateTotal(Long orderId) {

        Order order=orderDAO.findById(orderId).orElseThrow(()-> new RuntimeException("Order not found"));

        return order.getOrderItems().stream()
                .map(OrderItems::getPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);

    }
}




