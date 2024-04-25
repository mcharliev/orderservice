package ru.astondevs.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {
    private Long userId;
    private String productName;
    private BigDecimal price;
    private int quantity;
}
