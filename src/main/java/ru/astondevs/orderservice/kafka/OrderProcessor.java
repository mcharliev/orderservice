package ru.astondevs.orderservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.astondevs.orderservice.dto.OrderUpdateDto;

@Component
@RequiredArgsConstructor
public class OrderProcessor {

    private final KafkaTemplate<String, OrderUpdateDto> kafkaTemplate;

    @Value("${spring.kafka.template.default-topic}")
    private String orderTopic;

    public void processOrder(OrderUpdateDto order) {
        kafkaTemplate.send(orderTopic, order);
    }
}
