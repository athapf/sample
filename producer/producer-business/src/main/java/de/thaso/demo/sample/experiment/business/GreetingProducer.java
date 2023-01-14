package de.thaso.demo.sample.producer.business;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ApplicationScoped
public class GreetingProducer {
    private final static Logger LOGGER = LoggerFactory.getLogger(GreetingProducer.class);

    public static final String TOPIC = "greeting";

    @Inject
    KafkaProducer<String, Greeting> producer;

    private Long counter = 0L;

    @PreDestroy
    public void terminate() {
        producer.close();
    }

    public Greeting sendEmployee(final Greeting greeting)
        throws ExecutionException, InterruptedException, TimeoutException {
        LOGGER.info("==> send kafka greeting");
        List<Payment> paymentList = new ArrayList<>();
        paymentList.add(new Payment(RandomUtils.nextInt(1000,10000)));
        paymentList.add(new Payment(RandomUtils.nextInt(1000,10000)));
        greeting.setMitteilung(new Mitteilung("Horst", 17, paymentList));

        producer.send(new ProducerRecord<>(TOPIC, "key_" + (counter++) + "_" + RandomStringUtils.randomAlphanumeric(5), greeting))
            .get(5, TimeUnit.SECONDS);
        return greeting;
    }
}
