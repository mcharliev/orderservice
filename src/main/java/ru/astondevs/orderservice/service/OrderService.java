package ru.astondevs.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.astondevs.orderservice.dto.CreateOrderDto;
import ru.astondevs.orderservice.dto.OrderResponse;
import ru.astondevs.orderservice.dto.OrderUpdateDto;
import ru.astondevs.orderservice.entity.Order;
import ru.astondevs.orderservice.exception.NotEnoughProductException;
import ru.astondevs.orderservice.kafka.OrderProcessor;
import ru.astondevs.orderservice.repository.OrderRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryServiceClient inventoryServiceClient;

    private final OrderProcessor orderProcessor;

    public OrderResponse createOrder(CreateOrderDto dto) {
        boolean isAvailable = inventoryServiceClient.checkProductAvailability(dto.getProductName(), dto.getQuantity());
        if (!isAvailable) {
            throw new NotEnoughProductException();
        }
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setItem(dto.getProductName());
        order.setQuantity(dto.getQuantity());
        order.setTotalAmount(dto.getPrice());
        orderRepository.save(order);

        OrderUpdateDto orderUpdateDto = new OrderUpdateDto();
        orderUpdateDto.setProductName(order.getItem());
        orderUpdateDto.setQuantity(order.getQuantity());

        orderProcessor.processOrder(orderUpdateDto);
        return buildOrderResponse(order);
    }

    private OrderResponse buildOrderResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setMessage("Ваш заказ успешно сформирован и находится в обработке");
        response.setItem(order.getItem());
        response.setQuantity(order.getQuantity());
        response.setOrderId(order.getId());
        return response;
    }
}

