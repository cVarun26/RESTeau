package com.example.RESTeau.OrderService.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    private String itemName;
    private BigDecimal price;

}
