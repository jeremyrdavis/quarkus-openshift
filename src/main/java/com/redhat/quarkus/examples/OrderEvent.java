package com.redhat.quarkus.examples;

import java.util.UUID;

public class OrderEvent {

    public String itemId;
    public String orderId;
    public EventType eventType;
    public String name;
    public Item item;

    public OrderEvent() {
    }

    public OrderEvent(final EventType eventType) {
        this.eventType = eventType;
    }

    public OrderEvent(final EventType eventType, final String orderId, final String name, final Item item) {
        this.itemId = UUID.randomUUID().toString();
        this.eventType = eventType;
        this.orderId = orderId;
        this.name = name;
        this.item = item;
    }
}