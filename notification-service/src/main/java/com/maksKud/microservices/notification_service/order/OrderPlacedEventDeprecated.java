package com.maksKud.microservices.notification_service.order;

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
