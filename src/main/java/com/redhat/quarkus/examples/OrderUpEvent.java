package com.redhat.quarkus.examples;

import java.util.UUID;

public class OrderUpEvent extends OrderEvent {

    public OrderUpEvent(String orderId, String name, Item item, EventType eventType) {
        super(eventType, orderId, name, item);
    }

    public OrderUpEvent() {
    }
}