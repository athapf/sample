package de.thaso.demo.sample.producer.business;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ApplicationScoped
public class GreetingProducer {
    private final static Logger LOGGER = LoggerFactory.getLogger(GreetingProducer.class);

    public static final String TOPIC = "greeting";

    @Inject
    KafkaProducer<String, Greeting> producer;

    @PreDestroy
    public void terminate() {
        producer.close();
    }

    public Greeting sendEmployee(final Greeting greeting)
        throws ExecutionException, InterruptedException, TimeoutException {
        LOGGER.info("==> send kafka greeting");

        producer.send(new ProducerRecord<>(TOPIC, "key_" + RandomStringUtils.randomAlphanumeric(5), greeting))
            .get(5, TimeUnit.SECONDS);
        return greeting;
    }
}
