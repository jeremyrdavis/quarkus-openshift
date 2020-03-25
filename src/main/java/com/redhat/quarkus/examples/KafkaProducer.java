package com.redhat.quarkus.examples;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.concurrent.TimeUnit;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import io.reactivex.Flowable;

@ApplicationScoped
public class KafkaProducer{

    Jsonb jsonb = JsonbBuilder.create();

    @Outgoing("orders-topic")
    public Flowable<KafkaRecord<String, String>> generate() {

        return Flowable.interval(500, TimeUnit.MILLISECONDS)    
                .onBackpressureDrop()
                .map(tick -> {
                    final BeverageOrderInEvent event = new BeverageOrderInEvent(UUID.randomUUID().toString(), "Marcus", Item.ESPRESSO);
                    System.out.println("Sending : " + jsonb.toJson(event).toString());
                    return KafkaRecord.of(event.orderId, jsonb.toJson(event).toString());
                });
    }

}