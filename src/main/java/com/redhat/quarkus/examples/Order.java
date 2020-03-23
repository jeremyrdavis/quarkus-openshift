package com.redhat.quarkus.examples;

public class Order {

    public Item item;

    public String name;

    public Order(Item item, String name) {
        this.item = item;
        this.name = name;
    }

    public Order() {
    }
}