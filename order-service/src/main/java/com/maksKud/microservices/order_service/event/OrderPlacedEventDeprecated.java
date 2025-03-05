package com.maksKud.microservices.order_service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Deprecated
public class OrderPlacedEventDeprecated {
    private String orderNumber;
    private String email;
}