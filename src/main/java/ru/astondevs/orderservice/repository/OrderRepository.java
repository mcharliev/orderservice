package ru.astondevs.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.astondevs.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
