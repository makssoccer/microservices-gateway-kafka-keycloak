package com.maksKud.microservices.order_service.service;

import com.maksKud.microservices.order_service.client.InventoryClient;
import com.maksKud.microservices.order_service.dto.OrderRequest;
import com.maksKud.microservices.order_service.dto.OrderResponse;
import com.maksKud.microservices.order_service.event.OrderPlacedEvent;
import com.maksKud.microservices.order_service.model.Order;
import com.maksKud.microservices.order_service.repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public List<OrderResponse> getAllOrders(){
        throw new RuntimeException();
//        return orderRepository.findAll().stream()
//                .map(order -> new OrderResponse(order.getId(), order.getOrderNumber(),
//                        order.getSkuCode(), order.getPrice(), order.getQuantity(), null))
//                .toList();
    }

    public void placeOrder(OrderRequest orderRequest) {

        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price().multiply(BigDecimal.valueOf(orderRequest.quantity())));
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);

            // Send the message to Kafka Topic
            OrderPlacedEvent orderPlacedEventDeprecated = new OrderPlacedEvent();
            orderPlacedEventDeprecated.setOrderNumber(order.getOrderNumber());
            orderPlacedEventDeprecated.setEmail(orderRequest.userDetails().email());
            orderPlacedEventDeprecated.setFirstName(orderRequest.userDetails().firstName());
            orderPlacedEventDeprecated.setLastName(orderRequest.userDetails().lastName());
            log.info("Start - Sending OrderPlacedEventDeprecated {} to Kafka topic order-placed", orderPlacedEventDeprecated);
            kafkaTemplate.send("order-placed", orderPlacedEventDeprecated);
            log.info("End - Sending OrderPlacedEventDeprecated {} to Kafka topic order-placed", orderPlacedEventDeprecated);
        } else {
            throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() + " is not in stock");
        }
    }
}
