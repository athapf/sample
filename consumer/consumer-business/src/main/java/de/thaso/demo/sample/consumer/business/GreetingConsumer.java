package de.thaso.demo.sample.consumer.business;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.Serializable;
import java.time.Duration;
import java.util.Collections;

@ApplicationScoped
public class GreetingConsumer implements Serializable {
    private final static Logger LOGGER = LoggerFactory.getLogger(GreetingConsumer.class);

    public static final String TOPIC = "greeting";

    @Inject
    KafkaConsumer<String, Greeting> consumer;

    volatile boolean done = false;

    public void initialize(@Observes @Initialized(ApplicationScoped.class) Object object) {
        LOGGER.info("==> initialize kafka consumer");
        consumer.subscribe(Collections.singleton(TOPIC));
        new Thread(() -> {
            while (! done) {
                final ConsumerRecords<String, Greeting> consumerRecords = consumer.poll(Duration.ofSeconds(10));

                consumerRecords.forEach(record -> {
                    final Greeting greeting = record.value();
                    LOGGER.info("==> polled key : " + record.key());
                    process(greeting);
                });
            }
            consumer.close();
        }).start();
    }

    private void process(final Greeting greeting) {
        LOGGER.info("==> processe greeting : " + greeting);
    }

    public void check() {}

    public void terminate(@Observes @Destroyed(ApplicationScoped.class) Object object) {
        LOGGER.info("==> terminate kafka consumer");
        done = true;
    }
}
