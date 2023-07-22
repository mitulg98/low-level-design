package org.example.models.delivery;

import org.example.models.delivery.Delivery;

import java.util.ArrayList;
import java.util.List;

public class Over {
    private final List<Delivery> deliveries = new ArrayList<>();

    public void addDelivery(Delivery delivery) {
        deliveries.add(delivery);
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }
}
