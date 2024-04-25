package ru.astondevs.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.astondevs.orderservice.dto.CreateOrderDto;
import ru.astondevs.orderservice.dto.OrderResponse;
import ru.astondevs.orderservice.service.OrderService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody CreateOrderDto dto) {
        return ResponseEntity.ok(orderService.createOrder(dto));
    }
}
