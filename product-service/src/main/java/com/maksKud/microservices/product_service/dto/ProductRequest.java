package com.maksKud.microservices.product_service.dto;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, String brand, String description, BigDecimal price) {
}
