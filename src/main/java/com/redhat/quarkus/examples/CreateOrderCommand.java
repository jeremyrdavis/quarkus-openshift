package com.redhat.quarkus.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CreateOrderCommand {

    public final String id = UUID.randomUUID().toString();

    public Optional<List<Order>> beverages = Optional.empty();

    public Optional<List<Order>> kitchenOrders = Optional.empty();

    public CreateOrderCommand() {
    }

    public CreateOrderCommand(List<Order> beverages, List<Order> kitchenOrders) {
        this.beverages = Optional.ofNullable(beverages);
        this.kitchenOrders = Optional.ofNullable(kitchenOrders);
    }

    public void addBeverages(List<Order> beverageList) {
        if (this.beverages.isPresent()) {
            this.beverages.get().addAll(beverageList);
        }else{
            this.beverages = Optional.of(beverageList);
        }
    }

    public void addKitchenItems(List<Order> kitchenOrdersList) {
        if (this.kitchenOrders.isPresent()) {
            this.kitchenOrders.get().addAll(kitchenOrdersList);
        }else{
            this.kitchenOrders = Optional.ofNullable(kitchenOrdersList);
        }
    }

    private List<Order> createBeverages() {

        List<Order> beverages = new ArrayList(2);
        beverages.add(new Order(Item.COFFEE_WITH_ROOM, "Mickey"));
        beverages.add(new Order(Item.COFFEE_BLACK, "Minnie"));
        return beverages;
    }

    private List<Order> createKitchenItems() {
        List<Order> kitchenOrders = new ArrayList(2);
        kitchenOrders.add(new Order(Item.CAKEPOP, "Mickey"));
        kitchenOrders.add(new Order(Item.CROISSANT, "Minnie"));
        return kitchenOrders;
    }



}