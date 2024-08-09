package com.example.RESTeau.OrderService.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    // Initialize the list here
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItems> orderItems = new ArrayList<>();

    @Column(name = "status")
    private String status = "PENDING";

    @Column(name = "cuisine")
    private String cuisine;

    public void addItem(OrderItems item) {

        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }

        orderItems.add(item);
        item.setOrder(this);
    }
}







