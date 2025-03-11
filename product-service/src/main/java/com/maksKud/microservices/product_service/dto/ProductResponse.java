package com.maksKud.microservices.product_service.dto;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String brand, String description, BigDecimal price) {
}
