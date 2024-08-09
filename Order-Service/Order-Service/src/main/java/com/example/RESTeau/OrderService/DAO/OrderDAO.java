package com.example.RESTeau.OrderService.DAO;

import com.example.RESTeau.OrderService.Models.Order;
import com.example.RESTeau.OrderService.Models.OrderItems;
import com.example.RESTeau.OrderService.Models.Restaurant;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order,Long> {
    @Query("SELECT oi FROM OrderItems oi WHERE oi.order.id = :orderId")
    List<OrderItems> findByOrderId(@Param("orderId") Long orderId);

    List<Order> findByCuisine(String cuisine);
}
