package de.thaso.demo.sample.producer.business.utils;

import de.thaso.demo.sample.producer.business.Greeting;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.util.Properties;

@ApplicationScoped
public class KafkaProviders {
    private final static Logger LOGGER = LoggerFactory.getLogger(KafkaProviders.class);

    @Produces
    KafkaProducer<String, Greeting> getProducer() throws IOException {
        LOGGER.info("==> prepare kafka producer");
        final Properties config = new Properties();
        config.load(this.getClass().getResourceAsStream("/greeting.properties"));

        return new KafkaProducer<>(config,
                new StringSerializer(),
                new GreetingSerializer());
    }
}
