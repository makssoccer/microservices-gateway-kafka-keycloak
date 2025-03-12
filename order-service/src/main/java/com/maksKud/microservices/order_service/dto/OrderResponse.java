package com.maksKud.microservices.order_service.dto;

import java.math.BigDecimal;

public record OrderResponse(Long id, String orderNumber, String skuCode,
                            BigDecimal price, Integer quantity, OrderRequest.UserDetails userDetails) {

    public record UserDetails(String email, String firstName, String lastName) {}
}


