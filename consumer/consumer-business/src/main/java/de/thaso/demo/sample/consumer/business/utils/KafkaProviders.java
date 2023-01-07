package de.thaso.demo.sample.consumer.business.utils;

import de.thaso.demo.sample.consumer.business.Greeting;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.util.Properties;

@ApplicationScoped
public class KafkaProviders {

    @Produces
    KafkaConsumer<String, Greeting> getConsumer() throws IOException {
        final Properties config = new Properties();
        config.load(this.getClass().getResourceAsStream("/greeting.properties"));

        return new KafkaConsumer<>(config,
            new StringDeserializer(),
            new GreetingDeserializer());
    }
}
