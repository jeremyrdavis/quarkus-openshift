package com.redhat.quarkus.examples;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import io.smallrye.reactive.messaging.kafka.KafkaRecord;

public class KafkaConsumer{

    @Incoming("orders-topic")
    @Outgoing("my-data-stream")
    @Broadcast
    public String incoming(final KafkaRecord kafkaRecord){

        System.out.println("receieved: " + kafkaRecord.getKey() + " " + kafkaRecord.getPayload());
        return kafkaRecord.getPayload().toString();
    }



}